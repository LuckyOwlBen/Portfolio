
public class FizzBuzz {
	
	boolean isFunnyNoise = false;
	
	public void fizzBuzzBasic() {
		for(int i = 0; i <= 100; i++) {
			
			if(i%3 == 0 & i%5 == 0) {
				System.out.println("Fizzbuzz");
			}
			else if(i%3 == 0) {
				System.out.println("Fizz");
			}
			else if(i%5 == 0) {
				System.out.println("Buzz");
			}
			else
				System.out.println(i);
		}
		
	}
	public boolean fizzBuzzAdvanced(int m, int n, int[] numbers, String[] terms) {
		if(m > n) {
			System.out.println("The maximum was greater than the minimum try again");
			return false;
		}
		for(int i = m; i <= n; i++) {
			for(int j = 0; j < numbers.length; j++) {
				if(i % numbers[j] == 0) { 
					System.out.println(terms[j]);
					isFunnyNoise = true;
				}	
			}
			if(isFunnyNoise == true) {
				isFunnyNoise = false;
			}
			else{
				System.out.println(i);
			}
		}
		return true;
	}
}

