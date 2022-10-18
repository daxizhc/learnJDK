package design.strategy;

public class StrategyDemo {

    public static void main(String[] args) {
        IContext add = new IContext(new Add());
        System.out.println(add.executeStrategy(1,3));

        IContext multiply = new IContext(new Multiply());
        System.out.println(multiply.executeStrategy(2,5));
    }


}
