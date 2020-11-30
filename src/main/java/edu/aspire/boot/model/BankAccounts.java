package edu.aspire.boot.model;

public class BankAccounts {
	private int accountId;
	private double balance;
	private String bankName;
	public BankAccounts(int accountId, double balance, String bankName) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public BankAccounts() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
