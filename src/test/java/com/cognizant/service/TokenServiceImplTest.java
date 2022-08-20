package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * This class contains test cases for the TokenServiceImpl class.
 */

@ContextConfiguration
@Slf4j
@SpringBootTest
public class TokenServiceImplTest {

	@InjectMocks
	TokenServiceImpl tokenService;
	@Mock
	AuthClient authClient;

	@Mock
	AuthResponse authResponse;

	@Mock
	ResponseEntity<AuthResponse> entity;

	/**
	 * test to check the validity of token when token is valid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {

		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true), HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		assertEquals(true, tokenService.checkTokenValidity("token"));

	}

	/**
	 * test to check the validity of token when token gives null pointer exception
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {

		assertThrows(NullPointerException.class, () -> tokenService.checkTokenValidity("token"));

	}

	/**
	 * test to check the validity of token when token is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {

		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, false), HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(entity);
		assertEquals(false, tokenService.checkTokenValidity("token"));

	}

}
