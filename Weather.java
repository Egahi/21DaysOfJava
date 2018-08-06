public class Weather {
    public static void main(String[]  args) {
        float fah  = 86;
        System.out.println(fah + " degrees  Fahrenheit is ...");

        // To convert Fahrenheit to Celsius
        // Begin by subtracting 32
        fah = fah - 32;
        // Divide answer by 9
        fah = fah / 9;
        // Multiply the answer by 5
        fah = fah * 5;
        System.out.println(fah + " degrees Celsius\n");

        float cel = 30;
        System.out.println(cel + " degrees Celsius is...");
        // To Convert Fahrenheit into Celsius
        // Begin by Dividing the answer by 9
        cel = cel * 9;
        // Multiply that answer by 5
        cel = cel / 5;
        // Subtract 32
        cel = cel + 32;
        System.out.println(cel + " degrees Fahrenheit");
    }
}