package sk.umb.fpv.peaks.evacc.DTOs;

import sk.umb.fpv.peaks.evacc.Patient;
import sk.umb.fpv.peaks.evacc.Utils;
import sk.umb.fpv.peaks.evacc.VaccineShot;

import java.util.ArrayList;

public class PatientDTO {
    public PatientDTO() {
    }

    public PatientDTO(Patient p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.idNumber = p.getIdNumber();
        this.dateOfBirth = p.getDateOfBirth().format(Utils.EuropeanDateFormatter);
        this.street = p.getStreet();
        this.postCode = p.getPostCode();
        this.insurance = p.getInsurance();
        this.emailAddrs = p.getEmailAddrs();
        this.houseNumber = p.getHouseNumber();
        this.sex = p.getSex();
        this.telephoneNumber = p.getTelephoneNumber();
        this.city = p.getCity();
        this.country = p.getCountry();
        this.vaccineShots = new ArrayList<VaccineShotDTO>();
        for (VaccineShot s : p.getShots()) {
            VaccineShotDTO vaccineShotDTO = new VaccineShotDTO();
            vaccineShotDTO.id = s.getId();
            vaccineShotDTO.idPatient = s.getPatient().getId();
            vaccineShotDTO.idVaccine = s.getVaccine().getId();
            vaccineShotDTO.dateOfShot = s.getDateOfShot().format(Utils.EuropeanDateFormatter);
            vaccineShotDTO.shotNumber = s.getShotNumber();
            vaccineShotDTO.batch = s.getBatch();
            vaccineShotDTO.doctor = s.getDoctor();
            vaccineShotDTO.vaccine = new VaccineDTO(s.getVaccine());
            this.vaccineShots.add(vaccineShotDTO);
        }
        if (p.getShots().size() >= 2) {
            this.fullVaccinationSince = p.getShots().get(p.getShots().size() - 1).getDateOfShot().plusDays(14).format(Utils.EuropeanDateFormatter);
        } else {
            this.fullVaccinationSince = "-";
        }
    }

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
    public ArrayList<VaccineShotDTO> vaccineShots;
    public String fullVaccinationSince;
}
