package com.occamsrazor.web.util;

import java.io.File;

public enum Data {
USERS,ADMINS,ITEMS;
	@Override
	public String toString() {
		String returnValue = "C:"+File.separator+"Users"+File.separator+"bit30"+File.separator+"git"+File.separator+"repository2"+File.separator+"occamsrazor-1"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"resources"+File.separator+"file"+File.separator;
		switch (this) {
		case USERS:
			returnValue = returnValue.concat("users.csv") ; break;
		case ADMINS:
			returnValue = returnValue.concat("admins.csv");break;
		case ITEMS:
			returnValue = returnValue.concat("items.csv"); break;
		default:break;
		}
		return returnValue;
	}


}
