package sk.umb.fpv.peaks.evacc.service;

import org.springframework.stereotype.Service;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;
import sk.umb.fpv.peaks.evacc.domain.model.VaccineShot;
import sk.umb.fpv.peaks.evacc.domain.repository.VaccineShotRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineShotService {

    private VaccineShotRepository repository;
    public VaccineShotService(VaccineShotRepository repository) {
        this.repository = repository;
    }
    /*vytvorenie zaznamu ockovania*/

    public VaccineShot addVaccineShot(Patient patient,
                                      Vaccine vaccine,
                                      LocalDate dateOfShot,
                                      int shotNumber,
                                      String batch,
                                      String doctor){
        VaccineShot vaccineShot = new VaccineShot(patient, vaccine, dateOfShot, shotNumber, batch, doctor);
        return repository.save(vaccineShot);
    }
    /*vsetky zaznamy ockovani*/
    public List<VaccineShot> getVaccineShots(){
        return repository.findAll();
    }
    /*zaznamy o ockovani podla id*/
    public VaccineShot getVaccineShotById(long shotId){
        Optional<VaccineShot> optionalVaccineShot = repository.findById(shotId);
        return optionalVaccineShot.orElse(null);
    }
    /*update zaznamu ockovania*/
    public VaccineShot updateVaccineShotById(long shotId, VaccineShot newShot){
        VaccineShot vaccineShot = this.getVaccineShotById(shotId);
        if(vaccineShot != null){
            vaccineShot.setVaccine(newShot.getVaccine());
            vaccineShot.setPatient(newShot.getPatient());
            vaccineShot.setDateOfShot(newShot.getDateOfShot());
            vaccineShot.setShotNumber(newShot.getShotNumber());
            vaccineShot.setBatch(newShot.getBatch());
            vaccineShot.setDoctor(newShot.getDoctor());
            return repository.save(vaccineShot);
        }
        return null;
    }
    /*vymazanie zaznamu ockovania*/
    public void deleteVaccineShotById(long shotId){
        repository.deleteById(shotId);
    }






}



