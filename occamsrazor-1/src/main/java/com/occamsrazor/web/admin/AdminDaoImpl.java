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
		try {
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Admin selectOne(String employNumber) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
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
