<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #3b96d6;
}

.parent_header {
	margin: auto;
}

.button_style:hover {
	background-color: grey;
}

.button_style {
	height: 55px;
	width: 152px;
	align-content: center;
	border: 1px solid aliceblue;
	background: white;
	margin-left: 100px;
}

.employee_header {
	color: #ffffff;
	font-size: 35px;
	text-align: center;
	margin-top: 15%;
	margin-bottom: 6%
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
	<div class="parent_header">
		<div class="employee_header">Welcome to Employee Management
			Portal</div>
		<table style="margin-left: 24%;">
			<tr class="addemp">
				<td><a style="text-decoration: none;" href="empform.jsp"><div
							class="button_style">
							<p style="text-align: center; color: #564949">Add Employee</p>
						</div></a></td>
				<td><a style="text-decoration: none;"
					href="getallemployees.htm"><div class="button_style">
							<p style="text-align: center; color: #564949">Show Employees</p>
						</div></a></td>
			</tr>
		</table>
	</div>
</body>

</html>