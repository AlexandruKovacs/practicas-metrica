package calculator;

public interface ICommand {

	abstract void execute(Calculator calculator);
	abstract void undo(Calculator calculator);
	
}
