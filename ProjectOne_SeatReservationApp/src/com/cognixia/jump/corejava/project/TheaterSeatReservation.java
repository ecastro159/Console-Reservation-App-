package com.cognixia.jump.corejava.project;

import java.util.Scanner;

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
				if(input.equals("Y")) {
					System.out.println("Selected yes");
					start.printList();
					break;
				}else 
					System.out.println("Selected no");
					break;
				}
			}
		//
		//start.runProgram(sc);

		sc.close();

	}

}
