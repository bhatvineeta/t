<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style type="text/css">
body {
	background-color: #30362e;
}

.label {
	color: white;
	font-size: 17px;
	font-family: sans-serif;
	font-weight: lighter;
}

.textbox:focus {
	background-color: #878f854d;
}

.employee_header {
	color: #ffffff;
	font-size: 28px;
	text-align: center;
	margin-top: 11%;
	margin-bottom: 2%;
	margin-left: -25%;
}

.buttons:hover {
	background-color: #878f854d;
}

.button_style {
	height: 41px;
	width: 150px;
	align-content: center;
	border: 1px solid aliceblue;
	background: white;
	margin-left: 80%;
	margin-top: -5%;
}

.textbox {
	border-radius: 0px;
	border: none;
	height: 32px;
	width: 323px;
	background-color: #30362e;
	border-bottom: 1px solid white;
	text-color: white;
	color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
	function validateForm() {
		var name = document.form1.name.value;
		var designation = document.form1.designation.value;
		var technology = document.form1.technology.value;
		var deliveryGroup = document.form1.deliveryGroup.value;
		var location = document.form1.location.value;

		if (name == null || name == "") {
			alert("Name can't be blank");
			return false;

		}
		if (designation == null || designation == "") {
			alert("Designation can't be blank");
			return false;

		}
		if (technology == null || technology == "") {
			alert("Technology can't be blank");
			return false;

		}

		if (deliveryGroup == null || deliveryGroup == "") {
			alert("DeliveryGroup can't be blank");
			return false;

		}
		if (location == null || location == "") {
			alert("Location can't be blank");
			return false;

		}
		return true;

	}
</script>
<body>
	<div class="employee_header">Please Enter Employee Details.</div>
	<a style="text-decoration: none;" href="getallemployees.htm">
		<div class="button_style">
			<p style="text-align: center; color: #564949">Show Employees</p>
		</div>
	</a>
	<table cellpadding="13" style="margin: auto;">
		<form name="form1" modelAttribute="employee" action="insert.htm"
			onsubmit="return validateForm()" method="POST">
			<tr>
				<td><p class="label">Name</p></td>
				<td><input class="textbox" type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><p class="label">Designation</p></td>
				<td><input class="textbox" type="text" name="designation" /></td>
			</tr>
			<tr>
				<td><p class="label">Technology</p></td>
				<td><input class="textbox" type="text" name="technology" /></td>
			</tr>
			<tr>
				<td><p class="label">Delivery Group</p></td>
				<td><input class="textbox" type="text" name="deliveryGroup" /></td>
			</tr>
			<tr>
				<td><p class="label">Location</p></td>
				<td><input class="textbox" type="text" name="location" /></td>
			</tr>
	</table>
	<table cellpadding="10" cellspacing="40"
		style="margin: auto; margin-left: 28%">
		<tr>
			<%
				
			%>
			<td class="buttons" style="background-color: white"><input
				style="border: none; background-color: white" type="submit"
				action="" id="submitbutton" value="Register" /></td>
			<td class="buttons" style="background-color: white"><input
				style="border: none; background-color: white" type="reset"
				value="Reset" /></td>
		</tr>

		<tr>
			<td align="center"><div style="color: red; font-weight: bold;">${REGISTRATIONSTATUSMESSAGE}</div></td>
		</tr>

	</table>
	</form>

</body>
</html>