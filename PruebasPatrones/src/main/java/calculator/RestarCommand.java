package calculator;

public class RestarCommand implements Command {
	
    private int valor;
    private Calculator calculator;

    public RestarCommand(int valor, Calculator calculator) {
        this.valor = valor;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
    	calculator.restar(valor);
    }

    @Override
    public void undo() {
    	calculator.sumar(valor);
    }
    
}