/**
 * Basics
 */
public class Basics {

    public static void main(String[] args) {
        Basics obj = new Basics();

        obj.recurse(5);
    }

    private int recurse(int i) {

        if (i == 0) {
            return i;
        }

        System.out.println(recurse(i - 1));
        return -1;
    }
}