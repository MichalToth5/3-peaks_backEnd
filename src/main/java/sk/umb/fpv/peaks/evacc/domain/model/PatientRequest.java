package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientRequest {

    private String firstName;

    private String lastName;

    private String idNumber;

    private LocalDate dateOfBirth;

    private String sex;

    private String telephoneNumber;

    private String emailAddress;

    private String insurance;

    private PatientAddressInfo addressInfo;
}
