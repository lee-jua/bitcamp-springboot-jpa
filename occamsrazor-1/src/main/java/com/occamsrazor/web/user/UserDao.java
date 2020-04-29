package com.occamsrazor.web.user;

import java.util.List;

public interface UserDao {
	public void insert(User user);
	public List<User> selectAll();
	public User selectOne();
	public void update(User user);
	public void delete(User user);

}
