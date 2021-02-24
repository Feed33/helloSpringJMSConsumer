package com.sample.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	
	private String name;
	private String value;
	
	public Order() {
	    super();
	}
	
	@JsonCreator
	public Order(
			@JsonProperty("name") String name, 
			@JsonProperty("value") String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
	  return String.format("Message{name=%s, value=%s}", getName(), getValue());
	}	
	  
	  
}
