/*Fazer um programa para ler os dados (nome, email e salário)
de funcionários a partir de um arquivo em formato .csv.
Em seguida mostrar, em ordem alfabética, o email dos
funcionários cujo salário seja superior a um dado valor
fornecido pelo usuário.
Mostrar também a soma dos salários dos funcionários cujo
nome começa com a letra 'M'.
 * 
 * */

package exerciseApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import exerciseEntities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { //ler o arquivo

			List<Product> list = new ArrayList<>(); //lista a partir do arquivo
			
			String line = br.readLine(); //ler cada linha
			while (line != null) {
				String[] fields = line.split(","); //irá dividir os dados em 2 (String, double)
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			double avg = list.stream() //converter stream
					.map(p -> p.getPrice()) //apenas com os preços do produtos
					.reduce(0.0, (x,y) -> x + y) / list.size(); //reduce permite fazer a somatória com os preços
			
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> names = list.stream()
					.filter(p -> p.getPrice() < avg) //filtrar preço menor que a média
					.map(p -> p.getName()).sorted(comp.reversed()) //sorted: ordena em ordem alfabética e reversed ordena do contrário
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}