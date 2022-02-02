package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.00);
		
		//UPCASTING
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.00);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.1);
		
		//DOWNCASTING
		
		//É necessário realizar o casting manual 
		//da classe escolhida para ser aceita pelo compilador
		
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.00);
		
		//Downcasting normal, mas, acc3 foi diagnosticada como SavingsAccount
		//Resumindo o compilador não detecta o acc3 e só vai sar erro se for executada
		
		// ERRO -> BusinessAccount acc5 = (BusinessAccount)acc3;
		
		//Falhou, pois, acc3 não é instancia de BusinessAccount
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.00);
			System.out.println("Loan!");
		}
		
		//FORMA CORRETA!!!
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
	}

}
