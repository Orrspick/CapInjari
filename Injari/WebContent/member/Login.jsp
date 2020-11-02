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
    <script type="text/javascript">
    
    function goSignup() {
		location.href="Signup.do";
	}
    </script>
</head>
<body>
    <main class="page login-page">
        <section class="clean-block clean-form dark">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">로그인</h2>
                    <p>인자리에 오신것을 환영합니다.</p>
                </div>
                <form class="form-signin" action="MemberLoginAction.do" method="post">
                    <div class="form-group"><label for="email">아이디</label><input class="form-control item" type="email" id="email" name="email" required="" autofocus="" placeholder="E-mail"></div>
                    <div class="form-group"><label for="password">비밀번호</label><input class="form-control" type="password" id="pwd" name="password" placeholder="비밀번호" required=""></div>
                    <div class="form-group">
                        <div class="form-check"><input class="form-check-input" type="checkbox" id="checkbox"><label class="form-check-label" for="checkbox">Remember me</label></div>
                    </div><button class="btn btn-primary btn-block" type="submit" value="로그인">로그인</button>
                    <input class="btn btn-primary btn-block" type="button" value="회원가입" onclick="goSignup()" value="회원가입"></form>
            </div>
        </section>
    </main>
    </footer>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
    
		
       <%
       String check = (String)request.getAttribute("scheck");
       if(check!=null && check.equals("1"))
       {
           out.println("<script>");
           out.println("alert('회원가입 성공')");
           out.println("</script>");
       }
       %>
       <%
    // 아이디, 비밀번호가 틀릴경우 화면에 메시지 표시
    			String loginMsg = (String)request.getAttribute("fail");
    				
    			if(loginMsg!=null && loginMsg.equals("0")) 
    			{
    				out.println("<script>");
    		           out.println("alert('비밀번호를 확인해주세요.')");
    		           out.println("</script>");
    			}
    			else if(loginMsg!=null && loginMsg.equals("-1"))
    			{	
    				out.println("<script>");
    		           out.println("alert('아이디를 확인해주세요.')");
    		           out.println("</script>");
    			}
    			
    			
%>
</body>
</html>