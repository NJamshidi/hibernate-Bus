package ir.jamshidi.service;

public class BusSchedule extends BaseService {
    protected static BusSchedule instance;

    public static BusSchedule getInstance() {
        if (instance == null)
            instance = new BusSchedule();
        return instance;
    }
}
