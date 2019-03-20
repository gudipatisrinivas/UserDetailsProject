package com.userdetails.springboot.service;


import com.userdetails.springboot.model.User;

import java.util.List;
/**
* 
*
* @author  Srinivas Gudipati
* @version 1.0
* @since   2019-03-20
* 
* This is an interface thta has the Details regarding the UserService
*/
public interface UserService {
	
	User findById(Long id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findByStatus(String status);
	
	

	boolean isUserExist(User user);

	boolean isValid(User user);
}