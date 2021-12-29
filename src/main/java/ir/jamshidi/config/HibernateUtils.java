package ir.jamshidi.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
    private SessionFactory sessionFactory;
    private static HibernateUtils instance;

    public HibernateUtils() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateUtils getInstance() {
        if (instance == null)
            instance = new HibernateUtils();
        return instance;
    }
}
