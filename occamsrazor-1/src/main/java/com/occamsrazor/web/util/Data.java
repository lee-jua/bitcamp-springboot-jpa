package com.occamsrazor.web.util;

import java.io.File;

public enum Data {
PATH, USER_LIST, CSV,ADMIN_LIST,ITEM_LIST;
	@Override
	public String toString() {
		String message = "";
		switch (this) {
		case PATH:
			message = "C:"+File.separator+"Users"+File.separator+"bit30"+File.separator+"git"+File.separator+"repository2"+File.separator+"occamsrazor-1"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"resources"+File.separator+"file"+File.separator;	break;
		case CSV:
			message = ".csv";break;
		case USER_LIST:
			message = "user_list";break;
		case ADMIN_LIST:
			message = "admin_list";break;
		case ITEM_LIST:
			message = "item_list"; break;
		default:break;
		}
		return message;
	}


}
