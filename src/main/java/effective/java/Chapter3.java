package effective.java;

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


