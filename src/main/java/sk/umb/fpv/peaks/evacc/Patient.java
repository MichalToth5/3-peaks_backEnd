package sk.umb.fpv.peaks.evacc;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Patient {

    /*atributy triedy*/
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String idNumber; //rodne cislo
    private Date   dateOfBirth;
    private String sex;
    private String telephoneNumber;
    private String emailAddrs;
    private String insurance; //poistovna
    private String street;
    private String houseNumber;
    private String postCode;
    private String city;
    private String country;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<VaccineShot> shots;


    /*konstruktor*/

    public Patient() {
    }

    public Set<VaccineShot> getShots() {
        return shots;
    }

    public void setShots(Set<VaccineShot> shots) {
        this.shots = shots;
    }
    public Patient(String firstName,
                   String lastName,
                   String idNumber,
                   Date dateOfBirth,
                   String sex,
                   String telephoneNumber,
                   String emailAddrs,
                   String insurance,
                   String street,
                   String houseNumber,
                   String postCode,
                   String city,
                   String counrty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.telephoneNumber = telephoneNumber;
        this.emailAddrs = emailAddrs;
        this.insurance = insurance;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.city = city;
        this.country = counrty;
    }
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
