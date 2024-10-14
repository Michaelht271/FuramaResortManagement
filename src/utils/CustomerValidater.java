package utils;

import java.time.LocalDate;

public class CustomerValidater extends Utils {
	private static final String CUSTOMER_ID_REGEX = "^CU-\\d{4}$"; // Mã nhân viên NV-YYYY
    private static final String ID_CARD_REGEX = "\\d{12}$"; // CMND 9 hoặc 12 số
   
    // Check Customer Condition 
    public static boolean validaterCustomer(String customerID, String customerName, LocalDate birthDate, String idCard, String phone ) {
    	
    	  String newName = capitalizeWords(customerName);
    	if(!isValidPattern(customerID, CUSTOMER_ID_REGEX)) {
    		show("[-] Invalid Customer ID.") ;
    		return false;
    	}
    	if(newName == null) {
    		return false;
    	}  
    	if(!isAdult(birthDate)) {
    		show("[-] Invalid Customer Age");
    		return false;
    	}
    	if(!isValidPattern(idCard, ID_CARD_REGEX)) {
    		show("[-] Invalid Citizen Identification.") ;
    		return false;
    	}
    	
    	
        if(!isPhoneNumber(phone)) {
    	   show("[-] Invalid Customer Phone Number");
   		  return false;
       }
	   
      
       
        show("[+] Customer validation passed.");
        return true;
    }
    
    
    // Check Customer ID
    public static boolean validateEmployeID(String ID) {
    	if(!isValidPattern(ID, CUSTOMER_ID_REGEX)) {
    		show("[-] Invalid Customer ID.") ;
    		return false;
    	}
    	return true;
    }
    
    // Check Customer Name
    public static  boolean validateName(String name) {
    	String newName = capitalizeWords(name);
    	if(!isCapitalizedName(newName)) {
    		show("[-] Invalid Customer ID.") ;
    		return false;
    	}
    	return true;
    }
    
    // Check Customer Phone NUmber
    public static boolean validPhone(String phone) {
    	  if(!isPhoneNumber(phone)) {
       	   show("[-] Invalid Customer Phone Number");
      	   return false;
          }
    	  return true;
    }
    // check 18+
    public static boolean validateAdult(LocalDate birthDate) {
    	if(!isAdult(birthDate)) {
    		show("[-] Invalid Customer Age");
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
         	show("[-] Invalid Customer Salary ");
         	return false;
         } 
    	 return true;
    }
    
    public static boolean validateEmail(String email) {
    	if(!isValidateEmail(email)) {
         	show("[-] Invalid Customer Salary ");
         	return false;
         } 
    	 return true;
    }
}
