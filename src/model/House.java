package model;

public class House extends Facility{
	private String roomStandard;
    private int floorNumber;
	/**
	 * @param serviceID
	 * @param serviceName
	 * @param useArea
	 * @param servicePrice
	 * @param maxPeople
	 * @param serviceType
	 * @param roomStandard
	 * @param floorNumber
	 */
	public House(String serviceID, String serviceName, double useArea, double servicePrice, int maxPeople,
			String serviceType, String roomStandard, int floorNumber) {
		super(serviceID, serviceName, useArea, servicePrice, maxPeople, serviceType);
		this.roomStandard = roomStandard;
		this.floorNumber = floorNumber;
	}
	public String getRoomStandard() {
		return roomStandard;
	}
	public void setRoomStandard(String roomStandard) {
		this.roomStandard = roomStandard;
	}
	
     
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public String toString() {
		 return super.toString()+ String.format("%-15s|%-10d", roomStandard, floorNumber);
	}
	
}
