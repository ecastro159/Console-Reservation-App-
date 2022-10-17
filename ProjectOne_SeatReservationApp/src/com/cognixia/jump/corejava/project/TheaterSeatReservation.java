package com.cognixia.jump.corejava.project;

import java.util.Scanner;

public class TheaterSeatReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInput start = new UserInput();
		
		Scanner sc = new Scanner(System.in);

		while(true) {
			start.menu();
			String ans = sc.nextLine().trim().toLowerCase();			
			if(ans.equals("1")) {
				start.currentSeats();
			}
			
			if(ans.equals("2")) {
				if(start.check()) {
					System.out.println("No guest");
				}else {
					start.printGuestList();
				}
			}
			
			if(ans.equals("3")) {
				start.selectSeat(sc);
			}
			if(ans.equals("4")) {
				start.currentSeats();
				start.deleteSeat(sc);
			}
			//TODO Change Reservation Option
			
			
			if(ans.equals("0")) {
				break;
			}
		}

		sc.close();

	}

}
