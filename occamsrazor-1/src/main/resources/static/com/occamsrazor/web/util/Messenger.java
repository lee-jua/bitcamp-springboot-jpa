package com.occamsrazor.web.util;

public enum Messenger {
	SUCCESS, FAIL, FILE_SELECT_ERROR, FILE_INSERT_ERROR;
	
	@Override
	public String toString() {
		String returnValue = ""; 
		switch (this) {
		case FILE_SELECT_ERROR: returnValue ="파일 출력 시 에러 발생";break;
		case FILE_INSERT_ERROR : returnValue = "파일 입력 시 에러 발생";break;
		default:	break;
		}
		return returnValue;
	}
}
