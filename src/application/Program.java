package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		String arq = "C:\\Users\\danil\\Google Drive\\Cursos Udemy\\Java\\source.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(arq))){
			
			String linha = br.readLine();
			while (linha!=null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Erro: "+e.getMessage());
		}

	}

}
