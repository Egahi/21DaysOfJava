import com.egahi.ecommerce;

public class GiftShop {
    public static void main(String[] arguments) {
        Storefront store = new  Storefront();
        store.addItem("C01", "MUG",  "9.99", "150");
        store.addItem("C02", "LG MUG",  "12.99", "82");
        store.addItem("C03", "MOUSEPAD",  "10.49", "800");
        store.addItem("D01", "T SHIRT",  "16.99", "90");
        store.sort();

        for (int i = 0, j = store.getSize(); i < j; i++) {
            Item show = (Item) store.getItem(i);
            System.out.println("\nItem ID: " + show.getId() +
                               "\nName: " + show.getName() +
                               "\nRetail Price: $" + show.getRetail() +
                               "\nPrice: $" + show.getPrice() +
                               "\nQuantity: " + show.getQuantity());
        }
    }
}