package design.composite;

public class QuackCounter implements Quackable {

    static int count = 0;

    private final Quackable quackable;

    public QuackCounter(Quackable quackable) {
        this.quackable = quackable;
    }


    @Override
    public void quack() {
        count ++;
        quackable.quack();
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void registerObserver(Observer observer) {
    }

    @Override
    public void notifyObservers() {
    }
}
