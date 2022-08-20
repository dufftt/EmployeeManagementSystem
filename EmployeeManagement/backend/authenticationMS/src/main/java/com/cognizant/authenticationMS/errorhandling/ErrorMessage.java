package com.cognizant.authenticationMS.errorhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage 
{
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
}