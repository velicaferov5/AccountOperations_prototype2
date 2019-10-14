package service;

import app.App;
import model.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

	private Boolean receive(Integer accountId, double amount, Integer from, String phrase) {
		if (phrase.equals("Received") && amount > 0) {
			LocalDate today = LocalDate.now();
			LocalTime time = LocalTime.now();
			Account account = getAccountById(accountId);
			account.setBalance(account.getBalance() + amount);
			App.getTransactionService().addTransactions(account, amount, today + " " + time + " Received: " + Double.toString(amount) + " EUR from " + from);
			return true;
		}
		return false;
	}

	private Boolean send(Integer accountId, double amount, Integer to, String phrase) {
		Account account = getAccountById(accountId);
		if (phrase.equals("Sent") && amount > 0 && account.getBalance() >= amount) {
			LocalDate today = LocalDate.now();
			LocalTime time = LocalTime.now();
			account.setBalance(account.getBalance() - amount);
			App.getTransactionService().addTransactions(account, amount, today + " " + time + " Sent: " + Double.toString(amount) + " EUR to " + to);
			return true;
		}
		return false;
	}

	public Boolean sendAndReceive(Integer fromAccountId, double amount, Integer toAccountId) {
		if (send(fromAccountId, amount, toAccountId, "Sent") && receive(toAccountId, amount, fromAccountId, "Received")) {
			return true;
		}
		else return false;
	}

	public Account getAccountById(Integer accountId) {
		List<Account> accountList = App.getAccountList();
		Optional<Account> optional = accountList.stream().filter(a -> a.getAccountId() == accountId).findAny();
		return optional.get();
	}
}
