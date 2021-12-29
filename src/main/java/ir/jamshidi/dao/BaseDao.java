package ir.jamshidi.dao;

import ir.jamshidi.config.HibernateUtils;
import ir.jamshidi.model.BaseModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.logging.Logger;

public class BaseDao {
    protected static BaseDao instance;

    public static BaseDao getInstance() {
        if (instance == null)
            instance = new BaseDao();
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
            e.printStackTrace();
            throw new RuntimeException("Save failed in class " + this.getClass().getName());
        }
    }

    public BaseModel findById(Long id) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BaseModel> cr = builder.createQuery(BaseModel.class);
        Root<BaseModel> root = cr.from(BaseModel.class);
        cr.select(root).where(builder.equal(root.get("id"), id));

        Query<BaseModel> query = session.createQuery(cr);
        return query.uniqueResult();
    }
}
