package model;

public class Contract {
	private String contractID;
	private String bookingID;
	private double deposit;
	private double totalPayment;
	/**
	 * @param contractID
	 * @param bookingID
	 * @param deposit
	 * @param totalPayment
	 */
	public Contract(String contractID, String bookingID, double deposit, double totalPayment) {
		super();
		this.contractID = contractID;
		this.bookingID = bookingID;
		this.deposit = deposit;
		this.totalPayment = totalPayment;
	}
	public String getContractID() {
		return contractID;
	}
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	@Override
	public String toString() {
		return "|%-10s " + contractID + "|, " + bookingID + "|, " + deposit + "|, " + totalPayment + "|";
	}
	
	
}
