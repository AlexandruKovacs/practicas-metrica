package calculator;

public class MultiplyCommand implements ICommand {

    private final Calculator calculator;
    private final double value;

    public MultiplyCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute(Calculator calculator) {
        calculator.multiply(value);
    }

    @Override
    public void undo(Calculator calculator) {
        calculator.divide(value);
    }

	public Calculator getCalculator() {
		return calculator;
	}
	
}
