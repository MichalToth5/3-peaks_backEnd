package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evacc_vaccine")
public class Vaccine extends UuidDomainObject {

    private String name;

    private String type;

    private String manufacturer;

    private Integer nextShotInDays;

    private Integer minAge;

    private Integer maxAge;

}
