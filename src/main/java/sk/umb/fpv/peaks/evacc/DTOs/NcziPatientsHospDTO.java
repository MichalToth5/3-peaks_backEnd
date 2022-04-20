package sk.umb.fpv.peaks.evacc.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziPatientsHospDTO {
    public boolean success;
    public String next_offset;

    public List<NcziVaccinesPageDTO> page;

}
