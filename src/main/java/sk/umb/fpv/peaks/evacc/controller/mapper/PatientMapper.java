package sk.umb.fpv.peaks.evacc.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientAddressInfoDTO;
import sk.umb.fpv.peaks.evacc.controller.dto.PatientDTO;
import sk.umb.fpv.peaks.evacc.domain.model.Patient;
import sk.umb.fpv.peaks.evacc.domain.model.PatientAddressInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", imports = {DateTimeFormatter.class, LocalDate.class, LocalDateTime.class})
public abstract class PatientMapper {

    @Mapping(target = "dateOfBirth", expression = "java(LocalDate.parse(dto.getDateOfBirth(), DateTimeFormatter.ISO_LOCAL_DATE))")
    @Mapping(target = "addressInfo", expression ="java(this.addressInfoDtoToEntity(dto.getAddressInfo()))")
    public abstract Patient dtoToEntity(PatientDTO dto);
    public abstract PatientAddressInfo addressInfoDtoToEntity(PatientAddressInfoDTO dto);

    public abstract PatientDTO entityToDto(Patient patient);
}
