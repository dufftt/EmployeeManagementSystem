package com.cognizant.rulesMS.exception;


public class MinimumBalanceException extends RuntimeException{

	/**
	 * MinimumBalance Exception
	 */
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
