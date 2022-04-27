/*Fazer um programa que, a partir de uma lista de produtos, gere uma
nova lista contendo os nomes dos produtos em caixa alta * 
 * */

package functionApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//tipo product para tipo string. Usando lambda declarada
		Function <Product, String> func = p -> p.getName().toUpperCase();

		//é necessário converter a list para um tipo stream (sequência de dados), e dps do tipo stream para lista novamente 
		//map só funciona para stream, por isso a conversão
		List <String> names = list.stream().map(func).collect(Collectors.toList());
		
		//usando lambda inline
		List <String> name = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		names.forEach(System.out::println);
		name.forEach(System.out::println);
	}

}
