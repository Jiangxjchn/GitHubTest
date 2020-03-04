package Data.po.nutrition;

import Data.po.goods.Dish;

import java.util.Objects;


public class NutritionIntakeDetail {
    private int id;
    private String time;
    private Integer num;
    private Double intakeRate;
    private Integer dishId;
    private Dish dish;
    private Integer intakeId;
    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(Integer intakeId) {
        this.intakeId = intakeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getIntakeRate() {
        return intakeRate;
    }

    public void setIntakeRate(Double intakeRate) {
        this.intakeRate = intakeRate;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritionIntakeDetail that = (NutritionIntakeDetail) o;
        return id == that.id &&
                Objects.equals(time, that.time) &&
                Objects.equals(num, that.num) &&
                Objects.equals(intakeRate, that.intakeRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, num, intakeRate);
    }
}
