import java.util.ArrayList;
import java.util.Scanner;

public class SecureDoors {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
// Arraylist som har reda p� outputen
		ArrayList<String> EmployeeList = new ArrayList<>();
// Arraylist som kollar vilka som �r inne i byggnaden 
		ArrayList<String> EmployeesInsideBuilding = new ArrayList<>();

		System.out.println("Amount of entrys or exits - (1-1000)");
		int amount = 0;
// en loop som avslutas n�r den f�r svar p� antalet input
		while (true) {
			amount = input.nextInt();
			if (amount >= 1 && amount <= 1000) {
				break;
			} else {
				System.out.println("error");
			}

		}

		System.out.println("Input:");
		System.out.println(
				"Input entry, exit and a name with up to 20 letters! Remember uppercase on the first letter in the name!");

		String status = input.nextLine();

		for (int i = 1; i <= amount; i++) {
			status = input.nextLine();

			// kollar s� att inputen startar med exit eller entry och s� att namnet b�rjar
			// med stor bokstav och s� att namnet inte �r l�ngre �n 20 bokst�ver
			if (status.startsWith("entry") && Character.isUpperCase(status.charAt(6)) && status.length() <= 26
					|| status.startsWith("exit") && Character.isUpperCase(status.charAt(5)) && status.length() <= 25) {

				// tar entry stringsen och tar bort entry
				if (status.contains("entry")) {
					status = status.replaceAll("entry ", "");
					// L�gger till personerna som g�r in i byggnaden i en arraylist
					EmployeesInsideBuilding.add(status);
					// l�gger till entered
					status = status + " entered";
					// om personen som g�r in i byggnaden redan finns i arrayen s� l�ggs ANOMALY
					// till
					if (EmployeeList.contains(status)) {
						status = status + " (ANOMALY)";
						EmployeeList.add(status);
					} else {
						EmployeeList.add(status);

					}

					// om stringen inte b�rjar med entry s� g�r den igen else satsen
				} else {
					// tar bort exit
					status = status.replaceAll("exit ", "");
					if (EmployeesInsideBuilding.contains(status)) {
						// tar bort personen fr�n arraylisten n�r de l�mnar byggnaden
						EmployeesInsideBuilding.remove(status);
						status = status + " exited";
						EmployeeList.add(status);
					} else {
						// om EmployeesInsideBuilding arrayen inte inneh�ller status stringen s� skrivs
						// ANOMALY till
						status = status + " exited";
						status = status + " (ANOMALY)";
						EmployeeList.add(status);
					}

				}
			}
			// Om inputen inte n�r vilkoren s� skrivs enter ut och loopen �kar med en till
			// iteration
			else {
				System.out.println("error");
				amount++;
			}

		}
		// skriver ut listan efter loopen �r klar
		for (int i = 0; i < EmployeeList.size(); i++) {
			System.out.println(EmployeeList.get(i));
		}

	}
}
