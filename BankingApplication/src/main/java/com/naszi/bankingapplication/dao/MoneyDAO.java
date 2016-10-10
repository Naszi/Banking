package com.naszi.bankingapplication.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naszi.bankingapplication.connection.DatabaseConnection;
import com.naszi.bankingapplication.dto.MoneyDTO;
import com.naszi.bankingapplication.interfaces.IMoneyDAO;

public class MoneyDAO implements IMoneyDAO<MoneyDTO> {

	private static final String SQL_WITHDRAW_MONEY = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";
	private static final String SQL_ADD_MONEY = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";
	private static final String SQL_NUMBER_OF_CUSTOMERS = "SELECT COUNT(*) FROM CUSTOMER";
	private static final String SQL_NUMBER_OF_ACCOUNT = "SELECT COUNT(*) FROM ACCOUNT";
	private static final String SQL_MONEY_IN_BANK = "SELECT SUM(BALANCE) FROM ACCOUNT";

	private static final DatabaseConnection connection = DatabaseConnection.customerConnection();

	@Override
	public boolean withDrawMoney(MoneyDTO c, double amount) {

		PreparedStatement statement;

		try {
			statement = connection.getConnection().prepareStatement(SQL_WITHDRAW_MONEY);
			statement.setDouble(1, c.withDrawMoney(amount));
			statement.setInt(2, c.getAccountNumber());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;
	}

	@Override
	public boolean addMoney(MoneyDTO c, double amount) {

		PreparedStatement statement;

		try {
			statement = connection.getConnection().prepareStatement(SQL_ADD_MONEY);
			statement.setDouble(1, c.addMonney(amount));
			statement.setInt(2, c.getAccountNumber());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;
	}

	@Override
	public boolean numberOfCustomers() {

		PreparedStatement statement;

		try {
			statement = connection.getConnection().prepareStatement(SQL_NUMBER_OF_CUSTOMERS);
			statement.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;
	}

	@Override
	public boolean numberOfAccount() {

		PreparedStatement statement;

		try {
			statement = connection.getConnection().prepareStatement(SQL_NUMBER_OF_ACCOUNT);
			statement.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;
	}

	@Override
	public boolean moneyInBank() {

		PreparedStatement statement;

		try {
			statement = connection.getConnection().prepareStatement(SQL_MONEY_IN_BANK);
			statement.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;

	}

}
