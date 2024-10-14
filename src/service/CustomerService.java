package service;

import java.util.ArrayList;

import model.Customer;

import repository.CustomerRepository;
import utils.CustomerValidater;

public class CustomerService  implements ICustomerService{
	private CustomerRepository customerRepository;
	
	public CustomerService() {
		System.out.println("cuSe");
		customerRepository = new CustomerRepository();
		
	}

	@Override
	public void add(Customer t) {
		// TODO Auto-generated method stub
		if (t == null) {
	        throw new IllegalArgumentException("Customer cannot be null");
	    } else if(!CustomerValidater.validaterCustomer(t.getCustomerID(), t.getFullName(), t.getBirthday(), t.getCitizenIdentification(), t.getPhoneNumber())) {
	    	return;
	    }
		try {
		customerRepository.add(t);
		}catch(Exception e) {
			CustomerValidater.show("Error: "+ e.getMessage());
		}
		
	}

	@Override
	public ArrayList<Customer> getAll() {
		// TODO Auto-generated method stub
		
		return customerRepository.getAll();
	}

	@Override
	public  void update(Customer t) {
		if (t == null) {
	        throw new IllegalArgumentException("Customer cannot be null");
	    } else if(!CustomerValidater.validaterCustomer(t.getCustomerID(), t.getFullName(), t.getBirthday(), t.getCitizenIdentification(), t.getPhoneNumber() )) {
	    	return ;
	    }
		try {
		customerRepository.update(t);
		}catch(Exception e) {
			CustomerValidater.show("Error: "+ e.getMessage());
		}
		
	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
		
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
	
		customerRepository.display();
		
	}
	
	

}
