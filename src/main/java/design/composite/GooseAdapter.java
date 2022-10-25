package design.composite;

public class GooseAdapter implements Quackable{

    private final Goose goose;

    private final QuackObservable quackObservable;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        quackObservable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        quackObservable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quackObservable.notifyObservers();
    }
}
