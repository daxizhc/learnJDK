package design.composite;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable{

    private final QuackObservable quackObservable;

    private final List<Quackable> quackableList;

    public Flock() {
        this.quackableList = new ArrayList<>();
        quackObservable = new Observable(this);
    }

    public void addQuackable(Quackable quackable) {
        quackableList.add(quackable);
    }

    @Override
    public void quack() {
        for (Quackable quackable : quackableList) {
            quackable.quack();
        }
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
