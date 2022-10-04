package sk.umb.fpv.peaks.evacc.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziVaccinesPageDTO implements Serializable {

//    public int dose1_sum;
//    public int dose2_sum;
    public int dose1_count;
    public int dose2_count;

}
