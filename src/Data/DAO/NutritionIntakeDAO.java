package Data.DAO;

import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.UserDefinedNutrition;
import org.hibernate.SQLQuery;

import java.util.List;
import java.util.Map;

public class NutritionIntakeDAO extends BaseDAO{
    public boolean save(NutritionIntake nutritionIntake){
        try{

                getSession().save(nutritionIntake);

            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
    public void updateSql(NutritionIntake nutritionIntake){
        String SQL="UPDATE restaurant.dbo.nutrition_intake SET calorie ="+nutritionIntake.getCalorie()
                +" , fat = "+nutritionIntake.getFat()+" , DF = "+nutritionIntake.getDf()
                +" , protein = "+nutritionIntake.getProtein()+" , Na = "+nutritionIntake.getNa()
                +" , sugar = "+nutritionIntake.getSugar()+" where id = "+nutritionIntake.getId();
        SQLQuery sqlQuery= getSession().createSQLQuery(SQL);
        sqlQuery.executeUpdate();
    }
    public boolean update(NutritionIntake nutritionIntake){
        try{
            updateSql(nutritionIntake);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
