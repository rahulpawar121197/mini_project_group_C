package com.text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentInfo {
	
	
public void setStudentInfo(String name,int id,int marks) {
	

	try {
	ConnectionDemo cd=new ConnectionDemo();
	Connection con=cd.getConnection();
	PreparedStatement ps=con.prepareStatement("insert into quiz.student (name ,id,marks) values (?,?,?)");
	
	ps.setString(1,name );
	ps.setLong(2,id);
	ps.setLong(3, marks);
	
	ps.executeUpdate();
	}catch(Exception e) {
		
		e.printStackTrace();
		
		
	}
	
}


public void getStudentsInfo() {
	
	
	try {
		ConnectionDemo cd=new ConnectionDemo();
		Connection con=cd.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from student");
		
		
		
	ResultSet rs =	ps.executeQuery();
	
	while(rs.next()) {
		
		
		System.out.println("Student Name  "+rs.getString(2));
		
		System.out.println("id  "+rs.getInt(3));
		
		System.out.println("marks " + rs.getInt(4));
		
		
		ArrayList list=new ArrayList();
		
		list.add(new StudentSorting());
		
		
		
		
		
		
		
	}
		}catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
	
	
	
	
	
}





public void studentInfo(int id) {try {
	ConnectionDemo cd=new ConnectionDemo();
	Connection con=cd.getConnection();
	PreparedStatement ps=con.prepareStatement("Select * from student where id=?");
	
	
	ps.setLong(1, id);
ResultSet rs =	ps.executeQuery();

while(rs.next()) {
	
	
	System.out.println("name of student = " + rs.getString(2));
	System.out.println("marks of the student = " + rs.getInt(4));
	
	
	
	
}
	}catch(Exception e) {
		
		e.printStackTrace();
		
		
	}
	





	
	
	
	
}

}
