<%@page import="kr.or.ddit.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="boardList.do" method="get">
	<input type="text" name="search"><input type="submit" value="검색">
	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="등록">
	
	</form>
</body>
</html>
	