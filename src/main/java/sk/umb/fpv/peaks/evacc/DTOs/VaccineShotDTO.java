package sk.umb.fpv.peaks.evacc.DTOs;

import java.util.Date;

public class VaccineShotDTO {
    public long id;
    public long idPatient;
    public long idVaccine;
    public Date dateOfShot;
    public int shotNumber;
    public String batch;
    public String doctor;
}
