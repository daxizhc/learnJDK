package effective.java;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Chapter2 {

    //1、静态构造方法代替构造器
    @Test
    public void test1(){
        System.out.println(Boolean.valueOf(true));
    }

    //参数类型推导
    @Test
    public void test2(){
        Map<Integer, Long> testMap = MapUtil.newHashMap();
        System.out.println(testMap.size());
    }

    //2、builder模式
    @Test
    public void test3(){
        NutritionFacts nutritionFacts =
        new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(nutritionFacts);
    }

    //3、单例模式
    @Test
    public void test4(){
        SingletonOne singletonOne = SingletonOne.getSingletonOne();
        SingletonTwo singletonTwo = SingletonTwo.singletonTwo;
        SingletonThree singletonThree = SingletonThree.singletonThree;
    }

}

class MapUtil{
    static <k,v> HashMap<k, v> newHashMap(){
        return new HashMap<>();
    }
}

class NutritionFacts{
    private final int servingSize;  //(ml)              required
    private final int servings;     //(per container)   required
    private final int calories;     //                  optional
    private final int fat;          //(g)               optional
    private final int sodium;       //(mg)              optional
    private final int carbohydrate; //(g)               optional

    public static class Builder implements javafx.util.Builder<NutritionFacts> {
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }
        public Builder fat(int val){
            this.fat = val;
            return this;
        }
        public Builder carbohydrate(int val){
            this.carbohydrate = val;
            return this;
        }
        public Builder sodium(int val){
            this.sodium = val;
            return this;
        }
        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

}

// 饿汉模式,静态工厂方法
class SingletonOne{

    private static final SingletonOne singletonOne = new SingletonOne();

    private SingletonOne(){
        super();
    }

    public static SingletonOne getSingletonOne(){
        return singletonOne;
    }
}

// 饿汉模式，静态成员
class SingletonTwo{

    public static final SingletonTwo singletonTwo = new SingletonTwo();

    private SingletonTwo(){
        super();
    }
}

// 枚举,单例模式的最佳方法
enum  SingletonThree{
    singletonThree;
}