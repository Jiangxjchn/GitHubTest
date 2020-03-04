package Data.po.goods;

import Data.po.User.Address;

import java.util.Date;
import java.util.*;

public class Order {
    private String id;
    private Date time;
    private Double price;
    private String account;
    private String deliveryman;
    private Integer addressId;
    private boolean finished;
    //private Set<OrderDetail> orderDetails=new HashSet<>(0);
    private Map<String,OrderDetail> orderDetails=new HashMap<>();
    public Order() {
    }

//    public Set<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(Set<OrderDetail> orderDetails) {
//        this.orderDetails = orderDetails;
//    }


    public Map<String, OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<String, OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String customer) {
        this.account = customer;
    }

    public String getDeliveryman() {
        return deliveryman;
    }

    public void setDeliveryman(String deliveryman) {
        this.deliveryman = deliveryman;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return finished == order.finished &&
                Objects.equals(id, order.id) &&
                Objects.equals(time, order.time) &&
                Objects.equals(price, order.price) &&
                Objects.equals(account, order.account) &&
                Objects.equals(deliveryman, order.deliveryman);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, price, account, deliveryman, finished);
    }

    @Override
    public String toString() {
        StringBuilder string  = new StringBuilder("Order{" +
                "id='" + id + '\'' +
                ", time=" + time +
                ", price=" + price +
                ", account='" + account + '\'' +
                ", deliveryman='" + deliveryman + '\'' +
                ", finished=" + finished +
                ", addressid=" + addressId +
                '}');
//        for (OrderDetail temp : orderDetails) {
//            string.append(temp.toString());
//        }
        for (OrderDetail temp: orderDetails.values()){
            string.append(temp.toString());
        }
        return string.toString();
    }
}
