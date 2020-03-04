package Data.DAO;

import Data.po.User.Customer;
import Data.po.nutrition.UserDefinedNutrition;

import java.util.List;

public class UserDefNutDAO extends BaseDAO {

    public boolean save(List<UserDefinedNutrition> nutritions){
        try{
            for(UserDefinedNutrition each:nutritions){
                System.out.println(each);
                System.out.println(each.getId());
                getSession().save(each);
                System.out.println(each.getId());
            }
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(UserDefinedNutrition userDefinedNutrition){
        try{
            getSession().update(userDefinedNutrition);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean del(UserDefinedNutrition nutrition){
        try{
            getSession().delete(nutrition);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
