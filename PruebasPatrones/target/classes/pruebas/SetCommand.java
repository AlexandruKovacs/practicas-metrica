package calculator;

public class SetCommand implements ICommand {

	private final Calculator calculator;
	private final double value;
	
	public SetCommand(Calculator calculator, double value) {
		this.calculator = calculator;
		this.value = value;
	}
	
	public Calculator getCalculator() {
		return calculator;
	}

	@Override
	public void execute(Calculator calculator) {
		calculator.set(value);
	}

	@Override
	public void undo(Calculator calculator) {
		calculator.set(0);
	}

}
