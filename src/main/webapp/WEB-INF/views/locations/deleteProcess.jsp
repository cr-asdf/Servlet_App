<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id = request.getParameter("location_id");
    LocationDTO locationDTO = new LocationDTO();
    locationDTO.setLocation_id(Long.parseLong(id));
    
    LocationDAO locationDAO = new LocationDAO();
    int result = locationDAO.delete(locationDTO);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(result>0){ %>
<h3>지역 삭제 성공</h3>
<%}else{ %>
<h3>지역 삭제 실패</h3>
<%} %>
<a href="/">Home</a>
<a href="./list.jsp">지역 리스트</a>

</body>
</html>