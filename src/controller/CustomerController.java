package controller;

import java.time.LocalDate;

import menu.Menu;
import model.Customer;
import service.CustomerService;
import utils.CustomerValidater;


public class CustomerController extends Menu {

	private static String[] CusMenuChoice = { "Display list Customers", "Add new Customer", "Edit Customer",
			"Return main menu" };
	private static String CusTitle = "Customer Management";

	private CustomerService customerService;

	/**
	 * @param CusMenuChoice
	 * @param CusTitle
	 * @param CustomerService
	 */
	public CustomerController() {
		super(CusTitle, CusMenuChoice);
		System.out.println("cuCOn");
		customerService = new CustomerService();

	}

	private void displayListCustomer() {
		CustomerValidater.show("Customer Table");
		customerService.display();;
	}

	private void addNewCustomer() {
		do {
			CustomerValidater.show("Enter Customer Information");

			String CustomerID;
			do {
				CustomerID = CustomerValidater.readString("Enter Customer ID:");
			} while (!CustomerValidater.validateEmployeID(CustomerID));

			String fullName;
			do {
				fullName = CustomerValidater.readString("Enter Customer Full Name:");
			} while (!CustomerValidater.validateName(fullName));

			LocalDate birthday = CustomerValidater.readDate("Enter Customer Birthday (dd/MM/yyyy):");

			String sex = CustomerValidater.readString("Enter Customer Sex:");

			String citizenIdentification;
			do {
				citizenIdentification = CustomerValidater.readString("Enter Customer Citizen Identification:");
			} while (!CustomerValidater.validateCitizenIdentification(citizenIdentification));

			String phoneNumber;
			do {
				phoneNumber = CustomerValidater.readString("Enter Customer Phone Number:");
			} while (!CustomerValidater.validPhone(phoneNumber));

			String email;
			do {
				email = CustomerValidater.readString("Enter Customer Email:");
			} while (!CustomerValidater.validateEmail(email));

			String address = CustomerValidater.readString("Enter Customer Address:");

			String CustomerType = CustomerValidater.readString("Enter Customer Type:");

			// Thêm khách hàng mới vào danh sách
			customerService.add(new Customer(fullName, birthday, sex, citizenIdentification, phoneNumber, email,
					CustomerID, CustomerType, address));

			CustomerValidater.show("Customer added successfully!\n");
		} while (CustomerValidater.readBoolean("Do you want to continue adding Customers (true/false)?"));
	}

