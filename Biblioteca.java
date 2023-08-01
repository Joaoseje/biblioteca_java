import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Biblioteca {
	
	private ArrayList<Livro> livro;

	public Biblioteca() {
		this.livro = new ArrayList<Livro>();
	}
	public String[] leValores(String[] dadosIn) {
	    String[] dadosOut = new String[dadosIn.length];

	    for (int i = 0; i < dadosIn.length; i++) {
	        dadosOut[i] = JOptionPane.showInputDialog(null, "Entre com " + dadosIn[i] + ": ");
	    }

	    return dadosOut;
	}

	
	public String retornaString(String entrada) {
	    return entrada;
	}


	public LivrosInfantis leLivrosInfantis (){

		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Autor", "Ano de lançamento", "Brinde"};
		valores = leValores (nomeVal);
		
		int ano = this.retornaInteiro(valores[2]);
		
		
		LivrosInfantis livrosInfantis = new LivrosInfantis (valores[0], valores[1], ano, valores[3] );
		return livrosInfantis;
	}

	public LivrosDeCulinaria leLivrosDeCulinaria() {
	    String[] valores = new String[4];
	    String[] nomeVal = {"Nome", "Autor", "Ano de lançamento", "Tipo de culinária"};
	    valores = leValores(nomeVal);

	    int ano = this.retornaInteiro(valores[2]);

	    LivrosDeCulinaria livrosDeCulinaria = new LivrosDeCulinaria(valores[0], valores[1], ano, valores[3]);
	    return livrosDeCulinaria;
	}

	public GuiasDeViagem leGuiasDeViagem() {
	    String[] valores = new String[4];
	    String[] nomeVal = {"Nome", "Autor", "Ano de lançamento", "Local"};
	    valores = leValores(nomeVal);

	    int ano = this.retornaInteiro(valores[2]);

	    GuiasDeViagem guiasDeViagem = new GuiasDeViagem(valores[0], valores[1], ano, valores[3]);
	    return guiasDeViagem;
	}

	
	


	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		//Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Ano de lançamento incorreto!\n\nDigite um número inteiro para esta opção.");
		}
		return Integer.parseInt(entrada);
	}

	 public void salvaLivros(ArrayList<Livro> livro) {
	        String caminhoArquivo = System.getProperty("user.dir") + File.separator + "biblioteca.dados";
	        ObjectOutputStream outputStream = null;

	        try {
	            outputStream = new ObjectOutputStream(new FileOutputStream(caminhoArquivo));

	            for (int i = 0; i < livro.size(); i++) {
	                outputStream.writeObject(livro.get(i));
	            }
	        } catch (FileNotFoundException ex) {
	            JOptionPane.showMessageDialog(null, "Impossível criar arquivo!");
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (outputStream != null) {
	                    outputStream.flush();
	                    outputStream.close();
	                }
	            } catch (IOException ex) {
	            	ex.printStackTrace();
	            	}
	            }
	                
	 
	        }
	public ArrayList<Livro> recuperaLivros() {
	    ArrayList<Livro> livrosTemp = new ArrayList<Livro>();
	    String caminhoArquivo = System.getProperty("user.dir") + File.separator + "biblioteca.dados";
	    ObjectInputStream inputStream = null;

	    try {
	        inputStream = new ObjectInputStream(new FileInputStream(caminhoArquivo));
	        Object obj;

	        while ((obj = inputStream.readObject()) != null) {
	            if (obj instanceof Livro) {
	                livrosTemp.add((Livro) obj);
	            }
	        }
	    } catch (EOFException ex) {
	        System.out.println("Fim de arquivo.");
	    } catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	    } catch (FileNotFoundException ex) {
	        JOptionPane.showMessageDialog(null, "Arquivo com livros não existe!");
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return livrosTemp;
	}


	public void menuBiblioteca (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Biblioteca\n" +
					"Opções:\n" + 
					"1. Entrar Livros\n" +
					"2. Exibir Livros\n" +
					"3. Limpar Livros\n" +
					"4. Gravar Livros\n" +
					"5. Recuperar Livros\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Animais Mam�feros\n" +
						"Opções:\n" + 
						"1. Infantil\n" +
						"2. Culinária\n" +
						"3. Gia de viagem\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: livro.add((Livro)leLivrosInfantis());
				break;
				case 2: livro.add((Livro)leLivrosDeCulinaria());
				break;
				case 3: livro.add((Livro)leGuiasDeViagem());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Livro para entrada NãO escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (livro.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com livros primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < livro.size(); i++)	{
					dados += livro.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (livro.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com livros primeiramente");
					break;
				}
				livro.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (livro.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com livros primeiramente");
					break;
				}
				salvaLivros(livro);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				livro = recuperaLivros();
				if (livro.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo Biblioteca");
				break;
			}
		} while (opc1 != 9);
	}

	
	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca ();
		biblioteca.menuBiblioteca();
		
	}

}
