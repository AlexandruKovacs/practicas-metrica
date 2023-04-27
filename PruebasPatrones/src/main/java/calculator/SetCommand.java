package calculator;

public class SetCommand implements Command {

    private int valor;
    private int valorAnterior;
    private Calculator calculator;

    public SetCommand(int valor, Calculator calculator) {
        this.valor = valor;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
    	valorAnterior = calculator.getValor();
        calculator.setValor(valor);
    }

    @Override
    public void undo() {
    	calculator.setValor(valorAnterior);
    }

}
