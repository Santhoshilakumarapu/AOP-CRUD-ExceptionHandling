package net.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.java.dto.UserRequest;
import net.java.entity.User;
import net.java.exception.UserNotFoundException;
import net.java.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	/*
	 * 
	 * We can write below code using builder also 
	 * public User saveUser(UserRequest userRequest) { User user = User. build(0,
	 * userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
	 * userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
	 * return repository.save(user); }
	 */

	public User saveUser(UserRequest userRequest) {
		User user = new User(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return repository.save(user);
	}

	public List<User> getALlUsers() {
		 List<User> users = repository.findAll();
		 System.out.println("Getting data from DB "+users);
		return users;
	}

	public User getUser(int id) throws UserNotFoundException {
		User user = repository.findByUserId(id);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("user not found with id : " + id);
		}
	}

	public String deleteUser(int id) throws UserNotFoundException {

		User user = repository.findByUserId(id);
		if (user != null) {
			repository.deleteById(id);
		} else {
			throw new UserNotFoundException("user not found with id : " + id);
		}
		return "Successfully deleted user with id" + id;
	}

	public User updateUser(UserRequest userReq, int id) throws UserNotFoundException {

		User existingUser = repository.findByUserId(id);
		if (existingUser != null) {
			existingUser.setName(userReq.getName());
			existingUser.setEmail(userReq.getEmail());
			existingUser.setGender(userReq.getGender());
			existingUser.setAge(userReq.getAge());
			existingUser.setMobile(userReq.getMobile());
			existingUser.setNationality(userReq.getNationality());
			repository.save(existingUser);
		} else {
			throw new UserNotFoundException("user not found with id : " + id);
		}
		return existingUser;
	}

}
