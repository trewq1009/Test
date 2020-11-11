<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>

    <style>
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 100px auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
    </style>
    
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2 class="center-text-align">로그인</h2>
                    
                    <form action="loginForm.user" method="post">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input name="id" type="text" class="form-control" id="id" placeholder="아이디">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input name="password" type="password" class="form-control" id="password" placeholder="비밀번호 ">
                        </div>
                       
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="location.href='join.user' ">회원가입</button>
                        </div>
                       
                        <div class="form-group">
                            <button type="submit" class="btn btn-lg btn-info btn-block">로그인</button>
                        </div>
                    </form>
                    
                	<span style="color:red;">${msg }</span>
                </div>
            </div>
        </div>
    </section>
        
<%@ include file="include/footer.jsp" %>


