package sk.umb.fpv.peaks.evacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.umb.fpv.peaks.evacc.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p " +
            "WHERE CONCAT(p.firstName, ' ', " +
            "p.lastName, ' ', " +
            "p.idNumber, ' ', " +
            "p.street, ' ', " +
            "p.postCode, ' ', " +
            "p.city, ' ', " +
            "p.country) LIKE %?1%")
    public List<Patient> searchIgnoreCase(String search);

}
