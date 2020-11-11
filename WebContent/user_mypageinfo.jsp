<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    
                    <p>*표시는 필수 입력 표시입니다</p>
                    <table class="table">
                        <tbody class="m-control">
                            <tr>
                                <td class="m-title">*ID</td>
                                <td><input id="id" disabled class="form-control input-sm" value="${sessionScope.user.id }"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*이름</td>
                                <td><input id="name" class="form-control input-sm" value="${sessionScope.user.name }"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호</td>
                                <td><input type="password" id="password" class="form-control input-sm"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호확인</td>
                                <td><input type="password" id="password_confirm" class="form-control input-sm"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*E-mail</td>
                                <td>
                                    <input id="email" class="form-control input-sm" value="${sessionScope.user.email }">@
                                    <select id="email_provider" class="form-control input-sm sel">
                                        <option value="naver.com" selected={select("${sessionScope.user.email }", "naver.com")}>naver.com</option>                                        
                                        <option value="gmail.com" selected={select("${sessionScope.user.email }", "gmail.com")}>gmail.com</option>
                                        <option value="daum.net" selected={select("${sessionScope.user.email }", "daum.net")}>daum.net</option>
                                    </select>
                                    <button class="btn btn-info">중복확인</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*휴대폰</td>
                                <td>
                                    <input id="phone_first" class="form-control input-sm sel" value="${sessionScope.user.phoneFirst }"> -
                                    <input id="phone_second" class="form-control input-sm sel" value="${sessionScope.user.phoneSecond }"> -
                                    <input id="phone_third" class="form-control input-sm sel" value="${sessionScope.user.phoneThird }">
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*주소</td>
                                <td><input id="address" class="form-control input-sm add" value="${sessionScope.user.address }"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*상세주소</td>
                                <td><input id="address_detail" class="form-control input-sm add" value="${sessionScope.user.addressDetail }"></td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <div class="titlefoot">
                        <button type="button" onclick="check()" class="btn">수정</button>
                        <button type="button" onclick="location.href='mypage.user' " class="btn">목록</button>
                    </div>
                   

                   
                    <form action="updateForm.user" method="post" name="updateForm" hidden>
						<input id="id_post" name="id">
						<input type="password" id="password_post" name="password">
						<input id="name_post" name="name">
						<input id="phone_first_post" name="phone_first">
						<input id="phone_second_post" name="phone_second">
						<input id="phone_third_post" name="phone_third">
						<input id="email_post" name="email">
						<input id="email_provider_post" name="email_provider">
						<input id="address_post" name="address">
						<input id="address_detail_post" name="address_detail">
                    </form>
                </div>


            </div>

        </div>

    </section>
   
<script>
	function select(input, target) {
		if(input == target) return "selected"
		else return ""
	}
</script>
   
<script>
	function check() {
		
		if($('#id').val().trim().length < 4) {
			alert("아이디는 4자리이상 필수 입니다");
			return; //함수 종료
		} else if($('#password').val().trim().length < 4 ) {
			alert("비밀번호는 4자리 이상입니다");
			return;
		} else if($('#password').val() != $('#password_confirm').val()) {
			alert("비밀번호 확인란을 확인하세요");
			return;
		} else if($('#name').val().trim() == '') {
			alert("이름은 필수 입니다");
			return;
		} else if($('#phone_first').val().trim() == '' 
				|| $('#phone_second').val().trim() == '' 
				|| $('#phone_third').val().trim() == '') {
			alert("전화번호는 필수 입니다");
			return;
		} else if($('#email').val().trim() == '') {
			alert("이메일은 필수 입니다");
			return;
		} else if($('#address').val().trim() == '') {
			alert("주소는 필수 입니다");
			return;
		}  else if($('#address_detail').val().trim() == '') {
			alert("상세주소는 필수 입니다");
			return;
		} else {
			$('#id_post').val($('#id').val());
			$('#password_post').val($('#password').val());
			$('#name_post').val($('#name').val());
			$('#phone_first_post').val( $('#phone_first').val());
			$('#phone_second_post').val( $('#phone_second').val());
			$('#phone_third_post').val($('#phone_third').val());
			$('#email_post').val( $('#email').val());
			$('#email_provider_post').val($('#email_provider').val());
			$('#address_post').val($('#address').val());
			$('#address_detail_post').val( $('#address_detail').val());
		
			document.updateForm.submit();
		}

	}
</script>

<%@ include file="include/footer.jsp" %>
