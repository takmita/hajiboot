package com.example.hajiboot;

import org.junit.jupiter.api.Test;
import  org.junit.runner.RunWith;
import org.junit.runners.Suite;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import  static  org.assertj.core.api.Assertions.*;

@RunWith(Suite.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
final
class HajibootApplicationTests {
	@LocalServerPort
	int port;
	@Autowired
	TestRestTemplate restTemplate;
	@Test
	public void contextLoads() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port, String.class);
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
		assertThat(response.getBody()).isEqualTo("Hello World!");
	}
}
