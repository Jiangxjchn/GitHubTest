package Data.DAO;

import Data.po.User.Staff;
import org.hibernate.query.Query;

import java.util.List;

public class StaffDao extends BaseDAO implements InterfaceDAO<Staff> {
    public List<Staff> findByID(String Account){
        try {
            String HQL="FROM Staff where account="+Account;
            Query query=getSession().createQuery(HQL);
            List results=query.list();
            return results;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Staff> findByHQL(String HQL) {
        try{
            Query query=getSession().createQuery(HQL);
            List<Staff> results=query.list();
            return results;
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean update(Staff staff) {
        try{
            getSession().update(staff);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Staff staff) {
        try{
            getSession().delete(staff);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(Staff staff) {
        try{
            getSession().save(staff);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
