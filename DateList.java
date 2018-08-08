class DayList {
    public static void main(String[] args) {
        int month = 1, year = 2000;

        if (args.length > 0)
            month = args[0];
        if (args.length > 2)
            year = args[1];
        
        System.out.println("DATE: " + month + "/" + year);
    }
}