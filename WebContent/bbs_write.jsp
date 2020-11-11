<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>

    <style>
        .table-striped {
            text-align: center; 
            border: 2px solid #737373; 
        }

        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }
    </style>
    
    <section>
        <div class="container" style="margin-top: 5%;">
            <div class="row">
                <form name="writeForm" method="post" ACTION="register.board">
                    <table class="table table-striped" >
                        <thead>
                            <tr>
                                <th colspan="2" style="background-color: #9DCAFF; text-align: center;">게시판 글쓰기</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                <input type="text" class="form-control" placeholder="작성자" maxlength="50" disabled value="${sessionScope.user.id}">
                                </td>
                            </tr>
                            <tr>
                                <td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50"></td>
                            </tr>
                            <tr>
                                <td><textarea rows="15" class="form-control" placeholder="1000 글자 이하" name="content" maxlength="1000" ></textarea></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <input type="button" class="btn btn-primary pull-left" value="목록" onclick="location.href='list.board' ">
                    <input type="button" class="btn btn-primary pull-right" value="글쓰기" onClick="check()">
                </form>
            </div>
        </div>
    </section>
    
    <script>

	function check() {
		
		if(document.writeForm.title.value.trim().length < 1) {
			alert("제목을 입력하세요");
			return;
		} else {
			document.writeForm.submit();
		}
	}
    </script>
	    
<%@ include file="include/footer.jsp" %>


