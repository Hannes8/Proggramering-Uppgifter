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

	static ArrayList<Character> gissadebokst�ver = new ArrayList<Character>();

	static String ord = "";

	public static void main(String[] args) {

		while (true) {

			// om spelaren vill spela sj�lv
			if (Typavspel() == 1)
				v�ljspr�k();
			// slumpar ord
			else {
				// v�lj eget ord
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

	public static String V�ljegetord() {
		System.out.println("V�lj ett ord som den andra spelaren ska f�rs�ka gissa!");
		ord=input.next();
		System.out.println("�r du s�ker p� att du vill anv�nda "+ord+"som ditt ord?");
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
