package GissaTalSpel;

import java.util.Scanner;

public class GissaTalSpel {
	
	public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
			
			boolean k�r=true;
			
			int sv�rhetsgradtal=0;
			
			int antalgissningar=0;
			
		
			
		System.out.println("V�lkommen till gissa talet!");
		
		System.out.println("V�lj sv�rhetsgrad!");
		System.out.println("-1- L�tt,       fr�n 0 till 50");
		System.out.println("-2- Medelsv�rt, fr�n 0 till 100");
		System.out.println("-3- Sv�rt,      fr�n 0 till 1000");
		System.out.println("-4- Intense,    fr�n 0 till 1000000");
		System.out.println("-5- Costom,     v�lj sj�lv!");
		
		int val=input.nextInt();
		
		switch(val) {
		case 1:
			System.out.println("Du valde l�tt!");
			System.out.println("Gissa p� ett tal mellan 0 till 50!");
			System.out.println("Lycka till");
			
			sv�rhetsgradtal=50;
			break;
			
		case 2:
			System.out.println("Du valde medelsv�rt!");
			System.out.println("Gissa p� ett tal mellan 0 till 100");
			System.out.println("Lycka till!");
			sv�rhetsgradtal=100;
			break;
		
		case 3:
			System.out.println("Du valde Sv�r!");
			System.out.println("Gissa p� ett tal mellan 0 till 1000");
			System.out.println("Lycka till!");
			sv�rhetsgradtal=1000;
			break;
		
		case 4:
			System.out.println("Du valde Intense!");
			System.out.println("Gissa p� ett tal mellan 0 till 1000000");
			System.out.println("Lycka till!");
			sv�rhetsgradtal=1000000;
		
			break;
		
		case 5:
			System.out.println("Du valde Costom!");
			System.out.println("Gissa p� ett tal mellan 0 till x");
			System.out.println("Skriv in vilket tal du vill att x ska bli!");
			sv�rhetsgradtal=input.nextInt();
			System.out.println("Gissa p� ett tal mellan 0 till "+ sv�rhetsgradtal);
			System.out.println("Lycka till!");
			break;
			
		default:
			break;
		
		
		}
		
		
		
		// initierar en boolean som kontrollerar loopen
		int randomtal = (int)(Math.random() * sv�rhetsgradtal);
		
		System.out.println(randomtal);
		
		int gissning=input.nextInt();
				
			
			while(k�r=true) {
				

				
			if(0<=gissning && gissning<=sv�rhetsgradtal) {
			
				
			if(gissning>randomtal) {
				System.out.println("Talet �r l�gre �n "+gissning+"!");
				antalgissningar+=+1;
				}
			if(gissning<randomtal) {
				System.out.println("Talet �r h�gre �n "+gissning+"!");
				antalgissningar+=+1;
			}
			if(gissning==randomtal) {
				System.out.println("Du gissade r�tt!!!");
				k�r=false;
				antalgissningar+=+1;
				System.out.println("Du gissade r�tt tal p� "+antalgissningar+ " f�rs�k!");
			}
		}
			
			else {
				System.out.println("Error!");
			}
			gissning=input.nextInt();
			}
		
	}


}


		

