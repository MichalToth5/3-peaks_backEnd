package sk.umb.fpv.peaks.evacc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Vaccine {

    /*atributy triedy*/
    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Type is mandatory")
    private String type;

    @NotBlank(message = "Manufacturer is mandatory")
    private String manufacturer;

    @Min(value = 1, message = "Next shot is mandatory")
    private int nextShotInDays;

    @Min(value = 1, message = "Min age is mandatory")
    private int minAge;

    @Min(value = 1, message = "Max age must be larger than 0")
    @Max(value = 100, message = "Max age cannot be larger than 99")
    private int maxAge;

    /*konstruktory*/
    public Vaccine(
                   String name,
                   String type,
                   String manufacturer,
                   int nexShotInDays,
                   int minAge,
                   int maxAge) {
        this.name = name;
        this.type = type;
        this.manufacturer = manufacturer;
        this.nextShotInDays = nexShotInDays;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Vaccine() {
    }

    /*getters/setters*/
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public int getNextShotInDays() {
        return nextShotInDays;
    }
    public void setNextShotInDays(int nextShotInDays) {
        this.nextShotInDays = nextShotInDays;
    }
    public int getMinAge() {
        return minAge;
    }
    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
    public int getMaxAge() {
        return maxAge;
    }
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}
