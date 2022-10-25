package design.composite;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

    void simulate() {
        CountingDuckFactory countingDuckFactory = new CountingDuckFactory();
        Flock flockOfCountingDuck = new Flock();
        flockOfCountingDuck.addQuackable(countingDuckFactory.createMallardDuck());
        flockOfCountingDuck.addQuackable(countingDuckFactory.createGooseAdapter());
        simulate(flockOfCountingDuck);
        System.out.println(QuackCounter.getCount());

        DuckFactory duckFactory = new DuckFactory();
        Flock flockOfDuck = new Flock();
        flockOfDuck.addQuackable(duckFactory.createMallardDuck());
        flockOfDuck.addQuackable(duckFactory.createGooseAdapter());
        simulate(flockOfDuck);
        System.out.println(QuackCounter.getCount());

    }

    void simulate(Quackable duck) {
        duck.quack();
    }

}
