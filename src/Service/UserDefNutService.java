package Service;

import Data.DAO.IntakeDetailDAO;
import Data.DAO.NutritionIntakeDAO;
import Data.DAO.UserDefNutDAO;
import Data.po.User.Customer;
import Data.po.goods.Dish;
import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.NutritionIntakeDetail;
import Data.po.nutrition.UserDefinedNutrition;

import java.util.List;
import java.util.Map;

public class UserDefNutService {
    private UserDefNutDAO userDefNutDAO;
    private NutritionIntakeDAO nutritionIntakeDAO;
    private IntakeDetailDAO intakeDetailDAO;

    public boolean add(List<UserDefinedNutrition> nutritions, NutritionIntake nutritionIntake, String time) {
        int intakeID = nutritionIntake.getId();
        for (UserDefinedNutrition each : nutritions) {
            each.setIntakeID(intakeID);
            each.setTime(time);
        }
        if (userDefNutDAO.save(nutritions)) {
            Map<Integer, UserDefinedNutrition> userDefinedNutritionMap = nutritionIntake.getUserDefinedNutritionMap();

            for (UserDefinedNutrition each : nutritions) {
                System.out.println("我的"+each.getId());
                userDefinedNutritionMap.put(each.getId(), each);
                nutritionIntake.addSuger(each.getSugar());
                nutritionIntake.addProtein(each.getProtein());
                nutritionIntake.addNa(each.getNa());
                nutritionIntake.addFat(each.getFat());
                nutritionIntake.addDf(each.getDf());
                nutritionIntake.addCalorie(each.getCalorie());
            }
            nutritionIntakeDAO.update(nutritionIntake);
            return true;
        } else {
            return false;
        }
    }

    public boolean upd(UserDefinedNutrition from, UserDefinedNutrition to, NutritionIntake nutritionIntake) {
        if (userDefNutDAO.update(to)) {
            Map<Integer, UserDefinedNutrition> userDefinedNutritionMap = nutritionIntake.getUserDefinedNutritionMap();
            userDefinedNutritionMap.put(to.getId(), to);
            System.out.println(to);
            System.out.println(from);
            nutritionIntake.addSuger(to.getSugar() - from.getSugar());
            nutritionIntake.addProtein(to.getProtein() - from.getProtein());
            nutritionIntake.addNa(to.getNa() - from.getNa());
            nutritionIntake.addFat(to.getFat() - from.getFat());
            nutritionIntake.addDf(to.getDf() - from.getDf());
            nutritionIntake.addCalorie(to.getCalorie() - from.getCalorie());
            nutritionIntakeDAO.update(nutritionIntake);
            return true;
        } else {
            return false;
        }
    }

    public boolean del(UserDefinedNutrition nutrition, NutritionIntake nutritionIntake) {
        if (userDefNutDAO.del(nutrition)) {
            Map<Integer, UserDefinedNutrition> userDefinedNutritionMap = nutritionIntake.getUserDefinedNutritionMap();
            userDefinedNutritionMap.remove(nutrition.getId());
            nutritionIntake.addSuger(-nutrition.getSugar());
            nutritionIntake.addProtein(-nutrition.getProtein());
            nutritionIntake.addNa(-nutrition.getNa());
            nutritionIntake.addFat(-nutrition.getFat());
            nutritionIntake.addDf(-nutrition.getDf());
            nutritionIntake.addCalorie(-nutrition.getCalorie());
            nutritionIntakeDAO.update(nutritionIntake);
            return true;
        }
        return false;
    }
    public Customer alterNutionIntake(Customer customer,List<Integer> id,List<Double> rate,String time){
        NutritionIntakeDetail nutritionIntakeDetail;
        Map<Integer, NutritionIntakeDetail> nutritionIntakeDetailMap;
        Map<String, NutritionIntake> nutritionIntakeMap=customer.getNutritionIntakeMap();
        Dish dish;
        NutritionIntake nutritionIntake=nutritionIntakeMap.get(time);
        if(nutritionIntake==null){
            nutritionIntake=new NutritionIntake(time, customer.getAccount());
            nutritionIntakeMap.put(time,nutritionIntake);
        }
        nutritionIntakeDetailMap=nutritionIntake.getNutritionIntakeDetailMap();
        for(int i=0;i<id.size();i++){
            nutritionIntakeDetail=nutritionIntakeDetailMap.get(id.get(i));
            if(rate.get(i)<0){
                rate.set(i,0.0);
            }
            else if(rate.get(i)>1){
                rate.set(i,1.0);
            }
            double rateChange=rate.get(i)-nutritionIntakeDetail.getIntakeRate();
            dish=nutritionIntakeDetail.getDish();
            nutritionIntakeDetail.setIntakeRate(rate.get(i));
            intakeDetailDAO.update(nutritionIntakeDetail);
            nutritionIntake.addCalorie(rateChange*dish.getCalorie());
            nutritionIntake.addDf(rateChange*dish.getDf());
            nutritionIntake.addFat(rateChange*dish.getFat());
            nutritionIntake.addNa(rateChange*dish.getNa());
            nutritionIntake.addProtein(rateChange*dish.getProtein());
            nutritionIntake.addSuger(rateChange*dish.getSugar());
        }
        nutritionIntakeDAO.update(nutritionIntake);
        return customer;
    }
    public UserDefNutDAO getUserDefNutDAO() {
        return userDefNutDAO;
    }

    public NutritionIntakeDAO getNutritionIntakeDAO() {
        return nutritionIntakeDAO;
    }

    public void setNutritionIntakeDAO(NutritionIntakeDAO nutritionIntakeDAO) {
        this.nutritionIntakeDAO = nutritionIntakeDAO;
    }

    public void setUserDefNutDAO(UserDefNutDAO userDefNutDAO) {
        this.userDefNutDAO = userDefNutDAO;
    }

    public IntakeDetailDAO getIntakeDetailDAO() {
        return intakeDetailDAO;
    }

    public void setIntakeDetailDAO(IntakeDetailDAO intakeDetailDAO) {
        this.intakeDetailDAO = intakeDetailDAO;
    }
}
