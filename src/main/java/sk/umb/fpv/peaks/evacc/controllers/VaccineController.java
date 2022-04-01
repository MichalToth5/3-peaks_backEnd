package sk.umb.fpv.peaks.evacc.controllers;

import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.DTOs.VaccineDTO;
import sk.umb.fpv.peaks.evacc.Vaccine;
import sk.umb.fpv.peaks.evacc.services.VaccineService;

import java.util.ArrayList;
import java.util.List;

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
                vaccineDTO.nexShotInDays,
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
            vaccineDTO.name = v.getName();
            vaccineDTO.type = v.getType();
            vaccineDTO.manufacturer = v.getManufacturer();
            vaccineDTO.nexShotInDays = v.getNexShotInDays();
            vaccineDTO.minAge = v.getMinAge();
            vaccineDTO.maxAge = v.getMaxAge();
            vaccineDTOList.add(vaccineDTO);
        }
        return vaccineDTOList;
    }

    @GetMapping("/api/vaccine/{vaccineId}")
    public VaccineDTO getVaccineById(@RequestParam long vaccineId){
        VaccineDTO vaccineDTO = new VaccineDTO();
        Vaccine vaccine = service.getVaccineById(vaccineId);
        vaccineDTO.id = vaccine.getId();
        return vaccineDTO;
    }

    @PutMapping("/api/vaccine/{vaccineId}")
    public VaccineDTO updateVaccineById(@RequestParam  long vaccineId, @RequestBody VaccineDTO newVaccineDTO){
        Vaccine vaccine = service.getVaccineById(vaccineId);
        vaccine.setName(newVaccineDTO.name);
        vaccine.setType(newVaccineDTO.type);
        vaccine.setManufacturer(newVaccineDTO.manufacturer);
        vaccine.setNexShotInDays(newVaccineDTO.nexShotInDays);
        vaccine.setMinAge(newVaccineDTO.minAge);
        vaccine.setMaxAge(newVaccineDTO.maxAge);
        service.updateVaccineById(vaccineId, vaccine);
        return newVaccineDTO;
    }

    @DeleteMapping("/api/vaccine/{vaccineId}")
    public void deleteVaccineById(long vaccineId){
        service.deleteVaccineById(vaccineId);
    }
}
