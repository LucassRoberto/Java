package entities;

import exception.BusinessException;

public class ContaBancaria {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public ContaBancaria() {
	}
	public ContaBancaria(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public Double getBalance() {
		return balance;
	}
		
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += balance + amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);//ir� validar as condi��es para realizar o saque
		balance = balance - amount;
	}
	
	private void validateWithdraw (double amount) {//m�todo para tratar as exce��es
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("Withdrawal error: The amount exceeds the withdrawal limit.");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Withdrawal error: Insufficient balance.");
		}
	}
	
	
}
