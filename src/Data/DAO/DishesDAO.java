package Data.DAO;

import Data.po.goods.Dishes;
import org.hibernate.query.Query;

import java.util.List;

public class DishesDAO extends BaseDAO implements InterfaceDAO<Dishes> {

    @Override
    public boolean update(Dishes o) {

        return false;
    }

    @Override
    public boolean delete(Dishes o) {
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
    public boolean save(Dishes o) {
        return false;
    }
    public Dishes findByID(Integer id){
        getSession();
        System.out.println("session");
        try {
            String HQL="FROM Dishes where cartId="+id;
            Query query=getSession().createQuery(HQL);
            List results=query.list();
            return (Dishes) results.get(0);
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
}
