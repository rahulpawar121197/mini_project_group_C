package com.text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RandomQuiz {
	int score;
	
	public void call(int no) throws SQLException 
	
	{
		String check=" ";
		
		ConnectionDemo cd=new ConnectionDemo();
		Connection con=cd.getConnection();
        Scanner scanner=new Scanner(System.in);
        PreparedStatement ps=con.prepareStatement("select Questions from quiz where QueNo=?");
		
		PreparedStatement ps1=con.prepareStatement("select options from quiz where QueNo=?");
		PreparedStatement ps2=con.prepareStatement("select answer from quiz where QueNo=?");
		
		ps.setLong(1,no);
		ps1.setLong(1,no);
		ps2.setLong(1, no);
		
		
		ResultSet rs=ps.executeQuery();
		ResultSet rs1=ps1.executeQuery();
		ResultSet rs2=ps2.executeQuery();
		
		
		
		
		
		while (rs.next()) 
		{
			
	
			System.out.println("Question no " + no);
			
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
		
		
		
		
		
		}	
		
		
		
		
		
	
	
	
	public void getQuiz() {
		
		
		
		Scanner scanner=new Scanner(System.in);
		
		try {
			
			Scanner scanner1 =new Scanner(System.in);
			ConnectionDemo cd=new ConnectionDemo();
			Connection con=cd.getConnection();
			System.out.println("enter student name");
			
			String name=scanner1.next();
			
			System.out.println("enter student id");
			
			int count []= {0,0,0,0,0,0,0,0,0,0};
			int id=scanner1.nextInt();
			for(int i=0;i<=10;i++) {
			System.out.println("enter question no");
			
			int no=scanner1.nextInt();
		
			
			
	
			if(count[no-1]==0) {
			
				call(no);
				count[no-1]++;
			}
			else {
				
				System.out.println("Question has already attempted ");
			
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


