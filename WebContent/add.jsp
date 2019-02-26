<form action="/add" method="post">
<table>
	<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Employee Type</th>
		<th>Department Name</th>
	</tr>
	
	<tr>
		<td><input type="text" name="empId" /></td>
		<td><input type="text" name="empName" /></td>
		<td>
			<select name="empType">
				<option>Permanent Employee</option>
				<option>Intern</option>
			</select>
		</td>
		<td><input type="text" name="deptName" /></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="submit"></td>
	</tr>
</table>
</form>