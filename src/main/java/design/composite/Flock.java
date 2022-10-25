package design.composite;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable{

    private final List<Quackable> quackableList;

    public Flock() {
        this.quackableList = new ArrayList<>();
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
}
