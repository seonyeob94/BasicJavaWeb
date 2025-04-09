<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.ProdTypeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<ProdTypeVo> typeList = (List)request.getAttribute("typeList");
	List<ProdTypeVo> typeList2 = (List)request.getAttribute("typeList2");
	Integer typeNo = (Integer)request.getAttribute("typeNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	메인페이지</br>
	<select id="typeList">
		<option value ="-1">선택해주세요</option>
		<% 
			for(ProdTypeVo type : typeList){
			String select ="";
			if(typeNo !=null && type.getTypeNo()==typeNo){
				select = "selected";
			}
		%>
			<option value="<%= type.getTypeNo() %>"><%=type.getTypeName() %>
			</option>
		<%
			}
		%>	
	</select>
	
	<select id="typeList2">
		<option value ="-1">선택해주세요</option>
		<% 
			if(typeList2 != null){
				for(ProdTypeVo type : typeList2){
		%>
			<option value="<%= type.getTypeNo() %>"><%=type.getTypeName() %>
			</option>
		<%
			}
		}
		%>	
	</select>
	<script type="text/javascript">
	// 셀렉트 선택 했을때 알림창 뛰워보기
		var typeList = document.getElementById("typeList");
	
		typeList.addEventListener("change", function(){
			/* alert("알림창") */
			var select = typeList.value;
			
			location.href = 'main.do?typeNo='+select;
		})
	</script>
</body>
</html>