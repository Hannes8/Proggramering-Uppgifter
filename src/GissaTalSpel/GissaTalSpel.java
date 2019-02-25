package GissaTalSpel;

import java.util.Scanner;

public class GissaTalSpel {
	
	public static void main(String[] args) {
			Scanner input=new Scanner(System.in);
			
			boolean kör=true;
			
			int svårhetsgradtal=0;
			
			int antalgissningar=0;
			
		
			
		System.out.println("Välkommen till gissa talet!");
		
		System.out.println("Välj svårhetsgrad!");
		System.out.println("-1- Lätt,       från 0 till 50");
		System.out.println("-2- Medelsvårt, från 0 till 100");
		System.out.println("-3- Svårt,      från 0 till 1000");
		System.out.println("-4- Intense,    från 0 till 1000000");
		System.out.println("-5- Costom,     välj själv!");
		
		int val=input.nextInt();
		
		switch(val) {
		case 1:
			System.out.println("Du valde lätt!");
			System.out.println("Gissa på ett tal mellan 0 till 50!");
			System.out.println("Lycka till");
			
			svårhetsgradtal=50;
			break;
			
		case 2:
			System.out.println("Du valde medelsvårt!");
			System.out.println("Gissa på ett tal mellan 0 till 100");
			System.out.println("Lycka till!");
			svårhetsgradtal=100;
			break;
		
		case 3:
			System.out.println("Du valde Svår!");
			System.out.println("Gissa på ett tal mellan 0 till 1000");
			System.out.println("Lycka till!");
			svårhetsgradtal=1000;
			break;
		
		case 4:
			System.out.println("Du valde Intense!");
			System.out.println("Gissa på ett tal mellan 0 till 1000000");
			System.out.println("Lycka till!");
			svårhetsgradtal=1000000;
		
			break;
		
		case 5:
			System.out.println("Du valde Costom!");
			System.out.println("Gissa på ett tal mellan 0 till x");
			System.out.println("Skriv in vilket tal du vill att x ska bli!");
			svårhetsgradtal=input.nextInt();
			System.out.println("Gissa på ett tal mellan 0 till "+ svårhetsgradtal);
			System.out.println("Lycka till!");
			break;
			
		default:
			break;
		
		
		}
		
		
		
		// initierar en boolean som kontrollerar loopen
		int randomtal = (int)(Math.random() * svårhetsgradtal);
		
		System.out.println(randomtal);
		
		int gissning=input.nextInt();
				
			
			while(kör=true) {
				

				
			if(0<=gissning && gissning<=svårhetsgradtal) {
			
				
			if(gissning>randomtal) {
				System.out.println("Talet är lägre än "+gissning+"!");
				antalgissningar+=+1;
				}
			if(gissning<randomtal) {
				System.out.println("Talet är högre än "+gissning+"!");
				antalgissningar+=+1;
			}
			if(gissning==randomtal) {
				System.out.println("Du gissade rätt!!!");
				kör=false;
				antalgissningar+=+1;
				System.out.println("Du gissade rätt tal på "+antalgissningar+ " försök!");
			}
		}
			
			else {
				System.out.println("Error!");
			}
			gissning=input.nextInt();
			}
		
	}


}


		

