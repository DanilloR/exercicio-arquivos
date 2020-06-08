package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Informe o caminho do arquivo de entrada: ");
		String entrada = sc.nextLine();
		
		//cria uma variável do tipo File que recebe o caminho do arquivo
		File arquivo = new File (entrada);
		//método da classe File que pega apenas o caminho da pasta, sem o arquivo
		String geraPasta = arquivo.getParent();
		//cria uma novaa subpasta
		boolean criaPasta = new File (geraPasta+"\\out").mkdir();
		//dentro da subpasta, cria um novo arquivo
		String arquivoSaidaStr = geraPasta+"\\out\\summary.csv";
		
		List<Produto> lista = new ArrayList<Produto>();
		boolean sucessoLeitura = false;
		boolean sucessoGravacao = false;
		
		try (BufferedReader br = new BufferedReader(new FileReader(entrada))){
			
			String linha = br.readLine();
			
			while (linha!=null) {
				
				String [] campos = linha.split(",");
				String nome = campos[0];
				double preco = Double.parseDouble(campos[1]);
				int quantidade = Integer.parseInt(campos[2]);
				
				Produto produto = new Produto(nome,preco,quantidade);
				lista.add(produto);
				
				linha = br.readLine();
				sucessoLeitura = true;
			}
			
			System.out.println("Lista criada com sucesso a partir do arquivo: "+sucessoLeitura);
		
		}	
		catch (IOException e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaidaStr))) {
						
			for (Produto list : lista) {
				bw.write(list.toString());
				bw.newLine();
			}
			
			sucessoGravacao = true;
			System.out.println("Arquivo de saida gerado com sucesso: "+sucessoGravacao);
			
		}
		catch (IOException e) {
			System.out.println("Erro: "+e.getMessage());
		}
		

		sc.close();
}
}