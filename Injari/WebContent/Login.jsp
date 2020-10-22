<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login - Injari</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>
<body>
    <nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href="index.html">인자리</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="features.html">인자리</a></li>
                    <li class="nav-item dropdown"><a class="nav-link" data-toggle="dropdown" aria-expanded="false" href="#">USER_NAME</a>
                        <div class="dropdown-menu"><a class="dropdown-item" href="#">알림(0)</a><a class="dropdown-item" href="mypage.html">마이페이지</a><a class="dropdown-item" href="logout.jsp">로그아웃</a></div>
                    </li>
                    <li class="nav-item"><a class="nav-link active" href="login.html">로그인</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <main class="page login-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">로그인</h2>
                    <p>인자리에 오신것을 환영합니다.</p>
                </div>
                <form class="form-signin" action="Login_Query.jsp" method="post">
                    <div class="form-group"><label for="email">아이디</label><input class="form-control item" type="email" id="email" name="email" required="" autofocus="" placeholder="E-mail"></div>
                    <div class="form-group"><label for="password">비밀번호</label><input class="form-control" type="password" id="pwd" name="pwd" placeholder="비밀번호" required=""></div>
                    <div class="form-group">
                        <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Remember me</label></div>
                    </div><button class="btn btn-primary btn-block" type="submit" value="로그인">로그인</button><button class="btn btn-primary btn-block" type="button" value="회원가입" onclick="location.href=&#39;Signup.jsp&#39;">회원가입</button></form>
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
    <%
String check = request.getParameter("Check");
if(check==null){
    check="";
}
       if(check.equals("1"))
       {
           out.println("<script>");
           out.println("alert('회원가입 성공')");
           out.println("</script>");
       }
       else if(check.equals("-1")){
    	   out.println("<script>");
           out.println("alert('로그인 실패 다시 시도해주세요.')");
           out.println("</script>");
       }
%>
</body>
</html>