	private void updateCustomerAttributes() {
		CustomerValidater.show("Update Customer Attributes");

		String customerID;
		do {
			customerID = CustomerValidater.readString("Enter Customer ID:");
		} while (!CustomerValidater.validateEmployeID(customerID));

		Customer customer = customerService.findById(customerID);

		if (customer == null) {
			CustomerValidater.show("Customer with ID " + customerID + " not found.");
			return; // Kết thúc nếu không tìm thấy khách hàng
		}
		CustomerValidater.show(customer.toString());
		final String[] updateMenuChoices = { "Update Full Name", "Update Birthday", "Update Sex",
				"Update Citizen Identification", "Update Phone Number", "Update Email", "Update Address",
				"Update Customer Type", "Exit" };
		final String updateTitle = "Update Customer Attributes";

		// Tạo menu cập nhật từng thuộc tính
		Menu updateMenu = new Menu(updateTitle, updateMenuChoices) {

			@Override
			public void execute(int choice) {
				switch (choice) {
				case 1: // Cập nhật tên đầy đủ
					String fullName;
					do {
						fullName = CustomerValidater.readString("Enter new Full Name:");
					} while (!CustomerValidater.validateName(fullName));
					customer.setFullName(fullName);
					break;

				case 2: // Cập nhật ngày sinh
					LocalDate birthday = CustomerValidater.readDate("Enter new Birthday (dd/MM/yyyy):");
					customer.setBirthday(birthday);
					break;

				case 3: // Cập nhật giới tính
					String sex = CustomerValidater.readString("Enter new Sex:");
					customer.setSex(sex);
					break;

				case 4: // Cập nhật số căn cước công dân
					String citizenIdentification;
					do {
						citizenIdentification = CustomerValidater.readString("Enter new Citizen Identification:");
					} while (!CustomerValidater.validateCitizenIdentification(citizenIdentification));
					customer.setCitizenIdentification(citizenIdentification);
					break;

				case 5: // Cập nhật số điện thoại
					String phoneNumber;
					do {
						phoneNumber = CustomerValidater.readString("Enter new Phone Number:");
					} while (!CustomerValidater.validPhone(phoneNumber));
					customer.setPhoneNumber(phoneNumber);
					break;

				case 6: // Cập nhật email
					String email;
					do {
						email = CustomerValidater.readString("Enter new Email:");
					} while (!CustomerValidater.validateEmail(email));
					customer.setEmail(email);
					break;

				case 7: // Cập nhật địa chỉ
					String address = CustomerValidater.readString("Enter new Address:");
					customer.setAddress(address);
					break;

				case 8: // Cập nhật loại khách hàng
					String customerType = CustomerValidater.readString("Enter new Customer Type:");
					customer.setCustomerType(customerType);
					break;

				case 9: // Thoát
					return; // Thoát menu

				default:
					CustomerValidater.show("Invalid choice. Please try again.");
				}

				// Sau khi cập nhật, hiển thị thông báo và lưu thông tin
				CustomerValidater.show("Customer updated successfully!");
				customerService.update(customer); // Cập nhật khách hàng vào danh sách
			}
		};

		// Chạy menu con
		updateMenu.runsubMenu();
	}

	private  void removedCustomer() {
		CustomerValidater.show(" Removed Customer ");
		String customerID;
		do {

			do {
				customerID = CustomerValidater.readString("Enter Customer ID:");
			} while (!CustomerValidater.validateEmployeID(customerID));

			Customer customer = customerService.findById(customerID);

			if (customer == null) {
				CustomerValidater.show("Customer with ID " + customerID + " not found.");
				return;
			} else if (CustomerValidater.readBoolean("Do you want to removed Employee Information (true/false) ?")) {

				customerService.deleteById(customerID);
			}
		} while (CustomerValidater.readBoolean("Do you want to coninue removed Customer Information (true/false) ?"));
	}
	
    private void findCustomer() {
    	CustomerValidater.show(" Removed Customer ");
		String customerID;
		do {

			do {
				customerID = CustomerValidater.readString("Enter Customer ID:");
			} while (!CustomerValidater.validateEmployeID(customerID));

			Customer customer = customerService.findById(customerID);

			if (customer == null) {
				CustomerValidater.show("Customer with ID " + customerID + " not found.");
				return;
				}
		} while (CustomerValidater.readBoolean("Do you want to coninue removed Customer Information (true/false) ?"));
    }  
	private void editCustomer() {
		final String[] editMenuChoice = { "Update Customer", "Remove Customer", "Find Customer", "Exit" };
		final String editTitle = "Edit Customer";

		// Tạo menu chỉnh sửa cho khách hàng
		Menu editMenu = new Menu(editTitle, editMenuChoice) {

			@Override
			public void execute(int ch) {
				// Thực hiện các hành động tùy thuộc vào lựa chọn người dùng
				switch (ch) {
				case 1:
					// Gọi hàm cập nhật thông tin khách hàng
					updateCustomerAttributes();
					break;
				case 2:
					// Gọi hàm xóa khách hàng
					removedCustomer();
					break;
				case 3:
					// Gọi hàm tìm kiếm khách hàng
					findCustomer();
					break;
				case 4:
					// Thoát khỏi menu
					break;
				}
			}
		};

		// Chạy menu con
		editMenu.runsubMenu();
	}

	@Override
	public void execute(int ch) {
		// TODO Auto-generated method stub
		switch (ch) {
		case 1:
			displayListCustomer();
			break;
		case 2:
			addNewCustomer();
			break;
		case 3:
			editCustomer();
			break;
		case 4:
			return;
		}
	}

}
