package sk.umb.fpv.peaks.evacc.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziPatientsHospPageDTO {

    public int suspected_covid;
    public int confirmed_covid;
}
