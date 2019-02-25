package GissaTalSpel;

import java.util.Scanner;

public class GissaTalSpel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// deklarerar en boolean som kontrollerar loopen
		boolean kör = true;

		// deklarerar en integer som väljer hur många tal som man ska gissa mellan
		int svårhetsgradtal = 0;

		// deklarerar en integer som räknar antalet gissningar
		int antalgissningar = 0;

		System.out.println("Välkommen till gissa talet!");

		System.out.println("Välj svårhetsgrad!");
		System.out.println("-1- Lätt,       från 0 till 50");
		System.out.println("-2- Medelsvårt, från 0 till 100");
		System.out.println("-3- Svårt,      från 0 till 1000");
		System.out.println("-4- Intense,    från 0 till 1000000");
		System.out.println("-5- Custom,     välj själv!");

		// deklarerar val integern som används för switchcasen
		int val = input.nextInt();

		// skapar en switchcase för att kunna välja svårhetsgraden på ett simpelt sätt
		switch (val) {
		case 1:
			System.out.println("Du valde lätt!");
			System.out.println("Gissa på ett tal mellan 0 till 50!");
			System.out.println("Lycka till");

			svårhetsgradtal = 50;
			break;

		case 2:
			System.out.println("Du valde medelsvårt!");
			System.out.println("Gissa på ett tal mellan 0 till 100");
			System.out.println("Lycka till!");
			svårhetsgradtal = 100;
			break;

		case 3:
			System.out.println("Du valde Svår!");
			System.out.println("Gissa på ett tal mellan 0 till 1000");
			System.out.println("Lycka till!");
			svårhetsgradtal = 1000;
			break;

		case 4:
			System.out.println("Du valde Intense!");
			System.out.println("Gissa på ett tal mellan 0 till 1000000");
			System.out.println("Lycka till!");
			svårhetsgradtal = 1000000;

			break;

		case 5:
			System.out.println("Du valde Custom!");
			System.out.println("Gissa på ett tal mellan 0 till x");
			System.out.println("Skriv in vilket tal du vill att x ska bli!");
			svårhetsgradtal = input.nextInt();
			System.out.println("Gissa på ett tal mellan 0 till " + svårhetsgradtal);
			System.out.println("Lycka till!");
			break;

		default:
			System.out.println("Error");
			break;
			
		}

		int randomtal = (int) (Math.random() * svårhetsgradtal);

		
		
		//deklarerar integern gissning som input från skannern
		int gissning = input.nextInt();
		
		
		// skapar en loop som körs tills rätt tal är gissat
		while (kör = true) {

			// if sats som kontrollerar att talet är inom svårhetsgradens nivå
			if (0 <= gissning && gissning <= svårhetsgradtal) {
					
				// if sats som kollar om talet är mindre än gissningen
				if (gissning > randomtal) {
					System.out.println("Talet är lägre än " + gissning + "!");
					antalgissningar += +1;
				}
				// if sats som kollar om talet är större än gissningen 
				if (gissning < randomtal) {
					System.out.println("Talet är högre än " + gissning + "!");
					antalgissningar += +1;
				}
				// if sats som kollar om talet lika med gissningen
				if (gissning == randomtal) {
					System.out.println("Du gissade rätt!!!");
					kör = false;
					antalgissningar += +1;
					System.out.println("Du gissade rätt tal på " + antalgissningar + " försök!");
				}
			}

			else {
				System.out.println("Error!");
				System.out.println("Skriv in ett tal mellan 0 till "+ svårhetsgradtal);
			}
			// deklarerar variabeln gissning till input ingen så att inte loopen fortsätter innan jag skriver in ett nytt tal
			gissning = input.nextInt();
		}
		
	
			
			
		

	}

}
