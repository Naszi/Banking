package com.naszi.bankingapplication.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naszi.bankingapplication.connection.DatabaseConnection;
import com.naszi.bankingapplication.dto.AccountDTO;
import com.naszi.bankingapplication.interfaces.IAccountDAO;

public class AccountDAO implements IAccountDAO<AccountDTO> {

	private static final String SQL_INSERT = "INSERT INTO account (accountId, accountNumber, balance, currency, customerId) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_WITHDRAW_MONEY = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";
	private static final String SQL_ADD_MONEY = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";

	private static final DatabaseConnection connection = DatabaseConnection.customerConnection();

	@Override
	public boolean create(AccountDTO a) {

		PreparedStatement statement;

		try {
			connection.getConnection().setAutoCommit(false);
			statement = connection.getConnection().prepareStatement(SQL_INSERT);

			statement.setString(1, a.getAccountId());
			statement.setString(2, a.getAccountNumber());
			statement.setDouble(3, a.getBalance());
			statement.setString(4, a.getCurrency());
			statement.setString(5, a.getCustomerId());

			if (statement.executeUpdate() > 0) {
				connection.getConnection().commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.getConnection().rollback();
				System.err.println("Transaction is being rolled back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			connection.closeConnection();
			try {
				connection.getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean withDrawMoney(AccountDTO c, double amount) {

		PreparedStatement statement;

		try {
			connection.getConnection().setAutoCommit(false);
			statement = connection.getConnection().prepareStatement(SQL_WITHDRAW_MONEY);
			statement.setDouble(1, c.withDrawMoney(amount));
			statement.setString(2, c.getAccountNumber());

			if (statement.executeUpdate() > 0) {
				connection.getConnection().commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.getConnection().rollback();
				System.err.println("Transaction is being rolled back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			connection.closeConnection();
			try {
				connection.getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean addMoney(AccountDTO c, double amount) {

		PreparedStatement statement;

		try {
			connection.getConnection().setAutoCommit(false);
			statement = connection.getConnection().prepareStatement(SQL_ADD_MONEY);
			statement.setDouble(1, c.addMonney(amount));
			statement.setString(2, c.getAccountNumber());

			if (statement.executeUpdate() > 0) {
				connection.getConnection().commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.getConnection().rollback();
				System.err.println("Transaction is being rolled back");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			connection.closeConnection();
			try {
				connection.getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
