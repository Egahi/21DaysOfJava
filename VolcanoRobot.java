class VolcanoRobot {
    String status;
    int speed;
    float temperature;

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
    }
}