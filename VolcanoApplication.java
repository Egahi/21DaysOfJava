class VolcanoApplication {
    public static void main(String[] args) {
        VolcanoRobot dante = new VolcanoRobot();
        dante.status = "exploring";
        dante.speed = 2;
        dante.temperature = 510;

        dante.showAttributes();
        System.out.println("Increasing speed to 3.");
        dante.speed = 3;
        dante.showAttributes();
        System.out.println("Checking temperature.");
        dante.checkTemperature();
        dante.showAttributes();

        VolcanoRobot vr = new VolcanoRobot();
        vr.showAttributes();

        VolcanoRobot.date = "tommorrow";
        System.out.println("vr attributes...");
        vr.showAttributes();

        System.out.println("dante attributes...");
        dante.showAttributes();                
    }
}

