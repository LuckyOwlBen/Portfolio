import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean test;
		int m;
		int n;
		int d;
		int[] numbers;
		String[] funnyNoises;
		
		Scanner sc = new Scanner(System.in);
		FizzBuzz fb = new FizzBuzz();
		//fb.fizzBuzzBasic();
		
		do {
			
		
			System.out.println("Enter starting point");
			while(!sc.hasNextInt()) {
				System.out.println("Not an integer try again");
				sc.next();
			}
			m = sc.nextInt();
			
			System.out.println("Enter finish point");
			while(!sc.hasNextInt()) {
				System.out.println("Not an integer try again");
				sc.next();
			}
			n = sc.nextInt();
			
			System.out.println("How many items are being used as divisors");
			while(!sc.hasNextInt()) {
				System.out.println("Not an integer try again");
				sc.next();
			}
			d = sc.nextInt();
			
			numbers = new int[d];
			funnyNoises = new String[d];
			
			System.out.println("Enter noise trigger numbers");
			for(int i = 0; i < d; i++) {
				System.out.println("Enter a number");
				while(!sc.hasNextInt()) {
					System.out.println("Not an integer try again");
					sc.next();
				}
				numbers[i] = sc.nextInt(); 
			}
			
			System.out.println("Enter terms for the strings");
			for(int j = 0; j < d; j++) {
				System.out.println("Enter a funny noise");
				while(sc.hasNextInt()) {
					System.out.println("Not a funny noise try again");
					sc.next();
				}
				funnyNoises[j] = sc.next();
			}
			
			test = fb.fizzBuzzAdvanced(m, n, numbers, funnyNoises);
			
		}
		while(test == false);
		
		sc.close();
	}

}
