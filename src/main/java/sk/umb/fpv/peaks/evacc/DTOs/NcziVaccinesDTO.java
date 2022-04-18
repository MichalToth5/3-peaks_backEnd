package sk.umb.fpv.peaks.evacc.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziVaccinesDTO implements Serializable {

    public boolean success;
    public String next_offset;

    public List<NcziVaccinesPageDTO> page;

}
