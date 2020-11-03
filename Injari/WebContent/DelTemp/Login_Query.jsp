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
String pw = request.getParameter("pwd");
String name = new String();
int uid = 0;
int authority = 0;
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
	ResultSet rs = stmt.executeQuery("select uid,id,name,authority from user where id='"+id+"' and password='"+sh+"'");
	
	if(rs.next()){
		name = rs.getString("name");
		uid = rs.getInt("uid");
		authority = rs.getInt("authority");
		
		session.setAttribute("sessionID", id);
		session.setAttribute("name", name);
		session.setAttribute("uid", uid);
		session.setAttribute("authority", authority);
		stmt.close();
		conn.close();
		response.sendRedirect("Main.jsp");
	}
	else{
		response.sendRedirect("Login.jsp?check=-1");
	}
}catch(Exception e){
	e.printStackTrace();
}

%>

</body>
</html>