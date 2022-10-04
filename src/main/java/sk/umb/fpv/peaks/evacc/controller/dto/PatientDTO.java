package sk.umb.fpv.peaks.evacc.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.umb.fpv.peaks.evacc.domain.model.PatientAddressInfo;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
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
