<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Register - Injari</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <script language="JavaScript">
	function checkPw(form) {
	pw1 = form.password.value
	pw2 = form.passwordCheck.value;

	if (pw1 != pw2) {
		alert ("패스워드가 동일하지 않습니다")
		return false;
	}
		else return true;
	}
</script>
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href="main.jsp">인자리</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="main.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="features.html">인자리</a></li>
                    <li class="nav-item dropdown"><a class="nav-link" data-toggle="dropdown" aria-expanded="false" href="#">USER_NAME</a>
                        <div class="dropdown-menu"><a class="dropdown-item" href="#">알림(0)</a><a class="dropdown-item" href="mypage.html">마이페이지</a><a class="dropdown-item" href="logout.jsp">로그아웃</a></div>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="Login.jsp">로그인</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page registration-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">회원가입</h2>
                    <p>인자리 회원가입 페이지 입니다.</p>
                </div>
                <!-- return checkPw(this) 비밀번호 확인 작업 // 이메일 중복은 기회되면... -->
                <form method="post" onSubmit="return checkPw(this)" action="Sign_Query.jsp">
                    <div class="form-group"><label for="name">이름</label><input class="form-control item" type="text" id="name" name="name"></div>
                    <div class="form-group"><label for="email">이메일</label><input class="form-control item" type="email" id="email" name="email"></div>
                    <div class="form-group"><label for="password">비밀번호</label><input class="form-control item" type="password" id="password" name="password"></div>
                    <div class="form-group"><label for="password">비밀번호 확인</label><input class="form-control item" type="password" id="passwordCheck"> </div>
                    <button class="btn btn-primary btn-block" type="submit">회원가입</button></form>
            </div>
        </section>
    </main>
    <footer class="page-footer dark">
        <div class="footer-copyright">
            <p>© 2020 Capstone Design</p>
        </div>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>
</html>