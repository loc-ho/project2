<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.zumba.bean.Participants, com.zumba.dao.ParticipantsDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Participants</title>
</head>
<body>
    <h2>List of Participants</h2>
    <table border="1">
        <tr>
            <th>Participant ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Phone Number</th>
           <th>Batch ID</th>
        </tr>
        <%
            ParticipantsDao dao = new ParticipantsDao();
            List<Participants> list = dao.viewParticipants();
            for (Participants p : list) {
        %>
        <tr>
            <td><%= p.getPid() %></td>
            <td><%= p.getFname() %></td>
            <td><%= p.getLname() %></td>
            <td><%= p.getAge() %></td>
            <td><%= p.getPhonenumber() %></td>
            <td><%= p.getBid() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
