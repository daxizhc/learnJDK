package design.template;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("brew for tea");
    }

    @Override
    void addCondition() {
        System.out.println("add lemon");
    }

}
