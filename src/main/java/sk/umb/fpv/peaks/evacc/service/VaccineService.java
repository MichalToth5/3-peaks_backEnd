package sk.umb.fpv.peaks.evacc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.umb.fpv.peaks.evacc.controller.dto.VaccineDTO;
import sk.umb.fpv.peaks.evacc.controller.mapper.VaccineMapper;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;
import sk.umb.fpv.peaks.evacc.domain.repository.VaccineRepository;
import sk.umb.fpv.peaks.evacc.service.exceptions.VaccineAlreadyExists;
import sk.umb.fpv.peaks.evacc.service.exceptions.VaccineNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class VaccineService {

    private VaccineRepository vaccineRepository;

    private VaccineMapper vaccineMapper;
    @Autowired
    public void setVaccineRepository(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }
    @Autowired
    public void setVaccineMapper(VaccineMapper vaccineMapper) {
        this.vaccineMapper = vaccineMapper;
    }

    @Transactional
    public Vaccine createVaccine(Vaccine vaccine){
        log.debug("createVaccine from request: {}", vaccine);

        Vaccine v = vaccineRepository.findByName(vaccine.getName());
        if(v != null){
            throw new VaccineAlreadyExists("Vaccine with name: " + vaccine.getName() + " already exists!");
        }
        return vaccineRepository.save(vaccine);
    }

    @Transactional
    public List<Vaccine> getAllVaccines(Integer page, Integer size){
        log.debug("getAllVaccines()");

        return vaccineRepository.findAll(PageRequest.of(page, size)).toList();
    }

    @Transactional
    public Vaccine getVaccineById(UUID vaccineId){
        log.debug("getVaccine by id: {}", vaccineId);

        return vaccineRepository.findById(vaccineId)
                .orElseThrow(() -> new VaccineNotFoundException("Vaccine with id " + vaccineId + " not found!"));
    }

    @Transactional
    public Vaccine updateVaccine(UUID vaccineId, Vaccine vaccineToUpdate){
        log.debug("updateVaccine with id: {}, with update: {}", vaccineId, vaccineToUpdate);

        Vaccine vaccine = this.getVaccineById(vaccineId);
        if(vaccine != null){
            update(vaccine, vaccineToUpdate);
            return vaccine;
        }
        throw new VaccineNotFoundException("Vaccine with id " + vaccineId + " not found!");
    }

    @Transactional
    public void deleteVaccineById(UUID vaccineId){
        log.debug("deleteVaccine by id: {}", vaccineId);

        vaccineRepository.deleteById(vaccineId);
    }

    private Vaccine update(Vaccine original, Vaccine updated){
       original.setManufacturer(updated.getManufacturer());
       original.setMaxAge(updated.getMaxAge());
       original.setMinAge(updated.getMinAge());
       original.setName(updated.getName());
       original.setType(updated.getType());
       original.setNextShotInDays(updated.getNextShotInDays());
       return original;
    }
}
