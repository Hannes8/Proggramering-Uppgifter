package HangMan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Hangclass_metoder {
	// antal fel gissningar från spelaren
	static int antalfelgissningar = 0;
	//
	static Scanner input = new Scanner(System.in);
	// variabel för alla val i programmet
	static int val = 0;

// array lists med alla orden i de olika svårhetsgraderna

	static String[] svenskaordlätt = { "Potatis", "Korv", "Kött", "Bil", "Gul", "Röd", "Grön", "Bröd", "Dator", "Löv",
			"Grus", "Bus", "Buss", "Säng", "Telefon", "Skidor" };

	static String[] svenskaordmedel = { "Toaletter", "Pizzasås", "Telefonskal", "Skridskor", "Bordtennis", "Björn",
			"Lejon", "Öra" };

	static String[] svenskaordsvårt = { "Nationalencyklopedin", "Vispgrädde", "Ukulele", "Flaggstångsknoppsmålare",
			"nordvästersjökustartilleriflygspaningssimulatoranläggningsmaterielunderhållsuppföljningssystemdiskussionsinläggsförberedelsearbeten",
			"Yxa" };

	static String[] engelskaordlätt = { "Car", "Fart", "Yellow", "Rain", "Train", "Cloud", "Water", "Milk", "Hello",
			"Hi", "Potato", "Carrot", "Bot", "Lime", "Bannana", };

	static String[] engelskaordmedel = { "Chocolate", "Garlic", "Shark", "fjord", "rhubarb", "phlegm", "twelfth",
			"syndrome" };

	static String[] engelskaordsvårt = { "Difficult", "Bagpipes", "Dwarves", "Ivory", "Zombie", "Swivel", "Oxygen",
			"Unzip", "Quad", "Fishhook", "Rhythmic", "giaour" };

	// det valda ordet som chars i en arraylist
	static ArrayList<Character> ordet = new ArrayList<Character>();

	// de gissade bokstäverna i chars i en arraylist
	static ArrayList<Character> gissadebokstäver = new ArrayList<Character>();

	// ordet som spelaren ska försöka gissa
	static String ord;

	// de rätta bokstäverna som spelaren har gissat på
	static String rättbokstäver = "";

	// de rätta bokstäverna som spelaren har gissat på i en char array
	static char[] rättbokstäverchar;

	// Skapar ett objekt av den classen med det grafiska
	static Grafiskt_hangman grafisktobjekt = new Grafiskt_hangman();

	// boolean som kollar om språker är engelska
	static boolean språkengelska = false;

	public static void main(String[] args) {
		// ytre while loop som gör det möjligt att köra om spelet
		while (true) {

			// startar spelet
			start();

			// loop som körs tills spelet är klart, ordet är gissat eller spelaren har
			// gissat för många fel
			while (true) {
				// kör metoden gissa
				gissa();
				// anropar metoden grafiskt och ger input med antalfelgissningar, metoden skiver
				// ut de grafiska beroende på hur många fel gissningar som spelaren har
				grafisktobjekt.grafiskt(antalfelgissningar);

				// om arraylisten med bokstäverna från ordet är tom så avslutas loopen och
				// spelaren vinner
				if (ordet.size() == 0) {
					System.out.println(rättbokstäver);
					System.out.println("Grattis du vann!");

					break;
				}
				// om spelaren har gissat fel 9 gånger så avslutas loopen
				if (antalfelgissningar == 9) {
					System.out.println("Ordet var " + ord);
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

	/**
	 * Metoden startar spelet och väljer ut vilket ord som spelaren ska försöka
	 * gissa på
	 * 
	 */
	public static void start() {
		// om spelaren vill spela själv
		if (Typavspel() == 1) {

			// tilldelar stringen "ord" ett slumpat ord från svenskaord arrayen eller
			// engelska ord arrayen med den svårhetsgraden som är vald
			ord = slumparord(väljspråk(), svårhetsgrad());

		}
		// om spelaren väljer två spelare
		else {
			// tilldelar stringen "ord" ett ord som spelaren väljer
			ord = Väljegetord();
		}
		// gör om orden till bara stora bokstäver så det går att jämföra
		ord = ord.toUpperCase();
		// skapar en array med bokstäverna i ordet
		stringtillchars();
		// metod som tar längden på ordet och skirver ut ? för spelaren tex om ordet är
		// korv så ser spelaren ????
		rättgissadebokstäverstring();

	}

	/**
	 * Välkommnar spelaren och frågar om spelaren vill spela ensam eller som två
	 * spelare
	 * 
	 * ger tillbaks om det är en spelare(1) eller två spelare(2)
	 */
	public static int Typavspel() {
		mellanrum();

		System.out.println("Välkomen till hänga gubbe!");
		// loopar outputen så spelaren kan se alternativen igen om de skriver in fel
		while (true) {

			while (true) {
				System.out.println("Vill du spela ensam eller som två spelare?");
				System.out.println("-1-  Ensam");
				System.out.println("-2-  Två spelare");

				// kollar om inputen är en siffra i try, om det inte är det så körs catch
				try {
					val = input.nextInt();
					break;
					//
				} catch (InputMismatchException e) {
					mellanrum();
					System.out.println("error");
					System.out.println("Skirv in antigen 1 eller 2!");
					input.next();
				}
			}

			// switch case med valen
			switch (val) {
			case 1:
				return val;
			case 2:
				return val;
			default:
				mellanrum();
				System.out.println("error");
				System.out.println("Skriv in antigen 1 eller 2!");

			}
		}

	}

	/**
	 * 
	 * Spelaren får välja vilket språk spelet ska vara på, antigen engelska eller
	 * svenska
	 * 
	 * @return 1 eller 2, 1 är svenska och 2 engelska
	 */
	public static int väljspråk() {
		mellanrum();
		while (true) {

			while (true) {

				System.out.println("Vilket språk vill du köra med?");
				System.out.println("-1-  Svenska");
				System.out.println("-2-  Engelska");

				// kollar om inputen är en siffra, om det inte är det så fortsätter loopen och
				// spelaren kan skriva in igen
				try {
					val = input.nextInt();
					break;
				} catch (InputMismatchException e) {
					mellanrum();
					System.out.println("error");
					System.out.println("Skriv in antingen 1 eller 2!");
					input.next();
				}

			}

			// om spelaren skirver in en siffra så körs switchcasen och om det inte är 1
			// eller 2 så går den in i default och loopen börjar om
			switch (val) {
			case 1:
				return val;

			case 2:
				språkengelska = true;
				return val;

			default:
				mellanrum();
				System.out.println("error");
				System.out.println("Skriv in antingen 1 eller 2!");
				break;

			}
		}
	}

	/**
	 * Spelaren får välja svårhetsgrad, antigen lätt, medel eller svår
	 * 
	 * @return 1-lätt 2-medel 3-svår
	 */
	public static int svårhetsgrad() {
		mellanrum();
		while (true) {
			while (true) {

				System.out.println("Vilken svårhetsgrad vill du köra på?");
				System.out.println("-1-  Lätt");
				System.out.println("-2-  Medelsvårt");
				System.out.println("-3-  Svårt");

				try {
					val = input.nextInt();
					break;
				} catch (InputMismatchException e) {
					mellanrum();
					System.out.println("error");
					System.out.println("Skriv in antigen 1,2 eller 3!");
					input.next();
				}

			}

			switch (val) {
			case 1:
				mellanrum();
				System.out.println("Hänga gubbe på lätt svårhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			case 2:
				mellanrum();
				System.out.println("Hänga gubbe på medel svårhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			case 3:
				mellanrum();
				System.out.println("Hänga gubbe på svår svårhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			default:
				mellanrum();
				System.out.println("error");
				System.out.println("Skriv in antigen 1,2 eller 3!");
				break;

			}
		}
	}

	/**
	 * 
	 * metod som tar in vilket språk det är och vilken svårhetsgrad och slumpar ett
	 * ord från en av arrayerna med ord
	 * 
	 * @return ett slumpat ord
	 */
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
			// medel
			case 2:
				random = (int) (Math.random() * svenskaordmedel.length);
				ord = svenskaordmedel[random];
				break;
			// svår
			case 3:
				random = (int) (Math.random() * svenskaordsvårt.length);
				ord = svenskaordsvårt[random];
				break;

			// svårt
			}

			// engelska ord
		} else {
			switch (svårhetsgrad) {
			case 1:
				random = (int) (Math.random() * engelskaordlätt.length);
				ord = engelskaordlätt[random];
				break;

			case 2:
				random = (int) (Math.random() * engelskaordmedel.length);
				ord = engelskaordmedel[random];
				break;

			case 3:
				random = (int) (Math.random() * engelskaordsvårt.length);
				ord = engelskaordsvårt[random];
				break;

			}

		}
		return ord;
	}

	/**
	 * 
	 * Metod för två spelare, en av spelarna väljer själv ett ord
	 * 
	 * @return ordet som spelaren väljer
	 */

	public static String Väljegetord() {
		// loopar metoden
		mellanrum();
		while (true) {
			// Frågar frågan igen om spelaren valde fel ord
			System.out.println("Välj ett ord som den andra spelaren ska försöka gissa!");
			// stringen Ord blir spelarens input
			ord = input.next();
			
		
				if (!ord.matches(".*\\d.*")) {
					
				
			

// frågar om spelaren är säker på att hen vill använda ordet.
			while (true) {
				while (true) {
					System.out.println("Är du säker på att du vill använda " + ord + " som ditt ord?"); // "ord"
					System.out.println("-1-  Ja");
					System.out.println("-2-  Nej");
					// kollar om inputen är en siffra
					try {
						val = input.nextInt();
						break;
					} catch (InputMismatchException e) {
						mellanrum();
						System.out.println("error");
						System.out.println("Skriv in antigen 1 eller 2!");
						input.next();
					}
				}

				switch (val) {
				case 1:
					mellanrum();
					System.out.println("Spelet startar nu!");
					return ord;

				case 2:
					break;
				default:
					mellanrum();
					System.out.println("error");
					System.out.println("Skriv in antigen 1 eller 2!");
					
					// inte siffror i ordet
					
				}
				if (val == 2)
					break;

			}
				}
				else {
					mellanrum();
					System.out.println("error");
					System.out.println("Skirv bara in bokstäver");
				}
				
		}
	}

	/**
	 * 
	 * Metod som tar ordet och lägger in alla bokstäver i arraylisten ordet
	 * 
	 */
	public static void stringtillchars() {
		// loppar för längden av ordet
		for (int i = 0; i < ord.length(); i++) {
			//
			ordet.add(ord.charAt(i));
		}

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

	/**
	 * Spelaren gissar på en bokstav eller på ordet
	 * 
	 * 
	 */
	public static void gissa() {

		// printar de bokstäver som man gissat rätt, hur många index ordet har tex ????
		System.out.println(rättbokstäver);

// om spelaren har gissat på bokstäver så skrivs de ut från arrayen gissadebokstäver
		if (gissadebokstäver.size() >= 1) {
			System.out.println("Du har gissat på:" + gissadebokstäver);
		}
		System.out.println("Gissa på en bokstav eller gissa på ordet!");
		String gissningen = input.next();
 
		// boolean som kontrollerar om gissningen är en bokstav
		boolean ärgissningenintebokstav = false;

		// gör om gissningen till char array för att kolla om det bara är bokstäver
		char[] gissningsomchar = gissningen.toCharArray();

		// loopar igenom arrayen och om det inte är en bokstav så blir boolean
		// ärgissningenintebokstav true
		for (int i = 0; i < gissningsomchar.length; i++) {
			if (!Character.isLetter(gissningsomchar[i])) {
				ärgissningenintebokstav = true;
			}
		}
		// om gissningen innehåller ÅÄÖ så avbruts metoden
		if (gissningen.toUpperCase().matches(".*[ÅÄÖ].*")) {
			mellanrum();
			System.out.println("Bara bokstäver i det engelska alfabetet är tillåtet!");
			return;
		}
		// gissningen räknas bara om det bara är bokstäver
		if (ärgissningenintebokstav == false) {

			// om gissningen är bara en bokstav
			if (gissningen.length() == 1) {
				// ger charen gissning värdet av gissningen
				char gissning = gissningen.charAt(0);
				gissning = Character.toUpperCase(gissning);
				// om spelaren redan har gissat på bokstaven

				// om spelet är på engelska så kan man inte gissa på Å,Ä,Ö
				if (språkengelska == true) {

					
					for (int i = 0; i < gissningen.length(); i++) {
						if (gissningen.charAt(i) == 'Ö') {
							System.out.println("Bara bokstäver i det engelska alfabetet är tillåtet!");
							return;
						}
					}

				}

				if (gissadebokstäver.contains(gissning) || rättbokstäver.contains(gissningen.toUpperCase())) {
					System.out.println("Du har redan gissat på " + gissning);
					return;
				}

				if (ordet.contains(gissning)) {
					// gör mellanrum i konsolen efter varje gissning så det ser bättre ut
					mellanrum();
					System.out.println("Du gissade rätt!");
					// loopar bortagning av bokstäver så alla bokstäver av samma sort blir borttagna
					while (ordet.contains(new Character(gissning))) {
						ordet.remove(new Character(gissning));
					}
					rättgissadebokstäver(gissning);
				} else {
					// gör mellanrum i konsolen efter varje gissning så det ser bättre ut
					mellanrum();
					System.out.println("Du gissade fel!");
					antalfelgissningar++;
					gissadebokstäver.add(gissning);
				}

			}
			// om gissningen är längre än en bokstav så kollas det om det är rätt ord
			else {
				// om gissningen är samma som ordet
				if (gissningen.equalsIgnoreCase(ord)) {
					// tömmer arraylisten ordet så att spelet avslutas och spelaren vinner
					ordet.clear();
					rättbokstäver = ord;

				} else {
					// om spelaren inte gissade rätt
					mellanrum();
					System.out.println("Du gissade fel!");
					antalfelgissningar++;

				}

			}
		}
		// om det inte är en bokstav så körs inte koden och spelaren får gissa igen
		else {
			mellanrum();
			System.out.println("error!");
			System.out.println("skriv in antigen en bokstav eller ett ord!");
		}

	}

	/**
	 * metod som frågar om spelaren vill spela igen
	 * 
	 * @return 1 om spelaren ska spela igen, 2 om spelaren inte vill spela mer
	 */
	public static int spelaigen() {
		while (true) {
			while (true) {
				System.out.println("Vill du spela igen?");
				System.out.println("-1-  Ja");
				System.out.println("-2-  Nej");

				// om inputer inte är en inte så går programmet till catch
				try {
					val = input.nextInt();
					break;
					//
				} catch (InputMismatchException e) {
					System.out.println("Skirv in antingen 1 eller 2!");
					input.next();
				}
			}

			// switch case med valen

			switch (val) {
			// om spelaren vill spela igen så körs reset
			case 1:
				reset();
				return val;

			case 2:
				System.out.println("Tack för att du spelat!");
				return val;

			default:
				System.out.println("Skriv in antigen 1 eller 2!");

			}
		}

	}

	/**
	 * 
	 * Metod som skapar mellanrum i outputen
	 * 
	 */
	public static void mellanrum() {
		// skapar 20 rader
		for (int i = 0; i < 20; i++) {
			System.out.println("");

		}

	}

	/**
	 * Motod som nollställer alla variabler så ett nytt spel kan starta
	 * 
	 */
	public static void reset() {

		ordet.clear();

		gissadebokstäver.clear();

		String ord = "";

		rättbokstäver = "";

		antalfelgissningar = 0;
	}

}
