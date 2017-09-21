<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
</head>
<body>
<table border=1 align="right" cellspacing=0>
<tr>
<th>
<a href="login.jsp" name="login">로그인</a> 
<a href="register.jsp" name="register">회원가입</a> 
<a href="findlogin.jsp" name="findlogin">ID/PW찾기</a> 
</th>
</tr>
</table><br><br>
<table border=1 align="center" cellspacing=0>
<tr>
<th align=center>
<a href="home.jsp"><font size=6>FarmPAM</font></a></th>
<th>
<a href="notice.jsp">공지사항</a>
</th></tr>
</table><br>>
<table border=1 align="center">
<tr>
<td>
<input type=text>
<input type="button" value="검색">
</td>
</tr>
</table><br><br>

<table border=1 cellpadding=1 align="center" width=600px height=250px cellspacing=0>
<tr><td>
아이디<input type=text style="margin-left:77px;"> 
</td>
<td rowspan=2 width=100px><input type=button style="width:200px;height:150px; font-size:30px" value="Login">
</td>
</tr>
<tr><td>
비밀번호<input type=text style="margin-left:61px;">
</td></tr>
</table>
<table align="center" cellspacing=0>
<tr>
<td>
<a href="register.jsp">회원가입</a>
<a href="findlogin.jsp"  style="margin-left:16px;">ID/PW찾기</a>
</td>
</tr>
</table>
</body>
</html>