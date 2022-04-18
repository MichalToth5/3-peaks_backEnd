package sk.umb.fpv.peaks.evacc.controllers;

import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.DTOs.PatientDTO;
import sk.umb.fpv.peaks.evacc.DTOs.VaccineShotDTO;
import sk.umb.fpv.peaks.evacc.Patient;
import sk.umb.fpv.peaks.evacc.VaccineShot;
import sk.umb.fpv.peaks.evacc.services.PatientService;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    private PatientService service;
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/api/patient")
    public PatientDTO addPatient(@RequestBody PatientDTO patientDTO){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.uuuu");
        LocalDate localDate = LocalDate.parse(patientDTO.dateOfBirth,formatter);
        ZoneId defaultZone = ZoneId.systemDefault();
        Date date = Date.from(localDate.atStartOfDay(defaultZone).toInstant());
        Patient patient = service.addPatient(
                patientDTO.firstName,
                patientDTO.lastName,
                patientDTO.idNumber,
                date,
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
    public List<PatientDTO> getPatients(){
        List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patients = service.getPatients();
        for (Patient p : patients){
            DateFormat formatter = new SimpleDateFormat("d.M.uuuu");
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.id = p.getId();
            patientDTO.firstName = p.getFirstName();
            patientDTO.lastName= p.getLastName();
            patientDTO.idNumber = p.getIdNumber();
            patientDTO.dateOfBirth = formatter.format(p.getDateOfBirth());
            patientDTO.sex = p.getSex();
            patientDTO.telephoneNumber = p.getTelephoneNumber();
            patientDTO.emailAddrs = p.getEmailAddrs();
            patientDTO.insurance = p.getInsurance();
            patientDTO.street = p.getStreet();
            patientDTO.houseNumber = p.getHouseNumber();
            patientDTO.postCode = p.getPostCode();
            patientDTO.city = p.getCity();
            patientDTO.country = p.getCountry();
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
    }

    @GetMapping("/api/patient/{patientId}")
    public PatientDTO getPatientById(@PathVariable long patientId){
        DateFormat formatter = new SimpleDateFormat("d.M.uuuu");
        PatientDTO patientDTO = new PatientDTO();
        Patient patient = service.getPatientById(patientId);
        patientDTO.id = patient.getId();
        patientDTO.firstName = patient.getFirstName();
        patientDTO.lastName = patient.getLastName();
        patientDTO.idNumber = patient.getIdNumber();
        patientDTO.dateOfBirth =formatter.format(patient.getDateOfBirth());
        patientDTO.sex = patient.getSex();
        patientDTO.telephoneNumber = patient.getTelephoneNumber();
        patientDTO.emailAddrs = patient.getEmailAddrs();
        patientDTO.insurance = patient.getInsurance();
        patientDTO.street = patient.getStreet();
        patientDTO.houseNumber = patient.getHouseNumber();
        patientDTO.postCode = patient.getPostCode();
        patientDTO.city = patient.getCity();
        patientDTO.country= patient.getCountry();
        patientDTO.vaccines = new ArrayList<VaccineShotDTO>();
        for (VaccineShot s : patient.getShots()) {
            VaccineShotDTO vaccineShotDTO = new VaccineShotDTO();
            vaccineShotDTO.id = s.getId();
            vaccineShotDTO.idPatient = s.getPatient().getId();
            vaccineShotDTO.idVaccine = s.getVaccine().getId();
            vaccineShotDTO.dateOfShot = s.getDateOfShot();
            vaccineShotDTO.shotNumber = s.getShotNumber();
            vaccineShotDTO.batch = s.getBatch();
            vaccineShotDTO.doctor = s.getDoctor();
            patientDTO.vaccines.add(vaccineShotDTO);
        }
        return patientDTO;
    }
    @Transactional
    @PutMapping("/api/patient/{patientId}")
    public PatientDTO updatePatientById(@PathVariable long patientId, @RequestBody  PatientDTO newPatientDTO){
        Patient patient = service.getPatientById(patientId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.uuuu");
        LocalDate localDate = LocalDate.parse(newPatientDTO.dateOfBirth,formatter);
        ZoneId defaultZone = ZoneId.systemDefault();
        Date date = Date.from(localDate.atStartOfDay(defaultZone).toInstant());

        patient.setFirstName(newPatientDTO.firstName);
        patient.setLastName(newPatientDTO.lastName);
        patient.setIdNumber(newPatientDTO.idNumber);
        patient.setDateOfBirth(date);
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
    public List<PatientDTO> searchPatients(@RequestParam String search){
        List<Patient> patientList = service.searchPatients(search);
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for(Patient p : patientList){
            DateFormat formatter = new SimpleDateFormat("d.M.uuuu");
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.firstName = p.getFirstName();
            patientDTO.lastName= p.getLastName();
            patientDTO.idNumber = p.getIdNumber();
            patientDTO.dateOfBirth = formatter.format(p.getDateOfBirth());
            patientDTO.street = p.getStreet();
            patientDTO.postCode = p.getPostCode();
            patientDTO.city = p.getCity();
            patientDTO.country = p.getCountry();
            patientDTOList.add(patientDTO);
        }
        return patientDTOList;
    }
}
