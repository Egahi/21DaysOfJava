import java.util.*;

class ShoppingCart {
    Vector<Fruit> newCart;
    Fruit[] fruit = {new Fruit("Pear", 50, 50.00F),
                    new Fruit("Apple", 150, 100.00F),
                    new Fruit("Pineapple", 10, 400.00F)};

    public ShoppingCart() {
        newCart = new Vector<Fruit>();        
        addFruits(fruit);
        printFruits();
    }

    void addFruits(Fruit[] fruit) {
        for (int i = 0, j = fruit.length; i < j; i++) {
            if (!newCart.contains(fruit)) {
                newCart.add(fruit[i]);
            }
        }
    }

    void printFruits() {
        for(Fruit f : newCart) {
            System.out.println(f.quantity + " " + f.name + "s at $" + f.price + " each.");
        }
    }

    public static void main(String[] arguments) {
        ShoppingCart newCart = new ShoppingCart();
    }
}

class Fruit {
    String name;
    int quantity;
    float  price;

    public Fruit(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}