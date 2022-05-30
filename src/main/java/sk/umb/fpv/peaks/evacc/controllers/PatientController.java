package sk.umb.fpv.peaks.evacc.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.DTOs.PageCountDTO;
import sk.umb.fpv.peaks.evacc.DTOs.PatientDTO;
import sk.umb.fpv.peaks.evacc.DTOs.VaccineDTO;
import sk.umb.fpv.peaks.evacc.DTOs.VaccineShotDTO;
import sk.umb.fpv.peaks.evacc.EvaccApplication;
import sk.umb.fpv.peaks.evacc.Patient;
import sk.umb.fpv.peaks.evacc.Utils;
import sk.umb.fpv.peaks.evacc.VaccineShot;
import sk.umb.fpv.peaks.evacc.services.PatientService;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class PatientController {

    private PatientService service;
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/api/patient")
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO){
        Patient patient = service.addPatient(
                patientDTO.firstName,
                patientDTO.lastName,
                patientDTO.idNumber,
                LocalDate.parse(patientDTO.dateOfBirth, Utils.EuropeanDateFormatter),
                patientDTO.sex,
                patientDTO.telephoneNumber,
                patientDTO.emailAddrs,
                patientDTO.insurance,
                patientDTO.street,
                patientDTO.houseNumber,
                patientDTO.postCode,
                patientDTO.city,
                patientDTO.country
        );
        patientDTO.id = patient.getId();
        return patientDTO;
    }

    @GetMapping("/api/patient")
    public Iterable<PatientDTO> getPatients(@RequestParam(defaultValue = "0") Integer page){
        List<PatientDTO> patientDTOList = new ArrayList<>();
        Page<Patient> patients = service.getPatients(page);
        for (Patient p : patients){
            PatientDTO patientDTO = new PatientDTO(p);
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
    }

    @GetMapping("/api/patient/{patientId}")
    public PatientDTO getPatientById(@PathVariable long patientId){
        Patient patient = service.getPatientById(patientId);
        PatientDTO patientDTO = new PatientDTO(patient);
        return patientDTO;
    }
    @Transactional
    @PutMapping("/api/patient/{patientId}")
    public PatientDTO updatePatientById(@PathVariable long patientId, @RequestBody  PatientDTO newPatientDTO){
        Patient patient = service.getPatientById(patientId);

        patient.setFirstName(newPatientDTO.firstName);
        patient.setLastName(newPatientDTO.lastName);
        patient.setIdNumber(newPatientDTO.idNumber);
        patient.setDateOfBirth(LocalDate.parse(newPatientDTO.dateOfBirth, Utils.EuropeanDateFormatter));
        patient.setSex(newPatientDTO.sex);
        patient.setTelephoneNumber(newPatientDTO.telephoneNumber);
        patient.setEmailAddrs(newPatientDTO.emailAddrs);
        patient.setInsurance(newPatientDTO.insurance);
        patient.setStreet(newPatientDTO.street);
        patient.setHouseNumber(newPatientDTO.houseNumber);
        patient.setPostCode(newPatientDTO.postCode);
        patient.setCity(newPatientDTO.city);
        patient.setCountry(newPatientDTO.country);
        service.updatePatientById(patientId, patient);
        return newPatientDTO;
    }
    @Transactional
    @DeleteMapping("/api/patient/{patientId}")
    public  void deletePatientById(@PathVariable long patientId){
        service.deletePatientById(patientId);
    }

    @GetMapping("/api/patient/search")
    public Iterable<PatientDTO> searchPatients(@RequestParam String search){
        Iterable<Patient> patientList = service.searchPatients(search);
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for(Patient p : patientList){
            PatientDTO patientDTO = new PatientDTO(p);
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
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

    @GetMapping("/api/patient/pageCount")
    public PageCountDTO getPagesCount(){
        PageCountDTO pageCountDTO = new PageCountDTO();
        pageCountDTO.setPageCount(service.getPageCount());
        return pageCountDTO;
    }
}
