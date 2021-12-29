package ir.jamshidi.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Ticket extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "BUS_SCHEDULE_ID")
    private BusSchedule busSchedule;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private Date registerDate;

    public BusSchedule getBusSchedule() {
        return busSchedule;
    }

    public void setBusSchedule(BusSchedule busSchedule) {
        this.busSchedule = busSchedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
