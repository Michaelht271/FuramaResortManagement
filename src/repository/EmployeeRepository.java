package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

import model.Employee;
import utils.EmployeeValidater;
import utils.Utils;

public class EmployeeRepository implements IEmployeeRepository {
	private static final String FILE_PATH = "data/employee.csv";
	private ArrayList<Employee> employeeList;

	public EmployeeRepository() {
		employeeList = new ArrayList<>();
		
		loadFromFile();
		
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	@Override
	public void loadFromFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			 br.readLine();
			
			while ((line = br.readLine()) != null) {
				
				String[] parts = line.split(",");

				if (parts.length == 10) {
					System.out.print("bb");
					String employeeID = parts[0];
					String fullName = parts[1];
					LocalDate dateTime = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					String sex = parts[3];
					String citizenIdentification = parts[4];
					String phone = parts[5];
					String email = parts[6];			
					String academicStandard = parts[7];
					String position = parts[8];
					double salary = Double.parseDouble(parts[9]);
					Employee em = new Employee(fullName, dateTime, sex, citizenIdentification, phone, email,
							employeeID, academicStandard, position, salary);
					EmployeeValidater.validaterEmployee(employeeID,fullName, dateTime,citizenIdentification, phone, salary);
					employeeList.add(em);
				
				}
			}
		} catch (IOException e) {
			Utils.show("Error reading file: " + e.getMessage());
		} catch (Exception e) {
			Utils.show("Error reading file: " + e.getMessage());
		}

	}


	@Override
	public void saveToFile() {
	    // Sử dụng BufferedWriter để ghi dữ liệu vào tệp
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
	        for (Employee employee : employeeList) {
	            String line = createEmployeeLine(employee);
	            bw.write(line);
	            bw.newLine(); // Thêm dòng mới sau mỗi bản ghi
	        }
	    } catch (IOException e) {
	        Utils.show("Error writing file: " + e.getMessage()); // Hiển thị lỗi khi ghi tệp
	    }
	}

	// Phương thức tạo chuỗi từ đối tượng Employee
	private String createEmployeeLine(Employee employee) {
	    return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%f",
	            employee.getEmployeeID(),
	            employee.getFullName(),
	            employee.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
	            employee.getSex(),
	            employee.getCitizenIdentification(),
	            employee.getPhoneNumber(),
	            employee.getEmail(),
	            employee.getAcademicStandard(),
	            employee.getPosition(),
	            employee.getSalary());
	}


	@Override
	public Employee findById(String id) {
		// TODO Auto-generated method stub

		for (Employee employee : employeeList) {
			if (employee.getEmployeeID().equals(id)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		for (Employee employee : employeeList) {
			if (employee.getEmployeeID().equals(id)) {
				employeeList.remove(employee);
			}
		}
		saveToFile();

	}

	@Override
	public void add(Employee t) {
		employeeList.add(t);
		saveToFile();
	}

	@Override
	public void update(Employee t) {
		// Tìm nhân viên theo ID
		Employee employee = findById(t.getEmployeeID());
		if (employee != null) {
			// Cập nhật tất cả các thuộc tính của nhân viên
			employee.setFullName(t.getFullName());
			employee.setBirthday(t.getBirthday());
			employee.setSex(t.getSex());
			employee.setCitizenIdentification(t.getCitizenIdentification());
			employee.setPhoneNumber(t.getPhoneNumber());
			employee.setEmail(t.getEmail());
			employee.setAcademicStandard(t.getAcademicStandard());
			employee.setPosition(t.getPosition());
			employee.setSalary(t.getSalary());

			// Lưu danh sách nhân viên sau khi cập nhật
			saveToFile();
		} else {
			EmployeeValidater.show("Employee with ID " + t.getEmployeeID() + " not found.");
		}
	}

	@Override
	public void display(ArrayList<Employee> list) {
		EmployeeValidater.show("Employee List");
		for (Employee employee : employeeList) {
			EmployeeValidater.show(employee.toString());
		}

	}

	@Override
	public void display() {
		if (employeeList.isEmpty()) {
	        EmployeeValidater.show("No employees found.");
	    } else {
	        for (Employee employee : employeeList) {
	            EmployeeValidater.show(employee.toString());
	        }
	    }
	}
}
