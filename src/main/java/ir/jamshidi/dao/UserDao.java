package ir.jamshidi.dao;

public class UserDao extends BaseDao {
    protected static UserDao instance;

    public static UserDao getInstance() {
        if (instance == null)
            instance = new UserDao();
        return instance;
    }
}
