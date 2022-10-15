package com.cognixia.jump.corejava.project;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
	//Sets Up New Seat Class
	Seats myTheatre = new Seats();
	
	//Storing Names
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Change Letter to Number
	private int rowNumtoNum(char row) {
		int ans = 0;
		switch(row) {
		case 'A': 
			ans = 0;
			break;
		case 'B': 
			ans = 1;
			break;
		case 'C': 
			ans = 2;
			break;
		case 'D': 
			ans = 3;
			break;
		case 'E': 
			ans = 4;
			break;
		}
		
		return ans;
		
	}

	//Main Loop
	public void runProgram(Scanner sc) {
		System.out.println("Do you want to resever a seat?");
		System.out.println("Enter \"Y\" for Yes or \"N\" for No");
		while(true) {
			
			String ans = sc.nextLine().trim().toUpperCase();
			
			if(ans.equals("N")) {
				break;
			}else if(ans.equals("Y")) {
				System.out.println("Enter Your Name: ");
				personName(sc);
				myTheatre.println();
				seatSelection(sc);
				myTheatre.println();
				System.out.println("Do you want to resever another seat? Y/N?");
			}
			
			
		}
	}
	
	//Takes In Seat Information
	public void seatSelection(Scanner sc) {

		//Row and Column Variables
		char rowNum = ' ';
		int columnNum = 0;
		
		
		//Checking Input is in (A-E or a-e)(0-4) format 
		String regex = "^[a-eA-E]{1}[0-4]$";
		Pattern pattern = Pattern.compile(regex);
		
		
		//Loops until valid seat is selected
		while(true) {
			//User Input
			System.out.println("Enter seat :");
			String seat = sc.nextLine().trim().toUpperCase();
			
			//Regex Pattern Checker
			Matcher matcher = pattern.matcher(seat);
			boolean matchFound = matcher.find();
			//Splits Row and Column Information 
			if(matchFound) {
				//Stores Name and Seat
				myTheatre.addingNames(seat, getName());
				rowNum = seat.charAt(0);
				columnNum = Character.getNumericValue(seat.charAt(1));
				break;
			}else {
				System.out.println("Seat not found. Try another one \n");
			}
		}

		//Sets Row Number
		myTheatre.setSeatRow(rowNumtoNum(rowNum));
		//Sets Column Number
		myTheatre.setSeatColum(columnNum);

		
		// Check if Seat is Taken
		if(myTheatre.isTaken()) {
			System.out.println("Seat is already taken.\n");
		}else {
			//Reserves Seat
			myTheatre.reserveSeat();
		}


	}

	//Gets Name
	public void personName(Scanner sc) {
		String name = sc.nextLine().trim().toLowerCase();
		setName(name);
	}
	
	//Empty list
	public boolean check() {
		return myTheatre.checkEmptyList();
	}
	public void printList() {
		myTheatre.printGuestList();
	}
}
