<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AIP Admin Registration</title>
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

input[type=submit], [type=Register] {
	width: 40%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=radio] {
	width: 15%;
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
						<h1>AIP Admin Registration Form</h1>
					</div>
					<div class="panel-body">
						<form action="<%=request.getContextPath()%>/AIPAdminServlet"
							method="post">
							<table>
								<tr>
									<td>First Name</td>
									<td><input name="First_name" type="text" id="f_name"
										required
										onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)"
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>Last Name</td>
									<td><input name="Last_name" type="text" id="l_name"
										required
										onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)"
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>Age</td>
									<td><input name="Age" type="number" id="age" min="18"
										max="60" size="8" required
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<td>Gender</td>
								<td>Male<input name="Gender" id="Gender" type="radio"
									value="male"> Female<input name="Gender" id="Gender"
									type="radio" value="female"></td>
								</tr>
								<tr>
									<td>Contact Number</td>
									<td><input name="Contact_number" id="c_number" type="text"
										pattern="[6-9]{1}[0-9]{9}" required
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>City</td>
									<td><input name="City" id="City" type="text" size="10"
										required
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>State</td>
									<td><input name="State" id="State" type="text" size="10"
										required
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>User Id</td>
									<td><input name="User_Id" id="User_Id" type="text"
										size="10" required
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input name="Password" id="password" type="password"
										min="5" max="15" size="10" required
										oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
										oninput="this.setCustomValidity('')"></td>
								</tr>
								<tr>
									<td>What is your birth place?</td>
									<td><input name="AnswerOne" id="AnswerOne" type="text" required></td>
								</tr>
								<tr>
									<td>What is your favorite book?</td>
									<td><input name="AnswerTwo" id="AnswerTwo" type="text" required></td>
								</tr>
								<tr>
									<td>What is your dogs name?</td>
									<td><input name="AnswerThree" id="AnswerThree" type="text" required></td>
								</tr>
								<tr>
									<td></td>
									<td><input name="submit" type="submit" value="Register"
										onclick="check()"></td>
								</tr>
							</table>
						</form>
						</form>
						<form action="<%=request.getContextPath()%>/AIPAdminLoginServlet"
							method="post">
							If already registered Click <input name="submit" type="submit"
								value="login">
						</form>
					</div>
				</div>
			</div>
		</div>
	</center>
</body>
</html>