package com.cognixia.jump.corejava.project;

import java.util.*;


public class Seats {
	public String[][]  seat = {{"A0","A1","A2","A3","A4"},
										{"B0","B1","B2","B3","B4"},
											{"C0","C1","C2","C3","C4"},
												{"D0","D1","D2","D3","D4"},
													{"E0","E1","E2","E3","E4"}};
	
	public Map<String, String> guests = new HashMap<>();

	private int seatRow;
	private int seatColum;
	private boolean taken;
	
	//Constructor
	public Seats() {}
	
	
	//Setters and Getters
	public int getSeatRow() {
		return seatRow;
	}

	public int getSeatColum() {
		return seatColum;
	}

	public void setSeatRow(int seatRow) {
		this.seatRow = seatRow;
	}

	public void setSeatColum(int seatColum) {
		this.seatColum = seatColum;
	}

	public boolean isTaken() {
		taken();
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	
	//Methods
	
	//Changes Number to Correct Letter	
	private char numsToChar(int row) {
		char ans = 'x';
		switch(row) {
		case 0: 
			ans = 'A';
			break;
		case 1: 
			ans = 'B';
			break;
		case 2: 
			ans = 'C';
			break;
		case 3: 
			ans = 'D';
			break;
		case 4: 
			ans = 'E';
			break;
		}
		
		return ans;
		
	}

	//Marks Seat as Taken;
	public void reserveSeat() {
		seat[seatRow][seatColum] = "XX";
	}

	// Print out seats
	public void println() {
		//String top = String.format("|%-c|", "");
		System.out.println(" Welcome to [Your Move Theater Name Here]");
		System.out.println("        0    1    2    3    4");
		System.out.println("    ||=========================");
		//System.out.println("    ||------------------------");
		for(int i=0; i<seat.length; i++) {
			System.out.print(numsToChar(i) + "   || ");
			for(int j=0; j<seat.length; j++) {
				System.out.print("|" + seat[i][j] +"| ");
				//System.out.print(" | ");
			}
			if(i != seat.length) {
				System.out.println(" ");
				System.out.println("    ||-------------------------");
			}
			
		}
	}
	
	//Check if seat is taken;
	public void taken() {
		
		
		
		
		if(seat[seatRow][seatColum].equals("XX")) {
			setTaken(true);
		}else {
			setTaken(false);
		}
	}
	
	
	//Extras 
	//Adding and Removing names
	public void addingNames(String seat, String name) {
		guests.put(seat, name);
	};
	//Print Guest List and Seats
	public void printGuestList() {
		for(Map.Entry<String, String> list: guests.entrySet()) {
			System.out.println("Guest Name: "+list.getValue()+ "  Seat: "+ list.getKey());
		}
		System.out.println(" ");
	}
	
	public boolean checkEmptyList() {
		return guests.isEmpty();
		}
	//Delete Reservation and Makes Seat Available Again
	public void deleteReservation(String seatLocation) {
		seat[seatRow][seatColum] = seatLocation;
		guests.remove(seatLocation);
	};
		
		
	
	}
