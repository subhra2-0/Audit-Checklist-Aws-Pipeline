package com.cognizant.pojo;


import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author POD5
 * @version 1.8
 * @apiNote This class is used to hold the login credentials which will be sent
 *          by the user in the request body for getting the token
 *
 */
import lombok.extern.slf4j.Slf4j;


@ContextConfiguration @Slf4j
@SpringBootTest
public class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();
	/**
	 * to test the all param constructor of UserLoginCredential
	 */
	
	@Test
	public void testUserLoginCredentialAllConstructor() {
	
		UserCredentials credential = new UserCredentials("abc", "abc");
		assertEquals(credential.getUserId(), "abc");
	
	}
	/**
	 * to test the getter setter of Uid
	 */
	@Test
	public void testGetUid() {
		
		loginCredential.setUserId("abc");
		assertEquals(loginCredential.getUserId(), "abc");
		
	}
	/**
	 * to test the getter setter of Password
	 */
	@Test
	public void testUserPassword() {
		
		loginCredential.setPassword("abc");
		assertEquals(loginCredential.getPassword(), "abc");
		
	}
	/**
	 * to test the getter setter of toString()
	 */
	@Test
	public void testoString() {
		
		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);
		
	}

}
