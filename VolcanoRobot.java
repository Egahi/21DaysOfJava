class VolcanoRobot {
    static String date;
    String status;
    int speed;
    float temperature;

    /**
     * initialise variables with default value
     */
    VolcanoRobot() {
        date = "Today";
        status = "Exploring";
        speed = 10;
        temperature = 100;
    }

    /**
     * Initialise variables with inputed arguments
     * @param date is the current date
     * @param status is the status of the robot
     * @param speed is the current speed
     * @param temperature is the current temperature
     */
    VolcanoRobot(String date, String status, int speed, float temperature) {
        this.date = date;
        this.status = status;
        this.speed = speed;
        this.temperature = temperature;
    }

    void checkTemperature() {
        if (temperature > 600) {
            status = "returning home";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println();
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
        System.out.println("Date: " + date);
    }
}