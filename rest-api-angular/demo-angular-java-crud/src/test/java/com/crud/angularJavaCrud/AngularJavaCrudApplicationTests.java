package com.crud.angularJavaCrud;

import static org.junit.jupiter.api.Assertions.*;


import com.crud.angularJavaCrud.entities.User;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

@SpringBootTest(classes = AngularJavaCrudApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AngularJavaCrudApplicationTests {
/*
	@Test
	void contextLoads() {
	}*/

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl(){
		//System.out.println("----------------------- port "+port);
		return "http://localhost:" + port+"/api/v1";
		
	}

	@Test
	 void contextLoads() {
	}

	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
				HttpMethod.GET, entity, String.class);

		//Assert.assert();//.assert(response.getBody());
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
		//System.out.println(user.getFirstName());
		assertNotNull(user);
	}

	@Test
	public void testCreateUser() {
		String uuid=UUID.randomUUID().toString();
		User user = new User();
		user.setEmail("admin"+uuid+"@gmail.com");
		
		user.setCreatedBy("admin");
		user.setUpdatedBy("admin");
		user.setCreatedAt(new Date());
		user.setUpdatedAt(new Date());
		user.setUsername(uuid);

		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
		assertNotNull(postResponse);
		
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdatePost() {
		int id = 1;
		User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		String uuid=UUID.randomUUID().toString();
		user.setEmail("admin"+uuid+"@gmail.com");
		//user.setFirstName("admin1");
		//user.setLastName("admin2");
		user.setUsername(uuid);

		restTemplate.put(getRootUrl() + "/users/" + id, user);

		User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		assertNotNull(updatedUser);
	}

	@Test
	public void testDeletePost() {
		int id = 2;
		User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		assertNotNull(user);

		restTemplate.delete(getRootUrl() + "/users/" + id);

		try {
			user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}


}
