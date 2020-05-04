package com.occamsrazor.web.util;

import java.io.File;

public enum Data {
USER_PATH, ADMIN_PATH, LIST, CSV;
	@Override
	public String toString() {
		String message = "";
		switch (this) {
		case USER_PATH:
			message = "C:"+File.separator+"Users"+File.separator+"bit30"+File.separator+"git"+File.separator+"repository2"+File.separator+"occamsrazor-1"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"user "+File.separator;	break;
		case ADMIN_PATH:
			message = "C:"+File.separator+"Users"+File.separator+"bit30"+File.separator+"git"+File.separator+"repository2"+File.separator+"occamsrazor-1"+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator+"admin "+File.separator;	break;
		case CSV:
			message = ".csv";break;
		case LIST:
			message = "list";break;
		default:break;
		}
		return message;
	}


}
