package sk.umb.fpv.peaks.evacc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientDTO;
import sk.umb.fpv.peaks.evacc.controller.mapper.PatientMapper;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.domain.repository.PatientRepository;
import sk.umb.fpv.peaks.evacc.service.exceptions.PatientAlreadyExists;
import sk.umb.fpv.peaks.evacc.service.exceptions.PatientNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
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

    public Patient createPatient(Patient patient){
        log.debug("createPatient from request: {}", patient);

        Patient p = patientRepository.findByIdNumber(patient.getIdNumber());
        if(p != null){
            throw new PatientAlreadyExists("Patient with id number: " + patient.getIdNumber() + " already exists!");
        }
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
    public Patient updatePatient(UUID patientId, Patient patientToUpdate){
        log.debug("updatePatient with id: {}, with update: {}", patientId, patientToUpdate);

        Patient patient = this.getPatientById(patientId);
        if(patient != null){
            update(patient, patientToUpdate);
            return patient;
        }
        throw new PatientNotFoundException("Patient with id " + patientId + " not found!");
    }
    @Transactional
    public void deletePatientById(UUID patientId){
        log.debug("deletePatient by id: {}", patientId);

        patientRepository.deleteById(patientId);
    }

//    public Iterable<Patient> searchPatients(String search){
//        log.debug("search: {}", search);
//
//        if(search != null){
//            return patientRepository.searchIgnoreCase(search);
//        }
//        return patientRepository.findAll();
//    }

    public long getPageCount(){
        long pageCount = patientRepository.count();
        return round((float)pageCount / 10.0);
    }

    private Patient update(Patient original, Patient updated){
        original.setFirstName(updated.getFirstName());
        original.setLastName(updated.getLastName());
        original.setIdNumber(updated.getIdNumber());
        original.setDateOfBirth(updated.getDateOfBirth());
        original.setSex(updated.getSex());
        original.setTelephoneNumber(updated.getTelephoneNumber());
        original.setEmailAddress(updated.getEmailAddress());
        original.setInsurance(updated.getInsurance());
        original.setAddressInfo(updated.getAddressInfo());
        return original;
    }
}

