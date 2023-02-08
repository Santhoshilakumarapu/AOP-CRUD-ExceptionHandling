package net.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.dto.UserRequest;
import net.java.entity.User;
import net.java.exception.UserNotFoundException;
import net.java.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
    	
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
        
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getALlUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
    
    @PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable("id") int Id,@RequestBody UserRequest userReq) throws UserNotFoundException
	{
		return new ResponseEntity<User>(service.updateUser(userReq,Id),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteempById(@PathVariable("id") int Id) throws UserNotFoundException
	{
		service.deleteUser(Id);
		return "Deleted Successfuly with id"+Id;
		
	}
}
