package calculator;

public class AddCommand implements ICommand {

    private final Calculator calculator;
    private final double value;

    public AddCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute(Calculator calculator) {
        calculator.add(value);
    }

    @Override
    public void undo(Calculator calculator) {
        calculator.substract(value);
    }

	public Calculator getCalculator() {
		return calculator;
	}
	
}
