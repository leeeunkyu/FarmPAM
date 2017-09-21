<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>홈페이지</title>
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
</table><br><br><br>

<table border=1 align="center" cellspacing=0>
<tr>
<th align=center>
<a href="home.jsp"><font size=6>FarmPAM</font></a></th>
<th>
<a href="notice.jsp">공지사항</a>
</th></tr>
</table><br>

<table border=1 align="center" cellspacing=0>
<tr>
<td>
<input type=text>
<input type="button" name="search" value="검색">
</td>
</tr>
</table><br>

<table border=1 align="center" cellspacing=0 width=700px height=400px>
<tr><td align="center">
<a href="notice_info.jsp" >(공지)00000000000</a>
</td></tr>
<tr>
<td width=700px height=400px align="center">
내용
</td>
</tr>
</table>
</body>
</html>