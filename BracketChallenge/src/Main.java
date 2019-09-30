import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//String string;
		//boolean parseTest = false;
		int iteration;
		String[] bracketArray;

		System.out.println("Enter the number of times the bracket method shoud run");
		
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input try again");
			sc.next();
		}
		
		iteration = sc.nextInt();
		bracketArray = new String[iteration];
		
		for(int i = 0; i < iteration; i++) {
			
			String temp;
			System.out.println("Enter bracket string: "+i +"");
			temp = sc.next();
			/*while(!temp.contains("{") |temp.contains("}") | temp.contains("(") | temp.contains(")") | temp.contains("[") | temp.contains("]")) {
				System.out.println("invalid input try again");
				temp = sc.next();
			}*/
			
			bracketArray[i] = temp;			
		}
		sc.close();
		
		for(int j = 0; j < iteration; j++) {
			boolean test;
			test = BracketMethods.oppRecursion(bracketArray[j]);
			System.out.println(test);
		}

	}

}
