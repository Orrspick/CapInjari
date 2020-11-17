<%@page import="java.util.ArrayList"%>
<%@page import="com.injari.web.company.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>인자리 - Injari</title>
</head>
<body>
    <main class="page landing-page">
        <section class="clean-block about-us">
            <div class="container">
                <div class="block-heading">
                <%if(session.getAttribute("sessionEmail") != null){
                	%>
                	<h2 class="text-info">어서오세요 <%=session.getAttribute("name")%>님</h2>
                    <p>오늘의 인자리는 다음과 같습니다.</p>
                	<% }else{ %>
                	<h2 class="text-info">오늘의 인자리</h2>
                    <p>오늘의 인자리는 다음과 같습니다.</p>
                    <%} %>
                </div>
                
                <div class="row justify-content-center">
                <% CompanyDAO dao = CompanyDAO.getInstance();
                ArrayList<CompanyDTO>slist=dao.getCompany();
                int i = 0;
                for(CompanyDTO dto:slist){
                %>
                    <div class="col-sm-6 col-lg-4" style="margin-top: 9px;">
                        <a href="CompanyDetailAction.cop?cid=<%=dto.getCid()%>">
                            <div class="card clean-card text-center"><img class="card-img-top w-100 d-block" src="assets/img/avatars/avatar1.jpg">
                                <div class="card-body info">
                                    <h4 class="card-title"><%=dto.getCname()%></h4>
                                    <p class="card-text"><%=dto.getShotinfo() %></p>
                                </div>
                            </div>
                        </a>
                    </div>
                    <% } %>
            </div>
           
        </section>
    </main>
    <%
if(session.getAttribute("sessionEmail") != null && session.getAttribute("authority").equals(0)){ %>
	<script>
    if (confirm("자세한 정보를 등록하시겠습니까?") == true) {
    	location.href="DetailSignup.do";
    } else {
        
    }
</script>
<%}%>
</body>
</html>