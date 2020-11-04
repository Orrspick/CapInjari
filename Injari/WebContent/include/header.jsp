<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.injari.web.member.*" %>
    <%
	// MemberInfoAction에서 넘긴 회원정보를 추출한다.
	MemberDTO member = (MemberDTO)request.getAttribute("memberInfo");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
    
    <script type="text/javascript">
		
		function changeView(value){
			
			if(value == "0") // HOME 버튼 클릭시 첫화면으로 이동
			{
				location.href="index";
			}
			else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
			{
				location.href="member/Login";
			}
			else if(value == "2") // 회원가입 버튼 클릭시 회원가입 화면으로 이동
			{
				location.href="member/JoinForm.do";
			}
			else if(value == "3") // 로그아웃 버튼 클릭시 로그아웃 처리
			{
				location.href="MemberLogoutAction.do";
			}
			else if(value == "4") // 내정보 버튼 클릭시 회원정보 보여주는 화면으로 이동
			{
				location.href="MemberInfoAction.do";
			}
		}
	</script>
</head>
<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
        <div class="container"><a class="navbar-brand logo" href="Index.do">인자리</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link active" onclick="changeView(0)">Home</a></li>
                    <li class="nav-item"><a class="nav-link" onclick="changeView(0)">인자리</a></li>
                    <%
                    if(session.getAttribute("sessionEmail") != null) {
                    %>
                    <li class="nav-item dropdown"><a class="nav-link" data-toggle="dropdown" aria-expanded="false" href="#"> <%=session.getAttribute("name") %> 님</a>
                        <div class="dropdown-menu"><a class="dropdown-item" href="#">알림(0)</a><a class="dropdown-item" href="Mypage.do">마이페이지</a><a class="dropdown-item" href="MemberLogoutAction.do">로그아웃</a></div>
                    </li>
                    <%} else {%>
					<li class="nav-item"><a class="nav-link" href="Login.do">로그인</a></li>
                    <%} %>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>