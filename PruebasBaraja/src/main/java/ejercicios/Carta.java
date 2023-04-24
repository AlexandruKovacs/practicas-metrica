package ejercicios;

public class Carta {
	
    private final String palo;
    private final String numero;
    
    public Carta(String palo, String numero) {
        this.palo = palo;
        this.numero = numero;
    }
    
    public String getPalo() {
        return palo;
    }
    
    public String getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        return numero + " de " + palo;
    }

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
