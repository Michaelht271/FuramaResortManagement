package utils;

import java.time.LocalDate;

public class EmployeeValidater extends Utils{
	private static final String EMPLOYEE_ID_REGEX = "^EM-\\d{4}$"; // Mã nhân viên NV-YYYY
    private static final String ID_CARD_REGEX = "\\d{12}$"; // CMND 9 hoặc 12 số
   
    // Check Employee Condition 
    public static boolean validaterEmployee(String employeeID, String employeeName, LocalDate birthDate, String idCard, String phone, double salary ) {
    	
    	
    	String newName = capitalizeWords(employeeName);
    	if(!isValidPattern(employeeID, EMPLOYEE_ID_REGEX)) {
    		show("[-] Invalid Employee ID.") ;
    		return false;
    	}
    	if(newName == null) {
    		show("[-] Invalid employee Name");
    		return false;
    	}  
    	if(!isAdult(birthDate)) {
    		show("[-] Invalid Employee Age");
    		return false;
    	}
    	if(!isValidPattern(idCard, ID_CARD_REGEX)) {
    		show("[-] Invalid Citizen Identification.") ;
    		return false;
    	}
    	
    	
        if(!isPhoneNumber(phone)) {
    	   show("[-] Invalid Employee Phone Number");
   		  return false;
       }
	        
        if(!isPositiveDouble(salary)) {
        	show("[-] Invalid Employee Salary ");
        	return false;
        }
        show("[+] Employee validation passed.");
        return true;
    }
    
    
    // Check Employee ID
    public static boolean validateEmployeID(String ID) {
    	if(!isValidPattern(ID, EMPLOYEE_ID_REGEX)) {
    		show("[-] Invalid Employee ID.") ;
    		return false;
    	}
    	return true;
    }
    
    // Check Employee Name
    public static  boolean validateName(String name) {
    	String newName = capitalizeWords(name);
    	if(!isCapitalizedName(newName)) {
    		show("[-] Invalid Employee ID.") ;
    		return false;
    	}
    	return true;
    }
    
    // Check Employee Phone NUmber
    public static boolean validPhone(String phone) {
    	  if(!isPhoneNumber(phone)) {
       	   show("[-] Invalid Employee Phone Number");
      	   return false;
          }
    	  return true;
    }
    // check 18+
    public static boolean validateAdult(LocalDate birthDate) {
    	if(!isAdult(birthDate)) {
    		show("[-] Invalid Employee Age");
    		return false;
    	}
    	return true;
    }
    // check CItezen Identification
    public static boolean validateCitizenIdentification(String citizenIdentificattion ) {
    	if(!isValidPattern(citizenIdentificattion, ID_CARD_REGEX)) {
    		show("[-] Invalid Citizen Identification.") ;
    		return false;
    	}
    	return true;
    	
    }
    
    public static boolean validateSalary(double salary) {
    	 if(!isPositiveDouble(salary)) {
         	show("[-] Invalid Employee Salary ");
         	return false;
         } 
    	 return true;
    }
    
    public static boolean validateEmail(String email) {
    	if(!isValidateEmail(email)) {
         	show("[-] Invalid Employee Salary ");
         	return false;
         } 
    	 return true;
    }
}
