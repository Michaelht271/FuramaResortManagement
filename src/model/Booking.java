package model;

import java.time.LocalDateTime;

public class Booking {
	private String bookingID;
	private LocalDateTime booking_Date;
	private LocalDateTime bookingFistDate;
	private LocalDateTime bookingEndDate;

	
	private String customerID;
    private String serviceID;
	/**
	 * @param bookingID
	 * @param booking_Date
	 * @param bookingFistDate
	 * @param bookingEndDate
	 * @param customerID
	 * @param serviceID
	 */
	public Booking(String bookingID, LocalDateTime booking_Date, LocalDateTime bookingFistDate,
			LocalDateTime bookingEndDate, String customerID, String serviceID) {
		super();
		this.bookingID = bookingID;
		this.booking_Date = booking_Date;
		this.bookingFistDate = bookingFistDate;
		this.bookingEndDate = bookingEndDate;
		this.customerID = customerID;
		this.serviceID = serviceID;
	}
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public LocalDateTime getBooking_Date() {
		return booking_Date;
	}
	public void setBooking_Date(LocalDateTime booking_Date) {
		this.booking_Date = booking_Date;
	}
	public LocalDateTime getBookingFistDate() {
		return bookingFistDate;
	}
	public void setBookingFistDate(LocalDateTime bookingFistDate) {
		this.bookingFistDate = bookingFistDate;
	}
	public LocalDateTime getBookingEndDate() {
		return bookingEndDate;
	}
	public void setBookingEndDate(LocalDateTime bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	@Override
	public String toString() {
		return "|%-10s " + bookingID + "|, " + booking_Date + "|, " + bookingFistDate + "|, " + bookingEndDate + "|, "
				+ customerID + "|, " + serviceID + "|";
	}
    
    
}
