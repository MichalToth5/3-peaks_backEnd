package sk.umb.fpv.peaks.evacc;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class VaccineShot {

    /*atributy triedy*/
    private long id;
    private long idPatient;
    private long idVaccine;
    private Date dateOfShot;
    private int shotNumber;
    private String batch;
    private String doctor;
    /*konstruktor*/
    public VaccineShot(long idPatient,
                       long idVaccine,
                       Date dateOfShot,
                       int shotNumber,
                       String batch,
                       String doctor) {
        this.idPatient = idPatient;
        this.idVaccine = idVaccine;
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
    public long getIdPatient() {
        return idPatient;
    }
    public void setIdPatient(long idPatient) {
        this.idPatient = idPatient;
    }
    public long getIdVaccine() {
        return idVaccine;
    }
    public void setIdVaccine(long idVaccine) {
        this.idVaccine = idVaccine;
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
