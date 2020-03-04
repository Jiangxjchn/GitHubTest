package Data.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDAO {
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
