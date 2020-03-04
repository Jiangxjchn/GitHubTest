package Data.po.nutrition;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NutritionIntake {
    private int id;
    private String time;
    private Double calorie;
    private Double fat;
    private Double df;
    private Double protein;
    private Double na;
    private Double sugar;
    private String custID;
    private Map<Integer, NutritionIntakeDetail> nutritionIntakeDetailMap=new HashMap<>(0);
    private Map<Integer, UserDefinedNutrition> userDefinedNutritionMap=new HashMap<>(0);

    public NutritionIntake(){}
    public NutritionIntake(String time,String custID){
        this.time=time;
        this.custID=custID;
        calorie=fat=df=protein=na=sugar=0.0;
        nutritionIntakeDetailMap=new HashMap<>(0);
        userDefinedNutritionMap=new HashMap<>(0);
    }
    public Map<Integer, NutritionIntakeDetail> getNutritionIntakeDetailMap() {
        return nutritionIntakeDetailMap;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public void setNutritionIntakeDetailMap(Map<Integer, NutritionIntakeDetail> nutritionIntakeDetailMap) {
        this.nutritionIntakeDetailMap = nutritionIntakeDetailMap;
    }

    public Map<Integer, UserDefinedNutrition> getUserDefinedNutritionMap() {
        return userDefinedNutritionMap;
    }

    public void setUserDefinedNutritionMap(Map<Integer, UserDefinedNutrition> userDefinedNutritionMap) {
        this.userDefinedNutritionMap = userDefinedNutritionMap;
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

    public void addCalorie(Double calorie) { this.calorie+=calorie;}
    public void addFat(Double fat) { this.fat+=fat;}
    public void addDf(Double df) { this.df+=df;}
    public void addProtein(Double protein) { this.protein+=protein;}
    public void addNa(Double na) { this.na+=na;}
    public void addSuger(Double sugar) { this.sugar+=sugar;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritionIntake that = (NutritionIntake) o;
        return id == that.id &&
                Objects.equals(time, that.time) &&
                Objects.equals(calorie, that.calorie) &&
                Objects.equals(fat, that.fat) &&
                Objects.equals(df, that.df) &&
                Objects.equals(protein, that.protein) &&
                Objects.equals(na, that.na) &&
                Objects.equals(sugar, that.sugar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, calorie, fat, df, protein, na, sugar);
    }
}
