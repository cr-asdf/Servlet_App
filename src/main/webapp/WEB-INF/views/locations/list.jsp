<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/common.jsp"%>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<%@ include file="../template/header.jsp"%>
	<section class="wrap_left contents">
		<%@ include file="../template/nav.jsp"%>
		<div class="right contents_right">
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>지역 번호</th>
							<th>지역 명</th>
						</tr>
					</thead>
					<tbody>
				
					<c:forEach items="${list}" var="d" varStatus="st">
					
						<tr>
							<td>
								${pageScope.l.location_id}
								
								<h4>현재 아이템 : ${st.current}</h4>
								<h4>인덱스 번호 : ${st.index}</h4>
								<h4>순서 번호  : ${st.count}</h4>
								<h4>첫번째인가 ? : ${st.first}</h4>
								<h4>마지막인가 ? : ${st.last}</h4>
								
							</td>
							<td><a
								href="./detail.do?location_id=${l.location_id}">${l.city}</a>
							</td>
						</tr>
					</c:forEach>	

					</tbody>
				</table>
			</div>
			<div>
				<a href="add.do">지역 등록</a>
			</div>


		</div>

	</section>

	<%@ include file="../template/footer.jsp"%>



</body>
</html>