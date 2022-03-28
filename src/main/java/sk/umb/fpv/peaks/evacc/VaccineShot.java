package sk.umb.fpv.peaks.evacc;

import java.util.Date;

public class VaccineShot {

    /*atributy triedy*/
    private long id;
    private long idPatient;
    private long idVaccine;
    private Date dateOfShot;
    private int shotNumber;
    private String batch;
    private String doctorFirstName;
    private String doctorLastName;

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
    public String getDoctorFirstName() {
        return doctorFirstName;
    }
    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }
    public String getDoctorLastName() {
        return doctorLastName;
    }
    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }
}
