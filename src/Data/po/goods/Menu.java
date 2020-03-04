package Data.po.goods;

import java.util.Objects;

public class Menu {
    private Dish dish ;
    private double prize ;
    private int num ;
    private int id;

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Double.compare(menu.prize, prize) == 0 &&
                num == menu.num &&
                id == menu.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, prize);
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "dish=" + dish +
                ", prize=" + prize +
                ", num=" + num +
                ", id=" + id +
                '}';
    }
}
