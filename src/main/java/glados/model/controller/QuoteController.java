package glados.model.controller;

import glados.model.dao.QuoteDAOInterface;
import glados.model.entities.Quote;
import glados.model.factory.QuoteFactory;

public class QuoteController {
	private QuoteDAOInterface dao;
	private QuoteFactory factory;
	
	public Quote getQuote() {
		factory = new QuoteFactory();
		dao = factory.createQuoteDAO();
		int id = (int) ((Math.random() * (6 - 1)) + 1);
		Quote quote = dao.findById(id);
		return quote;
	}
}
