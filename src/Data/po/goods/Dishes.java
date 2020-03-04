package Data.po.goods;

import Data.po.User.Customer;

import java.util.Objects;

public class Dishes {
    private Integer cartId;
    private Integer dishId;
    private String account;
    //private CID_DID_PK pk;
    private Integer num;
    private Dish dish;
    private Customer customer;

    public Dishes() {
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public CID_DID_PK getPk() {
//        return pk;
//    }
//
//    public void setPk(CID_DID_PK pk) {
//        this.pk = pk;
//    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dishes = (Dishes) o;
        return Objects.equals(dishId, dishes.dishId) &&
                Objects.equals(account, dishes.account) &&
                Objects.equals(num, dishes.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash( dishId, account, num);
    }

    @Override
    public String toString() {
        if (dish == null) return "Dishes{" +
                "cartId=" + cartId +
                "dishId=" + dishId +
                ", account='" + account + '\'' +
                ", num=" + num + ",dish is null" +
                '}';
        return "Dishes{" +
                "cartId=" + cartId +
                "dishId=" + dishId +
                ", account='" + account + '\'' +
                ", num=" + num +
                '}' + dish.toString();
    }

    //    @Override
//    public String toString() {
//        return "Dishes{" +
//                "pk=" + pk +
//                ", num=" + num +
//                ", customer=" + customer +
//                '}';
//    }
}
