package sk.umb.fpv.peaks.evacc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.controller.dto.VaccineDTO;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;
import sk.umb.fpv.peaks.evacc.service.VaccineService;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VaccineController {

    private VaccineService service;
    public VaccineController(VaccineService service) {
        this.service = service;
    }

    @PostMapping("/api/vaccine")
    public VaccineDTO addVaccine(@RequestBody VaccineDTO vaccineDTO){
        Vaccine vaccine = service.addVaccine(
                vaccineDTO.name,
                vaccineDTO.type,
                vaccineDTO.manufacturer,
                vaccineDTO.nextShotInDays,
                vaccineDTO.minAge,
                vaccineDTO.maxAge
        );
        vaccineDTO.id = vaccine.getId();
        return vaccineDTO;
    }

    @GetMapping("/api/vaccine")
    public List<VaccineDTO> getVaccines(){
        List<VaccineDTO> vaccineDTOList = new ArrayList<>();
        List<Vaccine> vaccines = service.getVaccines();
        for(Vaccine v : vaccines){
            VaccineDTO vaccineDTO = new VaccineDTO();
            vaccineDTO.id = v.getId();
            vaccineDTO.name = v.getName();
            vaccineDTO.type = v.getType();
            vaccineDTO.manufacturer = v.getManufacturer();
            vaccineDTO.nextShotInDays = v.getNextShotInDays();
            vaccineDTO.minAge = v.getMinAge();
            vaccineDTO.maxAge = v.getMaxAge();
            vaccineDTOList.add(vaccineDTO);
        }
        return vaccineDTOList;
    }

    @GetMapping("/api/vaccine/{vaccineId}")
    public VaccineDTO getVaccineById(@PathVariable long vaccineId){
        VaccineDTO vaccineDTO = new VaccineDTO();
        Vaccine vaccine = service.getVaccineById(vaccineId);
        vaccineDTO.id = vaccine.getId();
        vaccineDTO.name = vaccine.getName();
        vaccineDTO.type = vaccine.getType();
        vaccineDTO.manufacturer = vaccine.getManufacturer();
        vaccineDTO.nextShotInDays = vaccine.getNextShotInDays();
        vaccineDTO.minAge =vaccine.getMinAge();
        vaccineDTO.maxAge =vaccine.getMaxAge();
        return vaccineDTO;
    }

    @PutMapping("/api/vaccine/{vaccineId}")
    public VaccineDTO updateVaccineById(@PathVariable  long vaccineId, @RequestBody VaccineDTO newVaccineDTO){
        Vaccine vaccine = service.getVaccineById(vaccineId);
        vaccine.setName(newVaccineDTO.name);
        vaccine.setType(newVaccineDTO.type);
        vaccine.setManufacturer(newVaccineDTO.manufacturer);
        vaccine.setNextShotInDays(newVaccineDTO.nextShotInDays);
        vaccine.setMinAge(newVaccineDTO.minAge);
        vaccine.setMaxAge(newVaccineDTO.maxAge);
        service.updateVaccineById(vaccineId, vaccine);
        return newVaccineDTO;
    }

    @DeleteMapping("/api/vaccine/{vaccineId}")
    public void deleteVaccineById(@PathVariable long vaccineId){
        service.deleteVaccineById(vaccineId);
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
