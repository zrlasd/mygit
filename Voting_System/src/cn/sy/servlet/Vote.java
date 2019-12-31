package cn.sy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sy.domain.User;
import cn.sy.service.UserService;

@WebServlet(name = "VoteServlet", urlPatterns = { "/vote" })
public class Vote extends HttpServlet {

	Date currentTime;
	SimpleDateFormat formatter;
	String dateString = null;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User exsitUser = new User();
		String name = request.getParameter("username");
		User user = new User();
		user.setName(name);
		UserService service = new UserService();
		currentTime = new Date();
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateString = formatter.format(currentTime);
		String username = (String) request.getSession().getAttribute("user");
		try {
			service.changeRecord(username,dateString);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			exsitUser = service.findCount(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (exsitUser != null && name.equals("zhaoliu")) {
			int count = exsitUser.getCount();
			count += 1;
			try {
				service.addCount(name, count);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("count", "投票成功：" + name + "当前票数为" + count);
			request.getRequestDispatcher("/vote.jsp").forward(request, response);
			return;
		} else if (exsitUser != null && name.equals("wangwu")) {
			
			int count = exsitUser.getCount();
			count += 1;
			try {
				service.addCount(name, count);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("count", "投票成功：" + name + "当前票数为" + count);
			request.getRequestDispatcher("/vote.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("message", "请选中你要投的人！");
			request.getRequestDispatcher("/vote.jsp").forward(request, response);
			return;
		}

	}

}
