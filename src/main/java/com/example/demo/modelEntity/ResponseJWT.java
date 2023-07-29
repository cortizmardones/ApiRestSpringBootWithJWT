package com.example.demo.modelEntity;

import lombok.Data;

@Data
public class ResponseJWT {
	
	private String messageResult;
	private String jwtoken;
	
	public ResponseJWT() {
		
	}
	
	public ResponseJWT(String messageResult, String jwtoken) {
		this.messageResult = messageResult;
		this.jwtoken = jwtoken;
	}
	
	

}
