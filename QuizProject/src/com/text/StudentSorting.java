package com.text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StudentSorting implements Comparable<StudentSorting>
{
	
	
	String name;
	int id;
	int marks;
	
	public StudentSorting() {}
	
	public StudentSorting(String name,int id,int marks) {
		
		
		this.name=name;
		this.id=id;
		
		this.marks=marks;
		
		
	}
	
	
	public void getStudentInfo() {
		
		String name=null;
		this.name=name;
		int id=0;
		this.id=id;
		int marks=0;
		this.marks=marks;
		
		
		try {
			ConnectionDemo cd=new ConnectionDemo();
			Connection con=cd.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from student");
			
			
			
		ResultSet rs =	ps.executeQuery();
		ArrayList<StudentSorting> list=new ArrayList<StudentSorting>();

		
		while(rs.next()) {
			
			
			name=rs.getString(2);
			
			id=rs.getInt(3);
			
			marks= rs.getInt(4);
			list.add(new StudentSorting(name,id,marks));
			
		}
			Collections.sort(list);
			
			for(StudentSorting obj : list) {
				  
				
				System.out.println("id = "+obj.id + " StudentName = " + obj.name +" marks =  "+obj.marks);
				
				
			}
			
		
			
			
			
			
			
		
			}catch(Exception e) {
				
				e.printStackTrace();
				
				
			}
	}


	@Override
	public String toString() {
		return "StudentSorting [name=" + name + ", id=" + id + ", marks=" + marks + "]";
	}

	@Override
	public int compareTo(StudentSorting o) {
		if (id==o.id)
			return 0;
		else if(id>o.id)
			return 1;
		else
		 return -1;
	}
}	
		
	
