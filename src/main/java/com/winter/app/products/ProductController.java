package com.winter.app.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductService productService;

    public ProductController() {
        super();
        productService = new ProductService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String uri = request.getRequestURI();
	
				uri = uri.substring(uri.lastIndexOf("/")+1);
				ActionForward actionForward = new ActionForward();
				try {
						if(uri.equals("add.do")) {
							String method = request.getMethod();
							if(method.toUpperCase().equals("POST")) {
									productService.add(request, actionForward);
							}else {
								actionForward.setFlag(true);
								actionForward.setPath("/WEB-INF/views/products/list.do");
							
							}	
						}else if(uri.equals("update.do")) {
								String method = request.getMethod();
								
								Cookie [] cookies = request.getCookies();
								
								for(Cookie cookie:cookies) {
									System.out.println(cookie.getName());
									System.out.println(cookie.getValue());
								}
								if(method.toUpperCase().equals("post")) {
									productService.update(request, actionForward);
								}else {
									actionForward.setFlag(true);
									actionForward.setPath("/WEB-INF/views/products/update.do");
							}
						}
						else if(uri.equals("list.do")) {
								String method = request.getMethod();
								productService.getLlist(request, actionForward);
										
								actionForward.setFlag(true);
								actionForward.setPath("/WEB-INF/views/products/list.do");		
							}else if(uri.equals("detail.do")) {
								String method = request.getMethod();
								if(method.toUpperCase().equals("POST")) {
									
									productService.detail(request, actionForward);
								}else {
									
									productService.detail(request, actionForward);
									
									actionForward.setFlag(true);
									actionForward.setPath("/WEB/INF/views/products/detail.do");
								}
							}
								
						}catch (Exception e) {
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
