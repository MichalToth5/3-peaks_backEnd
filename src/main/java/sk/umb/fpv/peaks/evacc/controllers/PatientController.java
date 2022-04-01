package sk.umb.fpv.peaks.evacc.controllers;

import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.DTOs.PatientDTO;
import sk.umb.fpv.peaks.evacc.Patient;
import sk.umb.fpv.peaks.evacc.services.PatientService;

import java.util.ArrayList;
import java.util.List;

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
                patientDTO.dateOfBirth,
                patientDTO.sex,
                patientDTO.telephoneNumber,
                patientDTO.emailAddrs,
                patientDTO.insurance,
                patientDTO.street,
                patientDTO.houseNumber,
                patientDTO.postCode,
                patientDTO.city,
                patientDTO.counrty
        );
        patientDTO.id = patient.getId();
        return patientDTO;
    }

    @GetMapping("/api/patient")
    public List<PatientDTO> getPatients(){
        List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patients = service.getPatients();
        for (Patient p : patients){
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.id = p.getId();
            patientDTO.firstName = p.getFirstName();
            patientDTO.lastName= p.getLastName();
            patientDTO.idNumber = p.getIdNumber();
            patientDTO.dateOfBirth = p.getDateOfBirth();
            patientDTO.sex = p.getSex();
            patientDTO.telephoneNumber = p.getTelephoneNumber();
            patientDTO.emailAddrs = p.getEmailAddrs();
            patientDTO.insurance = p.getInsurance();
            patientDTO.street = p.getStreet();
            patientDTO.houseNumber = p.getHouseNumber();
            patientDTO.postCode = p.getPostCode();
            patientDTO.city = p.getCity();
            patientDTO.counrty = p.getCountry();
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
    }

    @GetMapping("/api/patient/{patientId}")
    public PatientDTO getPatientById(@RequestParam long patientId){
        PatientDTO patientDTO = new PatientDTO();
        Patient patient = service.getPatientById(patientId);
        patientDTO.id = patient.getId();
        return patientDTO;
    }

    @PutMapping("/api/patient/{patientId}")
    public PatientDTO updatePatientById(@PathVariable long patientId, @RequestBody  PatientDTO newPatientDTO){
        Patient patient = service.getPatientById(patientId);
        patient.setFirstName(newPatientDTO.firstName);
        patient.setLastName(newPatientDTO.lastName);
        patient.setIdNumber(newPatientDTO.idNumber);
        patient.setDateOfBirth(newPatientDTO.dateOfBirth);
        patient.setSex(newPatientDTO.sex);
        patient.setTelephoneNumber(newPatientDTO.telephoneNumber);
        patient.setEmailAddrs(newPatientDTO.emailAddrs);
        patient.setInsurance(newPatientDTO.insurance);
        patient.setStreet(newPatientDTO.street);
        patient.setHouseNumber(newPatientDTO.houseNumber);
        patient.setPostCode(newPatientDTO.postCode);
        patient.setCity(newPatientDTO.city);
        patient.setCountry(newPatientDTO.counrty);
        service.updatePatientById(patientId, patient);
        return newPatientDTO;
    }

    @DeleteMapping("/api/patient/{patientId}")
    public  void deletePatientById(long patientId){
        service.deletePatientById(patientId);
    }

}
