<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Employee login page</title>
</head>

<style>
input, select {
	width: 100%;
	padding: 10px 20px;
	margin: 8px 10px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type=submit], [type=Login] {
	width: 40%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input:hover {
	background-color: lightblue;
}

.div {
	align: center;
	width: 40%;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>
	<center>
		<div class="div">
			<h1>Employee login page</h1>
			<form action="<%=request.getContextPath()%>/BankEmployeeUserServlet"
				method="post">
				<p>
					User_Id <input name="User_Id" type="text">
				</p>
				<p>
					Password<input name="Password" type="password">
				</p>
				<input type="submit" name="login" value="Login"><input type="reset"
					value="reset">
			</form>
		</div>
	</center>
</body>
</html>