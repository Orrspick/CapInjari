<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@page import="java.security.*"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = (String)request.getParameter("email");
String pw = request.getParameter("password");
String name = request.getParameter("name");
String sh = "";

try{
	MessageDigest sha = MessageDigest.getInstance("SHA-256");
	sha.update(pw.getBytes());
	byte byteData[] = sha.digest();
	for(int i = 0; i <byteData.length; i++){
		String x = Integer.toHexString(byteData[i] & 0xff);
		if(x.length()<2)
			sh += "0";
		sh += x;
	}
}catch(NoSuchAlgorithmException e){
	e.printStackTrace();
}

try{
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("db접근됨");
	Connection conn = 
			DriverManager.getConnection("jdbc:mariadb://localhost:3306/injari","injaridb","66457w0");
	Statement stmt = conn.createStatement();
	System.out.println("db연결됨");
	stmt.executeUpdate(
			"insert into user(name,id,password) values('"+ name +"','"+ id +"','"+ sh +"')");
	stmt.close();
	conn.close();
	response.sendRedirect("Login.jsp?Check=1");
}catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>