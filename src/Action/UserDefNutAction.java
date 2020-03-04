package Action;

import Data.po.User.Customer;
import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.NutritionIntakeDetail;
import Data.po.nutrition.UserDefinedNutrition;
import Service.CustomerService;
import Service.UserDefNutService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.text.SimpleDateFormat;
import java.util.*;

public class UserDefNutAction extends ActionSupport {
    private Map<String, Object> session;
    private UserDefNutService userDefNutService;
    private int id;
    private List<String> name;
    private List<Double> fat;
    private List<Double> df;
    private List<Double> protein;
    private List<Double> na;
    private List<Double> sugar;
    private List<Double> calorie;
    private Customer customer;
    private String time;

    public UserDefNutAction() {
        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
    }
    void check(List list){
        for(int i=0;i<list.size();i++){
            if((double)list.get(i)<0)list.set(i,0.0);
        }
    }
    public String addUserDefine() throws Exception{
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        Customer customer = (Customer) session.get("customer");
        Map<String, NutritionIntake> nutritionIntakeMap = customer.getNutritionIntakeMap();
        List<UserDefinedNutrition> nutritions = new ArrayList<>(0);
        UserDefinedNutrition userDefinedNutrition;
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        check(fat);check(df);check(na);check(protein);check(sugar);check(calorie);
        for (int i = 0; i < name.size(); i++) {
            userDefinedNutrition = new UserDefinedNutrition();
            userDefinedNutrition.setTime(time);
            userDefinedNutrition.setFat(fat.get(i));
            userDefinedNutrition.setDf(df.get(i));
            userDefinedNutrition.setNa(na.get(i));
            userDefinedNutrition.setName(name.get(i));
            userDefinedNutrition.setProtein(protein.get(i));
            userDefinedNutrition.setSugar(sugar.get(i));
            userDefinedNutrition.setCalorie(calorie.get(i));
            userDefinedNutrition.setIntakeID(nutritionIntake.getId());

            nutritions.add(userDefinedNutrition);
        }
        if (userDefNutService.add(nutritions, nutritionIntake, time)) {
            return "success";
        }
        return "fail";
    }

    public String updUserDefine() throws Exception{
        Customer customer = (Customer) session.get("customer");
        Map<String, NutritionIntake> nutritionIntakeMap = customer.getNutritionIntakeMap();
        UserDefinedNutrition userDefinedNutrition;
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        System.out.println(time);
        userDefinedNutrition = new UserDefinedNutrition();
        userDefinedNutrition.setId(id);
        userDefinedNutrition.setIntakeID(nutritionIntake.getId());
        userDefinedNutrition.setTime(time);
        check(fat);check(df);check(na);check(name);check(protein);check(sugar);check(calorie);
        userDefinedNutrition.setFat(fat.get(0));
        userDefinedNutrition.setDf(df.get(0));
        userDefinedNutrition.setNa(na.get(0));
        userDefinedNutrition.setName(name.get(0));
        userDefinedNutrition.setProtein(protein.get(0));
        userDefinedNutrition.setSugar(sugar.get(0));
        userDefinedNutrition.setCalorie(calorie.get(0));
        userDefinedNutrition.setIntakeID(nutritionIntake.getId());
        if (userDefNutService.upd(nutritionIntake.getUserDefinedNutritionMap().get(id),userDefinedNutrition, nutritionIntake)) {
            return "success";
        }
        return "fail";
    }
    public String delUserDefine() throws Exception{
        Customer customer = (Customer) session.get("customer");
        Map<String, NutritionIntake> nutritionIntakeMap = customer.getNutritionIntakeMap();
        UserDefinedNutrition userDefinedNutrition;
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        userDefinedNutrition = nutritionIntake.getUserDefinedNutritionMap().get(id);
        if (userDefNutService.del(userDefinedNutrition, nutritionIntake)) {
            return "success";
        }
        return "fail";
    }

    public UserDefNutService getUserDefNutService() {
        return userDefNutService;
    }

    public void setUserDefNutService(UserDefNutService userDefNutService) {
        this.userDefNutService = userDefNutService;
    }

    public List<Double> getCalorie() {
        return calorie;
    }

    public void setCalorie(List<Double> calorie) {
        this.calorie = calorie;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Double> getFat() {
        return fat;
    }

    public void setFat(List<Double> fat) {
        this.fat = fat;
    }

    public List<Double> getDf() {
        return df;
    }

    public void setDf(List<Double> df) {
        this.df = df;
    }

    public List<Double> getProtein() {
        return protein;
    }

    public void setProtein(List<Double> protein) {
        this.protein = protein;
    }

    public List<Double> getNa() {
        return na;
    }

    public void setNa(List<Double> na) {
        this.na = na;
    }

    public List<Double> getSugar() {
        return sugar;
    }

    public void setSugar(List<Double> sugar) {
        this.sugar = sugar;
    }
}
