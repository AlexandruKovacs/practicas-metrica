package calculator;

public class SumarCommand implements Command {
	
    private int valor;
    private Calculator calculator;

    public SumarCommand(int valor, Calculator calculator) {
        this.valor = valor;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
    	calculator.sumar(valor);
    }

    @Override
    public void undo() {
    	calculator.restar(valor);
    }
    
}