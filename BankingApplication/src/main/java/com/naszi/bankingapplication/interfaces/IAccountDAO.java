package com.naszi.bankingapplication.interfaces;

public interface IAccountDAO<Collection> {

	public boolean create(Collection c);

	public boolean withDrawMoney(Collection c, double amount);

	public boolean addMoney(Collection c, double amount);

}
