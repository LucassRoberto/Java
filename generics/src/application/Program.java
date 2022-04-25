/*Uma empresa de consultoria deseja avaliar a performance de produtos,
funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
o maior dentre um conjunto de elementos. Fazer um programa que leia um
conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
mostre o mais caro deles.
 * 
 * */

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import services.CalculationServices;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();

		String path = "C:\\exe";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();//ler as linhas do arquivo
			while (line != null) {
				String[] fields = line.split(",");//receber o objeto antes do separador vírgula
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));//receberá um string, um double...
				line = br.readLine();
			}
			
			Product x = CalculationServices.max(list);
			System.out.println("Most expensive:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
	}
}