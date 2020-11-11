<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>

    
     <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 수정</h2>

                    <form action="update.board" method="post">
						<input type="hidden" name="bno" value="${vo.bno }">
						
                        <div class="form-group">
                            <label>글쓴이</label>
                            <input name="writer" value="${vo.writer}" type="text" class="form-control" disabled value="${sessionScope.user.id}">
                        </div>
                        <div class="form-group">
                            <label>제목</label>
                            <input required name="title" value="${vo.title }" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" rows="5" name="content">${vo.content }</textarea>
                        </div>

                        <!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='list.board' ">목록</button>
                            <button type="submit" class="btn btn-info" >수정</button>
                            <button type="button" class="btn btn-default" onclick="ask()" >삭제</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
	</section>
        
        
    <script>
    function ask() {
	    if (confirm('정말 삭제하시겠습니까?')) location.href='delete.board?bno=${vo.bno}'
    }
    </script>
        
        
        
        
<%@ include file="include/footer.jsp" %>


