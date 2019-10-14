package test;

import app.App;
import model.Account;
import model.Customer;

import java.util.Arrays;
import java.util.List;

public class Test {
	
	private static int index=1;

	public static void main(String Args[]) {
		Test test = new Test();
		test.formData();
		test.process();
		System.out.println(test.set_Account_Without_Amount());
		System.out.println(!test.send_Zero_Amount());
		System.out.println(!test.send_More_Than_Balance());
		App.getAccountList().forEach(System.out::println);
	}

	private void formData() {
		Customer customer1 = new Customer(index, "Vali", "Jafarov");
		App.getCustomerList().add(customer1);
		Customer customer2 = new Customer(2, "Michael", "Adams");
		App.getCustomerList().add(customer2);
		Customer customer3 = new Customer(3, "Jonathan", "Swift");
		App.getCustomerList().add(customer3);

		Account account1 = new Account(index++, 1000);
		App.getAccountList().add(account1);
		customer1.getAccountList().add(account1);

		Account account2= new Account(index++, 2000);
		App.getAccountList().add(account2);
		customer2.getAccountList().add(account2);

		Account account3 = new Account(index++, 135000);
		App.getAccountList().add(account3);
		customer2.getAccountList().add(account3);

		Account account4 = new Account(index++, 3000);
		App.getAccountList().add(account4);
		customer3.getAccountList().add(account4);
	}

	private void process() {
		App.getAccountService().sendAndReceive(1, 101, 2);
		App.getAccountService().sendAndReceive(2, 200, 1);
		App.getAccountService().sendAndReceive(2, 50, 1);
		App.getAccountService().sendAndReceive(3, 50, 4);		
	}
	
	public Boolean set_Account_Without_Amount() {
		Customer customer = new Customer(Customer.getLastCustomerId("last ID")+1, "Russel", "Crow");
		Account account = new Account(Customer.getLastCustomerId("last ID"), 0);
		App.getAccountList().add(account);
		customer.getAccountList().add(account);
		return (account.getTransactions().size()==0);
	}
	
	public Boolean send_Zero_Amount() {
		Customer customer = new Customer(Customer.getLastCustomerId("last ID")+1, "Dow", "Jones");
		Account account = new Account(Customer.getLastCustomerId("last ID"), 0);
		App.getAccountList().add(account);
		customer.getAccountList().add(account);
		return App.getAccountService().sendAndReceive(index-1, 0, index-2);
	}
	
	public Boolean send_More_Than_Balance() {
		Customer customer = new Customer(Customer.getLastCustomerId("last ID")+1, "Thierry", "Henry");
		Account account = new Account(index++, 10);
		App.getAccountList().add(account);
		customer.getAccountList().add(account);
		return App.getAccountService().sendAndReceive(index-1, 500, index-2);
	}

}
