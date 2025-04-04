<%@page import="kr.or.ddit.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVo> memberList = (List)request.getAttribute("memberList");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>NAME</th>
				<th>DATE</th>
			</tr>
		</thead>""
		<tbody>
			<% for(MemberVo member : memberList){
			%>
			<tr>
				<td><%= member.getMemNo() %></td>
				<td><%= member.getId() %></td>
				<td><a href="memberDetail?memNo=<%= member.getMemNo() %>"> <%= member.getName() %></td>
				<td><%= member.getRegDate() %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<button onclick="goInsert()">등록</button>
	<script>
		function goInsert(){
			location.href="memberInsert.do";
		}

	</script>
</body>
</html>