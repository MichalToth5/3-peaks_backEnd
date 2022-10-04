package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "evacc_patient_address")
public class PatientAddressInfo extends UuidDomainObject{

    private String street;

    private String houseNumber;

    private String postCode;

    private String city;

    private String country;
}
