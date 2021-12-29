package ir.jamshidi.dto;

import ir.jamshidi.enums.BusType;
import ir.jamshidi.model.BaseModel;

import java.sql.Date;
import java.sql.Time;

public class BusScheduleCreationDTO extends BaseModel {
    private Date date;
    private Time time;
    private Long price;
    private String companyName;
    private BusType busType;
    private String plaque;
    private String startPoint;
    private String destinations;
    private Integer capacity;

    public BusScheduleCreationDTO() {
    }

    public BusScheduleCreationDTO(Date date, Time time, Long price, String companyName, BusType busType, String plaque, String startPoint, String destinations, Integer capacity) {
        this.date = date;
        this.time = time;
        this.price = price;
        this.companyName = companyName;
        this.busType = busType;
        this.plaque = plaque;
        this.startPoint = startPoint;
        this.destinations = destinations;
        this.capacity = capacity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
