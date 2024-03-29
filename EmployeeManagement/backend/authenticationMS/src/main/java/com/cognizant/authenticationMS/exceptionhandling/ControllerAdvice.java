package com.cognizant.authenticationMS.exceptionhandling;

import com.cognizant.authenticationMS.errorhandling.ErrorMessage;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ControllerAdvice {
	// Exception Method for APPUSER not found
	/**
	 * @param userNotFoundException
	 * @return ErrorMessage
	 */
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage userNotFoundException(UsernameNotFoundException userNotFoundException) {
		return new ErrorMessage(HttpStatus.NOT_FOUND, LocalDateTime.now(), userNotFoundException.getMessage());
	}

	// Exception for jwt malfunctioned error
	/**
	 * @return ErrorMessage
	 */
	@ExceptionHandler(MalformedJwtException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorMessage tokenMalformedException() {
		return new ErrorMessage(HttpStatus.UNAUTHORIZED, LocalDateTime.now(), "Not Authorized --> Token is Invalid..");
	}

	// Exception for JWT Signature unauthorized error
	/**
	 * @return ErrorMessage
	 */
	@ExceptionHandler(SignatureException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorMessage tokenSignatureException() {
		return new ErrorMessage(HttpStatus.UNAUTHORIZED, LocalDateTime.now(), "Not Authorized --> Token is Invalid..");
	}

}