package com.userdetails.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.userdetails.springboot.model.STATUS;
import com.userdetails.springboot.model.User;

@EnableBatchProcessing
@Configuration
public class CsvFileToDatabaseConfig {
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;
    

    @Bean
    public FlatFileItemReader<User> csvUserReader(){
        FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
        reader.setResource(new ClassPathResource("userdetails.csv"));
        reader.setLineMapper(new DefaultLineMapper<User>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "id"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {{
                setTargetType(User.class);
            }});
        }});
        return reader;
    }

	@Bean
	ItemProcessor<User, User> csvUserProcessor() {
		return new UserProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<User> csvUserWriter() {
		 JdbcBatchItemWriter<User> csvAnimeWriter = new JdbcBatchItemWriter<User>();
		 csvAnimeWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
		 csvAnimeWriter.setSql("INSERT INTO APP_USER(id,STATUS) VALUES (:id,"+STATUS.INACTIVE+")");
		 csvAnimeWriter.setDataSource(dataSource);
	     return csvAnimeWriter;
	}

	@Bean
	public Step csvFileToDatabaseStep() {
		return stepBuilderFactory.get("csvFileToDatabaseStep")
				.<User, User>chunk(1)
				.reader(csvUserReader())
				.processor(csvUserProcessor())
				.writer(csvUserWriter())
				.build();
	}
}
