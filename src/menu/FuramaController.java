package menu;

import controller.BookingController;
import controller.CustomerController;
import controller.EmployeeController;
import controller.FacilityController;
import controller.PromotionController;

public class FuramaController {

	public FuramaController() {

	}

	
		private  EmployeeController  employeeController  =  new  EmployeeController();
		private  BookingController   bookingController   =  new  BookingController();
		private  CustomerController  customerController  =  new  CustomerController();
		private  FacilityController  facilitiController  =  new  FacilityController();
        private  PromotionController promotionController =  new  PromotionController();	   



	public void displayMainMenu() {
		
		final String[] menuChoice = { "Employee Management", "Customer Management", "Facility Management",
				"Booking Management", "Promotion Management", "Exit" };

		final String title = "Resort Management";
		Menu displayMainMenu = new Menu(title, menuChoice) {
			@Override
			public void execute(int ch) {

				// TODO Auto-generated methvod stub
				switch (ch) {
					case 1:
						employeeController.runsubMenu();
						break;
					case 2:
						customerController .runsubMenu();
						break;
					case 3:
						facilitiController.runsubMenu();
	
						break;
					case 4:
						bookingController.runsubMenu();
						break;
					case 5:
						promotionController.runsubMenu();
						break;
					case 6:
						System.exit(0);

				}
			}

		};
		displayMainMenu.run();
	}
}
