package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Program {

	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// Exemplo de UPCASTING: objeto acc1 recebe bacc. 
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingAccount(1004, "Anna", 0.0, 0.01);
		
		// Exemplo de DOWNCASTING:
		
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.0);
		
		// BusinessAccount acc5 = (BusinessAccount)acc3;
		//instanceof verifica se um objeto pode receber m?todos de outro
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if (acc3 instanceof SavingAccount) {
			SavingAccount acc5 = (SavingAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		Account ac = new Account(1002, "Maria", 1000.0);
		ac.withdraw(200.00);
		System.out.println(ac.getBalance());
		
		//testando m?todo override de savingAccount
		Account ac1 = new SavingAccount(1002, "Jo?o", 1000.0, 0.01);
		ac1.withdraw(200);
		System.out.println(ac1.getBalance());
		
		//utilizando super
		Account ac2 = new BusinessAccount(1002, "Juca", 1000.0, 500.0);
		ac2.withdraw(200);
		System.out.println(ac2.getBalance());
	}


}
