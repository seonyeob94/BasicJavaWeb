<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String state = (String)request.getAttribute("state");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="main.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>
		</table>
		<input type="submit" value="로그인">
	</form>
	<script type="text/javascript">
		var state = "<%= state %>";
		if(state === 'fail'){
			alert("로그인 실패");
		}
		
		
	</script>
	
</body>
</html>