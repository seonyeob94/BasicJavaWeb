<%@page import="kr.or.ddit.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVo> list = (List)request.getAttribute("list");
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
			</tr>
		</thead>
		<tbody>
			<%
				for(MemberVo member : list){			
			%>
			<tr>
				<td><%= member.getMemNo()%></td>
				<td><%= member.getId()%></td>
				<td><%= member.getName() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>