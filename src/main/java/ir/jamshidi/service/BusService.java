package ir.jamshidi.service;

public class BusService extends BaseService {
    protected static BusService instance;

    public static BusService getInstance() {
        if (instance == null)
            instance = new BusService();
        return instance;
    }
}
