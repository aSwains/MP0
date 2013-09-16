
/* 
 * Authors: Jackie Lang, Kimia Nikazm, Alexander Swainson
 * Date: 15/09/2013
 * Project: MP0b
 */


import java.util.Arrays;

class MP0c {

/**
* Find all prime numbers up to a limit.
*
* @param n
* Largest number to search
* @param printPrimes
* If true, print the primes found to output.
*
* @return number of primes <= n
* @effects If printPrimes is true, prints all primes <= n to output.
*/
    static int findPrimes(int n, boolean printPrimes) {
        boolean isPrime = true;
        int numPrimes = 0;

        for (int i = 2; i <= n; i++) {
            isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                ++numPrimes;
                if (printPrimes) {
                    System.out.println(i);
                }
            }
        }
        return numPrimes;
    }

/**
* Find all prime numbers up to a limit.
*
* Improves on the original algorithm by limiting the number of values we
* have to check our number against --we only need to check up to the
* square root of the number.
*
* @param n
* Largest number to search
* @param printPrimes
* If true, print the primes found to output.
*
* @return number of primes <= n
* @effects If printPrimes is true, prints all primes <= n to output.
*/
    static int findPrimesQuickly(int n, boolean printPrimes) {
    	boolean isPrime = true;
        int numPrimes = 0;

        for (int i = 2; i <= n; i++) {
            isPrime = true;
            
            if(i % 2 != 0 || i == 2){
            	for (int j = 3; j*j <= i; j+=2) {
                    if (i % j == 0){
                        isPrime = false;
                        break;
                    }
                }
            }
            else
            	isPrime = false;

            if (isPrime) {
                ++numPrimes;
                if (printPrimes) {
                    System.out.println(i);
                }
            }
        }
        return numPrimes;
    }

	/**
* Find all prime numbers up to a limit.
*
* Improves on the faster algorithm by limiting the number of values we
* have to check our number against --we only need to check PRIMES up to the
* square root of the number.
*
* @param n
* Largest number to search
* @param printPrimes
* If true, print the primes found to output.
*
* @return number of primes <= n
* @effects If printPrimes is true, prints all primes <= n to output.
*/
    static int findPrimesMoreQuickly(int n, boolean printPrimes) {
        int numPrimes = 0;
        boolean primesList[] = new boolean[n];
        
        Arrays.fill(primesList, true);
        
        primesList[0] = primesList[1] = false;
        
        for (int i = 2; i < n; i++){
        	if(primesList[i] == true) {
                for (int j = 2; i * j  < n; j++) {
                    primesList[i * j] = false;
                }
            }
        }
        
        for(int p = 0; p < n; p++){
        	if(primesList[p]){
        		numPrimes++;
        		if(printPrimes)
        			System.out.println(p);        			        		
        	}
        }
        
        return numPrimes;
    }

    public static void main(String[] args) {
        int numPrimes;

        // Find and print all primes between 0 and 50.

        System.out.println("Running method findPrimes:");
        numPrimes = findPrimes(50, true);
        System.out.println(numPrimes + " primes <= 50");

        System.out.println("\nRunning method findPrimesQuickly:");
        numPrimes = findPrimesQuickly(50, true);
        System.out.println(numPrimes + " primes <= 50");

        System.out.println("\nRunning method findPrimesMoreQuickly:");
        numPrimes = findPrimesMoreQuickly(50, true);
        System.out.println(numPrimes + " primes <= 50");

        // Time how long it takes to find primes.

        long startTime = 0;
        long endTime = 0;

        System.out.print("\n\nTiming method findPrimes:");
        startTime = System.currentTimeMillis();
        numPrimes = findPrimes(40000, false);
        endTime = System.currentTimeMillis();
        System.out.println(" " + (endTime - startTime) + " milliseconds");
        System.out.println(numPrimes + " primes <= 40000");

        System.out.print("\nTiming method findPrimesFaster:");
        startTime = System.currentTimeMillis();
        numPrimes = findPrimesQuickly(40000, false);
        endTime = System.currentTimeMillis();
        System.out.println(" " + (endTime - startTime) + " milliseconds");
        System.out.println(numPrimes + " primes <= 40000");

        System.out.print("\nTiming method findPrimesEvenFaster:");
        startTime = System.currentTimeMillis();
        numPrimes = findPrimesMoreQuickly(40000, false);
        endTime = System.currentTimeMillis();
        System.out.println(" " + (endTime - startTime) + " milliseconds");
        System.out.println(numPrimes + " primes <= 40000");

        System.out.print("\n\nTiming method findPrimes:");
        startTime = System.currentTimeMillis();
        numPrimes = findPrimes(80000, false);
        endTime = System.currentTimeMillis();
        System.out.println(" " + (endTime - startTime) + " milliseconds");
        System.out.println(numPrimes + " primes <= 80000");

        System.out.print("\nTiming method findPrimesFaster:");
        startTime = System.currentTimeMillis();
        numPrimes = findPrimesQuickly(80000, false);
        endTime = System.currentTimeMillis();
        System.out.println(" " + (endTime - startTime) + " milliseconds");
        System.out.println(numPrimes + " primes <= 80000");

        System.out.print("\nTiming method findPrimesEvenFaster:");
        startTime = System.currentTimeMillis();
        numPrimes = findPrimesMoreQuickly(80000, false);
        endTime = System.currentTimeMillis();
        System.out.println(" " + (endTime - startTime) + " milliseconds");
        System.out.println(numPrimes + " primes <= 80000");
    }

}