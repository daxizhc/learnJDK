package design.composite;

public class CountingDuckFactory extends AbstractDuckFactory{

    @Override
    Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    Quackable createGooseAdapter() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}
