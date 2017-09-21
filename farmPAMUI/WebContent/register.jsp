<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
<table border=1 align="right"  cellspacing=0>
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
</table><br>
<table border=1 align="center">
<tr>
<td>
<input type=text>
<input type="button" value="검색">
</td>
</tr>
</table>

<table border=1 align="center" width=600px height=550px  cellspacing=0>
<tr>
<td>
<div style="margin-left:32px;">
아이디<input type=text style="margin-left:77px;"><input type="button" value="중복확인" style="margin-left:16px;"> <br><br>
비밀번호<input type=text style="margin-left:61px;"><br><br>
비밀번호 확인<input type=text style="margin-left:24px;"><br><br>
이름<input type=text style="margin-left:93px;"><br><br>
핸드폰 번호<input type=text style="margin-left:40px;"><br><br>
이메일<input type=text style="margin-left:77px;"><br><br>
질문<input type=text style="margin-left:93px;"><br><br>
답<input type=text style="margin-left:109px;"><br><br>
주소(시)<input type=text style="margin-left:65px;"><br><br>
나머지 주소<input type=text style="margin-left:40px;">
</div>
</td>
</tr>
</table>

</body>
</html>