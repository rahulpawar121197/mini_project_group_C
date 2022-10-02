package com.text;

import java.util.Scanner;

public class TestQuiz {
	
	
	public static void main(String[] args) {
		
		System.out.println("if you want access sequential question enter Yes");
		System.out.println("if you want access random question enter No");
		
		Scanner scanner=new Scanner(System.in);
		String stud_response=scanner.next();
		String response="Yes";
		String response1="No";
		if(response.equals(stud_response)) {
			
			
			SequentiallQuiz quiz=new SequentiallQuiz();
			for(int i=0;i<3;i++){
			
			quiz.getQuiz();
			}
		}
		
		else {
			RandomQuiz quiz=new RandomQuiz();
			
			quiz.getQuiz();
			
			
			
		}
	

		
		
}}
