package controller;

import menu.Menu;
import service.BookingSerivice;

public class BookingController extends Menu {
	private static String[] bookMenuChoice = { "Add new booking", "Display list booking", "Create new contracts",
			"Display list contracts", "Edit contracts", "Return main menu" };
	private static String bookTitle = "Booking Management";
    BookingSerivice bookService = new BookingSerivice();
	public BookingController(){
		super(bookTitle, bookMenuChoice);
		
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
				System.exit(0);
			}
		}
}
