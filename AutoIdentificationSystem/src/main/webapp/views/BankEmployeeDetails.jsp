<%@page language="java" import="java.util.*"%>
<%@ page import="com.AutoIdentification.model.BankEmployee"%>

<html>
<head>
<title>Bank Employee Verification</title>
</head>
<body>

	<header>
		<div align="center">
			<h1>Bank Employee Details</h1>
		</div>
	</header>
	<table border="2" style="border-collapse: collapse; width: auto;">
		<thead>
			<tr>
				<td><b>S.No</b></td>
				<td><b>ID</b></td>
				<td><b>First Name</b></td>
				<td><b>Last Name</b></td>
				<td><b>Age</b></td>
				<td><b>Gender</b></td>
				<td><b>Contact Number</b></td>
				<td><b>City</b></td>
				<td><b>State</b></td>
				<td><b>Action</b></td>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
			String id = null;
			List<BankEmployee> bankEmployees = (ArrayList<BankEmployee>) request.getAttribute("bankEmployee");
			%>

			<%
				for (BankEmployee bankEmployee : bankEmployees) {
			%>

			<tr>
				<%
					id = bankEmployee.getUser_Id();
				%>
				<td><%=i++%></td>
				<td><%=bankEmployee.getUser_Id()%></td>
				<td><%=bankEmployee.getFirst_name()%></td>
				<td><%=bankEmployee.getLast_name()%></td>
				<td><%=bankEmployee.getAge()%></td>
				<td><%=bankEmployee.getGender()%></td>
				<td><%=bankEmployee.getContact_number()%></td>
				<td><%=bankEmployee.getCity()%></td>
				<td><%=bankEmployee.getState()%></td>
				<form action="AIPAdminUserServlet" method="post">
					<td><input type="submit" name="reject" value="Reject"></td>
					<td><input type="hidden" name="rejectedbankEmployeeId"
						value="<%=id%>"></td>
						<td> <input type="submit" name="logoff" value="logoff"></td>
				</form>

				<%
					}
				%>
			
		</tbody>
	</table>
</body>
</html>