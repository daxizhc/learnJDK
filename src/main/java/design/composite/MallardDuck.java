package design.composite;

public class MallardDuck implements Quackable{

    private final QuackObservable quackObservable;

    public MallardDuck() {
        this.quackObservable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck Quack");
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
