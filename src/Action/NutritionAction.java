package Action;

import Data.po.User.Customer;
import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.NutritionIntakeDetail;
import Service.CustomerService;
import Service.UserDefNutService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.components.ActionError;

import java.util.List;
import java.util.Map;

public class NutritionAction extends ActionSupport {
    private Map<String,Object> session;
    private UserDefNutService userDefNutService ;
    private String account;
    private String time;
    private List<Integer> key;
    private List<Double> intakeRate;
    public NutritionAction(){
        ActionContext actionContext=ActionContext.getContext();
        session=actionContext.getSession();
    }
    public String alterNutritionIntakeDetail() throws Exception{
        Customer customer= (Customer) session.get("customer");
        if(customer==null||customer.getAccount().equals(account)==false) {
            addActionError("用户未登录或用户名匹配失败，请重新登陆");
            return "fail";
        }
        time=time.substring(1,11);
        try {
            if(key==null||key.size()==0) return "success";
            userDefNutService.alterNutionIntake(customer,key,intakeRate,time);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

        return "success";
    }

    public UserDefNutService getUserDefNutService() {
        return userDefNutService;
    }

    public void setUserDefNutService(UserDefNutService userDefNutService) {
        this.userDefNutService = userDefNutService;
    }

    public List<Integer> getKey() {
        return key;
    }

    public void setKey(List<Integer> key) {
        this.key = key;
    }

    public List<Double> getIntakeRate() {
        return intakeRate;
    }

    public void setIntakeRate(List<Double> intakeRate) {
        this.intakeRate = intakeRate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
