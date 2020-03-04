package Data.po.goods;

import java.util.Objects;

public class OrderDetail {
    private String DetailId;
    private String orderId;
    private Integer dishId;
    private Integer num;
    private Dish dish;

    public String getDetailId() {
        return DetailId;
    }

    public void setDetailId(String detailId) {
        DetailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, dishId, num);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "DetailId='" + DetailId + '\'' +
                "orderId='" + orderId + '\'' +
                ", dishId='" + dishId + '\'' +
                ", num=" + num +
                ", dish=" + dish.toString() +
                '}';
    }
}
