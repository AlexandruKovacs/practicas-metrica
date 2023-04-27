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
    
    public static Command getCommand(String[] args, Calculator calculator) {
    	
        if (args.length < 2) {
            throw new IllegalArgumentException("Se debe proporcionar el valor y el comando.");
        }

        int valor = Integer.parseInt(args[0]);
        String comando = args[1];

        switch (comando) {
            case "sumar":
                return new SumarCommand(valor, calculator);
                
            case "restar":
                return new RestarCommand(valor, calculator);
                
            case "multiplicar":
                return new MultiplicarCommand(valor, calculator);
                
            case "dividir":
                return new DividirCommand(valor, calculator);
                
            case "set":
                return new SetCommand(valor, calculator);
                
            default:
                throw new IllegalArgumentException("Comando no reconocido: " + comando);
        }
    }
    
}
