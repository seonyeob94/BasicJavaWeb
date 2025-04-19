<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$.ajax({
		url : "boardCodeList.do",
		type : "post",
		success : function(resp){
			console.log(resp);
			for(var i =0; i<resp.length; i++){
				var boardCode = resp[i];
				var option =
				`<option value = "\${boardCode.codeNo}">\${boardCode.codeName}</option>`;
				//"<option value'"+boardCode.codeNo+"'>"+boardCode.codeName+"</option>";
				$("#boardSelect").append(option);
			}
		}
	})

	$(document).ready(function(){
		$("#insertBtn").on('click', function(event){
			//alert("게시글이 등록되었습니다.");
			//이벤트를 막고 벌레데이션 후 전송
			event.preventDefault();//기본동작 방지

			var title =$("input[name='title']").val();
			var content = $("textarea[name='content']").val();
			var codeNo = $("#boardSelect").val();

			if(title === ""){
				alert("제목을 입력하세요");
				return;
			}
			if(content.trim() === ""){
				alert("내용을 입력하세요");
				return;
			}
			if(codeNo === ""){
				alert("게시판을 선택하세요");
				return;
			}

			//ajax로 전송
			//var formData = $("#insertForm").serialize(); // 폼 데이터 정규화
			//console.log(formData);
			
			const formData = new FormData();
			formData.append("title", title);
			formData.append("content", content);
			formData.append("codeNo", codeNo);
			console.log(formData);
			
			
			$.ajax({
				url : "boardInsert.do",
				type : "post",
				data : formData,
				success : function(res){
					location.href="boardList.do";
				},
				error : function(xhr, status, error){
					console.log("Error : "+ error);
				}
			})
		})
	
	})
</script>
</head>
<body>
	<form action="boardInsert.do" method="post" id="insertForm">
		<table border="1">
			<tr>
				<td>게시판 선택</td>
				<td>
					<select id="boardSelect" name="codeNo">
					
					</select>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="abc"></td>
			</tr>
			
			<tr>
				<td colspan="2">내용</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="50" cols="200" name="content">djkljh</textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="등록" id="insertBtn">
	</form>
</body>
</html>