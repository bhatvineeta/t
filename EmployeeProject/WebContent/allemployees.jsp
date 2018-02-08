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

.employee_header {
	color: #ffffff;
	font-size: 35px;
	text-align: center;
	margin-top: 7%;
	margin-bottom: 6%
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employees</title>
</head>
<script>
	function validateSearch() {
		var serach_empid = document.form1.search_empid.value;
		if (serach_empid == null || serach_empid == "") {
			alert("Insert Employee ID ");
			return false;
		}
		return true;
	}
</script>
<body>
	<div class="employee_header" align="center">Welcome to Employee
		Management Portal</div>
	<form method="get" action="search.htm"
		onsubmit="return validateSearch()" name="form1">
		<table style="margin-left: 80%">
			<tr>
				<td><input placeholder="search here" class="searchbox"
					type="text" name="search_empid" /> <input
					style="border: none; background-color: white" type="submit"
					value="Search" /></td>
			</tr>
		</table>

	</form>


	<table class="content" width="96%" align="center" cellpadding="10"
		style="border: 2px solid white; background: #fbf1ee4d; margin-top: 2%">
		<tr style="background-color: #1d1b1b;">
			<th style="color: white" scope="col">EMP ID</th>
			<th style="color: white" scope="col">NAME</th>
			<th style="color: white" scope="col">DESIGNATION<br /></th>
			<th style="color: white" scope="col">LOCATION</th>
			<th style="color: white" scope="col">DELIVERY GROUP</th>
			<th style="color: white" scope="col">TECHNOLOGY</th>
			<th style="color: white" scope="col">UPDATE</th>
			<th style="color: white" scope="col">DELETE</th>

		</tr>
		<c:forEach var="i" items="${allemployee}">
			<tr class="rows">
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center">${i.empid}</td>
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center">${i.name}</td>
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center">${i.designation}</td>
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center">${i.location}</td>
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center">${i.deliveryGroup}</td>
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center">${i.technology}</td>

				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center"><c:url var="updatepage" value="updatepage.htm">
						<c:param name="employeeId" value="${i.empid}" />
					</c:url> <a style="color: #1e2571" href="${updatepage}">Update</a>
				<td
					style="border-right: 2px solid white; border-bottom: 2px solid white"
					align="center"><c:url var="deletepage" value="deletepage.htm">
						<c:param name="empid" value="${i.empid}" />
					</c:url> <a style="color: #1e2571" href="${deletepage}">Delete</a>
			</tr>



		</c:forEach>


	</table>
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
		<tr>
			<td align="center"><div
					style="color: #009933; font-weight: bold;">${UPDATESTATUSMESSAGE}</div></td>
		</tr>
	</table>
	<div
		style="color: #009933; font-weight: bold; margin-top: 4%; margin-left: 40%" >${DELETESTATUSMESSAGE}</div>
</body>
</html>