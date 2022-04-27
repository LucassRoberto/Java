/*Fazer um programa que, a partir de uma lista de produtos, aumente o
preço dos produtos em 10%.
 * */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		double factor = 1.1;
		
		//expressão lambda declarada
		Consumer <Product> cons = p -> p.setPrice(p.getPrice() * 1.1);
		list.forEach(cons);
		
		//expressão lambda inline
		list.forEach(p -> p.setPrice(p.getPrice() * factor));

		list.forEach(System.out::println);
	}
}