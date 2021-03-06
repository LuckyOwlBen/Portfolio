package com.revature.logging;

public class StringAdder {
	public StringAdder() {
	}

	// "1,2,3,4,5" is the format. Desired length is two, will return the values
	// added together
	public Double add(String s) throws CalculatorException {
		Double sum  = 0.0;
		if (s == null || s.equals("")) {
			return 0.0;
		} else {
			String[] numbers = s.split(",");
			if(numbers.length > 2) {
				throw new CalculatorException("too many values");
			}
			else {
				try {
				sum = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
				}catch(Exception e){
					throw new CalculatorException("invalid input");
				}
			}
		}
		return sum;
	}
}
