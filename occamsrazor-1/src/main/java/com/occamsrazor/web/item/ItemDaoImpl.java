package com.occamsrazor.web.item;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;

@Repository
public class ItemDaoImpl implements ItemDao{

	@Override
	public List<Item> selectAll() {
		List<String> list = new ArrayList<>();
		List<Item> itemList = new ArrayList<>();
		String message = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(Data.PATH.toString()+Data.ITEM_LIST+Data.CSV)));
			while ((message = reader.readLine()) !=null) {
				list.add(message);
			}
			reader.close();
			for (int i = 0; i < list.size(); i++) {
				String[] arr = list.get(i).split(",");
				Item item = new Item();
				item.setId(arr[0]);
				item.setName(arr[1]);
				item.setDate(arr[2]);
				item.setGroup(arr[3]);
				item.setLocation(arr[4]);
				itemList.add(item);
			}
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		return itemList;
	}

}
