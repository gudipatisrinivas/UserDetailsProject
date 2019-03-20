package com.userdetails.springboot.repositories;

import com.userdetails.springboot.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
* 
*
* @author  Srinivas Gudipati
* @version 1.0
* @since   2019-03-20
* 
* This class contains the Spring Data Reposirtoy related methods
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);
    List<User> findByStatus(String status);
    List<User> findByFirstNameAndLastNameAndUsername(String firstName, String lastName, String userName);

}
