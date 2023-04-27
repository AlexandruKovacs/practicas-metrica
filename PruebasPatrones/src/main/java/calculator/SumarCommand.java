package calculator;

public class SumarCommand implements Command {
	
    private int valor;
    private Calculator calculator;

    public SumarCommand(int valor, Calculator calculator) {
        this.valor = valor;
        this.calculator = calculator;
    }

    public void execute() {
    	calculator.sumar(valor);
    }

    public void undo() {
    	calculator.restar(valor);
    }
}
