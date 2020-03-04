package Service;

import Data.DAO.DishDAO;
import Data.DAO.StaffDao;
import Data.po.User.Staff;
import Data.po.goods.Dish;
import Data.po.goods.Menu;
import SpringContext.SpringMain;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminService extends SpringMain implements IUserService<Staff> {
    private StaffDao staffDAO ;
    private DishDAO dishDAO ;
    private List<Menu> menus ;
    private Menu menu;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override

    public Staff login(Staff user) {
        List results=staffDAO.findByID(user.getAccount());
        if (results.isEmpty()) return null;
        else {
            return (Staff) results.get(0);
        }
    }

    public boolean changeMenu(List<Double> prize, List<Integer> num){
        for(int i=0;i<menus.size();i++){
            System.out.println(prize.get(i));
            Menu menu=menus.get(i) ;
            if(true){
                menu.setPrize(prize.get(i));
                menu.setNum(num.get(i));
                if(!dishDAO.updateInMenu(menu)) return false;
            }
            else if(menu.getPrize()!=0){
//                if(!dishDAO.deleteInMenu(menu)) return false ;

            }
        }
        return true ;
    }
    public List<Menu> findMenu(){
        menus.clear();
        Map<Integer, Boolean> used=new HashMap<>() ;
        List<Dish> indish=dishDAO.findAll() ;
        List<Menu> inmenu=dishDAO.findMenu() ;
        for (Menu dish:inmenu){
            used.put(dish.getId(),true) ;
        }
        for(Dish dish:indish){
            if(used.containsKey(dish.getId())){
                menu=dishDAO.findByIDInMenu(dish.getId()).get(0) ;
                menu.setDish(dish);
                menus.add(menu) ;
            }
            else{
                menu=new Menu();
                menu.setDish(dish);
                menu.setId(dish.getId());
                menu.setNum(0);
                menu.setPrize(0.0);
                menus.add(menu) ;
            }
        }
        return menus ;
    }
    public boolean addDish(List<String> name, List<Double> calorie, List<Double> fat, List<Double> suger, List<Double> df, List<Double> protein, List<Double> na, List<String> type, File[] uploadImage, String[] uploadImageFileName){
        String realPath= ServletActionContext.getServletContext().getRealPath("/image/dish");
        System.out.println(name.size());
        for(int i=0;i<name.size();i++){
            Dish temp=new Dish() ;
            temp.setName(name.get(i));
            temp.setCalorie(calorie.get(i));
            temp.setFat(fat.get(i));
            temp.setSugar(suger.get(i));
            temp.setDf(df.get(i));
            temp.setProtein(protein.get(i));
            temp.setNa(na.get(i));
            temp.setType(type.get(i));
            File file = new File(realPath);
            if(!file.exists())file.mkdirs();
            try {
                if(!uploadImageFileName[i].isEmpty()) {
                    File dest = new File(realPath,uploadImageFileName[i]);
                    FileUtils.copyFile(uploadImage[i], dest);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!uploadImageFileName[i].isEmpty()) temp.setImage(uploadImageFileName[i]);
            if(!dishDAO.save(temp)) return false ;
            Menu menu=new Menu() ;
            menu.setDish(temp);
            menu.setNum(0);
            menu.setPrize(0.0);
            menu.setId(temp.getId());
            if(!dishDAO.saveInMenu(menu)) return false ;
        }
        return true ;
    }
    public boolean setDish(Dish dish){
        return dishDAO.myupdate(dish) ;
    }
    public boolean delDish(Dish dish){
        return dishDAO.delete(dish) ;
    }
    public StaffDao getStaffDAO() {
        return staffDAO;
    }

    public void setStaffDAO(StaffDao staffDao) {
        this.staffDAO = staffDao;
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }


    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
