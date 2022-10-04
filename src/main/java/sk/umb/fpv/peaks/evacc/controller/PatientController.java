package sk.umb.fpv.peaks.evacc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.controller.dto.PageCountDTO;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientDTO;
import sk.umb.fpv.peaks.evacc.controller.mapper.PatientMapper;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.common.Utils;
import sk.umb.fpv.peaks.evacc.domain.model.PatientRequest;
import sk.umb.fpv.peaks.evacc.domain.model.PatientResource;
import sk.umb.fpv.peaks.evacc.service.PatientService;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.*;

@RestController
@Slf4j
public class PatientController {

    private PatientService patientService;
    private PatientMapper patientMapper;
    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
    @Autowired
    public void setPatientMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }
    @PostMapping("/api/patient")
    public PatientResource createPatient(@RequestBody PatientRequest request){
        log.debug("createPatient from request: {}", request);

        PatientResource patientResource = patientMapper.requestToResource(request);
        patientService.createPatient(patientResource);
        return patientResource;
    }

    @GetMapping("/api/patient")
    public List<PatientDTO> getPatients(@RequestParam Integer page, @RequestParam Integer size){
        log.debug("getPatients()");

        List<PatientDTO> patientDTOList = new ArrayList<>();
        patientService.getAllPatients(page, size)
                .forEach(patient -> patientDTOList.add(patientMapper.patientToDto(patient)));
        return patientDTOList;
    }

    @GetMapping("/api/patient/{patientId}")
    public PatientDTO getPatientById(@PathVariable UUID patientId){
        log.debug("getPatient by id: {}", patientId);

        Patient patient = patientService.getPatientById(patientId);
        return patientMapper.patientToDto(patient);
    }
    @PutMapping("/api/patient/{patientId}")
    public PatientDTO updatePatientById(@PathVariable UUID patientId, @RequestBody  PatientRequest request){
        log.debug("updatePatient by id: {}, request: {}", patientId, request);

        Patient patientToUpdate = patientService.getPatientById(patientId);
        patient.setFirstName(newPatientDTO.firstName);
        patient.setLastName(newPatientDTO.lastName);
        patient.setIdNumber(newPatientDTO.idNumber);
        patient.setDateOfBirth(LocalDate.parse(newPatientDTO.dateOfBirth, Utils.EuropeanDateFormatter));
        patient.setSex(newPatientDTO.sex);
        patient.setTelephoneNumber(newPatientDTO.telephoneNumber);
        patient.setEmailAddress(newPatientDTO.emailAddress);
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
        patientService.deletePatientById(patientId);
    }

    @GetMapping("/api/patient/search")
    public Iterable<PatientDTO> searchPatients(@RequestParam String search){
        Iterable<Patient> patientList = patientService.searchPatients(search);
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
        pageCountDTO.setPageCount(patientService.getPageCount());
        return pageCountDTO;
    }
}
