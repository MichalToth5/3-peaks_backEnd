package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResource {

    private String firstName;

    private String lastName;

    private String idNumber;

    private String dateOfBirth;

    private String sex;

    private String telephoneNumber;

    private String emailAddress;

    private String insurance;

    private PatientAddressInfo addressInfo;
}
