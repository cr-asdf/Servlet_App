package com.winter.app.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
    public UserController() {
        super();
     
        userService = new UserService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
	
		uri = uri.substring(uri.lastIndexOf("/")+1);
		ActionForward actionForward = new ActionForward();
		
	try {
			if(uri.equals("join.do")) {
					String method = request.getMethod();
					if(method.toUpperCase().equals("POST")) {
						userService.add(request, actionForward);				
					}else {
						actionForward.setFlag(true);
						actionForward.setPath("/WEB-INF/views/users/join.do");
					}
			}else if(uri.equals("login.do")) {
				String method = request.getMethod();
				
				Cookie [] cookies = request.getCookies();
				for(Cookie cookie: cookies) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}
				if(method.toUpperCase().equals("POST")) {
						userService.login(request, actionForward);
				}else {
					
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/login.jsp");
				}	
			}else if(uri.equals("logout.do")) {
					HttpSession session = request.getSession();
					session.invalidate();
					actionForward.setFlag(false);
					actionForward.setPath("../index.do");
					
				}else if(uri.equals("mypage.do")) {
					
					userService.login(request, actionForward);
					
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/mypage.jsp");
					
				}else if(uri.equals("update.do")) {
					String method = request.getMethod();
					
					if(method.toUpperCase().equals("POST")) {
						userService.update(request, actionForward);
					}
			}else {
				
					userService.update(request, actionForward);
					
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/users/update.jsp");
			}
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	if(actionForward.isFlag()) {
		RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
		view.forward(request, response);
	}else {
		response.sendRedirect(actionForward.getPath());
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
