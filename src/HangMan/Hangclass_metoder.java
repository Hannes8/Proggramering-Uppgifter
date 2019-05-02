package HangMan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Hangclass_metoder {
	// antal fel gissningar fr�n spelaren
	static int antalfelgissningar = 0;
	//
	static Scanner input = new Scanner(System.in);
	// variabel f�r alla val i programmet
	static int val = 0;

// array lists med alla orden i de olika sv�rhetsgraderna

	static String[] svenskaordl�tt = { "Potatis", "Korv", "K�tt", "Bil", "Gul", "R�d", "Gr�n", "Br�d", "Dator", "L�v",
			"Grus", "Bus", "Buss", "S�ng", "Telefon", "Skidor" };

	static String[] svenskaordmedel = { "Toaletter", "Pizzas�s", "Telefonskal", "Skridskor", "Bordtennis", "Bj�rn",
			"Lejon", "�ra" };

	static String[] svenskaordsv�rt = { "Nationalencyklopedin", "Vispgr�dde", "Ukulele", "Flaggst�ngsknoppsm�lare",
			"nordv�stersj�kustartilleriflygspaningssimulatoranl�ggningsmaterielunderh�llsuppf�ljningssystemdiskussionsinl�ggsf�rberedelsearbeten",
			"Yxa" };

	static String[] engelskaordl�tt = { "Car", "Fart", "Yellow", "Rain", "Train", "Cloud", "Water", "Milk", "Hello",
			"Hi", "Potato", "Carrot", "Bot", "Lime", "Bannana", };

	static String[] engelskaordmedel = { "Chocolate", "Garlic", "Shark", "fjord", "rhubarb", "phlegm", "twelfth",
			"syndrome" };

	static String[] engelskaordsv�rt = { "Difficult", "Bagpipes", "Dwarves", "Ivory", "Zombie", "Swivel", "Oxygen",
			"Unzip", "Quad", "Fishhook", "Rhythmic", "giaour" };

	// det valda ordet som chars i en arraylist
	static ArrayList<Character> ordet = new ArrayList<Character>();

	// de gissade bokst�verna i chars i en arraylist
	static ArrayList<Character> gissadebokst�ver = new ArrayList<Character>();

	// ordet som spelaren ska f�rs�ka gissa
	static String ord;

	// de r�tta bokst�verna som spelaren har gissat p�
	static String r�ttbokst�ver = "";

	// de r�tta bokst�verna som spelaren har gissat p� i en char array
	static char[] r�ttbokst�verchar;

	// Skapar ett objekt av den classen med det grafiska
	static Grafiskt_hangman grafisktobjekt = new Grafiskt_hangman();

	// boolean som kollar om spr�ker �r engelska
	static boolean spr�kengelska = false;

	public static void main(String[] args) {
		// ytre while loop som g�r det m�jligt att k�ra om spelet
		while (true) {

			// startar spelet
			start();

			// loop som k�rs tills spelet �r klart, ordet �r gissat eller spelaren har
			// gissat f�r m�nga fel
			while (true) {
				// k�r metoden gissa
				gissa();
				// anropar metoden grafiskt och ger input med antalfelgissningar, metoden skiver
				// ut de grafiska beroende p� hur m�nga fel gissningar som spelaren har
				grafisktobjekt.grafiskt(antalfelgissningar);

				// om arraylisten med bokst�verna fr�n ordet �r tom s� avslutas loopen och
				// spelaren vinner
				if (ordet.size() == 0) {
					System.out.println(r�ttbokst�ver);
					System.out.println("Grattis du vann!");

					break;
				}
				// om spelaren har gissat fel 9 g�nger s� avslutas loopen
				if (antalfelgissningar == 9) {
					System.out.println("Ordet var " + ord);
					break;
				}

			}
			// om spelaren inte vill spela mer s� bryts den ytre while loopen och programet
			// avslutas
			if (spelaigen() == 2) {
				break;
			}
			// om spelaren v�ljer att spela igen s� k�rs reset metoden och sedan k�rs
			// programet om igen
			reset();
		}
	}

	/**
	 * Metoden startar spelet och v�ljer ut vilket ord som spelaren ska f�rs�ka
	 * gissa p�
	 * 
	 */
	public static void start() {
		// om spelaren vill spela sj�lv
		if (Typavspel() == 1) {

			// tilldelar stringen "ord" ett slumpat ord fr�n svenskaord arrayen eller
			// engelska ord arrayen med den sv�rhetsgraden som �r vald
			ord = slumparord(v�ljspr�k(), sv�rhetsgrad());

		}
		// om spelaren v�ljer tv� spelare
		else {
			// tilldelar stringen "ord" ett ord som spelaren v�ljer
			ord = V�ljegetord();
		}
		// g�r om orden till bara stora bokst�ver s� det g�r att j�mf�ra
		ord = ord.toUpperCase();
		// skapar en array med bokst�verna i ordet
		stringtillchars();
		// metod som tar l�ngden p� ordet och skirver ut ? f�r spelaren tex om ordet �r
		// korv s� ser spelaren ????
		r�ttgissadebokst�verstring();

	}

	/**
	 * V�lkommnar spelaren och fr�gar om spelaren vill spela ensam eller som tv�
	 * spelare
	 * 
	 * ger tillbaks om det �r en spelare(1) eller tv� spelare(2)
	 */
	public static int Typavspel() {
		mellanrum();

		System.out.println("V�lkomen till h�nga gubbe!");
		// loopar outputen s� spelaren kan se alternativen igen om de skriver in fel
		while (true) {

			while (true) {
				System.out.println("Vill du spela ensam eller som tv� spelare?");
				System.out.println("-1-  Ensam");
				System.out.println("-2-  Tv� spelare");

				// kollar om inputen �r en siffra i try, om det inte �r det s� k�rs catch
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
	 * Spelaren f�r v�lja vilket spr�k spelet ska vara p�, antigen engelska eller
	 * svenska
	 * 
	 * @return 1 eller 2, 1 �r svenska och 2 engelska
	 */
	public static int v�ljspr�k() {
		mellanrum();
		while (true) {

			while (true) {

				System.out.println("Vilket spr�k vill du k�ra med?");
				System.out.println("-1-  Svenska");
				System.out.println("-2-  Engelska");

				// kollar om inputen �r en siffra, om det inte �r det s� forts�tter loopen och
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

			// om spelaren skirver in en siffra s� k�rs switchcasen och om det inte �r 1
			// eller 2 s� g�r den in i default och loopen b�rjar om
			switch (val) {
			case 1:
				return val;

			case 2:
				spr�kengelska = true;
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
	 * Spelaren f�r v�lja sv�rhetsgrad, antigen l�tt, medel eller sv�r
	 * 
	 * @return 1-l�tt 2-medel 3-sv�r
	 */
	public static int sv�rhetsgrad() {
		mellanrum();
		while (true) {
			while (true) {

				System.out.println("Vilken sv�rhetsgrad vill du k�ra p�?");
				System.out.println("-1-  L�tt");
				System.out.println("-2-  Medelsv�rt");
				System.out.println("-3-  Sv�rt");

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
				System.out.println("H�nga gubbe p� l�tt sv�rhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			case 2:
				mellanrum();
				System.out.println("H�nga gubbe p� medel sv�rhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			case 3:
				mellanrum();
				System.out.println("H�nga gubbe p� sv�r sv�rhetsgrad startar nu!");
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
	 * metod som tar in vilket spr�k det �r och vilken sv�rhetsgrad och slumpar ett
	 * ord fr�n en av arrayerna med ord
	 * 
	 * @return ett slumpat ord
	 */
	public static String slumparord(int spr�k, int sv�rhetsgrad) {
		// initierar int random
		int random;
		// om svenska �r valt
		if (spr�k == 1) {
			// switchcase som v�ljer beroende p� vilken sv�rhetsgrad som �r vald
			switch (sv�rhetsgrad) {

			case 1:
				// int random blir ett random tal mellan 0 till antalet ord i arrayen
				// svenskaordl�tt
				random = (int) (Math.random() * svenskaordl�tt.length);
				// stringen ord blir ett ord fr�n arrayen svenskaordl�tt med indexen fr�n int
				// random
				ord = svenskaordl�tt[random];
				break;
			// medel
			case 2:
				random = (int) (Math.random() * svenskaordmedel.length);
				ord = svenskaordmedel[random];
				break;
			// sv�r
			case 3:
				random = (int) (Math.random() * svenskaordsv�rt.length);
				ord = svenskaordsv�rt[random];
				break;

			// sv�rt
			}

			// engelska ord
		} else {
			switch (sv�rhetsgrad) {
			case 1:
				random = (int) (Math.random() * engelskaordl�tt.length);
				ord = engelskaordl�tt[random];
				break;

			case 2:
				random = (int) (Math.random() * engelskaordmedel.length);
				ord = engelskaordmedel[random];
				break;

			case 3:
				random = (int) (Math.random() * engelskaordsv�rt.length);
				ord = engelskaordsv�rt[random];
				break;

			}

		}
		return ord;
	}

	/**
	 * 
	 * Metod f�r tv� spelare, en av spelarna v�ljer sj�lv ett ord
	 * 
	 * @return ordet som spelaren v�ljer
	 */

	public static String V�ljegetord() {
		// loopar metoden
		mellanrum();
		while (true) {
			// Fr�gar fr�gan igen om spelaren valde fel ord
			System.out.println("V�lj ett ord som den andra spelaren ska f�rs�ka gissa!");
			// stringen Ord blir spelarens input
			ord = input.next();
			
		
				if (!ord.matches(".*\\d.*")) {
					
				
			

// fr�gar om spelaren �r s�ker p� att hen vill anv�nda ordet.
			while (true) {
				while (true) {
					System.out.println("�r du s�ker p� att du vill anv�nda " + ord + " som ditt ord?"); // "ord"
					System.out.println("-1-  Ja");
					System.out.println("-2-  Nej");
					// kollar om inputen �r en siffra
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
					System.out.println("Skirv bara in bokst�ver");
				}
				
		}
	}

	/**
	 * 
	 * Metod som tar ordet och l�gger in alla bokst�ver i arraylisten ordet
	 * 
	 */
	public static void stringtillchars() {
		// loppar f�r l�ngden av ordet
		for (int i = 0; i < ord.length(); i++) {
			//
			ordet.add(ord.charAt(i));
		}

	}

	public static void r�ttgissadebokst�verstring() {
		for (int i = 0; i < ord.length(); i++) {
			r�ttbokst�ver = r�ttbokst�ver + "?";

		}

	}

	// metod som visar de r�tt bokst�ver som �r r�tt gissade i ordet
	public static void r�ttgissadebokst�ver(char r�ttgissadbokstav) {

		// g�r om stringen r�ttbokst�ver till en char array s� det g�r att f�r�ndra
		// bokst�verna
		char[] r�ttbokst�verchar = r�ttbokst�ver.toCharArray();

		// loopar med l�ngden av ordet
		for (int i = 0; i < ord.length(); i++) {
// om den gissade bokstaven �r lika med den bokstaven p� indexet i i loopen s� byter char arrayen ut fr�n ett ? till r�tt bokstav
			if (ord.charAt(i) == (r�ttgissadbokstav)) {
				r�ttbokst�verchar[i] = r�ttgissadbokstav;

			}

		}
		// stringen r�ttbokst�ver f�r v�rdet av charsen i arrayen r�ttbokst�verchar
		r�ttbokst�ver = String.valueOf(r�ttbokst�verchar);
	}

	/**
	 * Spelaren gissar p� en bokstav eller p� ordet
	 * 
	 * 
	 */
	public static void gissa() {

		// printar de bokst�ver som man gissat r�tt, hur m�nga index ordet har tex ????
		System.out.println(r�ttbokst�ver);

// om spelaren har gissat p� bokst�ver s� skrivs de ut fr�n arrayen gissadebokst�ver
		if (gissadebokst�ver.size() >= 1) {
			System.out.println("Du har gissat p�:" + gissadebokst�ver);
		}
		System.out.println("Gissa p� en bokstav eller gissa p� ordet!");
		String gissningen = input.next();
 
		// boolean som kontrollerar om gissningen �r en bokstav
		boolean �rgissningenintebokstav = false;

		// g�r om gissningen till char array f�r att kolla om det bara �r bokst�ver
		char[] gissningsomchar = gissningen.toCharArray();

		// loopar igenom arrayen och om det inte �r en bokstav s� blir boolean
		// �rgissningenintebokstav true
		for (int i = 0; i < gissningsomchar.length; i++) {
			if (!Character.isLetter(gissningsomchar[i])) {
				�rgissningenintebokstav = true;
			}
		}
		// om gissningen inneh�ller ��� s� avbruts metoden
		if (gissningen.toUpperCase().matches(".*[���].*")) {
			mellanrum();
			System.out.println("Bara bokst�ver i det engelska alfabetet �r till�tet!");
			return;
		}
		// gissningen r�knas bara om det bara �r bokst�ver
		if (�rgissningenintebokstav == false) {

			// om gissningen �r bara en bokstav
			if (gissningen.length() == 1) {
				// ger charen gissning v�rdet av gissningen
				char gissning = gissningen.charAt(0);
				gissning = Character.toUpperCase(gissning);
				// om spelaren redan har gissat p� bokstaven

				// om spelet �r p� engelska s� kan man inte gissa p� �,�,�
				if (spr�kengelska == true) {

					
					for (int i = 0; i < gissningen.length(); i++) {
						if (gissningen.charAt(i) == '�') {
							System.out.println("Bara bokst�ver i det engelska alfabetet �r till�tet!");
							return;
						}
					}

				}

				if (gissadebokst�ver.contains(gissning) || r�ttbokst�ver.contains(gissningen.toUpperCase())) {
					System.out.println("Du har redan gissat p� " + gissning);
					return;
				}

				if (ordet.contains(gissning)) {
					// g�r mellanrum i konsolen efter varje gissning s� det ser b�ttre ut
					mellanrum();
					System.out.println("Du gissade r�tt!");
					// loopar bortagning av bokst�ver s� alla bokst�ver av samma sort blir borttagna
					while (ordet.contains(new Character(gissning))) {
						ordet.remove(new Character(gissning));
					}
					r�ttgissadebokst�ver(gissning);
				} else {
					// g�r mellanrum i konsolen efter varje gissning s� det ser b�ttre ut
					mellanrum();
					System.out.println("Du gissade fel!");
					antalfelgissningar++;
					gissadebokst�ver.add(gissning);
				}

			}
			// om gissningen �r l�ngre �n en bokstav s� kollas det om det �r r�tt ord
			else {
				// om gissningen �r samma som ordet
				if (gissningen.equalsIgnoreCase(ord)) {
					// t�mmer arraylisten ordet s� att spelet avslutas och spelaren vinner
					ordet.clear();
					r�ttbokst�ver = ord;

				} else {
					// om spelaren inte gissade r�tt
					mellanrum();
					System.out.println("Du gissade fel!");
					antalfelgissningar++;

				}

			}
		}
		// om det inte �r en bokstav s� k�rs inte koden och spelaren f�r gissa igen
		else {
			mellanrum();
			System.out.println("error!");
			System.out.println("skriv in antigen en bokstav eller ett ord!");
		}

	}

	/**
	 * metod som fr�gar om spelaren vill spela igen
	 * 
	 * @return 1 om spelaren ska spela igen, 2 om spelaren inte vill spela mer
	 */
	public static int spelaigen() {
		while (true) {
			while (true) {
				System.out.println("Vill du spela igen?");
				System.out.println("-1-  Ja");
				System.out.println("-2-  Nej");

				// om inputer inte �r en inte s� g�r programmet till catch
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
			// om spelaren vill spela igen s� k�rs reset
			case 1:
				reset();
				return val;

			case 2:
				System.out.println("Tack f�r att du spelat!");
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
	 * Motod som nollst�ller alla variabler s� ett nytt spel kan starta
	 * 
	 */
	public static void reset() {

		ordet.clear();

		gissadebokst�ver.clear();

		String ord = "";

		r�ttbokst�ver = "";

		antalfelgissningar = 0;
	}

}
