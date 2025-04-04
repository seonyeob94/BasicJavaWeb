<%@page import="kr.or.ddit.member.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	List<MemberVo> memberList = (List)request.getAttribute("memberList");
%>

	<table border="1">
		<thead>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>NAME</th>
				<th>DATE</th>
			</tr>
		</thead>
		<tbody>
				<%
					for(MemberVo member : memberList){
				%>
					<tr>
						<td><%= member.getMemNo() %></td>
						<td><%= member.getId() %></td>
						<td><%= member.getName() %></td>
						<td><%= member.getRegDate() %></td>
					</tr>
					
				<%
					}
				%>
		</tbody>	
	
	</table>	

</body>
</html>