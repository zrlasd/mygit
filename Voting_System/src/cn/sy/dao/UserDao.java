package cn.sy.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.sy.domain.User;
import cn.sy.domain.Voter;
import cn.sy.utils.DBUtils;

public class UserDao {
	public Voter login(Voter voter) throws SQLException {
		String sql = "select * from voter_info where username=? and password=?";
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Voter>(Voter.class),
				voter.getUsername(), voter.getPassword());
	}

	public User findCount(User user) throws SQLException {
		String sql = "select count from person_info where name=?";
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),user.getName());
	}

	public void addCount(String name, int count) throws SQLException {
		String sql = "update person_info set count=" + count + " where name=?";
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		runner.update(sql, name);
	}

	public void changeRecord(String username, String dateString) throws SQLException {
		String sql = "update voter_info set record=? where username=?";
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		runner.update(sql, dateString,username);
	}

	public Voter findRecord(String voter) throws SQLException {
		String sql = "select * from voter_info where username=?";
		QueryRunner runner = new QueryRunner(DBUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Voter>(Voter.class), voter);
	}

}
