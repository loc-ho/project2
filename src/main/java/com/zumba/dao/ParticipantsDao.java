package com.zumba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.zumba.bean.Participants;
import com.zumba.resource.DatabaseResource; 

public class ParticipantsDao {

    public List<Participants> viewParticipants() {
        List<Participants> listOfParticipants = new ArrayList<>();
        try {
            Connection con = DatabaseResource.getDbConnection();  
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Participants");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listOfParticipants.add(new Participants(
                    rs.getInt(1),  // pid
                    rs.getString(2),  // fname
                    rs.getString(3),  // lname
                    rs.getInt(4),  // age
                    rs.getString(5),  // phonenumber
                    rs.getInt(6)   // bid (foreign key)
                ));
            }

        } catch (Exception e) {
            System.err.println(e.toString());  // Corrected placement of catch block
        }
        return listOfParticipants;
    }


    public int addParticipants(Participants p) {
        int status = 0;
        try {
            Connection con = DatabaseResource.getDbConnection();
            PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO Participants (fname, lname, age, phonenumber, bid) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, p.getFname());
            pstmt.setString(2, p.getLname());
            pstmt.setInt(3, p.getAge());
            pstmt.setString(4, p.getPhonenumber());
            pstmt.setInt(5, p.getBid());

            status = pstmt.executeUpdate();  // Execute query
 
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return status;  
    }
}
