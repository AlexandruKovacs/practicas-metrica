package calculator;

public class Invoker {

	public static Command getCommand(String[] args, Calculator calculator) {
    	
        if (args.length < 2) {
            throw new IllegalArgumentException("Se debe proporcionar el valor y el comando");
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
