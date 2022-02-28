<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"> 
<title>BookStore Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>Create New User Form</h2>
	</div>
	
	<div align="center">
		<form action="create_user" method="post" onsubmit="return validateFormInput()">
			<table> 
				<tr>
					<td align="right">Email:</td>
					<td align="left"><input type="text" name="email" size="20"/></td>
				</tr>
				<tr>
					<td align="right">Full Name:</td>
					<td align="left">
						<input type="text" name="fullname" size="20"/>
					</td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td align="left">
						<input type="password" name="password" size="20"/>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save"/>
						<input type="button" value="Cancel"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
</body>
<script type="text/javascript">
	function validateFormInput() {
		let email = document.getElementById("email")
		let fullName = document.getElementById("fullname")
		let password = document.getElementById("password")
		
		if (email.value.length === 0) {
			alert("Email is required!")
			email.focus()
			return false
		}
		if (fullname.value.length === 0) {
			alert("fullname is required!")
			fullname.focus()
			return false
		}
		if (password.value.length === 0) {
			alert("password is required!")
			password.focus()
			return false
		}
	}
</script>
</html>