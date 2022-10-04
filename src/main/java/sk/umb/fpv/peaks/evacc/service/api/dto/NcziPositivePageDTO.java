package sk.umb.fpv.peaks.evacc.service.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NcziPositivePageDTO implements Serializable {

    public int positives_count;
    public int negatives_count;
    public int positives_sum;
    public int negatives_sum;

}
