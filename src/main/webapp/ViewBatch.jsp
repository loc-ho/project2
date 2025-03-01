<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.zumba.bean.Batch" %>
<%@ page import="com.zumba.dao.BatchDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Batches</title>
</head>
<body>
    <h2>List of Batches</h2>
    <table border="1">
        <tr>
            <th>Batch ID</th>
            <th>Type</th>
            <th>Time</th>
        </tr>
        <%
            BatchDao dao = new BatchDao();
            List<Batch> list = dao.viewAllBatch();
            for (Batch b : list) {
        %>
        <tr>
            <td><%= b.getBid() %></td>
            <td><%= b.getTypeofbatch() %></td>
            <td><%= b.getTime() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
