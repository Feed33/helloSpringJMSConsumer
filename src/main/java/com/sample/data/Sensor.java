package com.sample.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensor {
	
	private String id;
	private String value;
	
	public Sensor() {
	    super();
	}
	
	@JsonCreator
	public Sensor(
			@JsonProperty("id") String id, 
			@JsonProperty("value") String value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
	  return String.format("Message{id=%s, value=%s}", 
			  	getId(), getValue()
			  );
	}	
	  
	  
}
