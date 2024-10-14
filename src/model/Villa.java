package model;

public class Villa extends Facility{
	private String roomStandard;
	private double swimmingPoolArea;
	private int foorNumber;
	/**
	 * @param roomStandard
	 * @param swimmingPoolArea
	 * @param foorNumber
	 */
	public Villa(String roomStandard, double swimmingPoolArea, int foorNumber) {
		super();
		this.roomStandard = roomStandard;
		this.swimmingPoolArea = swimmingPoolArea;
		this.foorNumber = foorNumber;
	}
	public String getRoomStandard() {
		return roomStandard;
	}
	public void setRoomStandard(String roomStandard) {
		this.roomStandard = roomStandard;
	}
	public double getSwimmingPoolArea() {
		return swimmingPoolArea;
	}
	public void setSwimmingPoolArea(double swimmingPoolArea) {
		this.swimmingPoolArea = swimmingPoolArea;
	}
	public int getFoorNumber() {
		return foorNumber;
	}
	public void setFoorNumber(int foorNumber) {
		this.foorNumber = foorNumber;
	}
	@Override
	public String toString() {
		return super.toString()+"|%-10s " + roomStandard + "|, " + swimmingPoolArea + "|, " + foorNumber + "|";
	}
	
	
    
	
}
