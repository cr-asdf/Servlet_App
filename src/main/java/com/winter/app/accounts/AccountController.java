package com.winter.app.accounts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;


@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService accountService;
    public AccountController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String uri = request.getRequestURI();
				
				uri= uri.substring(uri.lastIndexOf("/")+1);
				ActionForward actionForward = new ActionForward();
		try {
			if(uri.equals("")) {
				
			}
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
