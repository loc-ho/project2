<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Batch</title>
</head>
<body>
    <h2>Add a New Batch</h2>
    <form action="BatchController" method="post">
        <label>Type of Batch:</label>
        <select name="typeofbatch">
            <option value="Morning">Morning</option>
            <option value="Evening">Evening</option>
        </select>
        <br><br>
        <label>Time:</label>
        <input type="text" name="time" placeholder="e.g., 8am-9am" required>
        <br><br>
        <input type="submit" value="Add Batch">
    </form>
	<a href="index.jsp">Home</a>

</body>
</html>
