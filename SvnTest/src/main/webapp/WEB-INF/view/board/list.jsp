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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#search').on("keyup", function(){
			var searchValue =$("#search").val();
			$.ajax({
				url : "boardList.do",
				type : "post",
				data : {search : searchValue},
				success : function(resp){
					$("#boardList").empty(); //기존 내용 삭제
					if(resp.length == 0){
						$("boardList").append("<tr><td colspan='4'>검색결과가 없습니다.</td></tr>");
						return;
					}
					else{
						$.each(resp, function(index, board){
						var row = 
						    "<tr>" +
							"<td>" + board.title + "</td>" +
							"<td>" + board.content + "</td>" +
							"<td>" + board.regDate + "</td>" +
							"<td>" + board.cnt + "</td>" +
							"</tr>";
						$("#boardList").append(row);	
					});
					}
					
					
				}
				
			})

		});
	})

	function goBoardWrite(codeNo){
		location.href="boardInsert.do?codeNo="+codeNo;
	}

</script>
</head>
<body>
	<form action="boardList.do" method="get">
	<input type="text" name="search" id="search"><input type="submit" value="검색">
	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>내용</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody id="boardList">
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
	<input type="button" value="등록" onclick="goBoardWrite(1)">
	
	</form>
</body>
</html>
	