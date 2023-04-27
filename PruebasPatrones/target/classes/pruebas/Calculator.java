package calculator;

public class Calculator {

    private double accumulator = 0.0;

	public void setAccumulator(double accumulator) {
		this.accumulator = accumulator;
	}

	public void add(double value) {
		accumulator += value;
	}

	public void substract(double value) {
		accumulator -= value;
	}

	public void multiply(double value) {
		accumulator *= value;
	}

	public void divide(double value) {
		
		if(value == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		
		accumulator /= value;
	}
	
	public void set(double value) {
		accumulator = value;
	}
	
	public double getAccumulator() {
		return accumulator;
	}
    
}