package HangMan;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Hangclass_metoder {
	static int antalfelgissningar = 0;
	static Scanner input = new Scanner(System.in);
	static int val = 0;

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

	static String ord = "";

	// Skapar ett objekt av den classen med det grafiska
	static Grafiskt_hangman grafisktobjekt = new Grafiskt_hangman();

	public static void main(String[] args) {

		while (true) {
			grafisktobjekt.grafiskt(5);
			
			//svårhetsgrad
			System.out.println(ord);
			
			// om spelaren vill spela själv
			if (Typavspel() == 1) {
				// tilldelar stringen "ord" ett slumpat ord från svenskaord arrayen eller
				// engelska ord arrayen med den svårhetsgraden som är vald
				ord = slumparord(väljspråk(),svårhetsgrad());
			System.out.println(ord);
			}
			// om spelaren väljer två spelare
			else {
				// tilldelar stringen "ord" ett ord som spelaren väljer
				ord = Väljegetord();

			}
			// loop som körs tills spelet är klart, ordet är gissat eller spelaren har
			// gissat för många fel
			while (true) {

			}

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
				break;

			}

		}

	}

	// metod som tar in vilket språk det är och slumpar ett ord från en av arrayerna
	// med ord
	public static String slumparord(int språk, int svårhetsgrad) {
		int random;
		// om svenska är valt
		if (språk == 1) {
			switch (svårhetsgrad) {
			// lätt
			case 1:
				random = (int) (Math.random() * svenskaordlätt.length + 1);
				ord = svenskaordlätt[random];
				// medel
			case 2:
				random = (int) (Math.random() * svenskaordmedel.length + 1);
				ord = svenskaordmedel[random];
				// svårt
			case 3:
				random = (int) (Math.random() * svenskaordsvårt.length + 1);
				ord = svenskaordsvårt[random];
			}

			// engelska ord
		} else {
			switch (svårhetsgrad) {
			case 1:
				random = (int) (Math.random() * engelskaordlätt.length + 1);
				ord = engelskaordlätt[random];

			case 2:
				random = (int) (Math.random() * engelskaordmedel.length + 1);
				ord = engelskaordmedel[random];

			case 3:
				random = (int) (Math.random() * engelskaordsvårt.length + 1);
				ord = engelskaordsvårt[random];

			}

		}
		return ord;
	}

	public static String Väljegetord() {
		val = 2;
		while (true) {
			if (val == 2) {
				System.out.println("Välj ett ord som den andra spelaren ska försöka gissa!");
				ord = input.next();
			}

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

	public static void gissa() {
		grafisktobjekt.grafiskt(antalfelgissningar);

		if (gissadebokstäver.size() >= 1) {
			System.out.println("Du har gissat på:" + gissadebokstäver);
		}

		System.out.println("Gissa på en bokstav eller gissa på ordet!");
		char gissning = input.next().charAt(0);
		
		if (ordet.contains(gissning)){
			ordet.remove(gissning);
			
		}
		else {
			System.out.println("Du gissade fel!");
			antalfelgissningar++;
			gissadebokstäver.add(gissning);
		}
		
	}

}
