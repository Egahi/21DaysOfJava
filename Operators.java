public class Operators {
    public static void main(String[] args) {
        float capital = 14000;
        System.out.println("Capital:\t\t$" + capital);

        // increase capital by 40%
        capital += capital * 0.4;
        System.out.println("Increased Capital:\t$" + capital);

        // loss of $1500
        capital -= 1500;
        System.out.println("Capital after loss:\t$" + capital);

        // increase of 12%
        capital += capital * 0.12;
        System.out.println("Increased Capital:\t$" + capital);
        System.out.format("\n\nCapital: %,d", 3000000);

        int number1 = 5, number2 = 6;
        System.out.println("\n\n" + number1 + " / " + number2 + "\t\t\t\t= " + number1 / number2);
        System.out.println("The Remainder from " + number1 + " / " + number2 + "\t= " + number1 % number2);   
    }
}