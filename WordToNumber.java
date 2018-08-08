class WordToNumber {
    public static void main(String[] args) {
        // ensure proper usage
        if (args.length == 1) {
            // get user input
            String numberInWords = args[0];

            // convert input from words to number
            long number = convertWordToNumber(numberInWords);

            if (number > 0 & number <= 10)
                System.out.println(numberInWords + " = " + number);
            else
                System.out.println("This program only supports numbers between"
                                 + " one and ten entered in lower case as this time.");
        }
        else    
            System.out.println("Usage: java WordToNumber number-in-words");
    }

    /**
     * converts a number from words to a long integer
     * @param numberInWords is the inputed number
     * @return the long integer equivalent of the number in words or
     * -1 if it can't convert the input 
     */
    static long convertWordToNumber(String numberInWords) {
        long number = -1;
        switch (numberInWords) {
            case "one":
                number = 1;
                break;
            case "two":
                number = 2;
                break;
            case "three":
                number = 3;
                break;
            case "four":
                number = 1;
                break;
            case "five":
                number = 5;
                break;
            case "six":
                number = 6;
                break;
            case "seven":
                number = 7;
                break;
            case "eight":
                number = 8;
                break;
            case "nine":
                number = 9;
                break;
            case "ten":
                number = 10;
                break;
        }

        return number;
    }
}