
public class ArrayerUppgift {

	public static void main(String[] args) {
			
	
	
	int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};
	
	
	String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};
		
	System.out.println(antalnumber(numbers));
	System.out.println(antaltom(names));
	System.out.println(hello(numbers));
	System.out.println(index(names));
	System.out.println(jämnatal(numbers));
	System.out.println(antall(names));
	System.out.println(namn5(names));
	System.out.println(antalsiffror(numbers));
	System.out.println(unikanamn(names));
	System.out.println(flestantalnamn(names));
	
	}
	
	
	// antal number 7 i arrayen "numbers"
	public static int antalnumber(int []number ) {
		int antal=0;
		
		for (int i = 0; i < number.length; i++) {
			
			if (number[i]==7) {
				
				antal++;
				
			}	
		}
		
		return antal;
	}
	
	
	// antalet tom i arrayen names
	public static int antaltom(String[] name) {
		int antal=0;
		for (int i = 0; i < name.length; i++) {
			
			
			if (name[i] == "Tom") {
				
				antal++;
			}
			
		}
		
		return antal;
	}
	
	// minst,flest förekommande siffror
	public static String hello(int[]numbers) {
		int antal = 0;
		int x=0;
		int y=100;
		int z=0;
		int a=0;
		int [] number = {0,1,2,3,4,5,6,7,8,9};
		
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if(numbers[j] == number[i]) {
					antal++;	
				}
			}
			if(antal>x) {
				x=antal;
				z=number[i];
			}
			if(antal<y) {
				y=antal;
				a=number[i];
			
			}
			antal=0;
			}
		return "minst: "+a+" flest: "+z;
		
		
		}
	
	// på vilken plats namnen Drusilla förekommer i arrayen names 
	public static int index(String[] names) {
		int index=0;
		for (int i = 0; i < names.length; i++) {
			index++;
			if(names[i]=="Drusilla") {
				break;
			}
			
		}
		
		return index;
	}
	
	// summan av alla jämna tal
	public static int jämnatal(int [] numbers) {
		int summa=0;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] %2 == 0) {
				summa = numbers[i]+summa;
			}
			
		}
		
		return summa;
	}
	// hur många namn som börjar med bokstaven L
	public static int antall(String [] names) {
		int antal=0;
		for (int i = 0; i < names.length; i++) {
			if(names[i].charAt(0) =='L') {
				antal++;
			}
			
		}
		return antal;
	}
// antal namn som är 5 bokstäver långa 
		public static int namn5(String [] names) {
			int antal=0;
			for (int i = 0; i < names.length; i++) {
				
				if(names[i].length()==5) {
					antal++;
				}	
			}
			return antal;
		}
		// hur många av varje siffra finns det i arrayen numbers
		public static String antalsiffror(int [] numbers) {
			String output="";
			int [] siffror = new int [10];
			for (int i = 0; i < siffror.length; i++) {
				for (int j = 0; j < numbers.length; j++) {
					if(numbers[j]==i) {
						siffror[i]++;
					}
					
				}
				output=output+"antal " +i+":or "+siffror[i]+"  ";
			}
			return output;
		}
		// hur många unika namn finns det
	public static int unikanamn(String[] names) {
		int antal=0;
		int j;
		for (int i = 0; i < names.length; i++) {
			
			for ( j = 0; j < names.length; j++) {
				
				
				if(names[i].equals(names[j])) {
					
					break;
				}
				
			}
			if(i==j) {
				
				antal++;
			}
		}
		return antal;
	}
	// flest antal av ett namn
	public static String flestantalnamn(String[]names) {
		String z="";
		int antal=0;
		int x=0;
		for (int i = 0; i < names.length; i++) {
			
			for (int j = 0; j < names.length; j++) {
				
				if(names[i]==names[j]) {
					
					antal++;
				}
				
				if(antal>x) {
					x=antal;
					z=names[i];
				}
				
			}
			antal=0;
		}
		return z;
		
	}
	
	
	
	
}

