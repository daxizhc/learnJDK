package design.factory;

public class ShapeFactory {

    public Shape getShape(String type) {
        if ("CIRCLE".equals(type)) {
            return new Circle();
        } else if ("RECTANGLE".equals(type)) {
            return new Rectangle();
        } else {
            return null;
        }
    }

}
