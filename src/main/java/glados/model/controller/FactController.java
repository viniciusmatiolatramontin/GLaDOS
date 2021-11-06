package glados.model.controller;

import glados.model.entities.RandomFact;
import glados.model.services.FactService;

public class FactController {
	private FactService service;
	
	public RandomFact getFact() {
		service = new FactService();
		return service.getFact();
	}
}
