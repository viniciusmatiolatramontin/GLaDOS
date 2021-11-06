package glados.model.entities;

public class Quote {
	private String quoteString;
	
	public Quote(String quoteString) {
		this.setQuoteString(quoteString);;
	}

	public String getQuoteString() {
		return quoteString;
	}

	public void setQuoteString(String quoteString) {
		if(quoteString == null || quoteString.isEmpty()) {
			throw new IllegalArgumentException("Erro, string invalida");
		}
		
		this.quoteString = quoteString;
	}
	
	
	
}
