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
        comando.execute();
        comandosEjecutados.push(comando);
    }
    
    public static Command getCommand(String[] args, Calculator calculator) {
    	
        if (args.length < 2) {
            throw new IllegalArgumentException("Se deben proporcionar al menos dos argumentos: el comando y el valor.");
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

    public void undoCommand() {
        Command ultimoComando = comandosEjecutados.pop();
        ultimoComando.undo();
    }
    
}
