package Hemuppgifterv36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Heml�xa {
	
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		uppgift1();
		
		uppgift2();
		
		int tal=6; 
		String ord="potatis";
		char bokstav='h';
		double decimaltal=6.9;
		
		uppgift3(tal,ord,bokstav,decimaltal);
		
		uppgift6();
		
		uppgift7(10);
		

		
	}
	
	// 1. Skapa en metod som tar in ett ok�nt antal heltal och returnerar deras summa.
	public static void uppgift1() {
		int summa=0;
		// slumpar fram ett tal mellan 1 till 20 
		int random= (int) (Math.random()*20+1);
		
		ArrayList<Integer>heltal = new ArrayList<>();
		// slumpar fram 1 till 20 heltal och l�gger dem i arraylisten heltal
		for (int i = 0; i <= random; i++) {
			heltal.add((int) (Math.random()*100+1));
		}
		// summan av heltalen
		for (int i = 0; i < heltal.size(); i++) {
			summa+=heltal.get(i);
		
		}
		
	System.out.println("-1- Summan av: "+ heltal + " �r " + summa);
		

		
		
		
	
	}
	// 2. Skapa en rekursiv metod som tar in en str�ng och returnerar den bakl�nges.
	public static void uppgift2() {
		String ordbakl�nges ="";
		
		
		String ord="potatis";
		
		for (int i = ord.length()-1; i >= 0; i--) {
		char bokstav=ord.charAt(i);
		ordbakl�nges=ordbakl�nges+bokstav;
			
		}
		System.out.println("-2- Ordet potatis bakl�nges �r: "+ordbakl�nges);
	}
	//3. Skapa en generisk metod som tar in ett ok�nt antal objekt och returnerar en array av dem.
	public static <T> void uppgift3(T a,T b,T c,T d) {
		
		ArrayList<String>array = new ArrayList<>();
		
	}
	// 4. Skapa en klass Box som tar in ett ok�nt antal objekt och lagrar dem.
public static void uppgift4() {
		
		
		
	}
// 5. Skapa en metod i klassen Box som kan j�mf�ra ifall tv� stycken Boxar inneh�ller samma datatyp.*
public static void uppgift5() {
	
	
	
}

	// 6. Skapa en rekursiv metod som tar in ett ord och skriver ut alla anagram av ordet.*
	
	public static void uppgift6() {
		boolean anagram=false;
		String ord ="bl�";
		ArrayList <Character>arraychar = new ArrayList<>();
		ArrayList <String>anagramarray = new ArrayList<>();
		
		String [] ordlista = {"hej","potatis","hello","b�l",};
		for (int i = 0; i < ord.length(); i++) {
			arraychar.add(ord.charAt(i));
		}
		// loopar igenom arrayen med ordlistan
		for (int i = 0; i < ordlista.length; i++) {
			anagram=true;
			
			for (int j = 0; j < ordlista[i].length(); j++) {
				
				// om bokstaven i ordlistan inte matchar med ordet eller om ordet och ordlistan �r olika l�nga s� blir anagram false
				if(!arraychar.contains(ordlista[i].charAt(j)) ||  !(ordlista[i].length() == ord.length())) {
				anagram=false;	
				}
				
			}
			if (anagram==true) {
				anagramarray.add(ordlista[i]);
			}
			
		}
		System.out.println("-6- anagramen till ordet "+ord+" �r "+anagramarray);
		
	}
	// 7. Skapa Application som rekursivt ritar ut ett fibonacci-tr�d.*
	
	  
	public static void uppgift7(int x) {
		String space="";
		int iterationer=0;
		for (int i = 0; i < x; i++) {
			space="";
			for (int j = 0; j < x-iterationer; j++) {
				space+=" ";
			}
			iterationer=iterationer+1;
			
			System.out.println(space+"x");
		}
		
		
	}

}
