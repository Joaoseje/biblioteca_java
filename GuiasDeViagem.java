
public class GuiasDeViagem extends Livro{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String local;

	public GuiasDeViagem(String nome, String autor, int ano, String local) {
		super(nome, autor, ano);
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public String toString() {
		String retorno = super.toString();
		retorno += "Local: "   + this.local + "\n";
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
