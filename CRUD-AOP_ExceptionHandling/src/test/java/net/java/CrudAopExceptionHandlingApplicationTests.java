package net.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import net.java.entity.User;
import net.java.repository.UserRepository;
import net.java.service.UserService;

@SpringBootTest
class CrudAopExceptionHandlingApplicationTests {

	@Autowired
	private UserService service;
	@MockBean
	private UserRepository repository;
	
	@Test
	public void getUsersTest()
	{
	when(repository.findAll()).thenReturn(Stream
	.of(new User(37, "Danile", "laku@gmail.com", "1234767890", "male", 31, "USA"), new User(58, "Huy","lakumarapu@gmail.com", "1234707890", "male", 38, "USA")).collect(Collectors.toList()));
	assertEquals(2, service.getALlUsers().size());
	}
}
	
	
