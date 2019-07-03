package com.synthesis.coding.codingtest.Service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.synthesis.coding.codingtest.entity.CustomResponseEntity;
import com.synthesis.coding.codingtest.entity.User;
import com.synthesis.coding.codingtest.model.USER_DETAILS;
import com.synthesis.coding.codingtest.repository.UserRepository;
import com.synthesis.coding.codingtest.service.CreateUserService;
import com.synthesis.coding.codingtest.service.CreateUserServiceImpl;

@RunWith(SpringRunner.class)
public class CreateUserServiceTest {

	@TestConfiguration
	static class CreateUserServiceImplTestConfiguration{
		
		@Bean
		public CreateUserService createUserService() {
			return new CreateUserServiceImpl();
		}
	}
	
	@Autowired
	private CreateUserService createUserService;
	
	@MockBean
	private UserRepository repository;
	
	private USER_DETAILS user_DETAILS;
	
	@org.junit.Before
	public void setup() {
		Mockito.when(repository.save(user_DETAILS)).thenReturn(user_DETAILS);
	}
	
	@Test
	public void createUserTest() {
		User newUser = new User();
		newUser.setUserName("test");
		newUser.setAddress("address");
		newUser.setEmailAddress("test@test.com");
		
		ResponseEntity<CustomResponseEntity> response=createUserService.createUser(newUser);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	
	
}
