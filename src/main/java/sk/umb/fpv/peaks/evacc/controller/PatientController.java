package sk.umb.fpv.peaks.evacc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.controller.dto.PageCountDTO;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientDTO;
import sk.umb.fpv.peaks.evacc.controller.mapper.PatientMapper;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.service.PatientService;

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
    public Patient createPatient(@RequestBody PatientDTO patientDTO){
        log.debug("createPatient from dto: {}", patientDTO);

        return patientService.createPatient(patientMapper.dtoToEntity(patientDTO));
    }

    @GetMapping("/api/patient")
    public List<PatientDTO> getPatients(@RequestParam Integer page, @RequestParam Integer size){
        log.debug("getPatients()");

        List<PatientDTO> patientDTOList = new ArrayList<>();
        patientService.getAllPatients(page, size)
                .forEach(patient -> patientDTOList.add(patientMapper.entityToDto(patient)));
        return patientDTOList;
    }

    @GetMapping("/api/patient/{patientId}")
    public PatientDTO getPatientById(@PathVariable UUID patientId){
        log.debug("getPatient by id: {}", patientId);

        return patientMapper.entityToDto(patientService.getPatientById(patientId));
    }
    @PutMapping("/api/patient/{patientId}")
    public PatientDTO updatePatientById(@PathVariable UUID patientId, @RequestBody  PatientDTO dto){
        log.debug("updatePatient by id: {}, from dto: {}", patientId, dto);

        return patientMapper.entityToDto(patientService.updatePatient(patientId, patientMapper.dtoToEntity(dto)));
    }
    @DeleteMapping("/api/patient/{patientId}")
    public  void deletePatientById(@PathVariable UUID patientId){
        log.debug("deletePatient by id: {}", patientId);

        patientService.deletePatientById(patientId);
    }

//    @GetMapping("/api/patient/search")
//    public Iterable<PatientDTO> searchPatients(@RequestParam String search){
//        List<PatientDTO> patientDTOList = new ArrayList<>();
//        patientService.searchPatients(search)
//                .forEach(patient -> patientDTOList.add(patientMapper.patientToDto(patient)));
//        return patientDTOList;
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Map<String, String> handleValidationExceptions(
//            ConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getConstraintViolations().forEach((error) -> {
//            String fieldName = error.getPropertyPath().toString();
//            String errorMessage = error.getMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

    @GetMapping("/api/patient/pageCount")
    public PageCountDTO getPagesCount(){
        PageCountDTO pageCountDTO = new PageCountDTO();
        pageCountDTO.setPageCount(patientService.getPageCount());
        return pageCountDTO;
    }
}
