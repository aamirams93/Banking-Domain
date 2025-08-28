package com.excelsoft.enties;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {
	private String msg;
	private HttpStatus status;

}
