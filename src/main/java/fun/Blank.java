package fun;

public class Blank {

    public static void main(String[] args) {
        // 160号空格
        for (char c : " ".toCharArray()) {
            System.out.println((int)c);
        }
        System.out.println("---");
        for (char c : " ".toCharArray()) {
            System.out.println((int)c);
        }
//        for (int i = 0; i < 256; i++) {
//            System.out.println("" + i + ": "+ (char)i);
//        }
        System.out.println((int)' ');
        System.out.println((int)' ');
    }
}
