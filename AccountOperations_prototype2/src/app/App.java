package app;

import model.Account;
import model.Customer;
import service.AccountService;
import service.TransactionService;

import java.util.ArrayList;
import java.util.List;

public class App {

	private static List<Customer> customerList = new ArrayList<>();
	private static List<Account> accountList = new ArrayList<>();

	private static AccountService accountService = new AccountService();
	private static TransactionService transactionService = new TransactionService();

	public static AccountService getAccountService() {
		return accountService;
	}

	public static void setAccountService(AccountService accountService) {
		App.accountService = accountService;
	}

	public static List<Customer> getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(List<Customer> customerList) {
		App.customerList = customerList;
	}

	public static List<Account> getAccountList() {
		return accountList;
	}

	public static void setAccountList(List<Account> accountList) {
		App.accountList = accountList;
	}

	public static TransactionService getTransactionService() {
		return transactionService;
	}

	public static void setTransactionService(TransactionService transactionService) {
		App.transactionService = transactionService;
	}

}
