package ir.jamshidi.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateFactory {
    private SessionFactory sessionFactory;
    private static HibernateFactory instance;

    public HibernateFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateFactory getInstance() {
        if (instance == null)
            instance = new HibernateFactory();
        return instance;
    }
}
