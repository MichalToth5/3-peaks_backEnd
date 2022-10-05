package sk.umb.fpv.peaks.evacc.controller.mapper;

import org.mapstruct.Mapper;
import sk.umb.fpv.peaks.evacc.controller.dto.VaccineDTO;
import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;

@Mapper(componentModel = "spring")
public abstract class VaccineMapper {

    public abstract Vaccine dtoToEntity(VaccineDTO dto);

    public abstract VaccineDTO entityToDto(Vaccine vaccine);
}
