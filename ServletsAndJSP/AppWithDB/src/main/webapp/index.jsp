<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
<form action='./RegisterUser' method ='post'>
<table>
		<tr>
			<td>Username</td>
			<td><input type='text' name='username'></td>
		</tr>

		<tr>
			<td>User City</td>
			<td><input type='text' name='city'></td>
		</tr>

		<tr>
			<td><input type='submit' value='signup'></td>
		</tr>
	</table>
</form>
	
</body>
</html>