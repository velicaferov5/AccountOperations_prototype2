package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private static Integer Id = 0;
	private Integer customerId;
	private String customerName;
	private String customerSurname;
	private List<Account> accountList = new ArrayList<>();

	public Customer(Integer customerId, String customerName, String customerSurname) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerSurname = customerSurname;

	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String phrase) {
		if (phrase.equals("new ID")) {
			this.customerId = Id++;
		} else
			this.customerId = -1;

	}

	public static int getLastCustomerId(String phrase) {
		if (phrase.equals("last ID")) {
			return Id;
		} else
			return -1;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerFullname() {
		return (customerName + " " + customerSurname);
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
}
