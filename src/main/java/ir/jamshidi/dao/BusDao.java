package ir.jamshidi.dao;

import ir.jamshidi.model.Bus;
import ir.jamshidi.model.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class BusDao extends BaseDao {
    protected static BusDao instance;

    public static BusDao getInstance() {
        if (instance == null)
            instance = new BusDao();
        return instance;
    }

    private BusDao() {
    }

    public Bus findByPlaque(String plaque) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bus> cr = builder.createQuery(Bus.class);
        Root<Bus> root = cr.from(Bus.class);
        cr.select(root).where(builder.equal(root.get("plaque"), plaque));

        Query<Bus> query = session.createQuery(cr);
        return query.uniqueResult();
    }
}
