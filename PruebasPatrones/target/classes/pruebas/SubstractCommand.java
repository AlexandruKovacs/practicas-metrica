package calculator;

public class SubstractCommand implements ICommand {

    private final Calculator calculator;
    private final double value;

    public SubstractCommand(Calculator calculator, double value) {
        this.calculator = calculator;
        this.value = value;
    }

    @Override
    public void execute(Calculator calculator) {
        calculator.substract(value);
    }

    @Override
    public void undo(Calculator calculator) {
        calculator.add(value);
    }

	public Calculator getCalculator() {
		return calculator;
	}
	
}
