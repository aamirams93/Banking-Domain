package com.excelsoft.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.excelsoft.enties.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ApiError> handle(Exception e)
	
	 {
		ApiError error=new ApiError();
		error.setMsg(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<ApiError>resp=new ResponseEntity(error,HttpStatus.NOT_FOUND);
		return resp;
	}
}