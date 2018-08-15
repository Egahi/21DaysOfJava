import java.util.*;

class ShoppingCart {
    Vector<String, int, float> fruit;

    public ShoppingCart(String inName, int inQuantity, float inPrice) {
        fruit = new Vector<String, int, float>();
        fruit.add(inName, inQuantity, inPrice);

        for(String attribute : fruit) {
            System.out.println(attribute);
        }
    }

    public static void main(String[] arguments) {
        ShoppingCart newCart = new ShoppingCart("Pear", 50, 100.00);
    }
}