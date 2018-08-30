class DateList {
    public static void main(String[] args) {
        // set 2000 as default year
        int year = 2000;

        // if a year is entered, use it
        if (args.length > 0)
            year = Integer.parseInt(args[0]);
        
        // print out every date in the year
        for (int i = 0; i < 12; i++) {
            for (int j = 0, days = DayCounter.countDays((i + 1), year); j < days; j++) {
                System.out.println((j + 1) + "/" + (i + 1) + "/" + year);
            }
        }
    }
}