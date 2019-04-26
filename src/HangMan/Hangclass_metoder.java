package HangMan;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Hangclass_metoder {
	static int antalfelgissningar = 0;
	static Scanner input = new Scanner(System.in);
	static int val = 0;

//
	static String[] svenskaordl�tt = { "Potatis", "Korv", "K�tt", "Bil", "Gul", "R�d", "Gr�n", "Br�d", "Dator", "L�v",
			"Grus", "Bus", "Buss", "S�ng", "Telefon", "Skidor" };

	static String[] svenskaordmedel = { "Toaletter", "Pizzas�s", "Telefonskal", "Skridskor", "Bordtennis", };

	static String[] svenskaordsv�rt = { "Nationalencyklopedin", "Vispgr�dde", "Ukulele", "Flaggst�ngsknoppsm�lare",
			"nordv�stersj�kustartilleriflygspaningssimulatoranl�ggningsmaterielunderh�llsuppf�ljningssystemdiskussionsinl�ggsf�rberedelsearbeten",
			"Yxa", };

	static String[] engelskaordl�tt = { "Car", "Fart", "Yellow", "Rain", "Train", "Cloud", "Water", "Milk", "Hello",
			"Hi", "Potato", "Carrot", "Bot", "Lime", "Bannana", };

	static String[] engelskaordmedel = { "Chocolate", "Garlic", "Shark", "fjord", "rhubarb", "phlegm", "twelfth",
			"syndrome" };

	static String[] engelskaordsv�rt = { "Difficult", "Bagpipes", "Dwarves", "Ivory", "Zombie", "Swivel", "Oxygen",
			"Unzip", "Quad", "Fishhook", "Rhythmic", "giaour" };

	static ArrayList<Character> ordet = new ArrayList<Character>();

	static ArrayList<Character> gissadebokst�ver = new ArrayList<Character>();

	static String ord;

	static String r�ttbokst�ver = "";

	static char[] r�ttbokst�verchar;

	// Skapar ett objekt av den classen med det grafiska
	static Grafiskt_hangman grafisktobjekt = new Grafiskt_hangman();

	public static void main(String[] args) {
		while (true) {

			// om spelaren vill spela sj�lv
			if (Typavspel() == 1) {
				// tilldelar stringen "ord" ett slumpat ord fr�n svenskaord arrayen eller
				// engelska ord arrayen med den sv�rhetsgraden som �r vald
				ord = slumparord(v�ljspr�k(), sv�rhetsgrad());

				// ska kunna g� tillbacka i programet , g�r det till en start metod

			}
			// om spelaren v�ljer tv� spelare
			else {
				// tilldelar stringen "ord" ett ord som spelaren v�ljer
				ord = V�ljegetord();

			}

			ord = ord.toUpperCase();
			stringtillchars();
			r�ttgissadebokst�verstring();

			// loop som k�rs tills spelet �r klart, ordet �r gissat eller spelaren har
			// gissat f�r m�nga fel
			while (true) {
				gissa();
				grafisktobjekt.grafiskt(antalfelgissningar);

				if (ordet.size() == 0) {
					System.out.println(r�ttbokst�ver);
					System.out.println("Grattis du vann!");

					break;
				}
				if (antalfelgissningar == 9) {
					System.out.println("Ordet var " + ord);
					break;
				}

				// tv� bokst�ver, vinner inte

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
	 * V�lkommnar spelaren och fr�gar om spelaren vill spela ensam eller som tv�
	 * spelare
	 * 
	 * ger tillbaks om det �r en spelare(1) eller tv� spelare(2)
	 */
	public static int Typavspel() {

		System.out.println("V�lkomen till h�nga gubbe!");
		System.out.println("regler");
		// loopar outputen s� spelaren kan se alternativen igen om de skriver in fel
		while (true) {

			while (true) {
				System.out.println("Vill du spela ensam eller som tv� spelare?");
				System.out.println("-1-  Ensam");
				System.out.println("-2-  Tv� spelare");
				// loopar medans validinput �r false

				// kollar om inputen �r en siffra i try, om det inte �r det s� k�rs catch
				try {
					val = input.nextInt();
					break;
					//
				} catch (InputMismatchException e) {
					System.out.println("Skirv in ett nummer!");
					input.next();
				}
			}

			switch (val) {
			case 1:
				return val;
			case 2:
				return val;
			default:
				System.out.println("error");

			}
		}

	}

	/**
	 * 
	 * Hello
	 * 
	 * @return
	 */
	public static int v�ljspr�k() {
		while (true) {

			while (true) {
				System.out.println("Vilket spr�k vill du k�ra med?");
				System.out.println("-1-  Svenska");
				System.out.println("-2-  Engelska");

				try {
					val = input.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Skriv in antingen 1 eller 2!");
					input.next();
				}
			}

			switch (val) {
			case 1:
				return val;

			case 2:
				return val;
			default:
				System.out.println("Skriv in antingen 1 eller 2!");
				break;

			}
		}
	}

// metod som v�ljer sv�rhetsgraden 
	public static int sv�rhetsgrad() {
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
					System.out.println("Skriv in antigen 1,2 eller 3!");
					input.next();
				}

			}
			switch (val) {
			case 1:
				System.out.println("H�nga gubbe p� l�tt sv�rhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			case 2:
				System.out.println("H�nga gubbe p� medel sv�rhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			case 3:
				System.out.println("H�nga gubbe p� sv�r sv�rhetsgrad startar nu!");
				System.out.println("Lycka till");
				return val;

			default:
				System.out.println("Skriv in antigen 1,2 eller 3!");
				break;

			}
		}
	}

	// metod som tar in vilket spr�k det �r och vilken sv�rhetsgrad och slumpar ett
	// ord fr�n en av arrayerna med ord
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
			// l�tt
			case 2:
				random = (int) (Math.random() * svenskaordmedel.length + 1);
				ord = svenskaordmedel[random];
				break;
			// medel
			case 3:
				random = (int) (Math.random() * svenskaordsv�rt.length + 1);
				ord = svenskaordsv�rt[random];
				break;

			// sv�rt
			}

			// engelska ord
		} else {
			switch (sv�rhetsgrad) {
			case 1:
				random = (int) (Math.random() * engelskaordl�tt.length + 1);
				ord = engelskaordl�tt[random];
				break;

			case 2:
				random = (int) (Math.random() * engelskaordmedel.length + 1);
				ord = engelskaordmedel[random];
				break;

			case 3:
				random = (int) (Math.random() * engelskaordsv�rt.length + 1);
				ord = engelskaordsv�rt[random];
				break;

			}

		}
		return ord;
	}

