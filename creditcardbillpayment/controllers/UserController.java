package com.cg.creditcardbillpayment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;
import com.cg.creditcardbillpayment.services.IUserService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/*****************************************************************************************************
	 * Method                           : loginUser 
	 * Description                      : To login the user 
	 * @param user                 		- user is checked with the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Boolean                 - returns true, if user login successfully
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 *****************************************************************************************************/

	@PostMapping("/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody User user) throws NoSuchUserException {
		return new ResponseEntity<Boolean>(userService.signIn(user), HttpStatus.ACCEPTED);
	}
	
	/****************************************************************************************************
	 * Method                           : logoutUser 
	 * Description                      : To logout the user 
	 * @param user                 		- user is checked with the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns Boolean                 - returns true, if user logout successfully
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ***************************************************************************************************/
	
	@PostMapping("/logout")
	public ResponseEntity<Boolean> logoutUser(@RequestBody User user) throws NoSuchUserException {
		return new ResponseEntity<Boolean>(userService.signOut(user), HttpStatus.OK);
	}
	
	
	
	/***************************************************************************************************
	 * Method                           : addUser 
	 * Description                      : To add the user to the database
	 * @param adduser                 	- user to be added to the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 *@returns User                 	- returns user after adding the user to database 
	 * @throws DuplicateUserException	- It is raised when user already exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 **************************************************************************************************/
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User adduser) throws DuplicateUserException{
		return new ResponseEntity<User>(userService.addUser(adduser), HttpStatus.OK);
	}
	
	/**************************************************************************************************
	 * Method                           : removeUser 
	 * Description                      : To remove the user 
	 * @param id                 		- user with id is to be removed from the database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns String              	- returns user removed successfully message
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 **************************************************************************************************/
	@DeleteMapping("/removeuser/{id}")
	public ResponseEntity<String> removeUser(@PathVariable String id) throws NoSuchUserException {
		return new ResponseEntity<String>(userService.removeUser(id), HttpStatus.OK);
	}
	
	
	/*************************************************************************************************
	 * Method                           : getAllUsers
	 * Description                      : To get all the users from the database
	 * @throws NoSuchUserException 		- It is raised when user not exists in database
	 * @returns List<User>          	- returns all users after fetching the database 
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************************/
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers() throws NoSuchUserException {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	/***************************************************************************************************
	 * Method                           : updatePassword 
	 * Description                      : To update the password of the user 
	 * @param id                 		- user id is to be updated in database
	 * @param currentPassword           - currentPassword is to be check in database
	 * @param newPassword               - newPassword is to be updated in database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @returns User                 	- returns user after updating the user password to database 
	 * @throws NoSuchUserException		- It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 **************************************************************************************************/
	
	@PutMapping("/updatepassword/{id}/{old}/{new}")
	public ResponseEntity<User> updatePassword(@PathVariable("id") String id,@PathVariable("old") String currentPassword,@PathVariable("new") String newPassword) throws NoSuchUserException {
		return new ResponseEntity<User>(userService.changePassword(id,currentPassword,newPassword), HttpStatus.OK);
	}
	
	/***************************************************************************************************
	 * Method                           : updateUser 
	 * Description                      : To update the user in the database
	 * @param user                 		- user to be update to the database
	 * @param RequestBody               - It maps the HttpRequest body to a transfer or domain object,
                                          enabling automatic deserialization of the inbound HttpRequest 
                                          body onto a Java object.
	 * @returns User                 	- returns user after updating the user to database 
	 * @throws NoSuchUserException	   - It is raised when user not exists in database
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 **************************************************************************************************/
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws NoSuchUserException {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}

	/*************************************************************************************************
	 * Method                           : getUser
	 * Description                      : To get the user by id from the database
	 * @param id                 		- user id to be fethed from the database
	 * @param PathVariable              - used to handle template variables in the request URI mapping,  
	 										and use them as method parameters
	 * @throws NoSuchUserException 		- It is raised when user not exists in database
	 * @returns User          			- returns user after fetching from the database 
	 * CreatedBy                        - B Sai Teja Kumar 
	 * Created Date                     - 24-MAR-2021
	 ************************************************************************************************/
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) throws NoSuchUserException {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
}
