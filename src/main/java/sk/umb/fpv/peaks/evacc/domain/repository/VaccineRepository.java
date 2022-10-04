package sk.umb.fpv.peaks.evacc.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;

import java.util.UUID;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, UUID> {
}
