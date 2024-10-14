package model;

public abstract class Facility {
	private String serviceID;
	private String serviceName;
	private double useArea;
	private double servicePrice;
	private int maxPeople;
	private String serviceType;
	/**
	 * @param serviceID
	 * @param serviceName
	 * @param useArea
	 * @param servicePrice
	 * @param maxPeople
	 * @param serviceType
	 */
	public Facility(String serviceID, String serviceName, double useArea, double servicePrice, int maxPeople,
			String serviceType) {
		super();
		this.serviceID = serviceID;
		this.serviceName = serviceName;
		this.useArea = useArea;
		this.servicePrice = servicePrice;
		this.maxPeople = maxPeople;
		this.serviceType = serviceType;
	}
	/**
	 * 
	 */
	public Facility() {
		super();
	}
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getUseArea() {
		return useArea;
	}
	public void setUseArea(double useArea) {
		this.useArea = useArea;
	}
	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Override
	public String toString() {
		return String.format("|%-10s|%-30s|%-10.2f|%-10.2f|%-102.f|%-10d|%-10s|",serviceID, serviceName, useArea, servicePrice, maxPeople, serviceType);
	}
	
	
	

}
