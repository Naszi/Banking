package com.naszi.bankingapplication.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naszi.bankingapplication.connection.DatabaseConnection;
import com.naszi.bankingapplication.dto.MoneyDTO;
import com.naszi.bankingapplication.interfaces.IMoneyDAO;

public class MoneyDAO implements IMoneyDAO<MoneyDTO> {

	private static final String SQL_WITHDRAW_MONEY = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";
	private static final String SQL_ADD_MONEY = "UPDATE ACCOUNT SET BALANCE=? WHERE ACCOUNTNUMBER=?";

	private static final DatabaseConnection connection = DatabaseConnection.customerConnection();

	@Override
	public boolean withDrawMoney(MoneyDTO c, double amount) {

		PreparedStatement statement;

		try {
			connection.getConnection().setAutoCommit(false);
			statement = connection.getConnection().prepareStatement(SQL_WITHDRAW_MONEY);
			statement.setDouble(1, c.withDrawMoney(amount));
			statement.setInt(2, c.getAccountNumber());

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
	public boolean addMoney(MoneyDTO c, double amount) {

		PreparedStatement statement;

		try {
			connection.getConnection().setAutoCommit(false);
			statement = connection.getConnection().prepareStatement(SQL_ADD_MONEY);
			statement.setDouble(1, c.addMonney(amount));
			statement.setInt(2, c.getAccountNumber());

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
	public boolean transferMoney(MoneyDTO from, MoneyDTO to, double amount) {

		PreparedStatement accountNumberFromStatement;
		PreparedStatement accountNumberToStatement;

		try {
			connection.getConnection().setAutoCommit(false);
			accountNumberFromStatement = connection.getConnection().prepareStatement(SQL_WITHDRAW_MONEY);
			accountNumberFromStatement.setDouble(1, from.withDrawMoney(amount));
			accountNumberFromStatement.setInt(2, from.getAccountNumber());

			accountNumberToStatement = connection.getConnection().prepareStatement(SQL_ADD_MONEY);
			accountNumberToStatement.setDouble(1, to.addMonney(amount));
			accountNumberToStatement.setInt(2, to.getAccountNumber());

			if (accountNumberFromStatement.executeUpdate() > 0 && accountNumberToStatement.executeUpdate() > 0) {
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
