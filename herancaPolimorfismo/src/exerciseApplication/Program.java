/*Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final,
mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.
Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e
produtos usados possuem data de fabricação. Estes dados específicos devem ser
acrescentados na etiqueta de preço conforme exemplo (próxima página). Para produtos
importados, a taxa e alfândega deve ser acrescentada ao preço final do produto.
Favor implementar o programa conforme projeto ao lado.
 * 
 * */

package exerciseApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exerciseEntities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList();

		System.out.print("Enter the number of products: ");
		int numberOfProducts = sc.nextInt();
		
		for (int i=0; i<numberOfProducts; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			if (type == 'c') {
				list.add(new Product(name, price))
			}
			if(type == 'u') {
				
			}
		}
		
		
		sc.close();
	}

}
