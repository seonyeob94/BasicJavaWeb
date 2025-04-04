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
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td><%= member.getMemNo() %></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%= member.getId() %></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%= member.getPw() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= member.getName() %></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td><%= member.getRegDate() %></td>
		</tr>
	</table>
	<button onclick="goUpdate(<%= member.getMemNo() %>)">수정</button>
	<button onclick="goDelete(<%= member.getMemNo() %>)">삭제</button>
	<script>
		function goUpdate(memNo){
			location.href = "updateForm?memNo="+memNo;

		}
		function goDelete(memNo){
			location.href = "memberDelete.do?memNO="+memNo;
		}
	</script>
</body>
</html>