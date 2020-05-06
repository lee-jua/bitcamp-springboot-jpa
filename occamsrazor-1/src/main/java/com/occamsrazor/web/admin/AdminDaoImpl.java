package com.occamsrazor.web.admin;

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
public class AdminDaoImpl implements AdminDao{

	@Override
	public void insert(Admin admin) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(
					new File(Data.PATH.toString() + Data.ADMIN_LIST + Data.CSV), true));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_INSERT_ERROR);
		}
		
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> adminList = new ArrayList<Admin>();
		List<String> list = new ArrayList<String>();
		String message = "";
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader(new File(Data.PATH.toString()+Data.ADMIN_LIST+Data.CSV)));
		while((message = reader.readLine()) !=null) {
			list.add(message);
		}
		reader.close();
		for (int i = 0; i < list.size(); i++) {
			Admin admin = new Admin();
			String[] arr = list.get(i).split(",");
			admin.setEmployNumber(arr[0]);
			admin.setPasswd(arr[1]);
			admin.setName(arr[2]);
			admin.setPosition(arr[3]);
			admin.setProfile(arr[4]);
			admin.setEmail(arr[5]);
			admin.setPhoneNumber(arr[6]);
			admin.setRegisterDate(arr[7]);
			adminList.add(admin);
		}
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		return adminList;
	}

	@Override
	public Admin selectOne(String employNumber) {
		String message = "";
		Admin admin = new Admin();
			try {
				BufferedReader reader = new BufferedReader(
						new FileReader(new File(Data.PATH.toString()+Data.ADMIN_LIST+Data.CSV)));
			while((message = reader.readLine()) !=null) {
				String arr[] = message.split(",");
				if (arr[0].equals(employNumber)) {
					admin.setEmployNumber(arr[0]);
					admin.setPasswd(arr[1]);
					admin.setName(arr[2]);
					admin.setPosition(arr[3]);
					admin.setProfile(arr[4]);
					admin.setEmail(arr[5]);
					admin.setPhoneNumber(arr[6]);
					admin.setRegisterDate(arr[7]);
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		return admin;
	}

	@Override
	public void update(Admin admin) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(Admin admin) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
