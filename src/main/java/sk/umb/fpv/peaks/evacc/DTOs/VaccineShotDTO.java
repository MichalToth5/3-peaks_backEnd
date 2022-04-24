package sk.umb.fpv.peaks.evacc.DTOs;

import sk.umb.fpv.peaks.evacc.Vaccine;

import java.time.LocalDate;
import java.util.Date;

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
