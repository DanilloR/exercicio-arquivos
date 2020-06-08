package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		String arq = "C:\\Users\\danil\\Google Drive\\Cursos Udemy\\Java\\source.csv";
		List<Produto> lista = new ArrayList<Produto>();
		boolean sucesso = false;
		
		try (BufferedReader br = new BufferedReader(new FileReader(arq))){
			
			String linha = br.readLine();
			
			while (linha!=null) {
				
				String [] campos = linha.split(",");
				String nome = campos[0];
				double preco = Double.parseDouble(campos[1]);
				int quantidade = Integer.parseInt(campos[2]);
				
				Produto produto = new Produto(nome,preco,quantidade);
				lista.add(produto);
				
				linha = br.readLine();
				
				sucesso = true;
			}
			
			System.out.println("Lista criada com sucesso a partir do arquivo: "+sucesso);
		
		}	
		catch (IOException e) {
			System.out.println("Erro: "+e.getMessage());
		}
		

}
}