import java.util.ArrayList;
import java.util.Scanner;

public class SecureDoors {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ArrayList <String> EmployeeList = new ArrayList<>();
		
		System.out.println("Amount of entrys or exits - (1-1000)");
		int amount=0;
		
		while(true) {
			amount=input.nextInt();
			if (amount>=1 && amount<=1000) {
				break;
			}
			else {
				System.out.println("error");
			}
			
		}
		
		System.out.println("Input:");
		
		String status=input.nextLine();
		
		for (int i = 1; i <=amount; i++) {
		status=input.nextLine();
		
		// behöver göra så att den bara kollar de första 5 index
		if(status.contains("entry") || status.contains("exit")) {
			
			if(EmployeeList.contains(status)) {
			status= status + "ANOMALY";
		
		}
			
		if(status.contains("entry")){
			status = status.replaceAll("entry ", "");
			status = status + " entered";
			EmployeeList.add(status);
		}
		else {
			status= status.replaceAll("exit ", "");
			status= status + " exited";
			EmployeeList.add(status);
			
			
		}
			
		
		
		}
		else {
			System.out.println("error");
			amount++;
		}
		
		}
		
			System.out.println(EmployeeList);
			
	}
}
