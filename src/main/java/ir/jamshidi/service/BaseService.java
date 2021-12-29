package ir.jamshidi.service;

import ir.jamshidi.config.HibernateUtils;
import ir.jamshidi.model.BaseModel;
import org.hibernate.Session;

import java.util.logging.Logger;

public class BaseService {
    protected static BaseService instance;

    public static BaseService getInstance() {
        if (instance == null)
            instance = new BaseService();
        return instance;
    }

    protected Session getSession() {
        return HibernateUtils.getInstance().getSessionFactory().openSession();
    }

    public void save(BaseModel model) {
        Session session = getSession();
        session.beginTransaction();
        try {
            session.save(model);
            session.getTransaction().commit();
            Logger.getLogger(this.getClass().getName()).info("new entity was saved");
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RuntimeException("Save failed in class " + this.getClass().getName());
        }
    }
}
