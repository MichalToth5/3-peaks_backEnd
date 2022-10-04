package sk.umb.fpv.peaks.evacc.controller.dto;

public class VaccineShotDTO {


    public long id;
    public long idPatient;
    public long idVaccine;
    public String dateOfShot;
    public int shotNumber;
    public String batch;
    public String doctor;
    public VaccineDTO vaccine;
}
