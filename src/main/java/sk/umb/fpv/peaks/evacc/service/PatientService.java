package sk.umb.fpv.peaks.evacc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientDTO;
import sk.umb.fpv.peaks.evacc.controller.mapper.PatientMapper;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.domain.model.PatientRequest;
import sk.umb.fpv.peaks.evacc.domain.model.PatientResource;
import sk.umb.fpv.peaks.evacc.domain.repository.PatientRepository;
import sk.umb.fpv.peaks.evacc.service.exceptions.PatientNotFoundException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Math.round;

@Service
@Slf4j
public class PatientService {

    private PatientRepository patientRepository;

    private PatientMapper patientMapper;
    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Autowired
    public void setPatientMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public Patient createPatient(PatientResource resource){
        log.debug("createPatient from request: {}", resource);

        Patient patient = patientMapper.resourceToPatient(resource);
        return patientRepository.save(patient);
    }
    @Transactional
    public List<Patient> getAllPatients(Integer page, Integer size){
        log.debug("getAllPatients()");

        return patientRepository.findAll(PageRequest.of(page, size)).toList();
    }

    @Transactional
    public Patient getPatientById(UUID patientId){
       log.debug("getPatient by id: {}", patientId);

       return patientRepository.findById(patientId)
               .orElseThrow(() -> new PatientNotFoundException("Patient with id " + patientId + " not found!"));
    }
    @Transactional
    public Patient updatePatient(UUID patientId, PatientResource resource){
        log.debug("getPatient by id: {}", patientId);

        Patient patientToUpdate = this.getPatientById(patientId);
        if(patientToUpdate != null){
            patientToUpdate = patientMapper.resourceToPatient(resource);
            return patientRepository.save(patientToUpdate);
        }
        throw new PatientNotFoundException("Patient with id " + patientId + " not found!");
    }
    @Transactional
    public void deletePatientById(UUID patientId){
        log.debug("deletePatient by id: {}", patientId);

        patientRepository.deleteById(patientId);
    }

    public Iterable<Patient> searchPatients(String search){
        if(search != null){
            return patientRepository.searchIgnoreCase(search);
        }
        return patientRepository.findAll();
    }

    public long getPageCount(){
        long pageCount = patientRepository.count();
        return round((float)pageCount / 10.0);
    }
}

