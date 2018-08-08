import java.util.awt;

class FourDPoint extends Point {
    public static void main(String[] arguments) {
        if (arguments.length > 0) {
            for (int i = 0, j = arguments.length; i < j; i++) {
                System.out.println(arguments[i]);
            }
        }
    }
}