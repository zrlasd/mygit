package cn.sy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.sy.domain.Voter;
import cn.sy.service.UserService;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class Login extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Voter voter = new Voter();
		voter.setUsername(username);
		voter.setPassword(password);
		UserService service = new UserService();
		try {
			Voter existVoter = service.login(voter);
			if (existVoter == null) {
				request.setAttribute("message", "登录失败：用户名或密码错误！");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
				return;
			} else {
				request.getSession().setAttribute("user",existVoter.getUsername());
				response.sendRedirect(request.getContextPath() + "/success.jsp");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
