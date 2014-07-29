package com.codetest.enums;

public enum ClientType {
	STANDARD,
	PRIVILIGED,
	SPECIAL;
	
	public static String allNames() {
		String allNames = ""; 
		ClientType[] values = values();
		for (ClientType clientType : values) {
			allNames  = allNames +  " " + clientType.name();
		}
		return allNames;
	}
	
	public boolean isSpecial() {
		return (this.equals(ClientType.SPECIAL));
	}
}
