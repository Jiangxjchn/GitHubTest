package Data.po.goods;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Dish {
    private String name;
    private Integer id;
    private Double calorie;
    private Double fat;
    private Double sugar;
    private Double df;
    private Double protein;
    private Double na;
    private Integer salesNum;
    private Double applauseRate;
    private String image;
    private Double price;
    private Integer weight;
    private String type;
    private Dishes dishes;
    private DishInMenu dishInMenu;
    private Set comments = new HashSet(0);
    private Integer goodRate;
    public Integer getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(Integer goodRate) {
        this.goodRate = goodRate;
    }
    public Set getComments() {
        return comments;
    }

    public void setComments(Set comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Dish() {
    }

    public DishInMenu getDishInMenu() {
        return dishInMenu;
    }

    public void setDishInMenu(DishInMenu dishInMenu) {
        this.dishInMenu = dishInMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    public Double getDf() {
        return df;
    }

    public void setDf(Double df) {
        this.df = df;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getNa() {
        return na;
    }

    public void setNa(Double na) {
        this.na = na;
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public Double getApplauseRate() {
        return applauseRate;
    }

    public void setApplauseRate(Double applauseRate) {
        this.applauseRate = applauseRate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(id, dish.id) &&
                Objects.equals(calorie, dish.calorie) &&
                Objects.equals(fat, dish.fat) &&
                Objects.equals(sugar, dish.sugar) &&
                Objects.equals(df, dish.df) &&
                Objects.equals(protein, dish.protein) &&
                Objects.equals(na, dish.na) &&
                Objects.equals(salesNum, dish.salesNum) &&
                Objects.equals(weight, dish.weight) &&
                Objects.equals(type, dish.type) &&
                Objects.equals(applauseRate, dish.applauseRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, calorie, fat, sugar, df, protein, na, salesNum, applauseRate,price,weight,type);
    }

    @Override
    public String toString() {
        if(this.id ==null)return "null";
        return "Dish{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", calorie=" + calorie +
                ", fat=" + fat +
                ", sugar=" + sugar +
                ", df=" + df +
                ", protein=" + protein +
                ", na=" + na +
                ", salesNum=" + salesNum +
                ", weight=" + weight +
                ", applauseRate=" + applauseRate +
                ", price=" + price +
                ", image=" + image +
                ", type=" + type +
                ", DishInMenu=" + dishInMenu +
                '}';
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
