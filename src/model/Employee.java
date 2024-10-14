package model;

import java.time.LocalDate;

public class Employee extends Person {
    // Attributes
    private String employeeID;
    private String academicStandard;
    private String position;
    private double salary;

    /**
     * Constructor for Employee class.
     * 
     * @param fullName
     * @param birthday
     * @param sex
     * @param citizenIdentification
     * @param phoneNumber
     * @param email
     * @param employeeID
     * @param academicStandard
     * @param position
     * @param salary
     */
    public Employee(String fullName, LocalDate birthday, String sex, String citizenIdentification,
            String phoneNumber, String email, String employeeID, String academicStandard, String position,
            double salary) {
        super(fullName, birthday, sex, citizenIdentification, phoneNumber, email);
        this.employeeID = employeeID;
        this.academicStandard = academicStandard;
        this.position = position;
        this.salary = salary;
    }

    // Getter and Setter
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getAcademicStandard() {
        return academicStandard;
    }

    public void setAcademicStandard(String academicStandard) {
        this.academicStandard = academicStandard;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Overriding toString method
    @Override
    public String toString() {
        // Format the output properly
        return String.format("%s | EmployeeID: %-10s | Academic: %-15s | Position: %-15s | Salary: %.2f", 
        		             employeeID, 
                             super.toString(), 
                             academicStandard, 
                             position, 
                             salary);
    }
}
