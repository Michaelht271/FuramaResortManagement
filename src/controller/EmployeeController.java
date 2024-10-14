package controller;

import java.time.LocalDate;
import menu.Menu;
import model.Employee;
import service.EmployeeService;
import utils.EmployeeValidater;

public class EmployeeController extends Menu {
	
	private static String[] eMenuChoice = { "Display list employees", "Add new employee", "Edit employee","Return main menu" };
	private static String eTitle = "Employee Management";
	private EmployeeService employeeService;

	public EmployeeController() {
		super(eTitle, eMenuChoice);
		
		employeeService = new EmployeeService();
	}

	private void displayListEmployee() {
		employeeService.display();
	}
     
	private void addnewEmployee() {
		do {
			EmployeeValidater.show("Enter Employee Information  ");

			String employeeID;
			do {
				employeeID = EmployeeValidater.readString("Enter Employee ID:");
			} while (!EmployeeValidater.validateEmployeID(employeeID));

			String fullName;
			do {
				fullName = EmployeeValidater.readString("Enter Employee FullName: ");
			} while (!EmployeeValidater.validateName(employeeID));

			LocalDate birthday = EmployeeValidater.readDate("Enter Employee Birthday: ");

			String sex = EmployeeValidater.readString("Enter Employee Sex: ");

			String citizenIdentification;
			do {
				citizenIdentification = EmployeeValidater.readString("Enter Employee Citizent Idenfification: ");
			} while (!EmployeeValidater.validateCitizenIdentification(citizenIdentification));

			String phoneNumber;
			do {
				phoneNumber = EmployeeValidater.readString("Enter Employee Phone Numbe: ");
			} while (!EmployeeValidater.validPhone(phoneNumber));

			String email;
			do {
				email = EmployeeValidater.readString("Enter Employee Email: ");
			} while (!EmployeeValidater.validateEmail(email));

			String academicStandard = EmployeeValidater.readString("Enter Employee Academic Standard: ");

			String position = EmployeeValidater.readString("Enter Employee Position: ");

			double salary;
			do {
				salary = EmployeeValidater.readPositiveDouble("Enter Employee Salary: ");
			} while (!EmployeeValidater.isPositiveDouble(salary));
			employeeService.add(new Employee(fullName, birthday, sex, citizenIdentification, phoneNumber, email,
					employeeID, academicStandard, position, salary));
			EmployeeValidater.show(" Addition Employee Sucessfully \n");
		} while (EmployeeValidater.readBoolean("Do you want to continue Employee Information (true/false) ?"));
	}

