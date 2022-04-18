package sk.umb.fpv.peaks.evacc.DTOs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class PatientDTO {
    public long id;
    public String firstName;
    public String lastName;
    public String idNumber; //rodne cislo
    public String dateOfBirth;
    public String sex;
    public String telephoneNumber;
    public String emailAddrs;
    public String insurance; //poistovna
    public String street;
    public String houseNumber;
    public String postCode;
    public String city;
    public String country;
    public ArrayList<VaccineShotDTO> vaccines;
}
