package ir.jamshidi.dao;

import ir.jamshidi.model.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CompanyDao extends BaseDao {
    protected static CompanyDao instance;

    public static CompanyDao getInstance() {
        if (instance == null)
            instance = new CompanyDao();
        return instance;
    }

    public Company findByName(String name) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Company> cr = builder.createQuery(Company.class);
        Root<Company> root = cr.from(Company.class);
        cr.select(root).where(builder.equal(root.get("name"), name));

        Query<Company> query = session.createQuery(cr);
        return query.uniqueResult();
    }
}
