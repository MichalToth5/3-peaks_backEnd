package sk.umb.fpv.peaks.evacc.controller.dto;

import sk.umb.fpv.peaks.evacc.domain.model.Vaccine;

public class VaccineDTO {
    public VaccineDTO() {

    }

    public VaccineDTO(Vaccine vaccine) {
        this.id = vaccine.getId();
        this.name = vaccine.getName();
        this.type = vaccine.getType();
        this.manufacturer = vaccine.getManufacturer();
        this.nextShotInDays = vaccine.getNextShotInDays();
        this.minAge =vaccine.getMinAge();
        this.maxAge =vaccine.getMaxAge();
    }

    public long id;
    public String name;
    public String type;
    public String manufacturer;
    public int nextShotInDays;
    public int minAge;
    public int maxAge;

}
