package controller;

import menu.Menu;

public class PromotionController extends Menu {
	private static String[] promotionMenuChoice = { "Display list customers use service",
			"Display list customers get voucher", "Return main menu" };

	private static String promtionTitle = "Customer Management";
    
	public PromotionController(){
		super(promtionTitle, promotionMenuChoice);
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
