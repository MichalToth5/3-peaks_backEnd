package sk.umb.fpv.peaks.evacc.controller.mapper;

import org.mapstruct.Mapper;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientDTO;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.domain.model.PatientRequest;
import sk.umb.fpv.peaks.evacc.domain.model.PatientResource;

@Mapper(componentModel = "spring")
public abstract class PatientMapper {

    public abstract PatientResource requestToResource(PatientRequest request);

    public abstract PatientDTO resourceToDto(PatientResource resource);

    public abstract Patient dtoToPatient(PatientDTO dto);
    public abstract Patient resourceToPatient(PatientResource resource);

    public abstract PatientDTO patientToDto(Patient patient);
}
