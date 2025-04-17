<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enc 타입을 쓴 이유 : 파일업로드 할때는 content타입잉 아니라 멀티part 써줘야함 -->
	<form action="upload.do" method="post" enctype="multipart/form-data">
		파일 선택 : <input type="file" name="file"><br>
		
		<input type="text" name="id">
		<input type="text" name="pw">
		<input type="text" name="name">

		<input type="submit" value="업로드">
	</form>
</body>
</html>