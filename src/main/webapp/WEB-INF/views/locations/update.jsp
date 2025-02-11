<%@page import="com.winter.app.locations.LocationDAO"%>
<%@page import="com.winter.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Update Form</h1>
	<form action="./update.do" method="post">
		<input type="hidden" name="location_id" value="${dto.location_id}">
		<input type="text" name="city" value="${dto.city}">
		<input type="text" name="street_address" value= "${dto.street_address}">
		<input type="text" name= "postal_code" value="${dto.postal_code}">
		<button type="submit">수정</button>
	</form>

</body>
</html>