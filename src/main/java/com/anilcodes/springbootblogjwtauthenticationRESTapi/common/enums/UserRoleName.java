package com.anilcodes.springbootblogjwtauthenticationRESTapi.common.enums;

public enum UserRoleName {
	
	ROLE_ADMIN("admin"), ROLE_USER("user");
	
	private final String name;
	
	UserRoleName(String name){
		this.name = name;
	}
	
	public static UserRoleName fromName(String name) {
		for (UserRoleName userRoleName: UserRoleName.values()) {
			if(userRoleName.name.equalsIgnoreCase(name)) {
				return userRoleName;
			}
		}
		return null;
	}
	
	public String getName() {
		return this.name;
	}

}
