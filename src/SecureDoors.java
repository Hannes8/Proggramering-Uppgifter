import java.util.ArrayList;
import java.util.Scanner;

public class SecureDoors {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
// En list som
		ArrayList<String> EmployeeList = new ArrayList<>();
// En lista som kollar vilka som är inuti byggnaden 
		ArrayList<String> EmployeesInsideBuilding = new ArrayList<>();

		System.out.println("Amount of entrys or exits - (1-1000)");
		int amount = 0;
// en loop som avslutas när den får svar på antalet input
		while (true) {
			amount = input.nextInt();
			if (amount >= 1 && amount <= 1000) {
				break;
			} else {
				System.out.println("error");
			}

		}

		System.out.println("Input:");

		String status = input.nextLine();

		for (int i = 1; i <= amount; i++) {
			status = input.nextLine();

			// kollar så att inputen startar med exit eller entry och så att namnet börjar
			// med stor bokstav
			if (status.startsWith("entry") && Character.isUpperCase(status.charAt(6))
					|| (status.startsWith("exit")) && Character.isUpperCase(status.charAt(5)))  {

				// tar entry stringsen och tar bort entry
				if (status.contains("entry")) {
					status = status.replaceAll("entry ", "");
					// har en arraylist som kollar vilka personer som är inuti byggnaden
					EmployeesInsideBuilding.add(status);
					// lägger till entered
					status = status + " entered";
					// om personen som går in i byggnaden redan finns i arrayen så läggs ANOMALY
					// till
					if (EmployeeList.contains(status)) {
						status = status + " (ANOMALY)";
						EmployeeList.add(status);
					} else {
						EmployeeList.add(status);

					}

					// om stringen inte börjar med entry så går den igen else satsen
				} else {
					// tar bort exit
					status = status.replaceAll("exit ", "");
					if (EmployeesInsideBuilding.contains(status)) {
						EmployeesInsideBuilding.remove(status);
						status = status + " exited";
						EmployeeList.add(status);
					} else {
						// om EmployeesInsideBuilding arrayen inte innehåller status stringen så skrivs
						// ANOMALY till
						status = status + " exited";
						status = status + " (ANOMALY)";
						EmployeeList.add(status);
					}

				}
			} else {
				System.out.println("error");
				amount++;
			}

		}

		for (int i = 0; i < EmployeeList.size(); i++) {
			System.out.println(EmployeeList.get(i));
		}

	}
}
