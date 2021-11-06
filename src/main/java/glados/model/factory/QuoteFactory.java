package glados.model.factory;

import glados.model.dao.QuoteDAO;

public class QuoteFactory {
	public QuoteDAO createQuoteDAO() {
		return new QuoteDAO();
	}
}
