package service;


import java.util.ArrayList;

import model.Employee;
import repository.EmployeeRepository;
import utils.EmployeeValidater;

public class EmployeeService implements IEmployeeService{
    private EmployeeRepository employeeRepository; 
    
    public EmployeeService() {
		// TODO Auto-generated constructor stub
    	
    	employeeRepository	= new EmployeeRepository();
        
    }
    
	@Override
	public void add(Employee t) {
		// TODO Auto-generated method stub
		if (t == null) {
	        throw new IllegalArgumentException("Employee cannot be null");
	    } else if(!EmployeeValidater.validaterEmployee(t.getEmployeeID(), t.getFullName(), t.getBirthday(), t.getCitizenIdentification(), t.getPhoneNumber(), t.getSalary())) {
	    	return;
	    }
		try {
		employeeRepository.add(t);
		}catch(Exception e) {
			EmployeeValidater.show("Error: "+ e.getMessage());
		}
		
	}

	@Override
	public ArrayList<Employee> getAll() {
		// TODO Auto-generated method stub
		
		return employeeRepository.getEmployeeList();
	}

	@Override
	public void update(Employee t) {
		if (t == null) {
	        throw new IllegalArgumentException("Employee cannot be null");
	    } else if(!EmployeeValidater.validaterEmployee(t.getEmployeeID(), t.getFullName(), t.getBirthday(), t.getCitizenIdentification(), t.getPhoneNumber(), t.getSalary())) {
	    	return;
	    }
		try {
		employeeRepository.update(t);
		}catch(Exception e) {
			EmployeeValidater.show("Error: "+ e.getMessage());
		}
		
	}

	@Override
	public Employee findById(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
		
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		employeeRepository.display();
		
	}

}
