package design.factory;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println(getClass().getName());
    }
}
