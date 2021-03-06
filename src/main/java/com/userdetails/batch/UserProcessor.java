package com.userdetails.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import com.userdetails.springboot.model.User;
/**
* 
*
* @author  Srinivas Gudipati
* @version 1.0
* @since   2019-03-20
* 
* This is the Processor for the Spring Batch file
*/
public class UserProcessor implements ItemProcessor<User, User> {
	
    private static final Logger log = LoggerFactory.getLogger(User.class);
    
    
	@Override
	public User process(User item) throws Exception {
		// TODO Auto-generated method stub
		return new User(item.getId());
	}

}
