package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

	@Test
	public void apiGetAllRazasTest() {
		String urlComplete = "http://localhost:8080/raza/listar";
		log.info("Inicio petición :  '" + urlComplete + "'");
		try {

			HttpClient cliente = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(urlComplete))
					.header("Authorization", getBasicAuthenticationHeader("admin", "to_be_encoded"))
					.GET()
					.build();

			HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() != 200) {
				log.info("Resultado EstatusCode: " + response.statusCode());
				log.info("Resultado petición : " + urlComplete + " = " + response.body() + "\n");
			} else {
				log.info("Resultado EstatusCode: " + response.statusCode());
				log.info("Resultado petición : " + urlComplete + " = " + response.body() + "\n");
			}

			// PRUEBA COMO TAL
			assertEquals(200, response.statusCode());

		} catch (Exception e) {
			log.error("Error en la llamada: ", e);
		}

	}

	private static final String getBasicAuthenticationHeader(String username, String password) {
		String valueToEncode = username + ":" + password;
		return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	}

}
