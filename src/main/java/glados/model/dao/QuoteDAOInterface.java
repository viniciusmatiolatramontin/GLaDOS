package glados.model.dao;

import glados.model.entities.Quote;

public interface QuoteDAOInterface {
	Quote findById(int id);
}
