import java.io.Serializable;

public abstract class Livro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String autor;
	private int ano;
	
	public Livro(String nome, String autor, int ano) {
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
	}
	
	public String toString() {
		String retorno = "";
		retorno += "Nome: "    + this.nome + "\n";
		retorno += "Autor: "     + this.autor  + "\n";
		retorno += "Ano de lançamento: "       + this.ano    + "\n";
		return retorno;
	}
	
	public abstract boolean enviarParaClassicos();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	

}
