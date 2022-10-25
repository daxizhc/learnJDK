package design.composite;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

    void simulate() {
        CountingDuckFactory countingDuckFactory = new CountingDuckFactory();
        Quackologist quackologist = new Quackologist();

        Flock flockOfCountingDuck = new Flock();
        Quackable countingMallardDuck = countingDuckFactory.createMallardDuck();
        Quackable countingGooseAdapter = countingDuckFactory.createGooseAdapter();
        flockOfCountingDuck.addQuackable(countingMallardDuck);
        flockOfCountingDuck.addQuackable(countingGooseAdapter);

        simulate(flockOfCountingDuck);
        System.out.println(QuackCounter.getCount());
        System.out.println("==========================");

        DuckFactory duckFactory = new DuckFactory();
        Flock flockOfDuck = new Flock();
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable gooseAdapter = duckFactory.createGooseAdapter();
        mallardDuck.registerObserver(quackologist);
        gooseAdapter.registerObserver(quackologist);
        flockOfDuck.addQuackable(mallardDuck);
        flockOfDuck.addQuackable(gooseAdapter);
        simulate(flockOfDuck);
        System.out.println(QuackCounter.getCount());

    }

    void simulate(Quackable duck) {
        duck.quack();
    }

}