	private void updateEmployee() {
	    EmployeeValidater.show("Update Employee Information");

	    // Yêu cầu nhập mã nhân viên và kiểm tra hợp lệ
	    String employeeID;
	    do {
	        employeeID = EmployeeValidater.readString("Enter Employee ID:");
	    } while (!EmployeeValidater.validateEmployeID(employeeID));

	    // Tìm nhân viên bằng ID
	    Employee employee = employeeService.findById(employeeID);
	    if (employee == null) {
	        EmployeeValidater.show("Employee with ID " + employeeID + " not found.");
	        return; // Thoát nếu không tìm thấy nhân viên
	    }

	    // Hiển thị thông tin nhân viên hiện tại
	    EmployeeValidater.show(employee.toString());

	    // Menu để cập nhật từng thuộc tính
	    final String[] updateMenuChoices = {
	        "Update Full Name",
	        "Update Birthday",
	        "Update Sex",
	        "Update Citizen Identification",
	        "Update Phone Number",
	        "Update Email",
	        "Update Academic Standard",
	        "Update Position",
	        "Update Salary",
	        "Exit"
	    };
	    final String updateTitle = "Choose the attribute you want to update:";

	    Menu updateMenu = new Menu(updateTitle, updateMenuChoices) {

	        @Override
	        public void execute(int choice) {
	            switch (choice) {
	                case 1: // Cập nhật tên đầy đủ
	                    String fullName;
	                    do {
	                        fullName = EmployeeValidater.readString("Enter new Full Name:");
	                    } while (!EmployeeValidater.validateName(fullName));
	                    employee.setFullName(fullName);
	                    break;

	                case 2: // Cập nhật ngày sinh
	                    LocalDate birthday = EmployeeValidater.readDate("Enter new Birthday (dd/MM/yyyy):");
	                    employee.setBirthday(birthday);
	                    break;

	                case 3: // Cập nhật giới tính
	                    String sex = EmployeeValidater.readString("Enter new Sex:");
	                    employee.setSex(sex);
	                    break;

	                case 4: // Cập nhật số căn cước công dân
	                    String citizenIdentification;
	                    do {
	                        citizenIdentification = EmployeeValidater.readString("Enter new Citizen Identification:");
	                    } while (!EmployeeValidater.validateCitizenIdentification(citizenIdentification));
	                    employee.setCitizenIdentification(citizenIdentification);
	                    break;

	                case 5: // Cập nhật số điện thoại
	                    String phoneNumber;
	                    do {
	                        phoneNumber = EmployeeValidater.readString("Enter new Phone Number:");
	                    } while (!EmployeeValidater.validPhone(phoneNumber));
	                    employee.setPhoneNumber(phoneNumber);
	                    break;

	                case 6: // Cập nhật email
	                    String email;
	                    do {
	                        email = EmployeeValidater.readString("Enter new Email:");
	                    } while (!EmployeeValidater.validateEmail(email));
	                    employee.setEmail(email);
	                    break;

	                case 7: // Cập nhật trình độ học vấn
	                    String academicStandard = EmployeeValidater.readString("Enter new Academic Standard:");
	                    employee.setAcademicStandard(academicStandard);
	                    break;

	                case 8: // Cập nhật chức vụ
	                    String position = EmployeeValidater.readString("Enter new Position:");
	                    employee.setPosition(position);
	                    break;

	                case 9: // Cập nhật lương
	                    double salary;
	                    do {
	                        salary = EmployeeValidater.readPositiveDouble("Enter new Salary:");
	                    } while (!EmployeeValidater.isPositiveDouble(salary));
	                    employee.setSalary(salary);
	                    break;

	                case 10: // Thoát
	                    return; // Thoát menu

	                default:
	                    EmployeeValidater.show("Invalid choice. Please try again.");
	            }

	            // Hiển thị thông báo sau khi cập nhật và lưu thông tin
	            EmployeeValidater.show("Employee updated successfully!");
	            employeeService.update(employee); // Cập nhật nhân viên trong danh sách
	        }
	    };

	    // Chạy menu
	    updateMenu.runsubMenu();
	}


	private void removedEmployee() {
		EmployeeValidater.show("Removed Employee");
		String employeeID;
		do {
			do {
				employeeID = EmployeeValidater.readString("Enter Employee ID:");
			} while (!EmployeeValidater.validateEmployeID(employeeID));

			Employee employee = employeeService.findById(employeeID);
			EmployeeValidater.show(employee.toString());

			if (EmployeeValidater.readBoolean("Do you want to removed Employee Information (true/false) ?")) {
				employeeService.deleteById(employeeID);
			}
			EmployeeValidater.show(" Removed Employee Sucessfully \n");

		} while (EmployeeValidater.readBoolean("Do you want to coninue removed Employee Information (true/false) ?"));
	}

	private void findEmployee() {
		EmployeeValidater.show("Removed Employee");
		do {
			String employeeID;
			do {
				employeeID = EmployeeValidater.readString("Enter Employee ID:");
			} while (!EmployeeValidater.validateEmployeID(employeeID));
			Employee employee = employeeService.findById(employeeID);
			EmployeeValidater.show(employee.toString());
		} while (EmployeeValidater.readBoolean("Do you want to continue Employee Information (true/false) ?"));
	}

	private void editEmploy() {
		final String[] editMenuChoice = { "Update Employee", "Remove Employee", "Find Employee", "Exit" };
		final String editTitle = "Edit Empoyee";

		Menu editMenu = new Menu(editTitle, editMenuChoice) {

			@Override
			public void execute(int ch) {
				// TODO Auto-generated method stub
				switch (ch) {
				case 1:
					updateEmployee();
					break;
				case 2:
					removedEmployee();
					break;
				case 3:
					findEmployee();
					break;
				case 4:
					break;
				}
			}

		};

		editMenu.runsubMenu();
	}

	@Override
	public void execute(int ch) {

		switch (ch) {
		case 1:
			displayListEmployee();
			break;
		case 2:
			addnewEmployee();
			break;
		case 3:
			editEmploy();
			break;
		case 4:
			return;
		}
	}

}
