<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role Selection</title>
</head>
<style>
input , select{
  width: 100%;
  padding: 10px 20px;
  margin: 8px 10px;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=submit],[type=reset]{
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
  align:center;
  width:40%;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px ;
  
}
</style>
<body>
<center>

<div class="div">
<h1>Role Selection</h1>
<form action="<%=request.getContextPath()%>/RoleSelectionServlet" method="post">
<select name="role" id="role">
<option> Select</option>
<option id="AIP Admin"> AIP Admin </option>
<option id="Bank Employee"> Bank Employee </option>
</select>
<input type="submit" value="Register"><input type="reset" value="reset">
</form>
</div>
</center>
</body>
</html>