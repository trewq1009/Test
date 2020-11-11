<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<%@ include file="include/header.jsp"%>

    <section>
       <div class="container">
           <div class="row">
               <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                   <h2>게시판 상세보기</h2>

                   <div class="form-group">
                       <label>등록일</label>
                       <input value=<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd hh:mm:ss"/> type="text" class="form-control" readonly>
                   </div>
                   <div class="form-group">
                       <label>글번호</label>
                       <input value="${vo.bno}" type="text" class="form-control" readonly>
                   </div>
                   <div class="form-group">
                       <label>조회수</label>
                       <input value="${vo.hit}" type="text" class="form-control" readonly>
                   </div>
                   <div class="form-group">
                       <label>글쓴이</label>
                       <input value="${vo.writer}" type="text" class="form-control" placeholder="자유" readonly>
                   </div>
                   <div class="form-group">
                       <label>제목</label>
                       <input value="${vo.title}" type="text" class="form-control" placeholder="자유" readonly>
                   </div>
                   <div class="form-group">
                       <label>내용</label>
                       <textarea class="form-control" rows="5" readonly>${vo.content }</textarea>
                   </div>
                   
                   <div class="form-group">
                       <button type="button" class="btn btn-success" onclick="location.href='list.board' ">목록</button>
                       
					<c:if test="${user.id == vo.writer}">
	                       <button type="button" class="btn btn-info" onclick="location.href='modify.board?bno=${vo.bno}' ">수정</button>
					</c:if>   
				
                   </div>
               </div>
           </div>
       </div>
</section>
	    
<%@ include file="include/footer.jsp" %>


