package HangMan;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangclass_metoder {
	static int antalfelgissningar = 0;
	static Scanner input = new Scanner(System.in);
	static int val = 0;

	static String[] svenskaord = { "" };

	static String[] engelskaord = {}; //https://github.com/Xethron/Hangman/blob/master/words.txt

	static ArrayList<Character> ordet = new ArrayList<Character>();

	static ArrayList<Character> gissadebokstäver = new ArrayList<Character>();

	static String ord = "";

	public static void main(String[] args) {

		while (true) {

			// om spelaren vill spela själv
			if (Typavspel() == 1)
				väljspråk();
			// slumpar ord
			else {
				// välj eget ord
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

	public static String slumparord(int val) {

		if (val == 1) {
			// svenska ord
			int random = (int) Math.random() * svenskaord.length + 1;
			ord = svenskaord[random];
		} else {
			int random = (int) Math.random() * engelskaord.length + 1;
			ord = engelskaord[random];
		}
		return ord;
	}

	public static String Väljegetord() {
		System.out.println("Välj ett ord som den andra spelaren ska försöka gissa!");
		ord=input.next();
		System.out.println("Är du säker på att du vill använda "+ord+"som ditt ord?");
		val=input.nextInt();
		System.out.println("-1-  Ja");
		System.out.println("-2-  Nej");
		
		switch(val) {
		case 1:
			return ord;
		case 2:
			break;
		default:
	System.err.println("error");
	break;
		}

	}

}
