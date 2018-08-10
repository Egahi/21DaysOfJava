class ZipCode {
    private int zipCode;

    public Boolean setZipCode(int zipCode) {
        Boolean valid = true;

        if ((zipCode >= 10000 & zipCode <= 99999) | 
            (zipCode >= 100000000 & zipCode <= 999999999))
            this.zipCode = zipCode;
        else
            valid = false;

        return valid;
    }

    public int getZipCode() {
        return zipCode;
    }

    public static void main(String[] arguments) {
        ZipCode customZipCode = new ZipCode();

        if (arguments.length == 1) {
            Boolean valid = customZipCode.setZipCode(arguments[0]);
            if (valid)
                System.out.println("Zip Code: " + customZipCode.getZipCode());
            else
                System.out.println("INVALID!");

        } else {
            System.out.println("Usage: java ZipCode code");
        }
    }
}