package design.composite;

public interface QuackObservable {

    void registerObserver(Observer observer);

    void notifyObservers();

}
