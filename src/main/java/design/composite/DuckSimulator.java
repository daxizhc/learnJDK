package design.composite;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        GooseAdapter gooseAdapter = new GooseAdapter(new Goose());
        simulate(mallardDuck);
        simulate(gooseAdapter);
    }

    void simulate(Quackable duck) {
        duck.quack();
    }

}
