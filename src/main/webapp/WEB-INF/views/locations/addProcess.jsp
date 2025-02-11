
<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LocationDTO locationDTO = new LocationDTO();
	String name = request.getParameter("location_id");
	String city = request.getParameter("city");
	String address = request.getParameter("street_address");
	
	
	//locationDTO.setLocation_id(Long.parseLong("location_id"));
	locationDTO.setCity(city);
	locationDTO.setStreet_address(address);
	
	LocationDAO locationDAO = new LocationDAO();
	 int result =locationDAO.add(locationDTO);

%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 지역 정보 등록 페이지</h1>
	<% if(result>0) {%>
	<h3>지역 정보 등록 성공</h3>
	<%}else{ %>
	<% }%>
	<a href="/">Home</a>
		<a href="./list.jsp">지역리스트 </a>

</body>
</html>