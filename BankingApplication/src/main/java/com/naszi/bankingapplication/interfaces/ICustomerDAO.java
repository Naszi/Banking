package com.naszi.bankingapplication.interfaces;

public interface ICustomerDAO<Collection> {

	public boolean create(Collection c);

	public boolean delete(Object key);

	public boolean update(Collection c);

	public Collection read(Object key);

}
