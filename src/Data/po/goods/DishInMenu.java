package Data.po.goods;

import java.util.Objects;

public class DishInMenu {
    private int id;
    private Integer num;
    private Double prize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishInMenu that = (DishInMenu) o;
        return id == that.id &&
                Objects.equals(num, that.num) &&
                Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, prize);
    }

    @Override
    public String toString() {
        return "DishInMenu{" +
                "id=" + id +
                ", num=" + num +
                ", prize=" + prize +
                '}';
    }
}
