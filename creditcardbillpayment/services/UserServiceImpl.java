package com.cg.creditcardbillpayment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.creditcardbillpayment.dao.UserRepository;


import com.cg.creditcardbillpayment.entities.User;
import com.cg.creditcardbillpayment.entities.UserRole;
import com.cg.creditcardbillpayment.exceptions.DuplicateUserException;
import com.cg.creditcardbillpayment.exceptions.NoSuchUserException;
import com.cg.creditcardbillpayment.exceptions.UserException;


/*******************************************************************************************************
 * @author 			B Sai Teja Kumar 
 * Description 		: It is a service class that provides the services to add a user, remove a user, 
 * 				 		signin the user, signout the user and update the password.
 * Version 			: 1.0 
 * Created Date 	: 24-March-2021
 *******************************************************************************************************/

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;
	

	
	
	/*******************************************************************************************
	 * Method						: signIn 
	 * Description					: To signIn to the user account
	 * @param user					- user to check with the database
	 * @returns Boolean 			- true, if user signed in
	 * @throws NoSuchUserException 	- It is raised when the user id does not exists in database
	 * @throws UserException       	- It is raised when the user password not matched,
	 * 								  user already signed in and user role not matched 
	 * Created By 					- B Sai Teja Kumar 
	 * Created Date 				- 24-March-2021
	 ******************************************************************************************/

	@Override
	public Boolean signIn(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Boolean status = false;
		Optional<User> resultUser = userRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				if (resultUser.get().getRole().equals(user.getRole())) {
					status = true;
				} else {
					throw new UserException("Access denied");
				}
			} else {
				throw new UserException("Wrong password");
			}
		} else {
			throw new NoSuchUserException("User not found");
		}
		return status;

	}
	
	
	/*******************************************************************************************
	 * Method						: signOut 
	 * Description					: To signOut from the user account
	 * @param user					- user to check with the database
	 * @returns Boolean 			- true, if user signed out
	 * @throws NoSuchUserException 	- It is raised when the user id does not exists in database
	 * @throws UserException       	- It is raised when the user password not matched and
	 * 								  user already signed out
	 * Created By 					- B Sai Teja Kumar 
	 * Created Date 				- 24-March-2021 
	 ******************************************************************************************/
	@Override
	public Boolean signOut(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Boolean status = false;
		Optional<User> resultUser = userRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(user.getPassword())) {
				if (resultUser.get().getRole().equals(user.getRole())) {
					status = true;
				} else {
					throw new UserException("Access denied");
				}
			} else {
				throw new UserException("Wrong password");
			}
		} else {
			throw new NoSuchUserException("User not found");
		}
		return status;

	}
	
	
	
	/*******************************************************************************************
	 * Method							: addUser 
	 * Description						: To add user in the database
	 * @param adduser					- user to be added in the database
	 * @returns User 					- returns user after adding to the database
	 * @throws DuplicateUserException 	- It is raised when the user already exists in database
	 * Created By 						- B Sai Teja Kumar 
	 * Created Date 					- 24-March-2021
	 ******************************************************************************************/

	@Override
	public User addUser(User adduser) throws DuplicateUserException {
		// TODO Auto-generated method stub
		Optional<User> resultUser = userRepository.findById(adduser.getUserId());
		if (resultUser.isEmpty()) {
			return userRepository.saveAndFlush(adduser);
		} else {
			throw new DuplicateUserException("User " + adduser.getUserId() + " Already Exists");
		}

	}
	

	/*******************************************************************************************
	 * Method							: removeUser 
	 * Description						: To remove user from the database
	 * @param id						- id to be removed from the database
	 * @returns String 					- returns user removed successfully message
	 * @throws NoSuchUserException		- It is raised when the user not exists in database
	 * Created By 						- B Sai Teja Kumar 
	 * Created Date 					- 24-March-2021
	 ******************************************************************************************/

	@Override
	public String removeUser(String id) throws NoSuchUserException {
		// TODO Auto-generated method stub
		try {
		Optional<User> resultUser = userRepository.findById(id);
		if (!resultUser.isEmpty()) {
			userRepository.deleteById(id);
			return "User id " + id + " is removed successfully";
		} else {
			throw new NoSuchUserException("User Not Found");
		}
		}catch(Exception exception) {
			throw new UserException("Delete the Statements and transactions before removing the user");
		}
	}

	
	/*******************************************************************************************
	 * Method							: getAllUsers 
	 * Description						: To get all the users from the database
	 * @returns List<User> 				- returns all users from the database
	 * @throws NoSuchUserException		- It is raised when no users exists in database
	 * Created By 						- B Sai Teja Kumar 
	 * Created Date 					- 24-March-2021
	 ******************************************************************************************/

	@Override
	public List<User> getAllUsers() throws NoSuchUserException {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new NoSuchUserException("No Users found");
		}
		return users;
	}

	
	/*******************************************************************************************
	 * Method							: updateUser 
	 * Description						: To update user in the database
	 * @param user						- user to be updated in the database
	 * @returns User 					- returns user after updated in the database
	 * @throws DuplicateUserException 	- It is raised when the user not exists in database
	 * Created By 						- B Sai Teja Kumar 
	 * Created Date 					- 24-March-2021
	 ******************************************************************************************/

	@Override
	public User updateUser(User user) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Optional<User> resultUser = userRepository.findById(user.getUserId());
		if (!resultUser.isEmpty()) {
			userRepository.saveAndFlush(user);
		} else {
			throw new DuplicateUserException("User Not Found");
		}
		return user;
	}

	/*******************************************************************************************
	 * Method							: getUserById 
	 * Description						: To remove user from the database
	 * @param id						- id to fetch user from the database
	 * @returns User 					- returns user 
	 * @throws NoSuchUserException		- It is raised when the user not exists in database
	 * Created By 						- B Sai Teja Kumar 
	 * Created Date 					- 24-March-2021
	 ******************************************************************************************/
	@Override
	public User getUserById(String id) throws NoSuchUserException {
		// TODO Auto-generated method stub
		Optional<User> resultUser = userRepository.findById(id);
		if (!resultUser.isEmpty()) {
			return resultUser.get();
		} else {
			throw new NoSuchUserException("User Not Found");
		}

	}
	
	/*******************************************************************************************
	 * Method						: changePassword 
	 * Description					: To changePassword of the user 
	 * @param id					- id to fetch user from the database
	 * @param currentPassword		- currentPassword to check user password
	 * @param newPassword			- newPassword to update the user password
	 * @returns User 				- returns user
	 * @throws NoSuchUserException 	- It is raised when the user id does not exists in database
	 * @throws UserException       	- It is raised when the user current password not matched
	 * Created By 					- B Sai Teja Kumar 
	 * Created Date 				- 24-March-2021
	 ******************************************************************************************/

	@Override
	public User changePassword(String id, String currentPassword, String newPassword) throws NoSuchUserException {
		// TODO Auto-generated method stub
		User changeUser;
		Optional<User> resultUser = userRepository.findById(id);
		if (!resultUser.isEmpty()) {
			if (resultUser.get().getPassword().equals(currentPassword)) {
				changeUser = new User(id, newPassword, resultUser.get().getRole());
				userRepository.save(changeUser);
			} else {
				throw new UserException("Old password was wrong");
			}
		} else {
			throw new NoSuchUserException("User Not Found");
		}
		return changeUser;
	}
	
}
