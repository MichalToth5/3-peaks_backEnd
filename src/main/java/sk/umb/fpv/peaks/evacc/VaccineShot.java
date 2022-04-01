package sk.umb.fpv.peaks.evacc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
@Entity
public class VaccineShot {

    /*atributy triedy*/
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Vaccine vaccine;
    private Date dateOfShot;
    private int shotNumber;
    private String batch;
    private String doctor;
    /*konstruktor*/

    public VaccineShot(Patient idPatient, Vaccine idVaccine, Date dateOfShot, int shotNumber, String batch, String doctor) {
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

    public Date getDateOfShot() {
        return dateOfShot;
    }

    public void setDateOfShot(Date dateOfShot) {
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
