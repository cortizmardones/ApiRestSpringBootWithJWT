package com.example.demo.CONTROLLER;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.DTO.ResponseJWTDTO;
import com.example.demo.MODEL_ENTITY.Persona;
import com.example.demo.SERVICE.PersonaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/token")
@Slf4j
public class JWTController {

	@Value("${secret.key}")
	private String secretKey;
		
	@Autowired
	private PersonaService personaService;

	@GetMapping("/getToken/{user}/{password}")
	public ResponseEntity<ResponseJWTDTO> getToken(@PathVariable String user, @PathVariable String password) {
		if (!validateUserAndPass(user.toLowerCase().trim(), password.toLowerCase().trim())) {
			log.error("Invalid credentials, a JWT will not be generated");
			return ResponseEntity.noContent().build();
			//return new ResponseEntity<ResponseJWT>(new ResponseJWT("Credenciales inválidas",""), HttpStatus.BAD_GATEWAY);
		}
		try {
			
			//Devuelve la hora actual del sistema en milisegundos.
		    long nowMillis = System.currentTimeMillis();
		    Date now = new Date(nowMillis);
			//PARAMETRO MILISEGUNDOS (1000 milisegundos == 1 segundo)
			//(MEDIA HORA)
			long ttlMillis = 18000000;
			long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        
	        //String secretKeyBase64Encode = Base64.getUrlEncoder().encodeToString(secretKey.getBytes());
	        //String secretKeyBase64Encode = Base64.getEncoder().encodeToString(secretKey.getBytes());
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
	
			String token = JWT.create()
								.withIssuer(user)
								//.withIssuedAt(now)
								//.withExpiresAt(exp)
								.sign(algorithm);
			log.info("Json Web Token generado: " + token);
			ResponseJWTDTO responseJWT = new ResponseJWTDTO();
			responseJWT.setJwtoken(token);
			responseJWT.setMessageResult("JWT generado exitosamente");
			return ResponseEntity.ok(responseJWT);
		} catch (JWTCreationException e) {
			log.error("Invalid Signing configuration / Couldn't convert Claims.", e);
		}
		return ResponseEntity.noContent().build();
	}

	public boolean validateToken(String token, String user) {
		log.info("Token recibido por usuario: '" + user + "' para validar: " + token );
		if (token != null && !token.isEmpty()) {
			try {
				//String secretKeyBase64Encode = Base64.getUrlEncoder().encodeToString(secretKey.getBytes());
				//String secretKeyBase64Encode = Base64.getEncoder().encodeToString(secretKey.getBytes());
				Algorithm algorithm = Algorithm.HMAC256(secretKey);
				JWTVerifier verifier = JWT.require(algorithm)
											//.withIssuer(user)
											.build();
				DecodedJWT decodedJWT = verifier.verify(token);
				//Claim claimsIss = decodedJWT.getClaim("iss");
				//Claim claimsIat = decodedJWT.getClaim("iat");
				//log.info("Claims 'iss' rescatado: " + claimsIss.toString());
				//log.info("Claims 'iat' rescatado: " + claimsIat.toString());
				return token.equals(decodedJWT.getToken());
			} catch (JWTVerificationException e) {
				log.error("Invalid signature/claims", e);
				return false;
			}
		} else {
			log.error("Token Nulo , no se realizará request");
			return false;
		}
	}

	public boolean validateUserAndPass(String user, String password) {
		try {
			Optional<Persona> persona = personaService.validateUserAndPass(user, password);
			if(persona.isPresent()) {
				return true;
			}
		} catch (Exception e) {
			log.error("Error", e);
		}
		return false;
	}

}
