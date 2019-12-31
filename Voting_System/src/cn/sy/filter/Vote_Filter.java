package cn.sy.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sy.service.UserService;
import cn.sy.domain.Voter;

@WebFilter(filterName = "VoteFilter", urlPatterns = { "/*" })
public class Vote_Filter implements Filter {
	Date currentTime;
	SimpleDateFormat formatter;
	String dateString = null;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		if (path.equals("/vote") || path.equals("/success")) {
			String recordTime = null;
			String voter = (String) request.getSession().getAttribute("user");
			UserService service = new UserService();
			if (voter == null) {
				request.setAttribute("message", "对不起，你还没用登录，请先登录！");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
			try {
				Voter voter2 = service.findRecord(voter);
				recordTime = voter2.getRecord();

				currentTime = new Date();
				formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				dateString = formatter.format(currentTime);

				try {
					Date one = formatter.parse(dateString);
					Date two = formatter.parse(recordTime);
					long time1 = one.getTime();
					long time2 = two.getTime();
					long c = time1 - time2;
					if (c < 24 * 60 * 60) {
						request.setAttribute("message", "对不起，您已经投过票了，明天再来吧！");
						request.getRequestDispatcher("/vote.jsp").forward(request, response);
					}
				} catch (ParseException e1) {
					 e1.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

