package com.occamsrazor.web.user;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.occamsrazor.web.util.Data;
import com.occamsrazor.web.util.Messenger;


@Repository
public class UserDaompl implements UserDao{

	@Override
	public void insert(User user) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Data.PATH.toString()+Data.USER_LIST+Data.CSV),true));
			writer.write(user.toString());
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_INSERT_ERROR);
		}
		
	}

	@Override
	public List<User> selectAll() {
		String message = "";
		List<User> userlist = new ArrayList<User>();
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(Data.PATH.toString()+Data.USER_LIST+Data.CSV)));
			while ((message = reader.readLine()) != null) {
			 list.add(message);
			}
			reader.close();
			for (int i = 0; i < list.size(); i++) {
				String[] arr = list.get(i).split(",");
				User user = new User();
				user.setUserid(arr[0]);
				user.setPasswd(arr[1]);
				user.setName(arr[2]);
				user.setSsn(arr[3]);
				user.setAddr(arr[4]);
				user.setProfile(arr[5]);
				user.setEmail(arr[6]);
				user.setPhoneNumber(arr[7]);
				user.setRegisterDate(arr[8]);
				userlist.add(user);
			}
			
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		return userlist;
	}

	@Override
	public User selectOne(String userid) {
		String message = "";
		User user= new User();
			try {
				BufferedReader reader = new BufferedReader(
						new FileReader(new File(Data.PATH.toString()+Data.USER_LIST+Data.CSV)));
			while((message = reader.readLine()) !=null) {
				String arr[] = message.split(",");
				if (arr[0].equals(userid)) {
					user.setUserid(arr[0]);
					user.setPasswd(arr[1]);
					user.setName(arr[2]);
					user.setSsn(arr[3]);
					user.setAddr(arr[4]);
					user.setProfile(arr[5]);
					user.setEmail(arr[6]);
					user.setPhoneNumber(arr[7]);
					user.setRegisterDate(arr[8]);
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		return user;
	}

	@Override
	public void update(User user) {
try {
	
} catch (Exception e) {
	// TODO: handle exception
}		
	}

	@Override
	public void delete(User user) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
