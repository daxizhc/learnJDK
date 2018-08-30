package effective.java;

import java.awt.*;

public class Chapter3 {


}


// equals违反对称性
class CaseInsensitiveString{

    private final String s;

    CaseInsensitiveString(String s) {
        if(s == null){
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CaseInsensitiveString){
            return s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
        }
        // 这里违反了对称性
        if(obj instanceof String){
            return s.equalsIgnoreCase((String)obj);
        }
        return false;
    }
}

// 传递性
class Point{

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)){
            return false;
        }
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}

class ColorPoint extends Point{

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Point)){
            return false;
        }
        if(obj instanceof ColorPoint){
            ColorPoint colorPoint = (ColorPoint)obj;
            return super.equals(colorPoint) && this.color == colorPoint.color;
        }else {
            return super.equals(obj);
        }
    }
}



