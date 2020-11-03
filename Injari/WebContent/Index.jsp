<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.injari.web.member.*" %>
    <%
	// MemberInfoAction에서 넘긴 회원정보를 추출한다.
	MemberDTO member=(MemberDTO)request.getAttribute("memberInfo");
    request.setCharacterEncoding("UTF-8");
    
%>
<%
    String contentPage=request.getParameter("contentPage");
    if(contentPage==null)
        contentPage="Main.jsp";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인자리 - Injari</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div style="margin-top: 40px"><jsp:include page="<%=contentPage%>"/></div> 
<jsp:include page="include/footer.jsp"/>
<%
if(session.getAttribute("sessionEmail") != null && member.getAuthority() == 0){ %>
	<script>
    if (confirm("자세한 정보를 등록하시겠습니까?") == true) {
        //확인
    } else {
        //취소
    }
</script>
<%
}
%>
</body>
</html>