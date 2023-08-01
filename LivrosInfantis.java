
public class LivrosInfantis extends Livro{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brinde;
    // Idade mínima do livro caso for Livre é 0 a idade
	public LivrosInfantis(String nome, String autor, int ano, String brinde) {
		super(nome, autor, ano);
		this.brinde = brinde;
	}

	public String getBrinde() {
		return brinde;
	}

	public void setIdade(String brinde) {
		this.brinde = brinde;
	}
	
	public String toString() {
		String retorno = super.toString();
		retorno += "Brinde: "   + this.brinde + "\n";
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
