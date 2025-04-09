
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
		<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">홈페이지</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                게시판
            </div>
            
			<c:forEach var="code" items="${codeList}" >
	            <!-- Nav Item - Pages Collapse Menu -->
	            <li class="nav-item">
	                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo${code.codeNo}"
	                    aria-expanded="true" aria-controls="collapseTwo">
	                    <i class="fas fa-fw fa-cog"></i>
	                    <span>${code.codeName}</span>
	                </a>
	                <div id="collapseTwo${code.codeNo}" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
	                    <div class="bg-white py-2 collapse-inner rounded">
	                        <a class="collapse-item" href="boardList.do?codeNo=${code.codeNo}">게시판 리스트</a>
	                        <a class="collapse-item" href="boardInsert.do?codeNo=${code.codeNo}">게시판 등록</a>
	                    </div>
	                </div>
	            </li>
            </c:forEach>


            <!-- Divider -->
            <hr class="sidebar-divider">


        </ul>        <!-- End of Sidebar -->
