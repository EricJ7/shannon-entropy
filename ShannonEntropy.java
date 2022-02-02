import java.util.Scanner;
import java.lang.Math;

public class shannonEntropy {

	// shannon entropy relates to the amount of suprise or
	// uncertainty within a system of possible outcomes
	// the larger the entropy, the greater the uncertainty of the outcome

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter the probabilities seperated by commas with no spaces");
		String probabilities = input.nextLine();
		String[] listProbabilitiesStr = probabilities.split(",");

		// convert str list to double list
		double[] probabilitiesArr = strArrtoDoubleArr(listProbabilitiesStr);

		printProbabilities(probabilitiesArr);
		double sum = sumProbabilities(probabilitiesArr);
		System.out.println("\nSum of probabilities = " + sum);

		double entropyBits = entropyCalc(probabilitiesArr);
		System.out.println("Shannon entropy of the system: " + entropyBits);

	}


	public static double mathRound (double entropy, int numDigits) {

		double x = Math.pow(10, numDigits);
		return Math.round(entropy * x) / x;

	}

	public static double entropyCalc (double[] probabilities) {

		double entropy = 0;
		// sum of possible probabilities 
		for(int i = 0; i < probabilities.length; i++) {
			 entropy += -(probabilities[i]) * ((Math.log(probabilities[i]) / Math.log(2)));
		}
		return entropy;

	}

	public static double sumProbabilities (double[] probabilities) {

		double sumProbabilities = 0;

		for(int i = 0; i < probabilities.length; i++) {

			sumProbabilities += probabilities[i];

		}

		return sumProbabilities;

	}


	public static double[] strArrtoDoubleArr (String[] strArr) {

		double[] doubleArr = new double[strArr.length];
		
		for(int i = 0; i < strArr.length; i++) {
			doubleArr[i] = Double.parseDouble(strArr[i]);
		}

		return doubleArr;

	}

	public static void printProbabilities (double[] probabilities) {

		for(int i = 0; i < probabilities.length; i++) {

			System.out.println("Probability " + (i + 1) + ": " + probabilities[i]); 

		}

	}

} 
