package sk.umb.fpv.peaks.evacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.umb.fpv.peaks.evacc.VaccineShot;

public interface VaccineShotRepository extends JpaRepository<VaccineShot, Long> {
}
