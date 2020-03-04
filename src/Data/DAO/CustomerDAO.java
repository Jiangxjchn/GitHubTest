package Data.DAO;

import Data.po.User.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAO extends BaseDAO implements InterfaceDAO<Customer>{
    public CustomerDAO() {
    }

    public List<Customer> findByID(String Account){
        try {
            String HQL="FROM Customer where account= '"+Account+"'";
            Query query=getSession().createQuery(HQL);
            List results=query.list();
            return results;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public Customer get(String account){
        try {
            return (Customer) getSession().get(Customer.class,account);
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Customer> findByHQL(String HQL) {
        try{
            Query query=getSession().createQuery(HQL);
            List<Customer> results=query.list();
            return results;
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean save(Customer customer){
        try{
            getSession().save(customer);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean update(Customer customer){
        try{
            getSession().update(customer);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean saveOrUpdate(Customer customer){
        try{
            getSession().saveOrUpdate(customer);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean delete(Customer customer){
        try{
            getSession().delete(customer);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public void executeSQLtoMoney(Double money,String account){
        String SQL="UPDATE restaurant.dbo.Customer SET balance ="+money+ " WHERE account = '"+account+"'";
        SQLQuery sqlQuery= getSession().createSQLQuery(SQL);
        sqlQuery.executeUpdate();
    }

}
