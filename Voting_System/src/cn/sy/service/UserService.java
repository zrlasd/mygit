package cn.sy.service;

import java.sql.SQLException;

import cn.sy.dao.UserDao;
import cn.sy.domain.User;
import cn.sy.domain.Voter;

public class UserService {

	public Voter login(Voter voter) throws SQLException {
		
		return new UserDao().login(voter);
	}

	public User findCount(User user) throws SQLException {
		return new UserDao().findCount(user);
	}

	public void addCount(String name,int count) throws SQLException {
		new UserDao().addCount(name,count);
	}

	public void changeRecord(String username, String dateString) throws SQLException {
		new UserDao().changeRecord(username, dateString);
	}

	public Voter findRecord(String voter) throws SQLException {
		return new UserDao().findRecord(voter);
	}



	
}
