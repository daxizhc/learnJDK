public class HelloNative {

    public static native void greeting();

    static {

        System.loadLibrary("hellonative");

    }

    public static void main(String[] args) {

        HelloNative.greeting();

    }

}