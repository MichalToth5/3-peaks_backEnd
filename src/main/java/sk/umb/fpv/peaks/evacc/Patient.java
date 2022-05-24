package sk.umb.fpv.peaks.evacc;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Patient {

    /*atributy triedy*/
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Meno je povinný údaj!")
    private String firstName;

    @NotBlank(message = "Priezvisko je povinný údaj!")
    private String lastName;

    @Min(value = 10, message = "Rod. číslo je príliš krátke!")
    @Max(value = 11, message = "Rod. číslo je príliš dlhé!")
    @NotBlank(message = "Rod. číslo je povinný údaj!")
    private String idNumber; //rodne cislo

    @NotNull(message = "Dátum narodenia je povinný údaj!")
    private LocalDate   dateOfBirth;

    @NotBlank(message = "Pohlavie je povinný údaj!")
    private String sex;

    @NotBlank(message = "Tel. číslo je povinný údaj!")
    private String telephoneNumber;

    @NotBlank(message = "Email je povinný údaj!")
    private String emailAddrs;

    @NotBlank(message = "Poisťovňa je povinný údaj!")
    private String insurance; //poistovna

    @NotBlank(message = "Ulica je povinný údaj!")
    private String street;

    @NotBlank(message = "Číslo domu je povinný údaj!")
    private String houseNumber;

    @NotBlank(message = "PSČ je povinný údaj!")
    private String postCode;

    @NotBlank(message = "Mesto je povinný údaj!")
    private String city;

    @NotBlank(message = "Krajina je povinný údaj!")
    private String country;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VaccineShot> shots;


    /*konstruktor*/

    public Patient() {
    }

    public List<VaccineShot> getShots() {
        return shots;
    }

    public void setShots(List<VaccineShot> shots) {
        this.shots = shots;
    }
    public Patient(String firstName,
                   String lastName,
                   String idNumber,
                   LocalDate dateOfBirth,
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
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
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
