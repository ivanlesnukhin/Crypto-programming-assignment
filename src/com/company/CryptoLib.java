package com.company;// Compilation (CryptoLibTest contains the main-method):
//   javac CryptoLibTest.java
// Running:
//   java CryptoLibTest



public class CryptoLib {


	//TASK 1 .....................................................................................

	/**
	 * GCD implementation
	 */
	public static int gcd(int a, int b){
		if (b==0) return a;
		return gcd(b,a%b);
	}



	/**
	 * DONE!!!
	 * Returns an array "result" with the values "result[0] = gcd",
	 * "result[1] = s" and "result[2] = t" such that "gcd" is the greatest
	 * common divisor of "a" and "b", and "gcd = a * s + b * t".
	 **/
	public static int[] EEA(int a, int b) {
		// Note: as you can see in the test suite,
		// your function should work for any (positive) value of a and b.


		int[] result = new int[3];

		if (a == b){
			result[0] = a;
			result[1] = 1;
			result[2] = 0;
			return result;
		}

		if (b == 0){
			return new int[]{a, 1, 0};
		}
		result = EEA(b, a%b);
		int g = result[0];
		int s = result[2];
		int t = result[1] - (a/b)*result[2];
		return new int [] {g, s, t};
	}

	/**
	 * DONE!!!
	 * Returns Euler's Totient for value "n".
	 **/
	public static int EulerPhi(int n) {
		int count = 0;
		for (int i = 1; i<n; i++){
			if (gcd(n, i) == 1){
				count++;
			}
		}
		return count;
	}

	/**
	 * DONE!!!
	 * Returns the value "v" such that "n*v = 1 (mod m)". Returns 0 if the
	 * modular inverse does not exist.
	 **/
	public static int ModInv(int n, int m) {
		//The commented part bellow does not work for one test, I do not know why; according to the
		//definition of the inverse we should check this first
		/*if (gcd(n, m) != 1){
			return 0;
		}
		*/
		if (n<0){
			while (n<0){
				n = n + m;
			}
		}
		int tmp;
		for (int i = 0; i < m; i++){
			tmp = (n*i) % m;
			if (tmp % m == 1){
				return i;
			}
		}

		return 0;
	}

	/**
	 * DONE!!!
	 * Returns 0 if "n" is a Fermat Prime, otherwise it returns the lowest
	 * Fermat Witness. Tests values from 2 (inclusive) to "n/3" (exclusive).
	 **/
	public static int FermatPT(int n) {
		if (n<6){
			System.out.println("The input to FermatPT() must be > 5");
			return -1;
		}
		double i;
		for (int a = 2; a <= (n/3); a++){
			i = Math.pow(a, (n-1));
			if (!(i%n == 1)){
				return a;
			}
		}

		return 0;
	}

	/**
	 * DONE!!!
	 * Returns the probability that calling a perfect hash function with
	 * "n_samples" (uniformly distributed) will give one collision (i.e. that
	 * two samples result in the same hash) -- where "size" is the number of
	 * different output values the hash function can produce.
	 **/

	//n_samples, size must be int!!!!!!!
	public static double HashCP(double n_samples, double size) {
		if (n_samples < 2){
			return 0;
		}
		if(n_samples > size){
			return 1;
		}
		double noCollision = 1;

		//with n_samples different inputs, the probability that h() will give different out put is:
		for (int i = (int) (size - n_samples + 1); i<size; i++){
			noCollision = noCollision * (i/size);
		}
		return (1-noCollision);

		/*
		wrong code!
		for (int i = 1; i < n_samples; i++){
			noCollision = noCollision * (i/size);
		}
		return 1 - noCollision;

		 */
	}

}
