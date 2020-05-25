package com.tcgmetis.demotcgmetis.models;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class GenericQueryForDaas {
	
	@NotEmpty(message = "Datasource may not be empty")
	@Pattern(regexp = "mongo|mysql", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String datasource;
	private LinkedHashMap<String, Object> query;
	
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public LinkedHashMap<String, Object> getQuery() {
		return query;
	}
	public void setQuery(LinkedHashMap<String, Object> query) {
		this.query = query;
	}
	
	@Override
	public String toString() {
		return "GenericQueryForDaas [datasource=" + datasource + ", query=" + query + "]";
	}
	
	
		

}
