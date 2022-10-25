package design.composite;

public class DuckFactory extends AbstractDuckFactory{
    @Override
    Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    Quackable createGooseAdapter() {
        return new GooseAdapter(new Goose());
    }
}
