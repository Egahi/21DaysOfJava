class ZipCode {
    private int zipCode;

    /**
     * sets the zip code value
     * accepts only 5 digits or 9 digits number
     * @param zipCode is the value to be asigned as the zip code
     * @return true if code is valid else false
     */
    public Boolean setZipCode(int zipCode) {
        Boolean valid = true;

        // only 5 or 9 digits numbers are valid
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

        // enusure proper usage
        if (arguments.length == 1) {
            Boolean valid = customZipCode.setZipCode(Integer.parseInt(arguments[0]));
            
            if (valid)
                System.out.println("Zip Code: " + customZipCode.getZipCode());
            else
                System.out.println("INVALID!");

        } else {
            System.out.println("Usage: java ZipCode code");
        }
    }
}