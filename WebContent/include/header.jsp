<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>BBS Test</title>

    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/custom.css" rel="stylesheet">

</head>
	
<body>

<nav class="navbar navbar-default" id="nav">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath }/">MIN and PARK</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath }/" style="margin-right: 10px;">메인</a></li>
            <li><a href="${pageContext.request.contextPath }/list.board">게시판</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
				
				<c:choose>
				<c:when test="${sessionScope.user == null }">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
				    	<li><a href="${pageContext.request.contextPath }/login.user">로그인</a></li>
						<li><a href="${pageContext.request.contextPath }/join.user">회원가입</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">내 정보<span class="caret"></span></a>
					<ul class="dropdown-menu">
				   		<li><a href="${pageContext.request.contextPath }/mypage.user">마이페이지</a></li>
						<li><a href="${pageContext.request.contextPath }/logout.user">로그아웃</a></li>
					</ul>
				  </c:otherwise>                   
				</c:choose>
                        
            </li>
        </ul>
    </div>
</nav>