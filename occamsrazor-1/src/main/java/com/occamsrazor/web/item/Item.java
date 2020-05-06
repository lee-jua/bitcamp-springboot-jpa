package com.occamsrazor.web.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
	private String id, name, date, group, location;
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", id, name, date, group, location);
		
	}
}
