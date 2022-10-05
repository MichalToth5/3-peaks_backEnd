package sk.umb.fpv.peaks.evacc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.controller.dto.VaccineDTO;
import sk.umb.fpv.peaks.evacc.controller.mapper.VaccineMapper;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;
import sk.umb.fpv.peaks.evacc.service.VaccineService;

import java.util.*;

@RestController
@Slf4j
public class VaccineController {

    private VaccineService vaccineService;

    private VaccineMapper vaccineMapper;

    @Autowired
    public void setVaccineService(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @Autowired
    public void setVaccineMapper(VaccineMapper vaccineMapper) {
        this.vaccineMapper = vaccineMapper;
    }

    @PostMapping("/api/vaccine")
    public Vaccine createVaccine(@RequestBody VaccineDTO vaccineDTO) {
        log.debug("createVaccine from dto: {}", vaccineDTO);

        return vaccineService.createVaccine(vaccineMapper.dtoToEntity(vaccineDTO));
    }

    @GetMapping("/api/vaccine")
    public List<VaccineDTO> getVaccines(@RequestParam Integer page, @RequestParam Integer size) {
        log.debug("getVaccines()");

        List<VaccineDTO> vaccineDTOList = new ArrayList<>();
        vaccineService.getAllVaccines(page, size)
                .forEach(vaccine -> vaccineDTOList.add(vaccineMapper.entityToDto(vaccine)));
        return vaccineDTOList;
    }

    @GetMapping("/api/vaccine/{vaccineId}")
    public VaccineDTO getVaccineById(@PathVariable UUID vaccineId) {
        log.debug("getVaccine by id: {}", vaccineId);

        return vaccineMapper.entityToDto(vaccineService.getVaccineById(vaccineId));
    }

    @PutMapping("/api/vaccine/{vaccineId}")
    public VaccineDTO updateVaccineById(@PathVariable UUID vaccineId, @RequestBody VaccineDTO dto) {
        log.debug("updateVaccine by id: {}, from dto: {}", vaccineId, dto);

        return vaccineMapper.entityToDto(vaccineService.updateVaccine(vaccineId, vaccineMapper.dtoToEntity(dto)));
    }

    @DeleteMapping("/api/vaccine/{vaccineId}")
    public void deleteVaccineById(@PathVariable UUID vaccineId) {
        log.debug("deleteVaccine by id: {}", vaccineId);

        vaccineService.deleteVaccineById(vaccineId);
    }


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
}
