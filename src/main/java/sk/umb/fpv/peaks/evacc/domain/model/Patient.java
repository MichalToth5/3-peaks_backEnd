package sk.umb.fpv.peaks.evacc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evacc_patient")
public class Patient extends UuidDomainObject {

    private String firstName;

    private String lastName;

    private String idNumber;

    private LocalDate dateOfBirth;

    private String sex;

    private String telephoneNumber;

    private String emailAddress;

    private String insurance;

    @OneToOne
    private PatientAddressInfo addressInfo;
}
