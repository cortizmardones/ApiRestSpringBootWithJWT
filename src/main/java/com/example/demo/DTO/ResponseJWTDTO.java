package com.example.demo.DTO;

import lombok.Data;

@Data
public class ResponseJWTDTO {
	
	private String messageResult;
	private String jwtoken;
	
	public ResponseJWTDTO() {
		
	}
	
	public ResponseJWTDTO(String messageResult, String jwtoken) {
		this.messageResult = messageResult;
		this.jwtoken = jwtoken;
	}
	
	

}
