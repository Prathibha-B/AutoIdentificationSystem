<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help Form</title>
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
						<form action="AIPAdminUserServlet" method="post">
							<table>
								<tr>
									<td>Description of the issue <input name="Description"
										type="text"></td>
								</tr>
								<tr>
									<td>For further details contact +9087774856</td>
								</tr>
								<tr>
									<td><input type="submit" name="help" value="submit"></td>
								</tr>

							</table>
							
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>