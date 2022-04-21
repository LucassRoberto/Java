/*Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usu�rio), os quais
podem ser pessoa f�sica ou pessoa jur�dica, e depois mostrar o valor do imposto pago por cada um,
bem como o total de imposto arrecadado.
Os dados de pessoa f�sica s�o: nome, renda anual e gastos com sa�de. Os dados de pessoa jur�dica
s�o nome, renda anual e n�mero de funcion�rios. As regras para c�lculo de imposto s�o as
seguintes:
Pessoa f�sica: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com sa�de, 50%
destes gastos s�o abatidos no imposto.
Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com sa�de, o imposto
fica: (50000 * 25%) - (2000 * 50%) = 11500.00
Pessoa jur�dica: pessoas jur�dicas pagam 16% de imposto. Por�m, se a empresa possuir mais de 10
funcion�rios, ela paga 14% de imposto.
Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcion�rios, o imposto fica:
400000 * 14% = 56000.00
 * 
 * */

package f_exerciseApplicationContribution;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import f_exerciseEntitiesContribution.Contribuinte;
import f_exerciseEntitiesContribution.PessoaFisica;
import f_exerciseEntitiesContribution.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();

		System.out.print("N�mero de contribuintes: ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Contribuinte #"+ (i + 1)+ ":");
			System.out.print("Pessoa f�sica ou jur�dica (f/j)?");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (tipo == 'f') {
				System.out.print("Gastos com sa�de: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
			else {
				System.out.print("N�mero de funcion�rios: ");
				int numeroFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
			
		}
		
		double totalImposto = 0;
		
		System.out.println();
		System.out.println("Lista de contribuintes com os respectivos valores de impostos: ");
		for (Contribuinte contribuinte: list) {
			System.out.println(contribuinte.getNome() +": $" + String.format("%.2f", contribuinte.imposto()));
		totalImposto +=contribuinte.imposto();
		}
		
		System.out.println();
		System.out.println("Total de imposto arrecadado: " + String.format("%.2f", totalImposto));
		
		sc.close();
	}

}
