package calculator;

public class Calculator {
	
    private int valor;

    public Calculator(int valor) {
        this.valor = valor;
    }

    public void sumar(int valor) {
        this.valor += valor;
    }

    public void restar(int valor) {
        this.valor -= valor;
    }

    public void multiplicar(int valor) {
    	
    	try {
    		this.valor = Math.multiplyExact(this.valor, valor);
    	} catch (ArithmeticException e) {
    		throw new NumberFormatException("Overflow!");
    	}
    }

    public void dividir(int valor) {
    	
        if (valor == 0) {
            throw new ArithmeticException("División por cero");
        }
        
        this.valor /= valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
    
}