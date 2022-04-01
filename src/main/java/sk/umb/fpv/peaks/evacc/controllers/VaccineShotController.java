package sk.umb.fpv.peaks.evacc.controllers;

import org.springframework.web.bind.annotation.*;
import sk.umb.fpv.peaks.evacc.DTOs.VaccineShotDTO;
import sk.umb.fpv.peaks.evacc.VaccineShot;
import sk.umb.fpv.peaks.evacc.services.VaccineShotService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VaccineShotController {

    private VaccineShotService service;
    public VaccineShotController(VaccineShotService service) {
        this.service = service;
    }

    @PostMapping("/api/shot")
    public VaccineShotDTO addShot(@RequestBody VaccineShotDTO vaccineShotDTO){
        VaccineShot vaccineShot = service.addVaccineShot(
                vaccineShotDTO.idPatient,
                vaccineShotDTO.idVaccine,
                vaccineShotDTO.dateOfShot,
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
            vaccineShotDTO.idPatient = s.getIdPatient();
            vaccineShotDTO.idVaccine = s.getIdVaccine();
            vaccineShotDTO.dateOfShot = s.getDateOfShot();
            vaccineShotDTO.shotNumber = s.getShotNumber();
            vaccineShotDTO.batch = s.getBatch();
            vaccineShotDTO.doctor = s.getDoctor();
            vaccineShotDTOList.add(vaccineShotDTO);
        }
        return vaccineShotDTOList;
    }

    @GetMapping("/api/shot/{shotId}")
    public VaccineShotDTO getShotById(@RequestParam long shotId){
        VaccineShotDTO vaccineShotDTO = new VaccineShotDTO();
        VaccineShot shot = service.getVaccineShotById(shotId);
        vaccineShotDTO.id = shot.getId();
        return vaccineShotDTO;
    }

    @PutMapping("/api/shot/{shotId}")
    public VaccineShotDTO updateShotById(@PathVariable long shotId, @RequestBody VaccineShotDTO newShotDTO){
        VaccineShot vaccineShot = service.getVaccineShotById(shotId);
        vaccineShot.setIdPatient(newShotDTO.idPatient);
        vaccineShot.setIdVaccine(newShotDTO.idVaccine);
        vaccineShot.setDateOfShot(newShotDTO.dateOfShot);
        vaccineShot.setShotNumber(newShotDTO.shotNumber);
        vaccineShot.setBatch(newShotDTO.batch);
        vaccineShot.setDoctor(newShotDTO.doctor);
        service.updateVaccineShotById(shotId, vaccineShot);
        return newShotDTO;
    }

    @DeleteMapping("/api/shot/{shotId}")
    public void deleteShotById(long shotId){
        service.deleteVaccineShotById(shotId);
    }
}
