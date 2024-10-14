package model;

public class Room extends Facility{
	private String freeService;

	/**
	 * @param freeService
	 */
	public Room(String freeService) {
		super();
		this.freeService = freeService;
	}

	public String getFreeService() {
		return freeService;
	}

	public void setFreeService(String freeService) {
		this.freeService = freeService;
	}

	@Override
	public String toString() {
		
		return super.toString()+"|%-10s " + freeService + "|";
	}
	
	
   
}
