package sk.umb.fpv.peaks.evacc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vaccine {

    /*atributy triedy*/
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String type;
    private String manufacturer;
    private int nextShotInDays;
    private int minAge;
    private int maxAge;
    /*konstruktor*/
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
