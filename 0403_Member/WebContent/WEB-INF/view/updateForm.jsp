<%@page import="kr.or.ddit.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%
	MemberVo member = (MemberVo)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberUpdate.do" method="post">
		<input type="hidden" name="memNo" value="<%= member.getMemNo() %>">
		<table border="1">
			
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%= member.getId() %>"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" value="<%= member.getPw() %>"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%= member.getName() %>"></td>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>	
</body>
</html>