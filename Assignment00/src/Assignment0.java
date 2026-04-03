/**
 * @author Harrison Haas
 * 
 * Completes the following four tasks and prints an example of each:
 * 1. Performs basic array compression using the counts of prepeated values
 * 2. Decompresses a compressed array
 * 3. Finds all local maxima in an array
 * 4. Multiplies two matrices
 */

public class Assignment0 {

	public static void main(String[] args) {

		int[] input = { 4, 4, 4, 1, 1, 2 };
		int[][] compressed = compressRuns(input);
		printD2ArrayInts(compressed);

		int[][] input2 = { { 4, 3 }, { 1, 2 }, { 2, 1 } };
		int[] decompressed = decompressRuns(input2);
		printD1ArrayInts(decompressed);

		int[] input3 = { 2, 7, 5, 1, 3, 3, 9 };
		int[] localMax = localMaxima(input3);
		printD1ArrayInts(localMax);
		
		double[][] matrixA = {{1,2,3},{4,5,6}};
		double[][] matrixB = {{10,11},{20,21},{30,31}};
		double[][] product = matrixMultiply(matrixA, matrixB);
		printD2ArrayDoubles(product);
	}

	/**
	 * Compress an inputted Array of integers into a two dimensional array
	 * consisting of the unique characters and how many times they are repeated in
	 * the inputted array
	 * 
	 * @param arr The array of integers to be considered
	 * @return The compressed two dimensional array
	 */
	public static int[][] compressRuns(int[] arr) {
		// Find the amount of unique integers in the input array
		int numOfUniqueInts = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				numOfUniqueInts++;
			}
		}

		// Create an array that contains the unique ints in order
		// Create an array that contains the frequency of the unique ints
		int[] uniqueInts = new int[numOfUniqueInts];
		int[] frequency = new int[numOfUniqueInts];

		int currentIndex = 0;
		int currentFrequency = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				uniqueInts[currentIndex] = arr[i - 1];
				frequency[currentIndex] = currentFrequency;
				currentFrequency = 1;
				currentIndex++;
			} else {
				currentFrequency++;
			}
			if (i == arr.length - 1) {
				uniqueInts[currentIndex] = arr[i];
				frequency[currentIndex] = currentFrequency;
			}
		}

		// Combine the two arrays created in this method into one two dimensional array
		// containing the unique integer in the first column and the frequency of the
		// integer in the second
		int[][] compressed = new int[numOfUniqueInts][2];
		for (int rowIndex = 0; rowIndex < compressed.length; rowIndex++) {
			for (int colIndex = 0; colIndex < compressed[rowIndex].length; colIndex++) {
				if (colIndex == 0) {
					compressed[rowIndex][colIndex] = uniqueInts[rowIndex];
				} else if (colIndex == 1) {
					compressed[rowIndex][colIndex] = frequency[rowIndex];
				}
			}
		}
		return compressed;
	}

	/**
	 * Decompresses an inputted two dimensional array into aone dimensional array by
	 * repeating the value in the first column the amount of times in the second
	 * column of the same row
	 * 
	 * @param compressedArr The compressed two dimensional array to be decompressed
	 * @return The decompressed one dimensional array
	 */
	public static int[] decompressRuns(int[][] compressedArr) {
		// Create an array of the correct length specified by the length of the
		// compressed Array's
		int decompressedLength = 0;
		for (int i = 0; i < compressedArr.length; i++) {
			decompressedLength += compressedArr[i][1];
		}
		int[] output = new int[decompressedLength];

		// Fill the created array with the compressed array's first column numbers the
		// correct amount of times
		int currentIndex = 0;
		for (int i = 0; i < compressedArr.length; i++) {
			for (int j = 0; j < compressedArr[i][1]; j++) {
				output[currentIndex] = compressedArr[i][0];
				currentIndex++;
			}
		}
		return output;
	}

	/**
	 * Prints out a two dimensional array of integers
	 * 
	 * @param input The array to be printed
	 */
	public static void printD2ArrayInts(int[][] input) {
		System.out.print("{");
		for (int rowIndex = 0; rowIndex < input.length; rowIndex++) {
			System.out.print("{");
			for (int colIndex = 0; colIndex < input[rowIndex].length; colIndex++) {
				if (colIndex < input[rowIndex].length - 1) {
					System.out.print(input[rowIndex][colIndex] + ",");
				} else {
					System.out.print(input[rowIndex][colIndex]);
				}
			}
			if (rowIndex < input.length - 1) {
				System.out.print("},");
			} else {
				System.out.print("}");
			}
		}
		System.out.println("}");
	}
	
	/**
	 * Prints out a two dimensional array of doubles
	 * 
	 * @param input The array to be printed
	 */
	public static void printD2ArrayDoubles(double[][] input) {
		System.out.print("{");
		for (int rowIndex = 0; rowIndex < input.length; rowIndex++) {
			System.out.print("{");
			for (int colIndex = 0; colIndex < input[rowIndex].length; colIndex++) {
				if (colIndex < input[rowIndex].length - 1) {
					System.out.print(input[rowIndex][colIndex] + ",");
				} else {
					System.out.print(input[rowIndex][colIndex]);
				}
			}
			if (rowIndex < input.length - 1) {
				System.out.print("},");
			} else {
				System.out.print("}");
			}
		}
		System.out.println("}");
	}

	/**
	 * Prints out a one dimensional array of ints
	 * 
	 * @param input The array to be printed
	 */
	public static void printD1ArrayInts(int[] input) {
		System.out.print("{");
		for (int i = 0; i < input.length; i++) {
			if (i < input.length - 1) {
				System.out.print(input[i] + ",");
			} else {
				System.out.print(input[i]);
			}
		}
		System.out.println("}");
	}
	
	/**
	 * Prints out a one dimensional array of doubles
	 * 
	 * @param input The array to be printed
	 */
	public static void printD1ArrayDoubles(double[] input) {
		System.out.print("{");
		for (int i = 0; i < input.length; i++) {
			if (i < input.length - 1) {
				System.out.print(input[i] + ",");
			} else {
				System.out.print(input[i]);
			}
		}
		System.out.println("}");
	}

	/**
	 * Finds the elements in an array of integers that are strictly greater than
	 * their neighbors and returns them in a new array
	 * 
	 * @param arr The array to be considered
	 * @return The local maxima of the input array as a new array of integers
	 */
	public static int[] localMaxima(int[] arr) {
		// Test for local maxima and count how many there are
		int maximaAmount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] > arr[i + 1]) {
					maximaAmount++;
				}
			} else if (i == arr.length - 1) {
				if (arr[i] > arr[i - 1]) {
					maximaAmount++;
				}
			} else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				maximaAmount++;
			}
		}
		// Create a new array with a length of the amount of the number of local maxima
		int[] output = new int[0];
		if (maximaAmount != 0) {
			output = new int[maximaAmount];
		} else {
			return output;
		}
		// Fill the array with the local maxima
		int outputIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (arr[i] > arr[i + 1]) {
					output[outputIndex] = arr[i];
					outputIndex++;
				}
			} else if (i == arr.length - 1) {
				if (arr[i] > arr[i - 1]) {
					output[outputIndex] = arr[i];
					outputIndex++;
				}
			} else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				output[outputIndex] = arr[i];
				outputIndex++;
			}
		}
		return output;
	}

	/**
	 * Multiplies two matrices together if possible. 
	 * If the dimensions do not permit it, a blank array will be returned.
	 * 
	 * @param matrixA The first matrix to be multiplied
	 * @param matrixB The second matrix to be multiplied
	 * @return The product of the matrices or a blank array
	 */
	public static double[][] matrixMultiply(double[][] matrixA, double[][] matrixB) {
		// Check if the number of columns in matrixA match the number of rows in matrixB
		if (matrixA[0].length != matrixB.length) {
			return new double[0][0];
		}

		// Create a new array with the same amount of rows as matrixA and columns of
		// matrixB
		double[][] output = new double[matrixA.length][matrixB[0].length];

		// Multiply each element in each row of matrixA by the corresponding element in
		// each column of matrixB and add the products together
		for (int outputRowIndex = 0; outputRowIndex < output.length; outputRowIndex++) {
			for (int outputColIndex = 0; outputColIndex < output[outputRowIndex].length; outputColIndex++) {
				for(int i =0;i<matrixA[outputRowIndex].length;i++) {
					output[outputRowIndex][outputColIndex] += matrixA[outputRowIndex][i]*matrixB[i][outputColIndex];
				}
			}
		}
		return output;
	}

}
