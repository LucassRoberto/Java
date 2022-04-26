/*Um site de internet registra um log de acessos dos usu�rios. Um
registro de log consiste no nome de usu�rio (apenas uma palavra) e o
instante em que o usu�rio acessou o site no padr�o ISO 8601,
separados por espa�o, conforme exemplo. Fazer um programa que leia
o log de acessos a partir de um arquivo, e da� informe quantos usu�rios
distintos acessaram o site.
 * 
 * */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();  //ir� ler o caminho completo do arquivo
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { //ir� abrir e ler o arquivo

			Set<LogEntry> set = new HashSet<>();
			
			String line = br.readLine(); //ler a primeira linha
			while (line != null) { //enquanto a linha for diferente de nulo...
			
				String[] fields = line.split(" "); //recortar a string baseado em um espa�o em branco
				String username = fields[0]; //receber� fields na posi��o 0
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment));
				//inserindo os dados no set. Os nomes repetidos ser�o barrados pelo pr�prio set
				
				line = br.readLine(); //ler a pr�xima linha 
			}	
			System.out.println("Total users: " + set.size()); // informa o tamanho do conjunto

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}