package Service;

import Aspect.DishNotEnoughException;
import Aspect.MoneyNotEnoughException;
import Comparetor.DishComparetor;
import Comparetor.DishComparetor2;
import Data.DAO.*;
import Data.po.User.Customer;
import Data.po.goods.*;
import Data.po.nutrition.NutritionIntake;
import Data.po.nutrition.NutritionIntakeDetail;
import SpringContext.SpringMain;

import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerService implements IUserService<Customer> {
    private SpringMain springMain;
    private CustomerDAO customerDAO = null;
    private DishDAO dishDAO = null;
    private DishInMenuDAO dishInMenuDAO;
    private Order order;
    private DishesDAO dishesDAO;
    private OrderDetail orderDetail;
    private OrderDAO orderDAO;
    private CommentDAO commentDAO;
    private NutritionIntakeDAO nutritionIntakeDAO;
    private IntakeDetailDAO intakeDetailDAO;
    Map<Integer, Dishes> shoppingCart;
    Map<String, OrderDetail> ordersDetails;

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer login(Customer user) {
        List results = customerDAO.findByID(user.getAccount());
        if (results.isEmpty()) return null;
        else {
            Customer customer = (Customer) results.get(0);
            Map<String, NutritionIntake> nutritionIntakeMap = customer.getNutritionIntakeMap();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, -6);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            for (int i = 0; i < 7; i++) {
                String time = sdf.format(calendar.getTime());
                if (nutritionIntakeMap.get(time) == null) {
                    NutritionIntake nutritionIntake = new NutritionIntake(time, customer.getAccount());
                    nutritionIntakeMap.put(time, nutritionIntake);
                    nutritionIntakeDAO.save(nutritionIntake);
                }
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return customer;
        }
    }

    public Customer orderDishes(List<Integer> chooseDishes, Customer customer) {
        //Set<Dishes> shoppingCart=customer.getShoppingCart();
        shoppingCart = customer.getShoppingCart();
        for (Integer i : chooseDishes) {
            Dishes temp = customer.findInShoppingCart(i, customer.getAccount());
            //int num=dishes.getNum();
            if (temp != null) {
                temp.setNum(temp.getNum() + 1);
                dishDAO.updateSQLtoNumInCart(customer.getAccount(), i);
                //dishes.setNum();
            } else {
                Dish dish = dishDAO.findByID(i).get(0);
                temp = new Dishes();
                temp.setDish(dish);
                temp.setAccount(customer.getAccount());
                temp.setNum(1);
                temp.setDishId(dish.getId());
                temp.setCustomer(customer);
                dishDAO.insertSQLtoNumInCart(customer.getAccount(), i);

            }
            shoppingCart.put(temp.getDishId(), temp);
        }
        //shoppingCart.add(dishes);
        customer.setShoppingCart(shoppingCart);
        // customerDAO.saveOrUpdate(customer);
        return customerDAO.findByID(customer.getAccount()).get(0);
    }

    public void addNutrition(Order order, Customer customer, Date date) {
        Map<String, OrderDetail> orderDetails = order.getOrderDetails();
        Map<String, NutritionIntake> nutritionIntakeMap = customer.getNutritionIntakeMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String time = sdf.format(date);
        NutritionIntake nutritionIntake = nutritionIntakeMap.get(time);
        //获取用户今日摄入数据
        if (nutritionIntake == null) {
            nutritionIntake = new NutritionIntake(time, customer.getAccount());
            nutritionIntakeMap.put(time, nutritionIntake);
            nutritionIntakeDAO.save(nutritionIntake);
        }
        Map<Integer, NutritionIntakeDetail> nutritionIntakeDetailMap = nutritionIntake.getNutritionIntakeDetailMap();
        List<NutritionIntakeDetail> list = new ArrayList<>(0);
        //将订单表数据加入用户摄入明细表
        for (Map.Entry<String, OrderDetail> each : orderDetails.entrySet()) {
            NutritionIntakeDetail nutritionIntakeDetail = new NutritionIntakeDetail();
            nutritionIntakeDetail.setTime(time);
            nutritionIntakeDetail.setIntakeRate(0.8);
            nutritionIntakeDetail.setDish(each.getValue().getDish());
            nutritionIntakeDetail.setDishId(each.getValue().getDishId());
            nutritionIntakeDetail.setNum(each.getValue().getNum());
            nutritionIntakeDetail.setIntakeId(nutritionIntake.getId());
            list.add(nutritionIntakeDetail);
        }
        //如果用户明细表插入成功，则修改用户今日摄入
        if (intakeDetailDAO.save(list)) {
            for (NutritionIntakeDetail each : list) {
                nutritionIntakeDetailMap.put(each.getId(), each);
                nutritionIntake.addSuger(each.getDish().getSugar());
                nutritionIntake.addProtein(each.getDish().getProtein());
                nutritionIntake.addNa(each.getDish().getNa());
                nutritionIntake.addFat(each.getDish().getFat());
                nutritionIntake.addDf(each.getDish().getDf());
                nutritionIntake.addCalorie(each.getDish().getCalorie());
            }
            nutritionIntakeDAO.update(nutritionIntake);
        }
    }

    public void PlaceAnOrder(Customer customer, List<Integer> cartIds, Integer addressId)
            throws MoneyNotEnoughException,DishNotEnoughException {
        shoppingCart = customer.getShoppingCart();
        double price = 0;
        for (Integer cart_ids : cartIds) {
            Dishes dishes = shoppingCart.get(cart_ids);
            price += dishes.getNum() * dishes.getDish().getDishInMenu().getPrize();
        }
        System.out.println(price);
        if (customer.getBalance() >= price) {
            order.setAccount(customer.getAccount());
            order.setFinished(false);
            Date date = new Date();
            Date date1 =new Date();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
            String time = dateformat.format(date);
            order.setId(customer.getAccount() + time);
            order.setTime(date1);
            for (Integer cart_ids : cartIds) {
                Dishes dishes = shoppingCart.get(cart_ids);
                DishInMenu dishInMenu = dishInMenuDAO.findByID(dishes.getDishId());
                Dish dish = dishDAO.get(dishes.getDishId());
                if (dishInMenu.getNum() >= dishes.getNum()) {
                    shoppingCart.remove(cart_ids);
                    orderDetail = SpringMain.newOrderDetail();
                    orderDetail.setDetailId(order.getId() + dishes.getDishId().toString());
                    orderDetail.setNum(dishes.getNum());
                    orderDetail.setDishId(dishes.getDishId());
                    orderDetail.setOrderId(order.getId());
                    orderDetail.setDish(dishes.getDish());
                    dish.setSalesNum(orderDetail.getDish().getSalesNum() + dishes.getNum());
                    ordersDetails.put(orderDetail.getDetailId(), orderDetail);
                    dishesDAO.delete(dishes);
                    dishInMenu.setNum(dishInMenu.getNum() - dishes.getNum());
                    dish.setDishInMenu(dishInMenu);
                    dish.setDishes(dishes);
                    //dishDAO.update(dish);
                    dishDAO.executeSQLtoSale_num(dish.getSalesNum(), dish.getId());
                    System.out.println(dishInMenu);
                    dishInMenuDAO.executeSQLtoNum(dishInMenu.getNum(), dishInMenu.getId());

//                    dishInMenuDAO.delete(dishInMenu);
//                    dishInMenuDAO.save(dishInMenu);
//                    dishDAO.delete(dish);
//                    dishDAO.save(dish);
                } else {
                    throw new DishNotEnoughException("剩余的" + dishes.getDish().getName() + "不够，只剩下" + dishInMenu.getNum() + "份！");
                }
            }
            order.setPrice(price);
            order.setOrderDetails(ordersDetails);
            order.setAddressId(addressId);

            orderDAO.save(order);
            customer.setBalance(customer.getBalance() - price);
            customer.setShoppingCart(shoppingCart);
            customer.addOrder(order);
            addNutrition(order, customer, date);
            customerDAO.executeSQLtoMoney(customer.getBalance(), customer.getAccount());
            //customer=customerDAO.findByID(customer.getAccount()).get(0);
            //customerDAO.update(customer);
            //customerDAO.saveOrUpdate(customer);
        } else if (customer.getBalance() < price) {
            throw new MoneyNotEnoughException("余额不足，还差" + (price - customer.getBalance()) + "元");
        }

    }

    public List<Dish> getAllDishes() {
        List<Dish> alldish=dishDAO.findAll();

        Collections.sort(alldish,new DishComparetor());
        return alldish;
    }

    public List<Dish> getAllDishes2() {
        List<Dish> alldish=dishDAO.findAll();

        Collections.sort(alldish,new DishComparetor2());
        return alldish;
    }

    public Customer alterInfo(Customer customer) {
        if (customerDAO.update(customer)) {
            System.out.println(true);
            return customer;
        }
        return customerDAO.findByID(customer.getAccount()).get(0);
    }


    public Customer topupMoney(Customer customer, Customer cus) {
        customer.setBalance(customer.getBalance() + cus.getBalance());
        customerDAO.update(customer);
        return customer;
    }

    public Dish ShowComment(Dish dish, Comment comment) throws Exception {

        dish = (Dish) dishDAO.FindByID(dish.getId());

        Set<Comment> comments=dish.getComments();
        Integer num=0;
        for (Comment c : comments)
        {
            if (c.getCustomer().equals(comment.getCustomer())) num++;
        }

        if (num>=2) throw new Exception("您已评论过两次，无法再次评论");
        //comment.setId(3);
        comment.setDish(dish);
        dish.getComments().add(comment);
        System.out.println("gggggggggggggggggg");
        System.out.println(comment.getId() + " " + comment.getDetail() + " " + comment.getCustomer() + " " + comment.getDish().getId());

        //commentDAO.save(comment);
        dishDAO.update(dish);
        return dish;


    }

    public void setSpringMain(OrderDetail springMain) {
        this.orderDetail = springMain;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public DishDAO getDishDAO() {
        return dishDAO;
    }

    public DishInMenuDAO getDishInMenuDAO() {
        return dishInMenuDAO;
    }

    public void setDishInMenuDAO(DishInMenuDAO dishInMenuDAO) {
        this.dishInMenuDAO = dishInMenuDAO;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DishesDAO getDishesDAO() {
        return dishesDAO;
    }

    public void setDishesDAO(DishesDAO dishesDAO) {
        this.dishesDAO = dishesDAO;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }


    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Map<Integer, Dishes> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Map<Integer, Dishes> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    public Map<String, OrderDetail> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Map<String, OrderDetail> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public NutritionIntakeDAO getNutritionIntakeDAO() {
        return nutritionIntakeDAO;
    }

    public void setNutritionIntakeDAO(NutritionIntakeDAO nutritionIntakeDAO) {
        this.nutritionIntakeDAO = nutritionIntakeDAO;
    }

    public IntakeDetailDAO getIntakeDetailDAO() {
        return intakeDetailDAO;
    }

    public void setIntakeDetailDAO(IntakeDetailDAO intakeDetailDAO) {
        this.intakeDetailDAO = intakeDetailDAO;
    }
}
