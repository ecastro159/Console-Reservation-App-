package com.cognixia.jump.corejava.project;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserInput {
	//Sets Up New Seat Class
	Seats myTheatre = new Seats();
	
	//Storing Names
	private String name;
	private String seatLocation;
	
	//Setters and Getters

	public String getSeatLocation() {
		return seatLocation;
	}

	public void setSeatLocation(String seatLocation) {
		this.seatLocation = seatLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Methods
	
	//Print Menu
	public void menu() {
		System.out.println("Select one of the following: ");
		System.out.println("See Avalible Seats: 1");
		System.out.println("See List of guest:  2");
		System.out.println("Make a reservation: 3");
		System.out.println("Delete reservation: 4");
		System.out.println("Change reservation: 5");
		System.out.println("Quit program: 		0 ");
	}
	//Print Seats
	//Print Seats
	public void currentSeats() {
		System.out.println("\n");
		myTheatre.println();
		System.out.println("\n");
	}
	//Convert Letter to Number
	//Change Letter to Number
	private int rowLettertoNum(char row) {
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
	//Seat Selection Loop
	//Seat Selection Loop
	public void selectSeat(Scanner sc) {
		System.out.println("Do you want to resever a seat?");
		System.out.println("Enter \"Y\" for Yes or \"N\" for No");
		while(true) {
			
			String ans = sc.nextLine().trim().toUpperCase();
			
			if(ans.equals("N")) {
				break;
			}else if(ans.equals("Y")) {
				//
				System.out.println("\n");
				myTheatre.println();
				validSeatSelection(sc);
				tryToReserve();
				// If Seat is Taken Loop
				if(myTheatre.isTaken()) {
					System.out.println("Seat is already taken.\n");
				}else {
					System.out.println("Enter Your Name: ");
					personName(sc);
					//Store Seat and Name to List;
					myTheatre.addingNames(getSeatLocation(), getName());
					myTheatre.reserveSeat();
				}

				myTheatre.println();
				System.out.println("Do you want to resever another seat? Y/N?");
			}
			
			
		}
	}
	//Checks for Valid Seat Input
	//Checks Valid Input
	private void validSeatSelection(Scanner sc) {
		// Checks for valid seat input
		// If true, sets seatLocation
		// Else loops until a valid input is entered 

		
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
				setSeatLocation(seat);
				break;
			}else {
				System.out.println("Seat not found. Try another one \n");
			}
		}
			
	}
	//Sends Reservation Info
	//Sends Reservation Info to Seats Class
	private void tryToReserve() {
		
		//Row and Column Variables
		char rowNum = ' ';
		int columnNum = 0;
		String seat = getSeatLocation();

		rowNum = seat.charAt(0);
		columnNum = Character.getNumericValue(seat.charAt(1));
		
		
		//Sets Row Number
		myTheatre.setSeatRow(rowLettertoNum(rowNum));
		//Sets Column Number
		myTheatre.setSeatColum(columnNum);
		//Envokes Seat Check 
		myTheatre.taken();
		
	}
	//Gets Persons Name
	//Gets Name
	public void personName(Scanner sc) {
		String name = sc.nextLine().trim();
		setName(name);
	}
	
	
	//Extras 
	//Check for Empty Guest List
	//Extra 
	
	//Empty list
	public boolean check() {
		return myTheatre.checkEmptyList();
	}
	//Print List
	//Prints Guest List
	public void printList() {
		myTheatre.printGuestList();
	}
	//Delete seat Reservation
	public void deleteSeat(Scanner sc) {
		System.out.println("Choose what reservation to cancel");
		validSeatSelection(sc);
		tryToReserve();
		if(myTheatre.isTaken()) {
			//Delete reservation
			myTheatre.deleteReservation(seatLocation);
		}else {
			System.out.println("Seat is not reserved");
		}
		//deleteReservation(setSeatLocation());
		
		
		
		
	}

}
