package GissaTalSpel;

import java.util.Scanner;

public class GissaTalSpel {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// deklarerar en boolean som kontrollerar loopen
		boolean k�r = true;

		// deklarerar en integer som v�ljer hur m�nga tal som man ska gissa mellan
		int sv�rhetsgradtal = 0;

		// deklarerar en integer som r�knar antalet gissningar
		int antalgissningar = 0;

		System.out.println("V�lkommen till gissa talet!");

		System.out.println("V�lj sv�rhetsgrad!");
		System.out.println("-1- L�tt,       fr�n 0 till 50");
		System.out.println("-2- Medelsv�rt, fr�n 0 till 100");
		System.out.println("-3- Sv�rt,      fr�n 0 till 1000");
		System.out.println("-4- Intense,    fr�n 0 till 1000000");
		System.out.println("-5- Custom,     v�lj sj�lv!");

		// deklarerar val integern som anv�nds f�r switchcasen
		int val = input.nextInt();

		// skapar en switchcase f�r att kunna v�lja sv�rhetsgraden p� ett simpelt s�tt
		switch (val) {
		case 1:
			System.out.println("Du valde l�tt!");
			System.out.println("Gissa p� ett tal mellan 0 till 50!");
			System.out.println("Lycka till");

			sv�rhetsgradtal = 50;
			break;

		case 2:
			System.out.println("Du valde medelsv�rt!");
			System.out.println("Gissa p� ett tal mellan 0 till 100");
			System.out.println("Lycka till!");
			sv�rhetsgradtal = 100;
			break;

		case 3:
			System.out.println("Du valde Sv�r!");
			System.out.println("Gissa p� ett tal mellan 0 till 1000");
			System.out.println("Lycka till!");
			sv�rhetsgradtal = 1000;
			break;

		case 4:
			System.out.println("Du valde Intense!");
			System.out.println("Gissa p� ett tal mellan 0 till 1000000");
			System.out.println("Lycka till!");
			sv�rhetsgradtal = 1000000;

			break;

		case 5:
			System.out.println("Du valde Custom!");
			System.out.println("Gissa p� ett tal mellan 0 till x");
			System.out.println("Skriv in vilket tal du vill att x ska bli!");
			sv�rhetsgradtal = input.nextInt();
			System.out.println("Gissa p� ett tal mellan 0 till " + sv�rhetsgradtal);
			System.out.println("Lycka till!");
			break;

		default:
			System.out.println("Error");
			break;
			
		}

		int randomtal = (int) (Math.random() * sv�rhetsgradtal);

		
		
		//deklarerar integern gissning som input fr�n skannern
		int gissning = input.nextInt();
		
		
		// skapar en loop som k�rs tills r�tt tal �r gissat
		while (k�r = true) {

			// if sats som kontrollerar att talet �r inom sv�rhetsgradens niv�
			if (0 <= gissning && gissning <= sv�rhetsgradtal) {
					
				// if sats som kollar om talet �r mindre �n gissningen
				if (gissning > randomtal) {
					System.out.println("Talet �r l�gre �n " + gissning + "!");
					antalgissningar += +1;
				}
				// if sats som kollar om talet �r st�rre �n gissningen 
				if (gissning < randomtal) {
					System.out.println("Talet �r h�gre �n " + gissning + "!");
					antalgissningar += +1;
				}
				// if sats som kollar om talet lika med gissningen
				if (gissning == randomtal) {
					System.out.println("Du gissade r�tt!!!");
					k�r = false;
					antalgissningar += +1;
					System.out.println("Du gissade r�tt tal p� " + antalgissningar + " f�rs�k!");
				}
			}

			else {
				System.out.println("Error!");
				System.out.println("Skriv in ett tal mellan 0 till "+ sv�rhetsgradtal);
			}
			// deklarerar variabeln gissning till input ingen s� att inte loopen forts�tter innan jag skriver in ett nytt tal
			gissning = input.nextInt();
		}
		
	
			
			
		

	}

}
