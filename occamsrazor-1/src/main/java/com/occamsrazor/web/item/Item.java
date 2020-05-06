package com.occamsrazor.web.item;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
@	Component
@Getter @Setter
public class Item {
	private String id, name, date, group, location;
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", id, name, date, group, location);
		
	}
}
