package effective.java.rule_9;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(short areaCode, short prefix, short lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof PhoneNumber)){
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber)obj;
        return areaCode == phoneNumber.areaCode &&
                prefix == phoneNumber.prefix &&
                lineNumber == phoneNumber.lineNumber;
    }

    @Override
    public int hashCode() {
        int result = 17;
        return 31*(31*(31 * result + (int)areaCode) + (int)prefix) + (int)lineNumber;
    }

    @Override
    public String toString() {
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }
}
