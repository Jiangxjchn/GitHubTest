package Data.DAO;
import Data.po.goods.DishInMenu;
import org.hibernate.SQLQuery;
import org.hibernate.query.Query;
import org.springframework.jdbc.object.SqlQuery;


public class DishInMenuDAO extends BaseDAO implements InterfaceDAO<DishInMenu>{
    @Override
    public boolean update(DishInMenu o) {
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
    public boolean delete(DishInMenu o) {
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
    public boolean save(DishInMenu o) {
        try{
            getSession().save(o);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public DishInMenu findByID(Integer ID){
        try {
            String HQL="FROM DishInMenu where id="+ID;
            Query query=getSession().createQuery(HQL);
            return (DishInMenu) query.list().get(0);
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public void executeSQLtoNum(Integer num,Integer id){
        String SQL="UPDATE restaurant.dbo.menu SET num ="+num+ " WHERE id = "+id;
        SQLQuery sqlQuery=getSession().createSQLQuery(SQL);
        sqlQuery.executeUpdate();
    }
}
