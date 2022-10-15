package com.cognixia.jump.corejava.project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
public class TheaterSeatReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInput start = new UserInput();
		
		Scanner sc = new Scanner(System.in);
		//Starts Program
		while(true) {
			// No Map, Not Print Map option
			if(start.check()) {		
				start.runProgram(sc);	
			}
			
			
			else {
				System.out.println("Print Guest list? Y/N");
				String input = sc.nextLine().trim().toUpperCase();
				if(input =="Y") {
					start.printList();
					break;
				}else 
					break;
				}
			}
		//
		//start.runProgram(sc);

		sc.close();

	}

}
