package service;

import model.Account;

public class TransactionService {

	public void addTransactions(Account account, double transactionAmount, String desc) {
		account.transactions.add(desc);
	}

}
