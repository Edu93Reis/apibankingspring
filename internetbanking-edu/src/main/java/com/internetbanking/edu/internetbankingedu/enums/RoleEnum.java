package com.internetbanking.edu.internetbankingedu.enums;

public enum RoleEnum {
	
	ROLE_USER( "0" ),	
	ROLE_ADMIN( "1" ); 
	
	private String value;
	
	private RoleEnum( String value ) 
	{
		this.value = value;
	}

	public String getValue( ) 
	{
		return value;
	}

}
