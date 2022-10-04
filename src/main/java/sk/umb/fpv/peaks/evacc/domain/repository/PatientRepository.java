package sk.umb.fpv.peaks.evacc.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID>, PagingAndSortingRepository<Patient, UUID> {

    public List<Patient> searchIgnoreCase(String search);
}
