package com.occamsrazor.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired AdminDao adminDao;

@Override
public void register(Admin admin) {
	admin.setEmployNumber("1234");
	admin.setPasswd("1");
	admin.setRegisterDate("20200501");
	adminDao.insert(admin);

}

@Override
public boolean login(Admin admin) {
	return true;
} 

@Override
public List<Admin> findAll() {
	return adminDao.selectAll();
}

@Override
public Admin findOne(String employNumber) {
	return adminDao.selectOne(employNumber);
}

@Override
public void modify(Admin admin) {
 adminDao.update(admin);
}

@Override
public void remove(Admin admin) {
	adminDao.delete(admin);
}


}
