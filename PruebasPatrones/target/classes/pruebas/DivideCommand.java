package calculator;

public class DivideCommand implements ICommand {

    private final Calculator calculator;
    private final double value;

    public DivideCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute(Calculator calculator) {
        calculator.divide(value);
    }

    @Override
    public void undo(Calculator calculator) {
        calculator.multiply(value);
    }

	public Calculator getCalculator() {
		return calculator;
	}
	
}
	
