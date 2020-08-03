package com.dennistudio.identity_card_validator;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		String number;
		
		Scanner scannerOne = new Scanner(System.in);
		
		System.out.println("Copyright © Dennis Studio 2021, Author by Dennis Lai\r\n");
			
		System.out.println("Identity card number validator\r\n");
		
		try {
			
			Thread.sleep(1000);
			
			System.out.println("Please input identity card number here, e.g. A123456(7) then input A1234567\r\n");
			
		} catch (Exception e) { }
		
		number = scannerOne.next();
		
		while (!Character.isLetter(number.charAt(0)) || number.length() != 8) {
			
			System.out.println("Please input the card number of correct formatting!");
			
			number = scannerOne.next();
			
		}
		
		try {
			
			Double.parseDouble(number.substring(1, 8));
			
		} catch (NumberFormatException e) {
			
			System.out.println("Please input the card number of correct formatting!");
			
		}
		
		String[] numbers = number.split("");
		
		numbers[0] = Integer.toString((number.charAt(0) - 64));
		
		int sum = 0;
		
		int j = 8;
		
		for (var i = 0; i < numbers.length - 1; i++) {
			
			sum += (Integer.parseInt(numbers[i]) * j);
			
			j--;
			
		}
		
		if ((sum + Integer.parseInt(numbers[7])) % 11 == 0) {
			
			System.out.println("Identity card number was correct.");
			
		} else {
			
			System.out.println("Identity card number was incorrect.");
			
		}
		
		scannerOne.close();
		
	}

}
