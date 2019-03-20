package com.userdetails.springboot.repositories;

import com.userdetails.springboot.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);
    List<User> findByStatus(String status);
    List<User> findByFirstNameAndLastNameAndUsername(String firstName, String lastName, String userName);

}
