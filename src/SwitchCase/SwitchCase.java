package SwitchCase;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean run = true;
		// Deklarerar en list som har reda på allt som köps
		String list = "You bought";
		int choice = 0;
		while (run) {
			System.out.println("Welcome to the ultimate snacks shop, Please enter the kind of product you want!");
			System.out.println("(1) - Soft drinks");
			System.out.println("(2) - Chips");
			System.out.println("(3) - Energy drinks");
			System.out.println("(4) - Candy");
			System.out.println("(5) - Check out");
			System.out.println();
			
			choice = input.nextInt();
			
		switch(choice) {
			case 1:
				System.out.println("Welcome to the soft drinks section!");
				System.out.println();
				System.out.println("What kind of drink do you want?");
				System.out.println("(1) - Fanta");
				System.out.println("(2) - Coca Cola");
				System.out.println("(3) - Sprite");
				System.out.println("(4) - Pepsi Max");
				System.out.println("(5) - Go Back");
				
				choice = input.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("The product fanta was added to your cart!");
					list +=" Fanta,";
					
					break;
				case 2:
					System.out.println("The product Coca cola was added to your cart!");

					list +=" Coca cola,";
					break;
				case 3:
					System.out.println("The product sprite was added to your cart!");

					list +=" Sprite,";
				case 4:
					System.out.println("The product pepsi max was added to your cart!");

					list +=" pepsi max,";
					break;
				case 5:
					System.out.println("going back");
					break;
				default:
					System.out.println("Invalid input");
					run = false;
					break;
				}
				break;
				
			case 2:
				System.out.println("Welcome to the chips section!");
				System.out.println();
				System.out.println("What kind of chips do you want?");
				System.out.println("(1) - Pringles");
				System.out.println("(2) - Estrella");
				System.out.println("(3) - OLW");
				System.out.println("(4) - Doritos");
				System.out.println("(5) - Go Back");
				
				choice=input.nextInt();
				
				switch (choice) {
				case 1:
					System.out.println("The product Pringles was added to your cart!");
					list +=" Pringles,";
					
					break;
				case 2:
					System.out.println("The product Estrella was added to your cart!");

					list +=" Estrella,";
					break;
				case 3:
					System.out.println("The product OLW was added to your cart!");

					list +=" OLW,";
				case 4:
					System.out.println("The product Doritos was added to your cart!");

					list +=" Doritos,";
					break;
				case 5:
					System.out.println("going back");
					break;
				default:
					System.out.println("Invalid input");
					run = false;
					break;
				}

				break;
				
			case 3:
				System.out.println("Welcome to the energy drink section!");
				System.out.println();
				System.out.println("(1) - Redbull");
				System.out.println("(2) - Monster");
				System.out.println("(3) - Nocco");
				System.out.println("(4) - Power raid");
				System.out.println("(5) - Go Back");
				choice=input.nextInt();
				switch (choice) {
				case 1:
					System.out.println("The product Redbull was added to your cart!");
					list +=" Redbull,";
					
					break;
				case 2:
					System.out.println("The product Monster was added to your cart!");

					list +=" Monster,";
					break;
				case 3:
					System.out.println("The product Nocco was added to your cart!");

					list +=" OLW,";
				case 4:
					System.out.println("The product Power raid was added to your cart!");

					list +=" Doritos,";
					break;
				case 5:
					System.out.println("going back");
					break;
				default:
					System.out.println("Invalid input");
					run = false;
					break;
				}
				break;
				
			case 4:
				System.out.println("Welcome to the candy section!");
				System.out.println();
				System.out.println("(1) - Bilar");
				System.out.println("(2) - Nappar");
				System.out.println("(3) - Daim");
				System.out.println("(4) - Pingvinstång");
				System.out.println("(5) - Go Back");
				choice=input.nextInt();

				switch (choice) {
				case 1:
					System.out.println("The product Bilar was added to your cart!");
					list +=" Bilar,";
					
					break;
				case 2:
					System.out.println("The product Nappar was added to your cart!");

					list +=" Nappar,";
					break;
				case 3:
					System.out.println("The product Daim was added to your cart!");

					list +=" Daim,";
				case 4:
					System.out.println("The product Pingvinstång was added to your cart!");

					list +=" Pingvinstång,";
					break;
				case 5:
					System.out.println("going back");
					break;
				default:
					System.out.println("Invalid input");
					run = false;
					break;
				}
				break;
				
			case 5:
				if(list.length()>13) {
				list= list+ " for a total of 10$";
				System.out.println(list);
				}
				System.out.println("Thank you for shoping at the ultimate snack shop!");
				run = false;
				
				break;
				
			default:
				System.out.println("Invalid input");
				run = false;
				break;
			
			}
		System.out.println();
		}
	}
}