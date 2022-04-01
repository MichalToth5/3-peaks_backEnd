package sk.umb.fpv.peaks.evacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.umb.fpv.peaks.evacc.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
