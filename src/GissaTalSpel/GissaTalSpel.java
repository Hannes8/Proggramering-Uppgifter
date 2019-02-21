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
				System.out.println("Talet är lägre än "+gissning+"!");
				}
			if(gissning>randomtal) {
				System.out.println("Talet är högre än "+gissning+"!");
			}
				
		}
			
			else {
				System.out.println("Error!");
			}
					
			}


}


		

