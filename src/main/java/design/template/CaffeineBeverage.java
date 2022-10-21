package design.template;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondition();
    }

    abstract void brew();

    abstract void addCondition();

    void boilWater() {
        System.out.println("boil water");
    }

    void pourInCup() {
        System.out.println("pour in cup");
    }

}
