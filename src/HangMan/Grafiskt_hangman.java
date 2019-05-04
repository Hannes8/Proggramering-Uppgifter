package HangMan;

public class Grafiskt_hangman {

	/**
	 * I denna klassen finns allt det grafiska som skivs ut till spelaren
	 * 
	 * tar in antalet fel gissningar som spelaren har och lägger in de i en switch
	 * case som printar ut de grafiska
	 * 
	 * @param tal, antal felgissningar
	 */
	public static void grafiskt(int tal) {

		switch (tal) {

		case 1:

			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			break;
		case 2:
			System.out.println(" _________");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			break;
		case 3:
			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			break;
		case 4:

			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|         0");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			break;
		case 5:
			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|         0");
			System.out.println("|         |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			break;

		case 6:
			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|         0");
			System.out.println("|        /|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			break;

		case 7:
			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|         0");
			System.out.println("|        /|\\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");

			break;
		case 8:

			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|         0");
			System.out.println("|        /|\\");
			System.out.println("|        /");
			System.out.println("|");
			System.out.println("|");
			break;
		case 9:
			System.out.println(" _________");
			System.out.println("|         |");
			System.out.println("|         0");
			System.out.println("|        /|\\");
			System.out.println("|        / \\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("Du förlorade :/");
			break;

		default:

			break;

		}

	}

}
