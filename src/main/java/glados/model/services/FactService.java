package glados.model.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import glados.model.entities.RandomFact;

public class FactService {

	public RandomFact getFact() {
		String catUrl = "https://uselessfacts.jsph.pl/random.json?language=en";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(catUrl))
				.build();
		HttpResponse<String> response = null;
		
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		RandomFact fact = null;
		
		try {
			fact = mapper.readValue(response.body(), new TypeReference<RandomFact>() {});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fact;
	}
}
