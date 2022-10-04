package sk.umb.fpv.peaks.evacc.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.umb.fpv.peaks.evacc.domain.model.VaccineShot;

public interface VaccineShotRepository extends JpaRepository<VaccineShot, Long> {

}
