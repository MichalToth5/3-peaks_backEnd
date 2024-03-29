package sk.umb.fpv.peaks.evacc.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class VaccineShot {

    /*atributy triedy*/
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Vaccine vaccine;

    @NotNull(message = "Dátum podania dávky je povinný údaj!")
    private LocalDate dateOfShot;

    @NotNull(message = "Počet dávok je povinný údaj!")
    private int shotNumber;

    @NotBlank(message = "Šarža je povinný údaj!")
    private String batch;

    @NotBlank(message = "Doktor je povinný údaj!")
    private String doctor;
    /*konstruktor*/

    public VaccineShot() {
    }

    public VaccineShot(Patient idPatient, Vaccine idVaccine, LocalDate dateOfShot, int shotNumber, String batch, String doctor) {
        this.patient = idPatient;
        this.vaccine = idVaccine;
        this.dateOfShot = dateOfShot;
        this.shotNumber = shotNumber;
        this.batch = batch;
        this.doctor = doctor;
    }

    /*getters/setters*/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public LocalDate getDateOfShot() {
        return dateOfShot;
    }

    public void setDateOfShot(LocalDate dateOfShot) {
        this.dateOfShot = dateOfShot;
    }

    public int getShotNumber() {
        return shotNumber;
    }

    public void setShotNumber(int shotNumber) {
        this.shotNumber = shotNumber;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
