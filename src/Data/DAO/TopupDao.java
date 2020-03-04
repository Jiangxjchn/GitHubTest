package Data.DAO;

import Data.po.User.Customer;
import Data.po.User.TopupDetail;
import org.hibernate.query.Query;

import java.util.List;

public class TopupDao extends BaseDAO implements InterfaceDAO<TopupDetail> {
    TopupDao(){

    }
    public List<TopupDetail> findByHQL(String HQL) {
        try{
            Query query=getSession().createQuery(HQL);
            List<TopupDetail> results=query.list();
            return results;
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<TopupDetail> findByID(Customer cus){
        try {
            System.out.println("DAO "+cus.getAccount());
            String HQL="FROM TopupDetail where account='"+cus.getAccount()+"'";
            if(getSession()==null)System.out.println("session is null");
            Query query=getSession().createQuery(HQL);

            List results=query.list();
            System.out.println("DAO:"+results);
            return results;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean update(TopupDetail o) {
        try{
            getSession().update(o);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(TopupDetail o) {
        try{
            getSession().delete(o);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean save(TopupDetail o) {
        try{
            getSession().save(o);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
