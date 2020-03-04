package Action;

import Aspect.DishNotEnoughException;
import Aspect.MoneyNotEnoughException;
import Data.po.User.Customer;
import Data.po.User.TopupDetail;
import Data.po.goods.Comment;
import Data.po.goods.Dish;
import Data.po.goods.Dishes;
import Service.AdminService;
import Service.CustomerService;
import Service.IUserService;
import Service.TopupService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerAction extends ActionSupport {
    private Customer customer;
    private CustomerService customerService;
    private AdminService adminService;
    private Dishes dishes;
    private Dish dish;
    private Map<String, Object> request, session;
    private List<Integer> orderDishes;
    private List<Integer> chooseDishes;
    private Integer addressId;
    private List<Dish> alldishes;
    private Comment comment;
    private TopupDetail topupdetail;
    private TopupService topupService;
    private List list = new ArrayList();

    @SuppressWarnings("unchecked")
    public CustomerAction() {
        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        request = (Map<String, Object>) actionContext.get("request");
    }

    public TopupDetail getTopupdetail() {
        return topupdetail;
    }

    public void setTopupdetail(TopupDetail topupdetail) {
        this.topupdetail = topupdetail;
    }

    public TopupService getTopupService() {
        return topupService;
    }

    public void setTopupService(TopupService topupService) {
        this.topupService = topupService;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setAlldishes(List<Dish> alldishes) {
        this.alldishes = alldishes;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public IUserService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String login() throws Exception {
        customer = customerService.login(customer);
        if (customer != null) {
            alldishes = customerService.getAllDishes();
            System.out.println(alldishes);
            session.put("alldishes", alldishes);
            session.put("customer", customer);
            return "success";
        } else {
            return "fail";
        }
    }

    public String orderDishes() throws Exception {
        customer = (Customer) session.get("customer");
        if (chooseDishes == null || chooseDishes.size() == 0) {
            return "dontChooseDishes";
        }
        customer = (customerService).orderDishes(chooseDishes, customer);
        alldishes = customerService.getAllDishes();
        session.put("customer", customer);
        session.put("alldishes", alldishes);
        return "success";
    }

    public String alterInfo() throws Exception {
        Customer cus = (Customer) session.get("customer");
        cus.setGender(customer.getGender());
        cus.setNickname(customer.getNickname());
        cus.setHeight(customer.getHeight());
        cus.setWeight(customer.getWeight());
        customer = customerService.alterInfo(cus);
        if (cus == customer) return "success";
        else {
            System.out.println(false);
            session.put("customer", customer);
            addActionError("用户信息修改失败");
            return "fail";
        }
    }

    public String placeAnOrder() throws Exception {
        try {
            if (orderDishes == null) {
                return "dontChooseDishes";
            }
            //System.out.println(orderDishes);
            System.out.println("---------------------------------------------------------------------------------------");
            customer = (Customer) session.get("customer");
            customerService.PlaceAnOrder(customer, orderDishes, addressId);
            alldishes = customerService.getAllDishes();
            customer = customerService.login(customer);
            session.put("customer", customer);
            session.put("alldishes", alldishes);
            return "success";
        } catch (DishNotEnoughException ed) {
            ed.printStackTrace();
            session.put("dishNotEnough", ed.getMessage());
            alldishes = customerService.getAllDishes();
            customer = customerService.login(customer);
            session.put("customer", customer);
            session.put("alldishes", alldishes);
            return "dishNotEnough";
        } catch (MoneyNotEnoughException e) {
            e.printStackTrace();
            session.put("moneyNotEnough", e.getMessage());
            alldishes = customerService.getAllDishes();
            customer = customerService.login(customer);
            session.put("customer", customer);
            session.put("alldishes", alldishes);
            return "moneyNotEnough";
        }

    }

    public String topupMoney() throws Exception {
        try {
            Customer cus = (Customer) session.get("customer");
            topupService.insert(cus, customer.getBalance());
            cus = (customerService).topupMoney(cus, customer);
            customer = customerService.alterInfo(cus);
            session.put("customer", customer);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    public String findTopup() {
        list = topupService.findByHql();
        System.out.println(list);
        return "success";
    }

    public String findTopupById() {
        Customer cus = (Customer) session.get("customer");
        System.out.println("Action" + cus.getAccount());
        list = topupService.findById(cus);
        System.out.println("Action list" + list);
        return "success";
    }

    public String ShowComment() throws Exception {

        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        try {


            Dish dishh = (Dish) session.get("dish");
            System.out.println(dish.getId() + " " + comment.getDetail() + " " + comment.getCustomer());
            dishh = (customerService).ShowComment(dish, comment);
            //	System.out.println("pppppppppppppppppp"+"  "+dishh.getComments().size());
            alldishes = (List<Dish>) session.get("alldishes");
            session.put("dish", dishh);
            for (int i = 0; i < alldishes.size(); i++) {

                if (alldishes.get(i).getId() == dishh.getId()) {
                    alldishes.set(i, dishh);
                }
            }
            session.put("alldishes", alldishes);
            session.put("tip", "添加评论成功");
            //	session.put("customer", session.get(customer));
            return "success";
        } catch (Exception e) {
            System.out.println("aaaaaaaaaaaaa");
            System.out.println(e);
            session.put("tip", "您已评论过两次，无法再次评论");

            return "fail";
        }


    }


    public String Dishsort1() {
        try {
            alldishes = customerService.getAllDishes();
            session.put("alldishes", alldishes);
            //	session.put("customer", session.get(customer));
            return "success";
        } catch (Exception e) {
            return "fail";
        }


    }


    public String Dishsort2() {
        try {
            alldishes = customerService.getAllDishes2();
            session.put("alldishes", alldishes);
            //	session.put("customer", session.get(customer));
            return "success";
        } catch (Exception e) {
            return "fail";
        }


    }

    public List<Integer> getOrderDishes() {
        return orderDishes;
    }

    public void setOrderDishes(List<Integer> orderDishes) {
        this.orderDishes = orderDishes;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public void setChooseDishes(List<Integer> chooseDishes) {
        this.chooseDishes = chooseDishes;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
