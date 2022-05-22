package sk.umb.fpv.peaks.evacc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.DTOs.VaccineShotDTO;
import sk.umb.fpv.peaks.evacc.EvaccApplication;
import sk.umb.fpv.peaks.evacc.Utils;
import sk.umb.fpv.peaks.evacc.VaccineShot;
import sk.umb.fpv.peaks.evacc.services.PatientService;
import sk.umb.fpv.peaks.evacc.services.VaccineService;
import sk.umb.fpv.peaks.evacc.services.VaccineShotService;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VaccineShotController {

    private VaccineShotService service;
    private VaccineService vaccineService;
    private PatientService patientService;
    public VaccineShotController(VaccineShotService service, VaccineService vaccineService, PatientService patientService) {
        this.service = service;
        this.vaccineService = vaccineService;
        this.patientService = patientService;
    }

    @PostMapping("/api/shot")
    public VaccineShotDTO addShot(@RequestBody VaccineShotDTO vaccineShotDTO){
        VaccineShot vaccineShot = service.addVaccineShot(
                patientService.getPatientById(vaccineShotDTO.idPatient),
                vaccineService.getVaccineById(vaccineShotDTO.idVaccine),
                LocalDate.parse(vaccineShotDTO.dateOfShot, Utils.EuropeanDateFormatter),
                vaccineShotDTO.shotNumber,
                vaccineShotDTO.batch,
                vaccineShotDTO.doctor
        );
        vaccineShotDTO.id = vaccineShot.getId();
        return vaccineShotDTO;
    }

    @GetMapping("/api/shot")
    public List<VaccineShotDTO> getShots(){
        List<VaccineShotDTO> vaccineShotDTOList = new ArrayList<>();
        List<VaccineShot> shots = service.getVaccineShots();
        for (VaccineShot s : shots){
            VaccineShotDTO vaccineShotDTO = new VaccineShotDTO();
            vaccineShotDTO.id = s.getId();
            vaccineShotDTO.idPatient = s.getPatient().getId();
            vaccineShotDTO.idVaccine = s.getVaccine().getId();
            vaccineShotDTO.dateOfShot = s.getDateOfShot().format(Utils.EuropeanDateFormatter);
            vaccineShotDTO.shotNumber = s.getShotNumber();
            vaccineShotDTO.batch = s.getBatch();
            vaccineShotDTO.doctor = s.getDoctor();
            vaccineShotDTOList.add(vaccineShotDTO);
        }
        return vaccineShotDTOList;
    }

    @GetMapping("/api/shot/{shotId}")
    public VaccineShotDTO getShotById(@PathVariable long shotId){
        VaccineShotDTO vaccineShotDTO = new VaccineShotDTO();
        VaccineShot shot = service.getVaccineShotById(shotId);
        vaccineShotDTO.id = shot.getId();
        vaccineShotDTO.idPatient = shot.getPatient().getId();
        vaccineShotDTO.idVaccine = shot.getVaccine().getId();
        vaccineShotDTO.dateOfShot = shot.getDateOfShot().format(Utils.EuropeanDateFormatter);
        vaccineShotDTO.shotNumber = shot.getShotNumber();
        vaccineShotDTO.batch = shot.getBatch();
        vaccineShotDTO.doctor = shot.getDoctor();
        return vaccineShotDTO;
    }

    @PutMapping("/api/shot/{shotId}")
    public VaccineShotDTO updateShotById(@PathVariable long shotId, @RequestBody VaccineShotDTO newShotDTO){
        VaccineShot vaccineShot = service.getVaccineShotById(shotId);
        vaccineShot.setVaccine(vaccineService.getVaccineById(newShotDTO.idVaccine));
        vaccineShot.setPatient(patientService.getPatientById(newShotDTO.idPatient));
        vaccineShot.setDateOfShot(LocalDate.parse(newShotDTO.dateOfShot, Utils.EuropeanDateFormatter));
        vaccineShot.setShotNumber(newShotDTO.shotNumber);
        vaccineShot.setBatch(newShotDTO.batch);
        vaccineShot.setDoctor(newShotDTO.doctor);
        service.updateVaccineShotById(shotId, vaccineShot);
        return newShotDTO;
    }

    @DeleteMapping("/api/shot/{shotId}")
    public void deleteShotById(@PathVariable long shotId){
        service.deleteVaccineShotById(shotId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleValidationExceptions(
            ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach((error) -> {
            String fieldName = error.getPropertyPath().toString();
            String errorMessage = error.getMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