// Metod f�r tv� spelare, en av spelarna v�ljer sj�lv ett ord
	public static String V�ljegetord() {
		val = 2;
		// loopar metoden
		while (true) {
			// Fr�gar fr�gan igen om spelaren valde fel ord
			if (val == 2) {
				System.out.println("V�lj ett ord som den andra spelaren ska f�rs�ka gissa!");
				// stringen Ord blir spelarens input
				ord = input.next();
			}
// fr�gar om spelaren �r s�ker p� att hen vill anv�nda ordet.
			System.out.println("�r du s�ker p� att du vill anv�nda " + ord + " som ditt ord?"); // "ord"
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

	// Metod som tar ordet och l�gger in alla bokst�ver i arraylisten ordet
	public static void stringtillchars() {
		for (int i = 0; i < ord.length(); i++) {
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

	public static void gissa() {

		System.out.println(r�ttbokst�ver);

		if (gissadebokst�ver.size() >= 1) {
			System.out.println("Du har gissat p�:" + gissadebokst�ver);
		}
		System.out.println("Gissa p� en bokstav eller gissa p� ordet!");
		String gissningen = input.next();

		if (gissningen.length() == 1) {
			char gissning = gissningen.charAt(0);
			gissning = Character.toUpperCase(gissning);
			if (gissadebokst�ver.contains(gissning)) {
				System.out.println("Du har redan gissat p� " + gissning);
				return;
			}

			if (ordet.contains(gissning)) {
				System.out.println("Du gissade r�tt!");
				ordet.remove(new Character(gissning));
				r�ttgissadebokst�ver(gissning);
			} else {
				System.out.println("Du gissade fel!");
				antalfelgissningar++;
				gissadebokst�ver.add(gissning);
			}

		}
		// om gissningen �r l�ngre �n en bokstav s� kollas det om det �r r�tt ord
		else {
			if (gissningen.equalsIgnoreCase(ord)) {
				ordet.clear();
				r�ttbokst�ver = ord;

			} else {
				antalfelgissningar++;

			}

		}
		// g�r mellanrum i konsolen efter varje gissning s� det ser b�ttre ut
		mellanrum();
	}

	public static int spelaigen() {
		while (true) {
			while (true) {
				System.out.println("Vill du spela igen?");
				System.out.println("-1-  Ja");
				System.out.println("-2-  Nej");


				try {
					val = input.nextInt();
					break;
					//
				} catch (InputMismatchException e) {
					System.out.println("Skirv in antingen 1 eller 2!");
					input.next();
				}
			}

			switch (val) {
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

	public static void mellanrum() {
		for (int i = 0; i < 20; i++) {
			System.out.println("");

		}

	}

	public static void reset() {

		ordet.clear();

		gissadebokst�ver.clear();

		String ord = "";

		r�ttbokst�ver = "";

		antalfelgissningar = 0;
	}

}
