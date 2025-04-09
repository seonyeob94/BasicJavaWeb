<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.ProdTypeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<ProdTypeVo> typeList = (List)request.getAttribute("typeList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	메인페이지</br>
	<select id="typeList">
		<option value ="-1">선택해주세요</option>
		<% 
			for(ProdTypeVo type : typeList){
			String select ="";
			
		%>
			<option value="<%= type.getTypeNo() %>"><%=type.getTypeName() %></option>
		<%
			}
		%>	
	</select>
	
	<select id="typeList2">
		<option value ="-1">선택해주세요</option>
		
	</select>
	<div id="prodResult">	</div>
	
	<script type="text/javascript">
	let productList = [];


	// 셀렉트 선택 했을때 알림창 뛰워보기
		var typeList = document.getElementById("typeList");
	
		typeList.addEventListener("change", function(){
			
			var select = typeList.value;
			
			$.ajax({
				type : 'post',
				url  : '/0407_Prod/typeList2' ,
				data :{
					typeNo : select
				},
				success: function(data){
					console.log(data);
					var str ="<option value ='-1'>선택하세요.</option>";
					for(var i =0; i<data.length;i++){
						var type = data[i];						
						str +='<option value='+type.typeNo+'>'+type.typeName +'</option>'
					}
					$('#typeList2').html(str);
				}
			})
			
		})
		
		//셀렉트 2 선택 했을때 알림창 띄어보기
		var typeList2 = document.getElementById('typeList2')
		typeList2.addEventListener("change", function(){
// 			alert("알림창")
			var select = typeList2.value;
			
			$.ajax({
				type : 'post',
				url  : '/0407_Prod/prodList' ,
				data :{
					typeNo : select
				},
				success: function(data){
					
					console.log(data);
					productList = data;
					renderTable(productList);
					
					
					
					
				}
			})
		})
		
		function renderTable(data){
					let str  = "<table border='1'>";
					str += "<tr><th>상품번호</th><th><a href='#' onclick='proc1(); return false;'>상품명</a></th>";
					str += "<th>내용</th><th>가격</th></tr>";
					
					for(var i=0;i<data.length;i++){
						let prod=data[i];
						str += "<tr>";
						str += "<td>"+prod.prodNo+"</td>";
						str += "<td>"+prod.name+"</td>";
						str += "<td>"+prod.content+"</td>";
						str += "<td>"+prod.price+"</td>";
						str += "</tr>";
					}
					
					str += "</table>"
					document.getElementById("prodResult").innerHTML = str;
			
		}
		
		const proc1= () =>{
			productList.sort((a, b) => a.name.localeCompare(b.name));
			
			renderTable(productList);
			
			
		}
	</script>
</body>
</html>