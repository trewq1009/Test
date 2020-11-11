<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>

    <style type="text/css">
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 0 auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
        
        
        .form-group > .sel {
            width: 120px;
            display: inline-block;
            
        }
    </style>
    
    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2 class="center-text-align">회원가입</h2>

                    <form action="joinForm.user" method="post" name="regForm">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input name="id" type="text" class="form-control" id="id" placeholder="아이디를 (영문포함 4~12자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input name="password" type="password" class="form-control" id="password" placeholder="비밀번호 (영 대/소문자, 숫자, 특수문자 3종류 이상 조합 8자 이상)">
                        </div>
                        <div class="form-group">
                            <label for="password-confrim">비밀번호 확인</label>
                            <input name="password_confirm" type="password" class="form-control" id="password-confrim" placeholder="비밀번호를 확인해주세요.">
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input name="name" type="text" class="form-control" id="name" placeholder="이름을 입력하세요.">
                        </div>

                        <div class="form-group">
                            <label for="hp">휴대폰번호</label><br>
                            
                            <input name="phone_first" class="form-control sel" placeholder="010"> -
                            <input name="phone_second" class="form-control sel" placeholder="xxxx"> -
                            <input name="phone_third" class="form-control sel" placeholder="xxxx">
                        
                        </div>
                        <div class="form-group">
                             <label for="hp">이메일</label><br>
                            <input name="email" class="form-control sel">@
                            <select name="email_provider" class="form-control sel">
                                <option value="naver.com">naver.com</option>
                                <option value="gmail.com">gmail.com</option>
                                <option value="daum.net">daum.net</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="addr-num">주소</label>
                            <input name="address" type="text" class="form-control" id="addr-basic" placeholder="기본주소">
                        </div>
                        <div class="form-group">
                            <input name="address_detail" type="text" class="form-control" id="addr-detail" placeholder="상세주소">
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-success btn-block" onclick="check()">회원가입</button>
                        </div>
                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="location.href='login.user' ">로그인</button>
                        </div>
                    </form>
                    
                	<span style="color:red;">${msg }</span>
                </div>
            </div>
        </div>
    </section>
    
    
<script>
	function check() {
		
		if(document.regForm.id.value.trim().length < 4) {
			alert("아이디는 4자리이상 필수 입니다");
			return; //함수 종료
		} else if(document.regForm.password.value.trim().length < 4 ) {
			alert("비밀번호는 4자리 이상입니다");
			return;
		} else if(document.regForm.password.value != document.regForm.password_confirm.value) {
			alert("비밀번호 확인란을 확인하세요");
			return;
		} else if(document.regForm.name.value.trim() == '') {
			alert("이름은 필수 입니다");
			return;
		} else if(document.regForm.phone_first.value.trim() == '' 
				|| document.regForm.phone_second.value.trim() == '' 
				|| document.regForm.phone_third.value.trim() == '') {
			alert("전화번호는 필수 입니다");
			return;
		} else if(document.regForm.email.value.trim() == '') {
			alert("이메일은 필수 입니다");
			return;
		} else if(document.regForm.address.value.trim() == '') {
			alert("주소는 필수 입니다");
			return;
		}  else if(document.regForm.address_detail.value.trim() == '') {
			alert("상세주소는 필수 입니다");
			return;
		} else {
			document.regForm.submit();
		}

	}
</script>
        
<%@ include file="include/footer.jsp" %>


