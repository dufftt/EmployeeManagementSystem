package com.cognizant.rulesMS.exception;


import com.cognizant.rulesMS.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//NullPointerException
			/**
			 * @param exception
			 * @param request
			 * @return ResponseEntity<?>
			 */
			@ExceptionHandler(MinimumBalanceException.class)
			public ResponseEntity<?> minBalance(MinimumBalanceException exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
			}
			
	    //Access Denied Exception		
			/**
			 * @param exception
			 * @param request
			 * @return ResponseEntity<?>
			 */
			@ExceptionHandler(AccessDeniedException.class)
			public ResponseEntity<?> AccessDenied(AccessDeniedException exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
			}
			
			
			
	// handling global exception
		/**
		 * @param exception
		 * @param request
		 * @return ResponseEntity<?>
		 */
		@ExceptionHandler(Exception.class)
			public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
				ErrorDetails errorDetails = 
						new ErrorDetails(exception.getMessage(), request.getDescription(false));
				return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		

}