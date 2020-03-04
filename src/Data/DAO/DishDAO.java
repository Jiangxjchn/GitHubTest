package Data.DAO;

import Data.po.goods.Dish;
import Data.po.goods.Menu;
import org.hibernate.SQLQuery;
import org.hibernate.query.Query;

import javax.persistence.Id;
import java.util.List;

public class DishDAO extends BaseDAO implements InterfaceDAO<Dish>{
    public Dish get(Integer ID){
        return  getSession().get(Dish.class, ID);
    }
    @Override
    public boolean delete(Dish dish){
        try{
            getSession().delete(dish);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public  boolean save(Dish dish){
        try{
            getSession().save(dish);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean update(Dish dish){
        try{
            System.out.println("//////"+dish);
            getSession().update(dish);
            System.out.println("//////"+dish);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Dish> findByID(Integer ID){
        try {
            String HQL="FROM Dish where id="+ID;
            Query query=getSession().createQuery(HQL);
            return query.list();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    public Dish FindByID(Integer ID){
        try {
            String HQL="FROM Dish where id="+ID;
            Query query=getSession().createQuery(HQL);
            List results=query.list();

            return (Dish) results.get(0);
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    public void executeSQLtoSale_num(Integer num,Integer id){
        String SQL="UPDATE restaurant.dbo.dish SET sales_num ="+num+ " WHERE id = "+id;
        SQLQuery sqlQuery= getSession().createSQLQuery(SQL);
        sqlQuery.executeUpdate();

    }
    public void updateSQLtoNumInCart(String account,Integer id){
        String SQL="UPDATE restaurant.dbo.shopping_cart SET num =num+"+1+ " WHERE dish_id = "+id+" and account='"+account+"'";
        SQLQuery sqlQuery= getSession().createSQLQuery(SQL);
        sqlQuery.executeUpdate();
    }
    public void insertSQLtoNumInCart(String account,Integer id){
        String SQL="insert into restaurant.dbo.shopping_cart(account, dish_id, num) VALUES ('"+account+"', "+id+", 1)";
        SQLQuery sqlQuery= getSession().createSQLQuery(SQL);
        sqlQuery.executeUpdate();
    }
    public boolean myupdate(Dish dish){
        try {
            String sql="update restaurant.dbo.dish set name='"+dish.getName()+"',calorie='"+dish.getCalorie()+"',fat='"+dish.getFat()+"',sugar='"+dish.getSugar()+"',DF='"+dish.getDf()+"',protein='"+dish.getProtein()+"',Na='"+dish.getNa()+"',type='"+dish.getType()+"' where id='"+dish.getId()+"'" ;
            SQLQuery query=getSession().createSQLQuery(sql) ;
            query.executeUpdate() ;
            return true ;
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean myupdate2(Dish dish){
        try {
            String sql="update restaurant.dbo.dish set name='"+dish.getName()+"',calorie='"+dish.getCalorie()+"',fat='"+dish.getFat()+"',sugar='"+dish.getSugar()+"',DF='"+dish.getDf()+"',protein='"+dish.getProtein()+"',Na='"+dish.getNa()+"',type='"+dish.getType()+ "',good_rate='"+dish.getGoodRate()+   "' where id='"+dish.getId()+"'" ;
            SQLQuery query=getSession().createSQLQuery(sql) ;
            query.executeUpdate() ;
            return true ;
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

    public  boolean updateInMenu(Menu menu){
        try{
            getSession().update(menu);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteInMenu(Menu menu){
        try{
            getSession().delete(menu);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Menu> findMenu(){
        try {
            String HQL="FROM Menu" ;
            Query query=getSession().createQuery(HQL) ;
            return  query.list();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Menu> findByIDInMenu(Integer ID){
        try {
            String HQL="FROM Menu where id="+ID;
            Query query=getSession().createQuery(HQL);
            return query.list();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Dish> findAll(){
        try {
            String HQL="FROM Dish" ;
            Query query=getSession().createQuery(HQL) ;
            return  query.list();
        }catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public  boolean saveInMenu(Menu menu){
        try{
            getSession().save(menu);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
