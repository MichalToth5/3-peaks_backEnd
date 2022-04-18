package sk.umb.fpv.peaks.evacc.services;

import org.springframework.stereotype.Service;
import sk.umb.fpv.peaks.evacc.Patient;
import sk.umb.fpv.peaks.evacc.repositories.PatientRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository repository;
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }
    /*vytvorenie pacienta*/
    public Patient addPatient(String firstName,
                                    String lastName,
                                    String idNumber,
                                    Date dateOfBirth,
                                    String sex,
                                    String telephoneNumber,
                                    String emailAddrs,
                                    String insurance,
                                    String street,
                                    String houseNumber,
                                    String postCode,
                                    String city,
                                    String country){
        Patient patient = new Patient(firstName, lastName, idNumber,
                dateOfBirth, sex, telephoneNumber, emailAddrs,
                insurance, street, houseNumber, postCode, city, country);
        return repository.save(patient);
    }
    /*vsetci pacienti*/
    public List<Patient> getPatients(){
        return repository.findAll();
    }
    /*pacienti podla id*/
    public Patient getPatientById(long patientId){
        Optional<Patient> optionalPatient = repository.findById(patientId);
        return optionalPatient.orElse(null);
    }
    @Transactional
    /*update pacienta*/
    public Patient updatePatientById(long patientId, Patient newPatient){
        Patient patient = this.getPatientById(patientId);
        if(patient != null){
            patient.setFirstName(newPatient.getFirstName());
            patient.setLastName(newPatient.getLastName());
            patient.setIdNumber(newPatient.getIdNumber());
            patient.setDateOfBirth(newPatient.getDateOfBirth());
            patient.setSex(newPatient.getSex());
            patient.setTelephoneNumber(newPatient.getTelephoneNumber());
            patient.setEmailAddrs(newPatient.getEmailAddrs());
            patient.setInsurance(newPatient.getInsurance());
            patient.setStreet(newPatient.getStreet());
            patient.setHouseNumber(newPatient.getHouseNumber());
            patient.setPostCode(newPatient.getPostCode());
            patient.setCity(newPatient.getCity());
            patient.setCountry(newPatient.getCountry());
            return repository.save(patient);
        }
        return null;
    }
    @Transactional
    /*vymazanie pacienta*/
    public void deletePatientById(long patientId){
        repository.deleteById(patientId);
    }

    public List<Patient> searchPatients(String search){
        if(search != null){
            return repository.searchIgnoreCase(search);
        }
        return repository.findAll();
    }
}

