public class Primes {
    public static void main(String[] args) {
        int limit = Integer.parseInt(args[0]);
        sieveOfEratosthenes(limit);
    }

    public static void sieveOfEratosthenes(int limit) {
        boolean[] prime = new boolean[limit + 1];
        for (int i = 0; i <= limit; i++) {
            prime[i] = true;
        }

        prime[0] = prime[1] = false;

        for (int p = 2; p * p <= limit; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }
        
        int PrimeAmount = 0;
        System.out.println("Prime numbers up to " + limit + ":");
        for (int p = 2; p <= limit; p++) {
            if (prime[p]) {
                System.out.println(p);
                PrimeAmount++;
            }
        }
        
        int PrimePercent = PrimeAmount * 100 / limit;
        System.out.println("There are " + PrimeAmount + " primes between 2 and " + limit + " (" + PrimePercent + "% are primes)");
    }
}