package com.crawler.pojo;

import java.util.List;

public class Genes {

	private List<Diseases> diseases;

	private String symbol;

	public List<Diseases> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Diseases> diseases) {
		this.diseases = diseases;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
