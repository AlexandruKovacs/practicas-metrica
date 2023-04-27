package calculator;

public class MultiplicarCommand implements Command {
	
    private int valor;
    private Calculator calculator;

    public MultiplicarCommand(int valor, Calculator calculator) {
        this.valor = valor;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
    	calculator.multiplicar(valor);
    }

    @Override
    public void undo() {
    	calculator.dividir(valor);
    }
    
}