<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<h2>Please Login to user service</h2>
		<form>
			Email: <input type="text" size="10"  />
			Password: <input type="password" size="10"  />
			<input type="submit" value="Login"  />
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html>