package Data.DAO;

import Data.po.goods.Order;

public class OrderDAO extends BaseDAO implements InterfaceDAO<Order> {

    @Override
    public boolean update(Order o) {
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
    public boolean delete(Order o) {
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
    public boolean save(Order o) {
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
