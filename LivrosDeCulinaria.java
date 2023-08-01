
public class LivrosDeCulinaria extends Livro{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// regional, internacional, doces, carnes...
	private String tipo;

	public LivrosDeCulinaria(String nome, String autor, int ano, String tipo) {
		super(nome, autor, ano);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		String retorno = super.toString();
		retorno += "Tipo de culinária: "   + this.tipo + "\n";
		if(this.enviarParaClassicos()) {
			retorno += "Enviar para clássicos" + "\n";
			return retorno;
		}
		else {
			return retorno;
		}
		
	}

	@Override
	public boolean enviarParaClassicos() {
		if(this.getAno() < 2000) {
			return true;
		}
		else {
			return false;
		}
	}

}
