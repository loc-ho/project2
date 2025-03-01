<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.zumba.bean.Batch, com.zumba.dao.BatchDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Participant</title>
</head>
<body>
    <h2>Add a New Participant</h2>
    <form action="ParticipantsController" method="post">
        <label>First Name:</label>
        <input type="text" name="fname" required><br><br>

        <label>Last Name:</label>
        <input type="text" name="lname" required><br><br>

        <label>Age:</label>
        <input type="number" name="age" required><br><br>

        <label>Phone Number:</label>
        <input type="text" name="phonenumber" required><br><br>

        <label>Select Batch:</label>
        <select name="bid">
            <%
                BatchDao dao = new BatchDao();
                List<Batch> batchList = dao.viewAllBatch();
                for (Batch b : batchList) {
            %>
            <option value="<%= b.getBid() %>"><%= b.getTypeofbatch() %> - <%= b.getTime() %></option>
            <%
                }
            %>
        </select>
        <br><br>

        <input type="submit" value="Add Participant">
    </form>
    	<a href="index.jsp">Home</a>
</body>
</html>
