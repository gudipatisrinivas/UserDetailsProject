package com.userdetails.springboot.service;

import java.util.List;

import com.userdetails.springboot.model.STATUS;
import com.userdetails.springboot.model.User;
import com.userdetails.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}


	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.deleteById(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	public List<User> findAllUsers(){
		return userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByLastNameAndFirstNameAndUserName(user.getFirstName(),user.getLastName(),user.getUsername()).size()>1?true:false;
	}

	private List<User> findByLastNameAndFirstNameAndUserName(String firstName, String lastName, String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstNameAndLastNameAndUsername(firstName,lastName,userName);
	}

	

	@Override
	public List<User> findByStatus(String status) {
		// TODO Auto-generated method stub
		return userRepository.findByStatus(STATUS.ACTIVE.toString());
	}

	@Override
	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		if(user==null || user.getFirstName().equals(null) || user.getLastName().equals(null)) {
			return true;
		}
		return false;
	}


	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByFirstName(name).get(0);
	}

}
