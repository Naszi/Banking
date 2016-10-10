package com.naszi.bankingapplication.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naszi.bankingapplication.connection.DatabaseConnection;
import com.naszi.bankingapplication.dto.BankStatisticsDTO;
import com.naszi.bankingapplication.interfaces.IBankingStatisticDAO;

public class BankStatisticsDAO implements IBankingStatisticDAO<BankStatisticsDTO> {

	private static final String SQL_NUMBER_OF_CUSTOMERS = "SELECT COUNT(*) FROM CUSTOMER";
	private static final String SQL_NUMBER_OF_ACCOUNT = "SELECT COUNT(*) FROM ACCOUNT";
	private static final String SQL_MONEY_IN_BANK = "SELECT SUM(BALANCE) FROM ACCOUNT";

	private static final DatabaseConnection connection = DatabaseConnection.customerConnection();

	@Override
	public BankStatisticsDTO bankStatistic() {

		PreparedStatement customersStatement;
		PreparedStatement accountStatement;
		PreparedStatement moneyStatement;

		ResultSet customerSet;
		ResultSet accountSet;
		ResultSet moneySet;

		BankStatisticsDTO bankStatisticsDTO = null;

		int customers;
		int accounts;
		int money;
		double averageBalanceCustomer;
		double averageBalanceAccount;

		try {
			customersStatement = connection.getConnection().prepareStatement(SQL_NUMBER_OF_CUSTOMERS);
			accountStatement = connection.getConnection().prepareStatement(SQL_NUMBER_OF_ACCOUNT);
			moneyStatement = connection.getConnection().prepareStatement(SQL_MONEY_IN_BANK);

			customerSet = customersStatement.executeQuery();
			accountSet = accountStatement.executeQuery();
			moneySet = moneyStatement.executeQuery();

			if (customerSet.next() && accountSet.next() && moneySet.next()) {
				customers = customerSet.getInt(1);
				accounts = accountSet.getInt(1);
				money = moneySet.getInt(1);

				averageBalanceCustomer = (double) money / (double) customers;
				averageBalanceAccount = (double) money / (double) accounts;

				bankStatisticsDTO = new BankStatisticsDTO(customers, accounts, money, averageBalanceCustomer,
						averageBalanceAccount);
			}

		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}
		return bankStatisticsDTO;
	}

}
