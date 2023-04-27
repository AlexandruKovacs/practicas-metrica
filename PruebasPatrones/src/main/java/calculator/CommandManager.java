package calculator;

import java.util.Stack;

public class CommandManager {

    private Stack<Command> comandosEjecutados;
    private Calculator calculator;

	public CommandManager(Calculator calculator) {
        this.calculator = calculator;
        comandosEjecutados = new Stack<Command>();
    }
    
    public void registCommand(Command comando) {
        comandosEjecutados.push(comando);
        comando.execute();
    }
    
    public void undoCommand(Command commando) {
        comandosEjecutados.pop();
        commando.undo();
    }
    
}
