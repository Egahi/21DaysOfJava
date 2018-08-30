class DayCounter {
    public static void main(String[] args) {
        // set default year
        int yearIn = 2008;

        // set default month
        int monthIn = 1;

        // use inputed month if provided
        if (args.length > 0)
            monthIn = Integer.parseInt(args[0]);
        // use inputed year if provided
        if (args.length > 1)
            yearIn = Integer.parseInt(args[1]);
        System.out.println(monthIn + "/" + yearIn + " has "
            + countDays(monthIn, yearIn) + " days.");
    }

    /**
    * Counts the number of days in a month of a year
    * @param month is the specified month
    * @param year is the specified year
    * @return the number of days 
    */
    static int countDays(int month, int year) {
        int count = -1;
        switch(month) {
            // months with 31 days
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            
            // months with 30 days
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;

            // february
            case 2:
                // leap year
                if (year % 4 == 0)
                    count = 29;
                else
                    count = 28;
                if ((year % 100 == 0)  & (year % 400 != 0))
                    count = 28;
        }

        return count;
    }
}