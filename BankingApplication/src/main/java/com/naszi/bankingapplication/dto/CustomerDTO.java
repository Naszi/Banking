package com.naszi.bankingapplication.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="customer")
public class CustomerDTO {

	private String customerId;
	private String name;
	private String address;
	private String birthDay;

	public CustomerDTO() {
	}

	public CustomerDTO(String customerId, String name, String address, String birthDay) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.birthDay = birthDay;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

}
