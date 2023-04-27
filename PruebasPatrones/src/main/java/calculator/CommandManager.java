package calculator;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
	
    private static CommandManager instance;
    private final Map<String, ICommand> commands = new HashMap<>();
    private final Calculator calculator;

    public CommandManager() {
        this.calculator = new Calculator();
    }

	public CommandManager getInstance(Calculator calculator) {
    	
        if (instance == null) {
            instance = new CommandManager();
        }
        
        return instance;
    }

    public void registerCommand(String commandName, ICommand command) {
        commands.put(commandName, command);
    }

    public ICommand getCommand(String commandName, double operand) {
        ICommand command = commands.get(commandName);
        
        if (command == null) {
            throw new IllegalArgumentException("Unknown command name: " + commandName);
        }
        
        return commandBuilder(commandName, operand);
    }
    
    public void undoLastCommand() {
    	
    }

    private ICommand commandBuilder(String commandName, double operand) {
    	
        switch (commandName) {
            case "add":
                return new AddCommand(calculator, operand);
                
            case "subtract":
                return new SubstractCommand(calculator, operand);
                
            case "multiply":
                return new MultiplyCommand(calculator, operand);
                
            case "divide":
                return new DivideCommand(calculator, operand);
                
            case "set":
            	return new SetCommand(calculator, operand);
                
            default:
                throw new IllegalArgumentException("Unknown command name: " + commandName);
        }
    }
}
