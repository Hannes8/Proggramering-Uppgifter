package GissaTalSpel;

import java.util.Scanner;

public class GissaTalSpel {
	
	public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
		System.out.println("Gissa ett tal mellan 0 till 100!");
		
		int antalgissningar;
		
		int randomtal = (int)(Math.random() * 100);
		
		int gissning=input.nextInt();
			
			
			if(0<=gissning && gissning<=100) {
				
			if(gissning<randomtal) {
				System.out.println("Talet �r l�gre �n "+gissning+"!");
				}
			if(gissning>randomtal) {
				System.out.println("Talet �r h�gre �n "+gissning+"!");
			}
				
		}
			
			else {
				System.out.println("Error!");
			}
					
			}


}


		

