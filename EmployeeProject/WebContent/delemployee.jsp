<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-color: #30362e;
}

.rows:hover {
	background-color: #ffffff;
	color: #000000;
}

.button_style {
	height: 55px;
	width: 152px;
	align-content: center;
	border: 1px solid aliceblue;
	background: white;
	margin-left: 25px;
}

td {
	border-bottom: none;
}

.rows {
	border-bottom: 1px solid white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>




	<table style="margin-left: 2%; margin-top: 5%">
		<tr class="addemp">
			<td><a style="text-decoration: none;" href="empform.jsp"><div
						class="button_style">
						<p style="text-align: center; color: #564949">Add Employee</p>
					</div></a></td>
			<td><a style="text-decoration: none;" href="index.jsp"><div
						class="button_style">
						<p style="text-align: center; color: #564949">Home</p>
					</div></a></td>
		</tr>
	</table>
	<div
		style="color: red; font-weight: bold; margin-top: 4%; margin-left: 40%">${DELETESTATUSMESSAGE}</div>
</body>
</html>
