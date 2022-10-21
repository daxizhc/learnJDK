package design.template;

public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("brew for coffee");
    }

    @Override
    void addCondition() {
        System.out.println("add milk");
    }
}
