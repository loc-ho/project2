package com.zumba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.zumba.bean.Batch;
import com.zumba.resource.DatabaseResource;

public class BatchDao {
	public List<Batch> viewAllBatch(){
		List<Batch> listOfBatch = new ArrayList<Batch>();
		try {
			Connection con = DatabaseResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Batch");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Batch bb = new Batch();
				bb.setBid(rs.getInt("bid"));
				bb.setTime(rs.getString("time"));
				bb.setTypeofbatch(rs.getString("typeofbatch"));
				listOfBatch.add(bb);
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return listOfBatch;
	}
	
	public int addBatch(Batch b) {
		int status = 0;
		try {
			Connection con = DatabaseResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO Batch (typeofbatch, time) VALUES (?, ?)");
			pstmt.setString(1, b.getTypeofbatch());
			pstmt.setString(2, b.getTime());
			status = pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return status;
	}
}
