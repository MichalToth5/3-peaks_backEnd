package sk.umb.fpv.peaks.evacc;

import java.util.Date;

public class Patient {

    /*atributy triedy*/
    private long id;
    private String firstName;
    private String lastName;
    private String idNumber; //rodne cislo
    private Date  dateOfBirth;
    private String sex;
    private String telephoneNumber;
    private String emailAddrs;
    private String insurance; //poistovna
    private String street;
    private String houseNumber;
    private String postCode;
    private String city;
    private String counrty;

    /*getters/setters*/
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getEmailAddrs() {
        return emailAddrs;
    }
    public void setEmailAddrs(String emailAddrs) {
        this.emailAddrs = emailAddrs;
    }
    public String getInsurance() {
        return insurance;
    }
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCounrty() {
        return counrty;
    }
    public void setCounrty(String counrty) {
        this.counrty = counrty;
    }
}
