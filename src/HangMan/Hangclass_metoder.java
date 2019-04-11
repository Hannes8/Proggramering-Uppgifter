package HangMan;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Hangclass_metoder {
	static int antalfelgissningar = 0;
	static Scanner input = new Scanner(System.in);
	static int val = 0;

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

	static String ord = "";

	// Skapar ett objekt av den classen med det grafiska
	static Grafiskt_hangman grafisktobjekt = new Grafiskt_hangman();

	public static void main(String[] args) {

		while (true) {
			grafisktobjekt.grafiskt(5);
			
			//sv�rhetsgrad
			System.out.println(ord);
			
			// om spelaren vill spela sj�lv
			if (Typavspel() == 1) {
				// tilldelar stringen "ord" ett slumpat ord fr�n svenskaord arrayen eller
				// engelska ord arrayen med den sv�rhetsgraden som �r vald
				ord = slumparord(v�ljspr�k(),sv�rhetsgrad());
			System.out.println(ord);
			}
			// om spelaren v�ljer tv� spelare
			else {
				// tilldelar stringen "ord" ett ord som spelaren v�ljer
				ord = V�ljegetord();

			}
			// loop som k�rs tills spelet �r klart, ordet �r gissat eller spelaren har
			// gissat f�r m�nga fel
			while (true) {

			}

		}
	}

	public static int Typavspel() {
		System.out.println("V�lkomen till h�nga gubbe!");
		System.out.println("regler");
		System.out.println("Vill du spela ensam eller som tv� spelare?");
		System.out.println("-1-  Ensam");
		System.out.println("-2-  Tv� spelare");

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

	// metod som v�ljer spr�k
	public static int v�ljspr�k() {
		System.out.println("Vilket spr�k vill du k�ra med?");
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

	public static int sv�rhetsgrad() {
		while (true) {
			System.out.println("Vilken sv�rhetsgrad vill du k�ra p�?");
			System.out.println("-1-  L�tt");
			System.out.println("-2-  Medelsv�rt");
			System.out.println("-3-  Sv�rt");
			val = input.nextInt();

			switch (val) {
			case 1:
				return val;

			case 2:
				return val;

			case 3:
				return val;

			default:
				break;

			}

		}

	}

	// metod som tar in vilket spr�k det �r och slumpar ett ord fr�n en av arrayerna
	// med ord
	public static String slumparord(int spr�k, int sv�rhetsgrad) {
		int random;
		// om svenska �r valt
		if (spr�k == 1) {
			switch (sv�rhetsgrad) {
			// l�tt
			case 1:
				random = (int) (Math.random() * svenskaordl�tt.length + 1);
				ord = svenskaordl�tt[random];
				// medel
			case 2:
				random = (int) (Math.random() * svenskaordmedel.length + 1);
				ord = svenskaordmedel[random];
				// sv�rt
			case 3:
				random = (int) (Math.random() * svenskaordsv�rt.length + 1);
				ord = svenskaordsv�rt[random];
			}

			// engelska ord
		} else {
			switch (sv�rhetsgrad) {
			case 1:
				random = (int) (Math.random() * engelskaordl�tt.length + 1);
				ord = engelskaordl�tt[random];

			case 2:
				random = (int) (Math.random() * engelskaordmedel.length + 1);
				ord = engelskaordmedel[random];

			case 3:
				random = (int) (Math.random() * engelskaordsv�rt.length + 1);
				ord = engelskaordsv�rt[random];

			}

		}
		return ord;
	}

	public static String V�ljegetord() {
		val = 2;
		while (true) {
			if (val == 2) {
				System.out.println("V�lj ett ord som den andra spelaren ska f�rs�ka gissa!");
				ord = input.next();
			}

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

	public static void gissa() {
		grafisktobjekt.grafiskt(antalfelgissningar);

		if (gissadebokst�ver.size() >= 1) {
			System.out.println("Du har gissat p�:" + gissadebokst�ver);
		}

		System.out.println("Gissa p� en bokstav eller gissa p� ordet!");
		char gissning = input.next().charAt(0);
		
		if (ordet.contains(gissning)){
			ordet.remove(gissning);
			
		}
		else {
			System.out.println("Du gissade fel!");
			antalfelgissningar++;
			gissadebokst�ver.add(gissning);
		}
		
	}

}
