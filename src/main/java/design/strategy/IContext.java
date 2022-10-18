package design.strategy;

public class IContext {

    private final IStrategy strategy;

    public IContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}
