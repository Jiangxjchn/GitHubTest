package Data.DAO;

import Data.po.User.Customer;
import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.NutritionIntakeDetail;
import Data.po.nutrition.UserDefinedNutrition;

import java.util.List;
import java.util.Map;

public class IntakeDetailDAO extends BaseDAO {

    public boolean save(List<NutritionIntakeDetail> nutritions){
        try{
            for(NutritionIntakeDetail each:nutritions){
                getSession().save(each);
            }
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(NutritionIntakeDetail nutritionIntakeDetail){
        try{
            getSession().update(nutritionIntakeDetail);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean del(NutritionIntakeDetail nutrition){
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
