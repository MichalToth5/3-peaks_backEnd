package sk.umb.fpv.peaks.evacc.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
