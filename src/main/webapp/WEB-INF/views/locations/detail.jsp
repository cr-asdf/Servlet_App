<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<c:choose>
		<c:when test="${not empty dto}">
		
		<h3>${dto.location_id}</h3>
		<h3>${dto.city}</h3>
		<h3>${dto.street_address}</h3>
		
		<a href="./update.do?location_id=${requestScope.dto.location_id}">지역 수정</a>
		<a href="./update.do?location_id=${requestScope.dto.lacation_id}">지역 삭제</a>	
		</c:when>
		
		
		
		<c:otherwise>
		<h3>지역 정보가 없다</h3>
		</c:otherwise>
		</c:choose>	
	<h1>Location Detail Page</h1>	
		
		
	



</body>
</html>