package Action;

import Data.po.User.Staff;
import Data.po.goods.Dish;
import Service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;
import java.util.List;
import java.util.Map;

public class AdminAction extends ActionSupport  {
    private List<String> name ;
    private List<Double> calorie ;
    private List<Double> fat ;
    private List<Double> suger ;
    private List<Double> df ;
    private List<Double> protein ;
    private List<Double> na ;
    private List<String> type ;
    private Dish dish ;
    private Staff staff ;
    private AdminService adminService;
    private List<Double> prize ;
    private List<Integer> num ;
    private File[] uploadImage ;
    private String[] uploadImageContentType;
    private String[] uploadImageFileName;
    private Map<String, Object> request,session;
    public AdminAction() {
        ActionContext actionContext = ActionContext.getContext();
        session= actionContext.getSession();
    }

    public String login() throws Exception{
//        staff=adminService.login(staff) ;
//        if(staff!=null){
//            session.put("staff",staff) ;
//            session.put("dish",adminService.getMenus()) ;
//            return "success" ;
//        }
//        else return "fail" ;
        session.put("staff",staff) ;
        adminService.login(staff);
        session.put("dish",adminService.findMenu()) ;
        return "success" ;
    }

    public String addDish() throws Exception{
        if(adminService.addDish(name,calorie,fat,suger,df,protein,na,type,uploadImage,uploadImageFileName)) {
            session.put("dish",adminService.findMenu()) ;
            session.put("message","添加成功！") ;
            return "success" ;
        }
        else  {
            session.put("message","添加失败！") ;
            return "fail" ;
        }
    }

    public String changeMenu() throws Exception{
        if(adminService.changeMenu(prize,num)) {
            session.put("dish",adminService.findMenu()) ;
            session.put("message","修改菜单成功！") ;
            return  "success" ;
        }
        else {
            session.put("message","修改菜单失败！") ;
            return "false" ;
        }
    }
    public String setDish() throws Exception{
        if(adminService.setDish(dish)) {
            session.put("dish",adminService.findMenu()) ;
            session.put("message","更改菜品成功！") ;
            return "success" ;
        }
        session.put("message","更改菜品失败！") ;
        return "fail" ;
    }
    public String delDish() throws Exception{
        if(adminService.delDish(dish)) {
            session.put("dish",adminService.findMenu()) ;
            session.put("message","删除菜品成功！") ;
            return "success" ;
        }
        else {
            session.put("message","删除菜品失败！") ;
            return "fail" ;
        }
    }


    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public List<Double> getPrize() {
        return prize;
    }

    public void setPrize(List<Double> prize) {
        this.prize = prize;
    }

    public List<Integer> getNum() {
        return num;
    }

    public void setNum(List<Integer> num) {
        this.num = num;
    }


    public String[] getUploadImageContentType() {
        return uploadImageContentType;
    }

    public void setUploadImageContentType(String[] uploadImageContentType) {
        this.uploadImageContentType = uploadImageContentType;
    }

    public void setUploadImageFileName(String[] uploadImageFileName) {
        this.uploadImageFileName = uploadImageFileName;
    }

    public void setUploadImage(File[] uploadImage) {
        this.uploadImage = uploadImage;
    }
    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Double> getCalorie() {
        return calorie;
    }

    public void setCalorie(List<Double> calorie) {
        this.calorie = calorie;
    }

    public List<Double> getFat() {
        return fat;
    }

    public void setFat(List<Double> fat) {
        this.fat = fat;
    }

    public List<Double> getSuger() {
        return suger;
    }

    public void setSuger(List<Double> suger) {
        this.suger = suger;
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

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Dish getDish() {
        return dish;
    }
}
