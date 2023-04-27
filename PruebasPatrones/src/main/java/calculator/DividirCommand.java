package calculator;

public class DividirCommand implements Command {
	
    private int valor;
    private Calculator calculator;

    public DividirCommand(int valor, Calculator calculator) {
        this.valor = valor;
        this.calculator = calculator;
    }

    public void execute() {
    	calculator.dividir(valor);
    }

    public void undo() {
    	calculator.multiplicar(valor);
    }
}