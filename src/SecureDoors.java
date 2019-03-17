import java.util.ArrayList;
import java.util.Scanner;

public class SecureDoors {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ArrayList<String> EmployeeList = new ArrayList<>();

		ArrayList<String> EmployeesInsideBuilding = new ArrayList<>();

		System.out.println("Amount of entrys or exits - (1-1000)");
		int amount = 0;

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
					|| (status.startsWith("exit")) && Character.isUpperCase(status.charAt(5))) {

				if (status.contains("entry")) {
					status = status.replaceAll("entry ", "");
					EmployeesInsideBuilding.add(status);
					status = status + " entered";
					if (EmployeeList.contains(status)) {
						status = status + " (ANOMALY)";
						EmployeeList.add(status);
					} else {
						EmployeeList.add(status);

					}

				} else {
					status = status.replaceAll("exit ", "");
					if (EmployeesInsideBuilding.contains(status)) {
						EmployeesInsideBuilding.remove(status);
						status = status + " exited";
						EmployeeList.add(status);
					} else {
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
