package ir.jamshidi.model;

import ir.jamshidi.enums.BusType;

import javax.persistence.*;

@Entity
public class Bus extends BaseModel{

    @Column(name = "PLAQUE",unique = true, length = 32)
    private String plaque;

    @Column(name = "TYPE")
    private BusType type;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    private Integer capacity;

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public BusType getType() {
        return type;
    }

    public void setType(BusType type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "plaque='" + plaque + '\'' +
                ", type=" + type +
                ", company=" + company +
                ", capacity=" + capacity +
                '}';
    }
}
