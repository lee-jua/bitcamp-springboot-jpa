package com.occamsrazor.web.user;

import java.util.List;

public interface UserService {
public void add(User user);
public int count(); //인공지능으로 public이 추가된다 신기하다
public User login(User user);
public User detail(String userid);
public boolean update(User user);
public boolean remove(String userid);
public List<User> list();
}
