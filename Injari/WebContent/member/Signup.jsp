<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - Injari</title>
    <script language="JavaScript">
    function checkValue()
    {
        if(!document.userInfo.email.value){
            alert("아이디를 입력하세요.");
            return false;
        }
        
        if(!document.userInfo.password.value){
            alert("비밀번호를 입력하세요.");
            return false;
        }
        
        // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
        if(document.userInfo.password.value != document.userInfo.passwordCheck.value ){
            alert("비밀번호를 동일하게 입력하세요.");
            return false;
        }
    }
	
</script>
</head>
<body>
    <main class="page registration-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">회원가입</h2>
                    <p>인자리 회원가입 페이지 입니다.</p>
                </div>
                <!-- return checkPw(this) 비밀번호 확인 작업 // 이메일 중복은 기회되면...  -->
                <form method="post" onSubmit="return checkValue()" action="MemberSignupAction.do" name="userInfo">
                    <div class="form-group"><label for="name">이름</label><input class="form-control item" type="text" id="name" name="name"></div>
                    <div class="form-group"><label for="email">이메일(아이디)</label><input class="form-control item" type="email" id="email" name="email"></div>
                    <div class="form-group"><label for="password">비밀번호</label><input class="form-control item" type="password" id="password" name="password"></div>
                    <div class="form-group"><label for="password">비밀번호 확인</label><input class="form-control item" type="password" id="passwordCheck"> </div>
                    <button class="btn btn-primary btn-block" type="submit">회원가입</button></form>
            </div>
        </section>
    </main>
</body>
</html>