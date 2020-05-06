package com.occamsrazor.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
@Autowired AdminDao adminDao;

@Override
public void register(Admin admin) {
	
	adminDao.insert(admin);

}

@Override
public boolean login(Admin admin) {
	boolean ok = false;
	if (admin.getPasswd().equals(adminDao.selectOne(admin.getEmployNumber()).getPasswd())) {
		ok = true;
	}
	return ok;
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
