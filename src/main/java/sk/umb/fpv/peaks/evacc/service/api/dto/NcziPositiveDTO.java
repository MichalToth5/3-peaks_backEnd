package sk.umb.fpv.peaks.evacc.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziPositiveDTO implements Serializable {

    public boolean success;
    public String next_offset;

    public List<NcziPositivePageDTO> page;

}
