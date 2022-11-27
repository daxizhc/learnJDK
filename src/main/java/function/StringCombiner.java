package function;

public class StringCombiner {

    private final StringBuilder stringBuilder;

    private final String prefix;

    private final String postfix;

    private final String delim;

    public StringCombiner(String prefix, String postfix, String delim) {
        this.prefix = prefix;
        this.postfix = postfix;
        this.delim = delim;
        stringBuilder = new StringBuilder();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public synchronized StringCombiner add(String element) {
        if (stringBuilder.length() == 0) {
            stringBuilder.append(prefix);
        } else {
            stringBuilder.append(delim);
        }
        stringBuilder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        return this;
    }

    public String getResult() {
        if (stringBuilder.length() == 0) {
            return prefix + postfix;
        }
        return stringBuilder.append(postfix).toString();
    }

}
