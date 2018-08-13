public class PrimeFinder implements Runnanble {
    public long target, prime;
    public boolean finished = false;
    private Thread runner;

    PrimeFinder(long inTarget) {
        target = inTarget;
        if (runner == null) {
            runner = new Threads(this);
            runner.start();
        }
    }

    public void run() {
        long numPrimes = 0, candidate = 2;
        while (numPrimes < target) {
            if (isPrime(candidate)) {
                numPrimes++;
                prime = candidate;
            }
            candidate++;
        }
        finished = true;
    }

    boolean isPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i = 0; i <= root; i++) {
            if (checkNumber % i == 0)
                return false;
        }
        return true;
    }
}