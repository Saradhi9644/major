package com.cg.creditcardbillpayment.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;


@Service
public interface IUserService {
	
	public Boolean signIn(User user) throws NoSuchUserException;
	public Boolean signOut(User user) throws NoSuchUserException;
	public User changePassword(String id, String currentPassword,String newPassword) throws NoSuchUserException;	
	
	public User updateUser(User user) throws NoSuchUserException;
	public List<User> getAllUsers() throws NoSuchUserException;
	public String removeUser(String id) throws NoSuchUserException;
	public User getUserById(String id) throws NoSuchUserException;	
	public User addUser(User user) throws DuplicateUserException;
	
	
	
	
}
