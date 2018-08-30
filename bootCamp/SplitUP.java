import java.util.StringTokenizer;

class SplitUP {
    public static void main(String[] args) {
        String birthday = "12/25/2018";

        StringTokenizer string = new StringTokenizer(birthday, "/");

        System.out.println("\n\nMonth: " + string.nextToken());
        System.out.println("Day: "  + string.nextToken());
        System.out.println("Year: " + string.nextToken());
    }
}