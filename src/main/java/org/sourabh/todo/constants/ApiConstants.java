package org.sourabh.todo.constants;

public enum ApiConstants {
	NotFound("DATA NOT FOUND"),
	UserNotFound("USER NOT FOUND"),
	Error("SOME ERROR OCCURRED");
	
	 
	private String value;

	ApiConstants(String value) {
	    this.value = value;
	}
	
	public String value()
	{
		return value;
	}
	
}
