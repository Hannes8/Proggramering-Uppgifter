package Hemuppgifterv36;

import java.util.Scanner;

public class Heml�xa {
	static int[] heltal = {31,54,12,4,6,787,5,43,2,6,878,6};
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		uppgift1();
		
		uppgift2();
		
		
		
	}
	
	// 1. Skapa en metod som tar in ett ok�nt antal heltal och returnerar deras summa.
	public static void uppgift1() {
		int summa=0;
		
		for (int i = 0; i < heltal.length; i++) {
		
			summa = summa + heltal[i];
		} 
		

		
		System.out.println("-1- Summan �r: "+summa);
		
		
	}
	// 2. Skapa en rekursiv metod som tar in en str�ng och returnerar den bakl�nges.
	public static void uppgift2() {
		String ordbakl�nges ="";
		
		System.out.println("Skriv in ett ord!");
		
		String ord=input.next();
		for (int i = ord.length()-1; i >= 0; i--) {
		char bokstav=ord.charAt(i);
		ordbakl�nges=ordbakl�nges+bokstav;
			
		}
		System.out.println(ordbakl�nges);
	}
	// 3. Skapa en generisk metod som tar in ett ok�nt antal objekt och returnerar en array av dem.
	public static void uppgift3() {
		
		
		
		
	}
	// 4. Skapa en klass Box som tar in ett ok�nt antal objekt och lagrar dem.
public static void uppgift4() {
		
		
		
	}
// 5. Skapa en metod i klassen Box som kan j�mf�ra ifall tv� stycken Boxar inneh�ller samma datatyp.*
public static void uppgift5() {
	
	
	
}

	// 6. Skapa en rekursiv metod som tar in ett ord och skriver ut alla anagram av ordet.*
	
	public static void uppgift6() {
	
		
		
	}
	// 7. Skapa Application som rekursivt ritar ut ett fibonacci-tr�d.*
	public static void uppgift7() {
		
		
	}

}
