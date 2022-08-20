package com.cognizant.transactionMS.exception;


public class MinimumBalanceException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public MinimumBalanceException() {
		super();
	}

	/**
	 * @param message
	 */
	public MinimumBalanceException(String message) {
		super(message);
	}

	
	
}
