package com.example.demo.DTO;

import lombok.Data;

@Data
public class ResponseTokenDTO {
	
	private String messageResult;
	private String jwtoken;
	
	public ResponseTokenDTO() {
		
	}
	
	public ResponseTokenDTO(String messageResult, String jwtoken) {
		this.messageResult = messageResult;
		this.jwtoken = jwtoken;
	}
	
	

}
