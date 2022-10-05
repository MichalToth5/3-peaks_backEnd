package sk.umb.fpv.peaks.evacc.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VaccineDTO {

    public String name;

    public String type;

    public String manufacturer;

    public Integer nextShotInDays;

    public Integer minAge;

    public Integer maxAge;
}
