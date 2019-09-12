package Hemuppgifterv36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hemläxa {

	static ArrayList<Character> arraychar = new ArrayList<>();

	static int iterationer = 0;

	static String ordbaklänges = "";
	static int indexcount = 0;

	public static void main(String[] args) {

		System.out.println("-1- " + uppgift1(65, 77, 88));
		
		
		String ord2 = "potatis";
		
		System.out.println("-2- " + uppgift2(ord2));

		// objekt till uppgift 3
		int tal = 6;
		String ord = "potatis";
		char bokstav = 'h';
		double decimaltal = 6.9;

		System.out.println("-3- " + Arrays.toString(uppgift3(tal, ord, bokstav, decimaltal)));

		uppgift6();


	}

	/**
	 * 1. Skapa en metod som tar in ett okänt antal heltal och returnerar deras
	 * summa.
	 */
	public static int uppgift1(int... heltal) {
		int summa = 0;

		for (int i = 0; i < heltal.length; i++) {
			summa += heltal[i];
		}

		return summa;

	}

	/**
	 * 2. Skapa en rekursiv metod som tar in en sträng och returnerar den baklänges.
	 * 
	 * @return
	 */
	public static String uppgift2(String ord) {

		ordbaklänges = ordbaklänges + ord.charAt(ord.length() - 1 - indexcount);

		indexcount++;

		if (indexcount == ord.length())
			return ordbaklänges;

		uppgift2(ord);
		return ordbaklänges;

	}

	/**
	 * 3. Skapa en generisk metod som tar in ett okänt antal objekt och returnerar
	 * en array av dem.
	 */
	public static <T> T[] uppgift3(T... objekt) {

		return objekt;

	}

	/**
	 * 6. Skapa en rekursiv metod som tar in ett ord och skriver ut alla anagram av
	 * ordet
	 * 
	 * glömde göra den rekursiv
	 */
	public static void uppgift6() {
		boolean anagram = false;
		String ord = "blå";
		ArrayList<Character> arraychar = new ArrayList<>();
		ArrayList<String> anagramarray = new ArrayList<>();

		String[] ordlista = { "hej", "potatis", "hello", "bål", };
		for (int i = 0; i < ord.length(); i++) {
			arraychar.add(ord.charAt(i));
		}
		// loopar igenom arrayen med ordlistan
		for (int i = 0; i < ordlista.length; i++) {
			anagram = true;

			for (int j = 0; j < ordlista[i].length(); j++) {

				// om bokstaven i ordlistan inte matchar med ordet eller om ordet och ordlistan
				// är olika långa så blir anagram false
				if (!arraychar.contains(ordlista[i].charAt(j)) || !(ordlista[i].length() == ord.length())) {
					anagram = false;
				}

			}
			if (anagram == true) {
				anagramarray.add(ordlista[i]);
			}

		}
		System.out.println("-6- anagramen till ordet " + ord + " är " + anagramarray);
	}

}
