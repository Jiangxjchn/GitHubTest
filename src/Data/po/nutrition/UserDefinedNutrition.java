package Data.po.nutrition;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.Objects;

public class UserDefinedNutrition {
    private int id;
    private String time;
    private String name;
    private Double fat;
    private Double df;
    private Double protein;
    private Double na;
    private Double sugar;
    private int intakeID;
    private Double calorie;

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public int getIntakeID() {
        return intakeID;
    }

    public void setIntakeID(int intakeID) {
        this.intakeID = intakeID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
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

    public Double getSugar() {
        return sugar;
    }

    public void setSugar(Double sugar) {
        this.sugar = sugar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDefinedNutrition that = (UserDefinedNutrition) o;
        return id == that.id &&
                Objects.equals(time, that.time) &&
                Objects.equals(name, that.name) &&
                Objects.equals(fat, that.fat) &&
                Objects.equals(df, that.df) &&
                Objects.equals(protein, that.protein) &&
                Objects.equals(na, that.na) &&
                Objects.equals(sugar, that.sugar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, name, fat, df, protein, na, sugar);
    }

    @Override
    public String toString() {
        return "UserDefinedNutrition{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", fat=" + fat +
                ", df=" + df +
                ", protein=" + protein +
                ", na=" + na +
                ", sugar=" + sugar +
                ", intakeID=" + intakeID +
                ", calorie=" + calorie +
                '}';
    }
}
