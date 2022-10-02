package com.text;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class SequentiallQuiz {

	 
public void getQuiz() {
	
	String check=" ";
	int score=0;
	Scanner scanner=new Scanner(System.in);
	
	try {
		
		Scanner scanner1 =new Scanner(System.in);
		ConnectionDemo cd=new ConnectionDemo();
		Connection con=cd.getConnection();
		System.out.println("enter student name");
		
		String name=scanner1.next();
		
		System.out.println("enter student id");
		
		int id=scanner1.nextInt();
		
		
		
		System.out.println("Enter Yes if you want acess questions sequentially");
		System.out.println("Enter No if you want acess questions randomly");
		
		String Stud_response=scanner1.next();
		
		String response="yes";
		String response1="No";
		if(response.equals(Stud_response)) {
		
		int i=1;
	while(i<=10){
		
		
          PreparedStatement ps=con.prepareStatement("select Questions from quiz where QueNo=?");
		
		PreparedStatement ps1=con.prepareStatement("select options from quiz where QueNo=?");
		PreparedStatement ps2=con.prepareStatement("select answer from quiz where QueNo=?");
		
		ps.setLong(1,i);
		ps1.setLong(1,i);
		ps2.setLong(1, i);
		
		
		ResultSet rs=ps.executeQuery();
		ResultSet rs1=ps1.executeQuery();
		ResultSet rs2=ps2.executeQuery();
		
		
		
		
		
		while (rs.next()) 
		{
			
	
			System.out.println("Question no " + i);
			
			System.out.println(rs.getString(1));
			
			
		}
		
		while(rs1.next()) {
			
			System.out.println(rs1.getString(1));
			
			
		}
		
		
		while(rs2.next()) {
			
			
		 check =	rs2.getString(1);
		
		}
		
		
		System.out.println("Answer...");
		
		String answer=scanner.next();
		
		
	
		
		if(answer.equals(check)) {
		
		System.out.println("correct");
		score++;
		}
		else {
			
			System.out.println("wrong");
			
		}
		
		
		
		
		
		
		
		i++;
		
	
		
	
	
		
	
	}
	
		
		
		}
		
		
		
	
		
	System.out.println();
	
		System.out.println("total marks " + score + "/10");
		
		if(score>=8) {
			
			System.out.println("Status>> Class A");
		}
		
		else if(score>=6 && score<8) {
			
			System.out.println("Status >> Class B");
		}
		else if(score==5) {
			System.out.println("Status >> Class c");
			
		}
		
		else {
			
		  System.out.println("Status >>  Fail");
		}
		
		
		StudentInfo sf=new StudentInfo();
		sf.setStudentInfo(name,id,score);
			
		
		
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	
}


	
	



	
		
	
	
	

	


	
	
	
	
	
	
	
	
	
	
}





