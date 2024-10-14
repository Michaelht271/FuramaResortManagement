package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Customer;

import utils.CustomerValidater;


public class CustomerRepository implements ICustomerRepository {
	private static final String FILE_PATH = "data/customer.csv";
	private ArrayList<Customer> customerList;

	public CustomerRepository() {
		// TODO Auto-generated constructor stub
		System.out.println("cuR");
		customerList = new ArrayList<>();
		loadFromFile();
	}

	@Override
	public void loadFromFile() {
		System.out.println("d1d");
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			String line;
			br.readLine();
			System.out.println("d2");
			while((line = br.readLine())!= null) {
				String data[] = line.split(",");
				System.out.println("d3");
				if(data.length == 9) {
					String customerID = data[0];
					String fullName = data[1];
					LocalDate dateTime = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					String sex = data[3];
					String citizenIdentification = data[4];
					String phone = data[5];
					String email = data[6];
					String address = data[7];
				    String customerType =data[8];
				    Customer cs = new Customer(fullName, dateTime, sex, citizenIdentification, phone, email, customerID, customerType, address);
				    customerList.add(cs);
				}
			}
		} catch(IOException e) {
			CustomerValidater.show("Error Reading File: " + e.getMessage());
					
		} catch(Exception e) {
			CustomerValidater.show("Error : " + e.getMessage() );
		}
		
	}

	@Override
	public void saveToFile() {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
	        for (Customer customer : customerList) {
	            String line = createCustomerLine(customer);
	            bw.write(line);
	            bw.newLine(); // Thêm dòng mới sau mỗi bản ghi
	        }
	    } catch (IOException e) {
	        CustomerValidater.show("Error writing file: " + e.getMessage()); // Hiển thị thông báo lỗi nếu có
	    }
	}

	// Phương thức tạo chuỗi từ đối tượng Customer
	private String createCustomerLine(Customer customer) {
	    return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
	            customer.getCustomerID(), // ID khách hàng
	            customer.getFullName(), // Tên đầy đủ
	            customer.getBirthday().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), // Ngày sinh
	            customer.getSex(), // Giới tính
	            customer.getCitizenIdentification(), // Số chứng minh nhân dân
	            customer.getPhoneNumber(), // Số điện thoại
	            customer.getEmail(), // Địa chỉ email
	            customer.getAddress(), // Địa chỉ
	            customer.getCustomerType() // Loại khách hàng
	            // Thêm các trường khác nếu cần thiết
	    );
	}


	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		for(Customer customer : customerList) {
			if(customer.getCustomerID().equals(id)) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public void deleteById(String id) {
		for(Customer customer : customerList) {
			if(customer.getCustomerID().equals(id)) {
				customerList.remove(customer);
				saveToFile();
			}
		}
		
	}

	@Override
	public void add(Customer t) {
		customerList.add(t);
		saveToFile();

	}
	public void update(Customer t) {
	    // Tìm khách hàng theo ID
	    Customer customer = findById(t.getCustomerID());
	    if (customer != null) {
	        // Cập nhật tất cả các thuộc tính của khách hàng
	        customer.setFullName(t.getFullName());
	        customer.setBirthday(t.getBirthday());
	        customer.setSex(t.getSex());
	        customer.setCitizenIdentification(t.getCitizenIdentification());
	        customer.setPhoneNumber(t.getPhoneNumber());
	        customer.setEmail(t.getEmail());
	        customer.setAddress(t.getAddress());
	        customer.setCustomerType(t.getCustomerType());

	        // Lưu danh sách khách hàng sau khi cập nhật
	        saveToFile();
	    } else {
	        CustomerValidater.show("Customer with ID " + t.getCustomerID() + " not found.");
	    }
	}

	@Override
	public void display(ArrayList<Customer> list) {
		
	     for(Customer customer : customerList) {
	    	 CustomerValidater.show(customer.toString());
	     }
	            
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	     for(Customer customer : customerList) {
	    	 CustomerValidater.show(customer.toString());
	     }
	            

	}
   
	public ArrayList<Customer> getAll(){
		return customerList;
	}
}
