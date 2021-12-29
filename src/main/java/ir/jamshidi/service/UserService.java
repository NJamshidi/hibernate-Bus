package ir.jamshidi.service;

public class UserService extends BaseService {
    protected static UserService instance;

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }
}
