package model;

import java.time.LocalDate;

public class Customer extends Person{

	private String customerID;
    private String customerType;
    private String address;
	/**
	 * @param fullName
	 * @param birthday
	 * @param sex
	 * @param citizenIdentification
	 * @param phoneNumbers
	 * @param email
	 * @param customerID
	 * @param customerType
	 * @param address
	 */
	public Customer(String fullName, LocalDate birthday, String sex, String citizenIdentification,
			String phoneNumber, String email, String customerID, String customerType, String address) {
		super(fullName, birthday, sex, citizenIdentification, phoneNumber, email);
		this.customerID = customerID;
		this.customerType = customerType;
		this.address = address;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override

	public String toString() {
	    return String.format("|%-10s|, %-10s|, %-30s|", customerID, customerType, address);
	}

    
    
}
