package com.cognizant.exception;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * This class handles the FeignProxy exception
 * this class extends the Exception class.
 *
 */

public class FeignProxyException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	
	
	public FeignProxyException() {
		super();
	}

}
