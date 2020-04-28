package com.occamsrazor.web.admin;

public interface AdminService {
public void add(Admin member);
public Admin[] list();
public boolean login(Admin member);
public Admin detail(String userid);
public Admin[] SearchByName(String name);
public Admin[] SearchByGender(String ssn);
public int count();
public int namecount(String name);
public int gendercount(String ssn);
public void update(Admin member);
public void delete(Admin member); 
}
