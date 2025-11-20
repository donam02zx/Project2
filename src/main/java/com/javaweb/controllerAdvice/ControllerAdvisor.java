package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customexceptions.FieldRequiredException;
import com.javaweb.model.ErrorResponseDTO;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
            ArithmeticException ex, WebRequest request) {
		
		ErrorResponseDTO errDTO = new ErrorResponseDTO();
		errDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("So nguyen khong chia cho 0 duoc!");
		errDTO.setDetails(details);
		
        
        return new ResponseEntity<>(errDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiedException(
            FieldRequiredException ex, WebRequest request) {
		
		ErrorResponseDTO errDTO = new ErrorResponseDTO();
		errDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Kiem tra xem name voi number co null khong!");
		errDTO.setDetails(details);
		
        
        return new ResponseEntity<>(errDTO, HttpStatus.BAD_GATEWAY);
	}
}
