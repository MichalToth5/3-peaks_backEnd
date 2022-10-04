package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evacc_vaccine_shot")
public class VaccineShot extends UuidDomainObject {

    @OneToOne
    private VaccineShotDetail shotDetail;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Vaccine vaccine;
}
