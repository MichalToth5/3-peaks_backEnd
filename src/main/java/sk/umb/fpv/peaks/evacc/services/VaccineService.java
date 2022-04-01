package sk.umb.fpv.peaks.evacc.services;

import org.springframework.stereotype.Service;
import sk.umb.fpv.peaks.evacc.Vaccine;
import sk.umb.fpv.peaks.evacc.repositories.VaccineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineService {

    private VaccineRepository repository;
    public VaccineService(VaccineRepository repository) {
        this.repository = repository;
    }
    /*vytvorenie vakciny*/
    public Vaccine addVaccine(String name,
                                    String type,
                                    String manufacturer,
                                    int nexShotInDays,
                                    int minAge,
                                    int maxAge){
        Vaccine vaccine = new Vaccine(name, type, manufacturer, nexShotInDays, minAge, maxAge);
        return repository.save(vaccine);
    }
    /*vsetky vakciny*/
    public List<Vaccine> getVaccines(){
        return repository.findAll();
    }
    /*vakciny podla id*/
    public Vaccine getVaccineById(long vaccineId){
        Optional<Vaccine> optionalVaccine = repository.findById(vaccineId);
        return optionalVaccine.orElse(null);
    }
    /*update vakciny*/
    public Vaccine updateVaccineById(long vaccineId, Vaccine newVaccine){
        Vaccine vaccine = this.getVaccineById(vaccineId);
        if(vaccine != null){
            vaccine.setName(newVaccine.getName());
            vaccine.setType(newVaccine.getType());
            vaccine.setManufacturer(newVaccine.getManufacturer());
            vaccine.setNexShotInDays(newVaccine.getNexShotInDays());
            vaccine.setMinAge(newVaccine.getMinAge());
            vaccine.setMaxAge(newVaccine.getMaxAge());
            return repository.save(vaccine);
        }
        return null;
    }
    /*vymazanie vakciny*/
    public void deleteVaccineById(long vaccineId){
        repository.deleteById(vaccineId);
    }




}
