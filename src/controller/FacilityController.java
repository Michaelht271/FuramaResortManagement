package controller;

import menu.Menu;
import service.FacilityService;

public class FacilityController extends Menu{

	
	private static 	String[] facMenuChoice = { "Display list Facility", "Add new Facility", "DisplayFacility maintenace",
				"Return main menu" };
	private static 	String facTitle = "Customer Management";
	      FacilityService facilityService = new FacilityService();
           public FacilityController (){
        	   super(facTitle, facMenuChoice);
           }
		
			@Override
			public void execute(int ch) {
				// TODO Auto-generated method stub
				switch (ch) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						return;			
			    }
			}


	
}
