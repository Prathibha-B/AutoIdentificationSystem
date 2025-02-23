<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<style>
input, select {
	width: 100%;
	padding: 10px 20px;
	margin: 8px 10px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type=submit] {
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
		<div class="div">
			<div class="row">
				<div class="panel">
					<div class="panel-heading">

						<form action="<%=request.getContextPath()%>/AIPAdminUserServlet"
							method="post">
							<table>
								<tr>
									<td>User Id</td>
									<td><input name="UserId" id="UserId" type="text" required></td>
								</tr>
								<tr>
									<td>What is your birth place?</td>
									<td><input name="AnswerOne" id="AnswerOne" type="text"
										required></td>
								</tr>
								<tr>
									<td>What is your favorite book?</td>
									<td><input name="AnswerTwo" id="AnswerTwo" type="text"
										required></td>
								</tr>
								<tr>
									<td>What is your dogs name?</td>
									<td><input name="AnswerThree" id="AnswerThree" type="text"
										required></td>
								</tr>
								<tr>
									<td>Enter New Password</td>
									<td><input name="password" id="password" type="password"
										required></td>
								</tr>
								<tr>
									<td></td>
									<td><input name="verify" type="submit" value="Verify"
										onclick="check()"></td>

								</tr>
							</table>
						</form>
						<%=request.getAttribute("message")%>

					</div>
				</div>
			</div>
		</div>
</body>
</html>