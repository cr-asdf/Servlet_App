package com.winter.app.locations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private LocationService locationService;
    public LocationController() {
        super();
        
        locationService = new LocationService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	String uri = request.getRequestURI();
	
	uri = uri.substring(uri.lastIndexOf("/")+1);
	String path="";
	ActionForward actionForward = new ActionForward();
	actionForward.setFlag(true);
	actionForward.setPath("/WEB-INF/views/errors/notfound.jsp");
	try {
		switch (uri) {
		case "list.do":
			locationService.getList(request,actionForward);
			
			break;

		case "detail.do":
			locationService.getDetail(request, actionForward);
			
			break;
			
		case "add.do" :
			String method = request.getMethod();
			if(method.toUpperCase().equals("POST")) {
			locationService.add(request,actionForward);
		}else {
			actionForward.setFlag(true);
			actionForward.setPath("/WEB-INF/views/locations/add.jsp");
		}
		break;
		
		case "update.do" :
			String m = request.getMethod();
			if(m.toUpperCase().equals("POST")) {
				locationService.updateProcess(request,actionForward);
			}else {
				locationService.update(request,actionForward);
			}
			break;
			
		case "delete.do":
			locationService.delete(request, actionForward);
			break;
		}	
	}catch(Exception e) {
		e.printStackTrace();
	}
	RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
	view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
