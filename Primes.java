public class Primes {
    public static void main(String[] args) {
        int limit = Integer.parseInt(args[0]);
        sieveOfEratosthenes(limit);
    }

    public static void sieveOfEratosthenes(int limit) {
        // Create a boolean array "prime[0..limit]" and initialize all entries as true.
        // A value in prime[i] will be false if 'i' is Not a prime, true otherwise.
        boolean[] prime = new boolean[limit + 1];
        for (int i = 0; i <= limit; i++) {
            prime[i] = true;
        }

        prime[0] = prime[1] = false; // 0 and 1 are not prime numbers

        // Start with the first prime number, which is 2
        for (int p = 2; p * p <= limit; p++) {
            // If prime[p] is still true, then it's a prime number
            if (prime[p] == true) {
                // Mark all multiples of p as false (not prime)
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }

        // Print all prime numbers
        int PrimeAmount = 0;
        System.out.println("Prime numbers up to " + limit + ":");
        for (int p = 2; p <= limit; p++) {
            if (prime[p]) {
                System.out.println(p + " ");
                PrimeAmount++;
            }
        }
        
        int PrimePercent = PrimeAmount * 100 / limit;
        System.out.println("There are " + PrimeAmount + " primes between 2 and " + limit + " (" + PrimePercent + "% are primes)");
    }
}