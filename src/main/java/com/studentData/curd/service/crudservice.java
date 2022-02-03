package com.studentData.curd.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentData.curd.model.crudmodel;

public class crudservice {
	
	Connection con;

	
	public crudservice(){
		
		try {
			String url =String.format("jdbc:mysql://localhost:3306/STUDENT");
			String uname ="root";
			String pwd = "4399";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}

	
	public crudmodel insertSTUDENT(crudmodel STUDENT) {
		String insert = "insert into STUDENT(stud_no,stud_name,stud_DOB,stud_DOJ) values(?,?,?,?) ";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, STUDENT.getId());
			ps.setString(2, STUDENT.getName());
			ps.setInt(3, STUDENT.getStud_DOB());
			ps.setInt(4, STUDENT.getStud_DOJ());
			
			ps.execute();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return STUDENT;
		
	}
	
	public ArrayList<crudmodel> getSTUDENT() throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		
		String select = "select * from STUDENT";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			
			model.setId(rs.getInt("stud_no"));
			model.setName(rs.getString("stud_name")); 
			model.setStud_DOB(rs.getInt("stud_DOB"));
			model.setStud_DOJ(rs.getInt("stud_DOJ"));
			
			data.add(model);
			
		}
		
		return data;
		
	}
	
	
	public ArrayList<crudmodel> getSTUDENTById(int id) throws SQLException{
		
		ArrayList<crudmodel> data = new ArrayList<crudmodel>();
		String select = "select * from STUDENT where stud_no =?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			crudmodel model = new crudmodel();
			model.setId(rs.getInt("stud_no"));
			model.setName(rs.getString("stud_name")); // column name
			model.setStud_DOB(rs.getInt("stud_DOB"));
			model.setStud_DOJ(rs.getInt("stud_DOJ"));
			
			data.add(model);		
		}		
		return data;	
	}
	
	public crudmodel updatetSTUDENT(crudmodel STUDENT) {
		String insert = "update STUDENT set stud_name=? , stud_DOB=?,stud_DOJ=? where stud_no =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, STUDENT.getId());
			ps.setString(2, STUDENT.getName());
			ps.setInt(3, STUDENT.getStud_DOB());
			ps.setInt(4, STUDENT.getStud_DOJ());
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return STUDENT;
		
	}
	

	public int deletetSTUDENT(int id) {
		String insert = "delete from STUDENT where stud_no =?";
		
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1,id);
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
		
		return id;
		
	}
	
	


}

