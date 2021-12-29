package ir.jamshidi.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class BusSchedule extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "BUS_ID")
    private Bus bus;

    @Basic
    @Column(name = "DATE")
    private java.sql.Date date;

    @Basic
    @Column(name = "TIME")
    private java.sql.Time time;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "START_POINT")
    private String startPoint;

    @Column(name = "DESTINATIONS")
    private String destination;

    public BusSchedule() {
    }

    public BusSchedule(Bus bus, Date date, Time time, Long price, String startPoint, String destination) {
        this.bus = bus;
        this.date = date;
        this.time = time;
        this.price = price;
        this.startPoint = startPoint;
        this.destination = destination;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destinations) {
        this.destination = destinations;
    }

    @Override
    public String toString() {
        return "\nBusSchedule{" +
                "bus=" + bus +
                ", date=" + date +
                ", time=" + time +
                ", price=" + price +
                ", startPoint='" + startPoint + '\'' +
                ", destinations='" + destination + '\'' +
                '}';
    }
}
