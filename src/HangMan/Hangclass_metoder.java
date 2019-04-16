package HangMan;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Hangclass_metoder {
	static int antalfelgissningar = 0;
	static Scanner input = new Scanner(System.in);
	static int val = 0;

//
	static String[] svenskaordlätt = { "Potatis", "Korv", "Kött", "Bil", "Gul", "Röd", "Grön", "Bröd", "Dator", "Löv",
			"Grus", "Bus", "Buss", "Säng", "Telefon", "Skidor" };

	static String[] svenskaordmedel = { "Toaletter", "Pizzasås", "Telefonskal", "Skridskor", "Bordtennis", };

	static String[] svenskaordsvårt = { "Nationalencyklopedin", "Vispgrädde", "Ukulele", "Flaggstångsknoppsmålare",
			"nordvästersjökustartilleriflygspaningssimulatoranläggningsmaterielunderhållsuppföljningssystemdiskussionsinläggsförberedelsearbeten",
			"Yxa", };

	static String[] engelskaordlätt = { "Car", "Fart", "Yellow", "Rain", "Train", "Cloud", "Water", "Milk", "Hello",
			"Hi", "Potato", "Carrot", "Bot", "Lime", "Bannana", };

	static String[] engelskaordmedel = { "Chocolate", "Garlic", "Shark", "fjord", "rhubarb", "phlegm", "twelfth",
			"syndrome" };

	static String[] engelskaordsvårt = { "Difficult", "Bagpipes", "Dwarves", "Ivory", "Zombie", "Swivel", "Oxygen",
			"Unzip", "Quad", "Fishhook", "Rhythmic", "giaour" };

	static ArrayList<Character> ordet = new ArrayList<Character>();

	static ArrayList<Character> gissadebokstäver = new ArrayList<Character>();

	static String ord;

	static String rättbokstäver = "";
	
	static char[] rättbokstäverchar;

	// Skapar ett objekt av den classen med det grafiska
	static Grafiskt_hangman grafisktobjekt = new Grafiskt_hangman();

	public static void main(String[] args) {
		while (true) {

			// om spelaren vill spela själv
			if (Typavspel() == 1) {
				// tilldelar stringen "ord" ett slumpat ord från svenskaord arrayen eller
				// engelska ord arrayen med den svårhetsgraden som är vald
				ord = slumparord(väljspråk(), svårhetsgrad());
				System.out.println(ord);
			}
			// om spelaren väljer två spelare
			else {
				// tilldelar stringen "ord" ett ord som spelaren väljer
				ord = Väljegetord();

			}

			ord = ord.toUpperCase();
			stringtillchars();
			rättgissadebokstäverstring();

			// loop som körs tills spelet är klart, ordet är gissat eller spelaren har
			// gissat för många fel
			while (true) {
				gissa();
				grafisktobjekt.grafiskt(antalfelgissningar);

				if (ordet.size() == 0) {
					System.out.println(rättbokstäver);
					System.out.println("Grattis du vann!");

					break;
				}
				if (antalfelgissningar == 9) {
					break;
				}

			}
			// om spelaren inte vill spela mer så bryts den ytre while loopen och programet
			// avslutas
			if (spelaigen() == 2) {
				break;
			}
			// om spelaren väljer att spela igen så körs reset metoden och sedan körs
			// programet om igen
			reset();
		}
	}

	public static int Typavspel() {
		System.out.println("Välkomen till hänga gubbe!");
		System.out.println("regler");
		System.out.println("Vill du spela ensam eller som två spelare?");
		System.out.println("-1-  Ensam");
		System.out.println("-2-  Två spelare");

		while (true) {
			int val = input.nextInt();
			switch (val) {
			case 1:
				return val;
			case 2:
				return val;
			default:
				System.out.println("error");
				break;
			}
		}

	}

	// metod som väljer språk
	public static int väljspråk() {
		System.out.println("Vilket språk vill du köra med?");
		System.out.println("-1-  Svenska");
		System.out.println("-2-  Engelska");

		while (true) {
			val = input.nextInt();
			switch (val) {
			case 1:
				return val;

			case 2:
				return val;
			default:
				System.out.println("error");
				break;
			}
		}
	}

// metod som väljer svårhetsgraden 
	public static int svårhetsgrad() {
		while (true) {
			System.out.println("Vilken svårhetsgrad vill du köra på?");
			System.out.println("-1-  Lätt");
			System.out.println("-2-  Medelsvårt");
			System.out.println("-3-  Svårt");
			val = input.nextInt();

			switch (val) {
			case 1:
				return val;

			case 2:
				return val;

			case 3:
				return val;

			default:
				System.out.println("error");
				break;

			}

		}

	}

	// metod som tar in vilket språk det är och vilken svårhetsgrad och slumpar ett
	// ord från en av arrayerna med ord
	public static String slumparord(int språk, int svårhetsgrad) {
		// initierar int random
		int random;
		// om svenska är valt
		if (språk == 1) {
			// switchcase som väljer beroende på vilken svårhetsgrad som är vald
			switch (svårhetsgrad) {

			case 1:
				// int random blir ett random tal mellan 0 till antalet ord i arrayen
				// svenskaordlätt
				random = (int) (Math.random() * svenskaordlätt.length);
				// stringen ord blir ett ord från arrayen svenskaordlätt med indexen från int
				// random
				ord = svenskaordlätt[random];
				break;
			// lätt
			case 2:
				random = (int) (Math.random() * svenskaordmedel.length + 1);
				ord = svenskaordmedel[random];
				break;
			// medel
			case 3:
				random = (int) (Math.random() * svenskaordsvårt.length + 1);
				ord = svenskaordsvårt[random];
				break;

			// svårt
			}

			// engelska ord
		} else {
			switch (svårhetsgrad) {
			case 1:
				random = (int) (Math.random() * engelskaordlätt.length + 1);
				ord = engelskaordlätt[random];
				break;

			case 2:
				random = (int) (Math.random() * engelskaordmedel.length + 1);
				ord = engelskaordmedel[random];
				break;

			case 3:
				random = (int) (Math.random() * engelskaordsvårt.length + 1);
				ord = engelskaordsvårt[random];
				break;

			}

		}
		return ord;
	}

// Metod för två spelare, en av spelarna väljer själv ett ord
	public static String Väljegetord() {
		val = 2;
		// loopar metoden
		while (true) {
			// Frågar frågan igen om spelaren valde fel ord
			if (val == 2) {
				System.out.println("Välj ett ord som den andra spelaren ska försöka gissa!");
				// stringen Ord blir spelarens input
				ord = input.next();
			}
// frågar om spelaren är säker på att hen vill använda ordet.
			System.out.println("Är du säker på att du vill använda " + ord + " som ditt ord?"); // "ord"
			System.out.println("-1-  Ja");
			System.out.println("-2-  Nej");
			val = input.nextInt();

			switch (val) {
			case 1:
				return ord;
			case 2:
				break;
			default:
				System.out.println("error");
				break;
			}
		}

	}

	// Metod som tar ordet och lägger in alla bokstäver i arraylisten ordet
	public static void stringtillchars() {
		for (int i = 0; i < ord.length(); i++) {
			ordet.add(ord.charAt(i));
		}
		System.out.println(ordet);

	}

	public static void rättgissadebokstäverstring() {
		for (int i = 0; i < ord.length(); i++) {
			rättbokstäver = rättbokstäver + "?";

		}

	}

	// metod som visar de rätt bokstäver som är rätt gissade i ordet
	public static void rättgissadebokstäver(char rättgissadbokstav) {

		// gör om stringen rättbokstäver till en char array så det går att förändra
		// bokstäverna
		char[] rättbokstäverchar = rättbokstäver.toCharArray();

		// loopar med längden av ordet
		for (int i = 0; i < ord.length(); i++) {
// om den gissade bokstaven är lika med den bokstaven på indexet i i loopen så byter char arrayen ut från ett ? till rätt bokstav
			if (ord.charAt(i) == (rättgissadbokstav)) {
				rättbokstäverchar[i] = rättgissadbokstav;

			}

		}
		// stringen rättbokstäver får värdet av charsen i arrayen rättbokstäverchar
		rättbokstäver = String.valueOf(rättbokstäverchar);
	}

	public static void gissa() {

		System.out.println(rättbokstäver);

		if (gissadebokstäver.size() >= 1) {
			System.out.println("Du har gissat på:" + gissadebokstäver);
		}
		System.out.println("Gissa på en bokstav eller gissa på ordet!");
		String gissningen = input.next();

		if (gissningen.length() == 1) {
			char gissning = gissningen.charAt(0);
			gissning = Character.toUpperCase(gissning);
			if (gissadebokstäver.contains(gissning)) {
				System.out.println("Du har redan gissat på " + gissning);
				return;
			}

			if (ordet.contains(gissning)) {
				System.out.println("Du gissade rätt!");
				ordet.remove(new Character(gissning));
				rättgissadebokstäver(gissning);
			} else {
				System.out.println("Du gissade fel!");
				antalfelgissningar++;
				gissadebokstäver.add(gissning);
			}

		}
		// om gissningen är längre än en bokstav så kollas det om det är rätt ord
		else {
			if (gissningen.equalsIgnoreCase(ord)) {
			ordet.clear();
			rättbokstäver=ord;

			} else {
				antalfelgissningar++;

			}

		}
	}

	public static int spelaigen() {
		while (true) {
			System.out.println("Vill du spela igen?");
			System.out.println("-1-  Ja");
			System.out.println("-2-  Nej");
			val = input.nextInt();
			switch (val) {
			case 1:
				reset();
				return val;

			case 2:
				System.out.println("Tack för att du spelat!");
				return val;

			default:
				System.out.println("Error");

			}
		}

	}

	public static void reset() {

		ordet.clear();

		gissadebokstäver.clear();

		String ord = "";

		rättbokstäver = "";

		antalfelgissningar = 0;
	}

}
