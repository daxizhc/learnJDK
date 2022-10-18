package design.strategy;

public class Multiply implements IStrategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
