package com.naszi.bankingapplication.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naszi.bankingapplication.connection.DatabaseConnection;
import com.naszi.bankingapplication.dto.CustomerDTO;
import com.naszi.bankingapplication.interfaces.ICustomerDAO;

public class CustomerDAO implements ICustomerDAO<CustomerDTO> {

	private static final String SQL_INSERT = "INSERT INTO customer (customerId, name, address, birthday) VALUES (?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM customer WHERE customerId = ?";
	private static final String SQL_UPDATE = "UPDATE customer SET name = ?, address = ?, birthday = ? WHERE customerId = ?";
	private static final String SQL_READ = "SELECT * FROM customer WHERE customerId = ?";

	private static final DatabaseConnection connection = DatabaseConnection.customerConnection();

	@Override
	public boolean create(CustomerDTO c) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.getConnection().prepareStatement(SQL_INSERT);

			preparedStatement.setString(1, c.getCustomerId());
			preparedStatement.setString(2, c.getName());
			preparedStatement.setString(3, c.getAddress());
			preparedStatement.setString(4, c.getBirthDay());

			if (preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}

		return false;

	}

	@Override
	public boolean delete(Object key) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.getConnection().prepareStatement(SQL_DELETE);
			preparedStatement.setString(1, key.toString());

			if (preparedStatement.executeUpdate() > 0) {
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
	public boolean update(CustomerDTO c) {
		PreparedStatement preparedStatement;

		try {
			preparedStatement = connection.getConnection().prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, c.getName());
			preparedStatement.setString(2, c.getAddress());
			preparedStatement.setString(3, c.getBirthDay());
			preparedStatement.setString(4, c.getCustomerId());

			if (preparedStatement.executeUpdate() > 0) {
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
	public CustomerDTO read(Object key) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		CustomerDTO customerDTO = null;

		try {
			preparedStatement = connection.getConnection().prepareStatement(SQL_READ);
			preparedStatement.setString(1, key.toString());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				customerDTO = new CustomerDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
			return customerDTO;

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection();
		}
		return customerDTO;
	}

}
