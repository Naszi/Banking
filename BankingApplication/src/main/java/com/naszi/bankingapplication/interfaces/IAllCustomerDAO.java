package com.naszi.bankingapplication.interfaces;

import java.util.List;

public interface IAllCustomerDAO<Collection> {
	public List<Collection> readAll();
}
