<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

.update_header {
	color: #ffffff;
	font-size: 35px;
	text-align: center;
	margin-top: 7%;
	margin-bottom: 6%
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Details</title>
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
			alert("deliveryGroup can't be blank");
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

	<div class="update_header">Update Employee Details.</div>

	<table cellpadding="13" style="margin: auto;">
		<form name="form1" action="modify.htm"
			onsubmit="return validateForm()" method="POST">
			<tr>
				<td><p class="label">Employee ID</p></td>
				<td><input class="textbox" type="text" name="empid"
					value="${emp.empid}" readonly /></td>
			</tr>

			<tr>
				<td><p class="label">Name</p></td>
				<td><input class="textbox" type="text" name="name"
					value="${emp.name}" /></td>
			</tr>
			<tr>
				<td><p class="label">Designation</p></td>
				<td><input class="textbox" type="text" name="designation"
					value="${emp.designation }" /></td>
			</tr>
			<tr>
				<td><p class="label">Technology</p></td>
				<td><input class="textbox" type="text" name="technology"
					value="${emp.technology }" /></td>
			</tr>
			<tr>
				<td><p class="label">Delivery Group</p></td>
				<td><input class="textbox" type="text" name="deliveryGroup"
					value="${emp.deliveryGroup}" /></td>
			</tr>
			<tr>
				<td><p class="label">Location</p></td>
				<td><input class="textbox" type="text" name="location"
					value="${emp.location }" /></td>
			</tr>
	</table>
	<table cellpadding="10" cellspacing="40"
		style="margin: auto; margin-left: 28%">
		<tr>
			<td class="buttons" style="background-color: white"><input
				style="border: none; background-color: white" type="submit"
				action="" value="Update" /></td>
			<td><a style="text-decoration: none;" href="getallemployees.htm"><div
						class="button_style">
						<p style="text-align: center; color: #564949">Show Employees</p>
					</div></a></td>

		</tr>

		<tr>
			<td align="center"><div
					style="color: #009933; font-weight: bold;">${UPDATESTATUSMESSAGE}</div></td>
		</tr>

	</table>
	</form>

</body>
</html>