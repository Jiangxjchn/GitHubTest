package Data.po.User;

import Data.po.goods.Dish;
import Data.po.goods.Dishes;
import Data.po.goods.Order;
import Data.po.goods.OrderDetail;
import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.NutritionIntakeDetail;
import Data.po.nutrition.UserDefinedNutrition;

import java.text.SimpleDateFormat;
import java.util.*;

public class Customer extends BaseUser {

    private String nickname;
    private Double balance;
    private Double height;
    private Double weight;
    private Boolean gender;
    private Integer def_address;
    private String phone;
    //private Set<Address> addresses = new HashSet<>(0);
    //private Set<Dishes> ShoppingCart = new HashSet<>(0);
    private Map<Integer, Dishes> shoppingCart = new HashMap<>();
    //private Set<Order> orders=new HashSet<>(0);
    private Map<String, Order> orders = new TreeMap<>();
    private Map<Integer, Address> addresses = new HashMap<>();
    private Map<String, NutritionIntake> nutritionIntakeMap = new HashMap<>(0);

    private List<NutritionIntake> nutritionIntakes;
    private String nowDate;
    private List<String> dates;

    public void addOrder(Order order) {
        this.orders.put(order.getId(), order);
    }

    public double calorieRecommend() {
        try {
            double num = 1500;
            if (gender) num += weight * 10;
            else num += weight * 9;
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double sugerRecommend() {
        try {
            double num = 100;
            if (gender) num += weight * 2;
            else num += weight * 1.5;
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double fatRecommend() {
        return calorieRecommend() / 36.0;
    }

    public double DFRecommend() {
        return 26;
    }

    public double proteinRecommend() {
        try {
            double num = 0;
            if (gender) num += weight * 1.0;
            else num += weight * 0.8;
            return num;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double naRecommend() {
        return 6;
    }

    public double todaySuger() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        if (nutritionIntake == null) return 0;
        else return nutritionIntake.getSugar();
    }

    public double todayFat() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        if (nutritionIntake == null) return 0;
        else return nutritionIntake.getFat();
    }

    public double todayProtein() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        if (nutritionIntake == null) return 0;
        else return nutritionIntake.getProtein();
    }
    public Map<Integer,UserDefinedNutrition> takeUserDefined(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        return nutritionIntakeMap.get(time).getUserDefinedNutritionMap();
    }
    public double todayDF() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        if (nutritionIntake == null) return 0;
        else return nutritionIntake.getDf();
    }

    public double todayNa() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        if (nutritionIntake == null) return 0;
        else return nutritionIntake.getNa();
    }

    public List<Double> lastWeekCalorie() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat sdf2=new SimpleDateFormat("MM/dd");
        String time = sdf.format(date);
        String time2;
        List<Double> list = new ArrayList<>(0);
        NutritionIntake nutritionIntake;
        if (time.equals(nowDate) && nutritionIntakes != null) {
            for (NutritionIntake each : nutritionIntakes) {
                list.add(each.getCalorie());
            }
        } else {
            nowDate = sdf.format(date);
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -6);
            dates = new ArrayList<>(0);
            nutritionIntakes = new ArrayList<>(0);
            for (int i = 0; i < 7; i++) {
                time = sdf.format(calendar.getTime());
                time2 = sdf.format(calendar.getTime());
                dates.add("\'" + time2 + "\'");
//                System.out.println(time2);
//                System.out.println(time);
                nutritionIntake = nutritionIntakeMap.get(time);
                if (nutritionIntake == null) {
                    list.add(0.0);
                    nutritionIntakes.add(new NutritionIntake());
                } else {
                    nutritionIntakes.add(nutritionIntake);
                    list.add(nutritionIntake.getCalorie());
                }
                calendar.add(calendar.DAY_OF_MONTH, 1);
            }
        }
        return list;
    }

    public List<String> lastWeekDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        if (time.equals(nowDate) == false || dates == null) {
            lastWeekCalorie();
        }
//        for(int i=0;i<dates.size();i++){
//            System.out.println(dates.get(i));
//        }
//        System.out.println(dates);
        return dates;
    }

    public Map take(String time) {
        //String time=nowDate;

        time = time.substring(1, 11);
//        System.out.println("sdf" + time);
//        System.out.println(nutritionIntakeMap.get(time));
//        System.out.println(nutritionIntakeMap.get(time).getCalorie());
        Map<Integer, NutritionIntakeDetail> map = nutritionIntakeMap.get(time).getNutritionIntakeDetailMap();
//        System.out.println(map);
        return map;
    }

    public Customer() {
    }
//    public Set<Dishes> getShoppingCart() {
//        return ShoppingCart;
//    }
//
//    public void setShoppingCart(Set<Dishes> shoppingCart) {
//        ShoppingCart = shoppingCart;
//    }

    public Map<Integer, Dishes> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Map<Integer, Dishes> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


//    public Set<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(Set<Address> addresses) {
//        this.addresses = addresses;
//    }

    public Map<Integer, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<Integer, Address> addresses) {
        this.addresses = addresses;
    }


//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }


    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    public Map<String, NutritionIntake> getNutritionIntakeMap() {
        return nutritionIntakeMap;
    }

    public void setNutritionIntakeMap(Map<String, NutritionIntake> nutritionIntakeMap) {
        this.nutritionIntakeMap = nutritionIntakeMap;
    }


    public Integer getDef_address() {
        return def_address;
    }

    public void setDef_address(Integer def_address) {
        this.def_address = def_address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double heignt) {
        this.height = heignt;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Dishes findInShoppingCart(Integer Id,String account) {
        for(Dishes temp:shoppingCart.values()){
            if(temp.getDishId().equals(Id)&&temp.getAccount().equals(account))return temp;
        }
        return null;
    }

    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(nickname, customer.nickname) &&
                Objects.equals(balance, customer.balance) &&
                Objects.equals(height, customer.height) &&
                Objects.equals(weight, customer.weight) &&
                Objects.equals(gender, customer.gender) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(def_address, customer.def_address) &&
                Objects.equals(addresses, customer.addresses) &&
                Objects.equals(shoppingCart, customer.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nickname, balance, height, weight, gender, phone, def_address, addresses, shoppingCart);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Customer{" +
                "nickname='" + nickname + '\'' +
                ", balance=" + balance +
                ", height=" + height +
                ", weight=" + weight +
                ", gender=" + gender +
                ", id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", def_address='" + def_address + '\'' +
                '}');
//        for (Address temp : addresses) {
//            string.append(temp.toString());
//        }
        string.append('\n');
        for (Address temp : addresses.values()) {
            string.append(temp.toString());
        }
//        for (Dishes temp : ShoppingCart) {
//            string.append(temp.toString());
//        }
        string.append('\n');
        for (Dishes temp : shoppingCart.values()) {
            string.append(temp.toString());
        }
//        for (Order temp: orders){
//            string.append(temp.toString());
//        }
        string.append('\n');
        for (Order temp : orders.values()) {
            string.append(temp.toString());
        }
        return string.toString();
    }

}
