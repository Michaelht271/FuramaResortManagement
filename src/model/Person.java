package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person {
    // Attributes 
    private String fullName;
    private LocalDate birthday;
    private String sex;
    private String citizenIdentification;
    private String phoneNumber;
    private String email;

    /**
     * Constructor to initialize the Person object.
     * 
     * @param fullName              Full name of the person
     * @param birthday              Birthday of the person (LocalDate format)
     * @param sex                   Gender of the person
     * @param citizenIdentification ID number (citizen identification)
     * @param phoneNumber           Phone number of the person
     * @param email                 Email address of the person
     */
    public Person(String fullName, LocalDate birthday, String sex, String citizenIdentification, String phoneNumber,
            String email) {

        this.fullName = fullName;
        this.birthday = birthday;
        this.sex = sex;
        this.citizenIdentification = citizenIdentification;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCitizenIdentification() {
        return citizenIdentification;
    }

    public void setCitizenIdentification(String citizenIdentification) {
        this.citizenIdentification = citizenIdentification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method with formatted output
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("|%-30s|, %-30s|, %-15s|, %-15s|, %-12s|, %-50s|", 
                              fullName, 
                              birthday.format(formatter), 
                              sex, 
                              citizenIdentification, 
                              phoneNumber, 
                              email);
    }
}
