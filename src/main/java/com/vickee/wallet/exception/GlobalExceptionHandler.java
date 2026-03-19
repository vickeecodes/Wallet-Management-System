package com.vickee.wallet.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<?> handle(RuntimeException ex) {
//		return ResponseEntity.badRequest().body(ex.getMessage());
//	}
//}

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
    
    @ExceptionHandler(RuntimeException.class) 
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) { 
    	Map<String, String> error = new HashMap<>(); 
    	error.put("error", ex.getMessage()); 
    	return ResponseEntity.status(401).body(error); 
    } 
}
