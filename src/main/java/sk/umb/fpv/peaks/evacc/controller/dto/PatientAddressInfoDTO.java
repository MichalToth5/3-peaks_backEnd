package sk.umb.fpv.peaks.evacc.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientAddressInfoDTO {

    private String street;

    private String houseNumber;

    private String postCode;

    private String city;

    private String country;
}
