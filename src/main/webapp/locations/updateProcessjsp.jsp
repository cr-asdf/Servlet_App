<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("location_id");
	String ad = request.getParameter("street_address");
	String p = request.getParameter("postal_code");
	String c = request.getParameter("city");
	
	
	LocationDTO locationDTO = new LocationDTO();
	
	locationDTO.setLocation_id(Long.parseLong(id));
	locationDTO.setStreet_address(ad);
	locationDTO.setPostal_code(p);
	locationDTO.setCity(c);
	
	
	
	LocationDAO locationDAO = new LocationDAO();
	int result =locationDAO.update(locationDTO);

	String r = "지역 등록 실패";
	if(result>0) {
		r="지역 등록 성공";
		
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%= r %></h3>
	<a href="/">Home</a>
	<a href="./list.jsp">지역 리스트</a>
</body>
</html>