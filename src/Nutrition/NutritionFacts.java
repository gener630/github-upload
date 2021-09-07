package Nutrition;

import java.util.Date;
import java.util.Objects;

public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    //通过builder模式建立了一个NutritionFacts对象
    private static final NutritionFacts nutritionFacts=new Builder(240,8)
            .calories(100).sodium(35).carbohydrate(27).build();
    //通过公有构造器建立一个NutritionFacts对象
    private static final NutritionFacts nutritionFacts1=new NutritionFacts(240,8,100,0,35,27);
    public static NutritionFacts getInstance(){
        return nutritionFacts;
    }

    public static class Builder{
        private final int servingSize;
        private final int servings;
        private int calories=0;
        private int fat=0;
        private int sodium=0;
        private int carbohydrate=0;
        public Builder(int servingSize,int servings){
            this.servingSize=servingSize;
            this.servings=servings;
        }
        public Builder calories(int val){
            calories=val;
            return this;
        }
        public Builder fat(int val){
            fat=val;
            return this;
        }
        public Builder sodium(int val){
            sodium=val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate=val;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }
    private NutritionFacts(Builder builder){
        servingSize=builder.servingSize;
        servings=builder.servings;
        calories= builder.calories;
        fat= builder.fat;;
        sodium= builder.sodium;;
        carbohydrate= builder.carbohydrate;;
    }
    public NutritionFacts(int servingSize,int servings,int calories,int fat,int sodium,int carbohydrate){
        this.servingSize=servingSize;
        this.servings=servings;
        this.calories=calories;
        this.fat=fat;
        this.sodium=sodium;
        this.carbohydrate=carbohydrate;
    }
    public static void main(String args[]){
    }
}
