<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                    	${sessionScope.user.name} 님 (${sessionScope.user.id})
                    </div>
                    <div>
                        <p>회원정보</p>
                    </div>
                    <div>
                        <button type="button" class="btn btn-primary" onclick="location.href='update.user' ">회원정보변경</button>
                        <button type="button" class="btn btn-primary" id="delCheck" onclick="ask()">회원 탈퇴</button>
                        
                    </div>
                    <div class="delete-hidden">
                        <form>
                        <input type="password" class="form-control" placeholder="비밀번호를 입력하세요">
                        <button type="button" class="btn btn-primary" >확인</button>
                        </form>
                    </div>
                    
                    <br>
                    <div>
                        <p>작성한 게시물</p>
                        <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="text-align: center;">번호</th>
                            <th style="text-align: center;">제목</th>
                            <th style="text-align: center;">작성일</th>
                            <th style="text-align: center;">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    
						<c:forEach var="vo" items="${myList }">
							<tbody>                        
								<tr>
									<td>${vo.bno }</td>
									<td>
										<a href="content.board?bno=${vo.bno }">
											${vo.title }
										</a>
									</td>
									<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy년MM월dd일  hh:mm:ss"/></td>
									<td>${vo.hit }</td>
								</tr>
							</tbody>
						</c:forEach>
						

                    </tbody>
                </table>
                    </div>
                    
                    
                </div>


            </div>

        </div>

    </section>
    
    <script>
    function ask() {
	    if (confirm('정말 탈퇴하시겠습니까?')) location.href='delete.user'
    }
    </script>
    
<%@ include file="include/footer.jsp" %>


