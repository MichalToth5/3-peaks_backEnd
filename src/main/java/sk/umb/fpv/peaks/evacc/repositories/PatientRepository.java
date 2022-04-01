package sk.umb.fpv.peaks.evacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.umb.fpv.peaks.evacc.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
