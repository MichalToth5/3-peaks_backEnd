package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "evacc_vaccine_shot_detail")
public class VaccineShotDetail extends UuidDomainObject{

    private LocalDateTime dateOfShot;

    private Integer shotNumber;

    private String batch;

    private String doctor;
}
