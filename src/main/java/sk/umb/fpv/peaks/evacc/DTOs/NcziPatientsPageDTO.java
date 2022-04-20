package sk.umb.fpv.peaks.evacc.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziPatientsPageDTO implements Serializable {

    public int ventilated_covid;
    public int non_covid;
    public int confirmed_covid;
    public int suspected_covid;

}
