package chizhenko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String sequence;
		int[] myArr;
		ArrayList<Integer> arrL = new ArrayList<>();

		System.out.println("¬ведите последовательность чисел через кому, в конце поставьте точку:");
		sequence = sc.nextLine();
		sc.close();

		myArr = countOfNumbers(sequence);

		System.out.println(Arrays.toString(myArr));

		if (amount(myArr)) {
			System.out.println(returnAmauntNext(myArr));
		} else if (composition(myArr)) {
			System.out.println(returnCompositionNext(myArr));
		} else {
			arrL = degree(myArr);

			if (arrL.get(0) == 1) {
				System.out.println(Math.pow(arrL.get(1) + 1, arrL.get(2)));
			} else {
				System.out.println("ѕоследовательность не распознана");
			}
		}

	}

	static boolean amount(int[] pArr) {

		boolean returnResult = true;

		int delta = 0;

		for (int i = 1; i < pArr.length; i++) {

			if (i == 1) {
				delta = pArr[i] - pArr[i - 1];
			} else {
				if ((pArr[i] - pArr[i - 1]) != delta) {
					returnResult = false;
					break;
				}
			}

		}

		return returnResult;
	}

	static int returnAmauntNext(int[] pArr) {

		return pArr[pArr.length - 1] + (pArr[1] - pArr[0]);

	}

	static boolean composition(int[] pArr) {

		boolean returnResult = true;

		int delta = 0;

		for (int i = 1; i < pArr.length; i++) {

			if (i == 1) {
				delta = pArr[i] / pArr[i - 1];
			} else {
				if ((pArr[i] / pArr[i - 1]) != delta) {
					returnResult = false;
					break;
				}
			}

		}

		return returnResult;
	}

	static int returnCompositionNext(int[] pArr) {
		return pArr[pArr.length - 1] * (pArr[1] / pArr[0]);
	}

	static ArrayList<Integer> degree(int[] pArr) {

		ArrayList<Integer> arr = new ArrayList<>();

		int returnResult = 1;
		int pow = 0;
		int max = 0;

		for (int i = 2; i < 10; i++) {
			returnResult = 1;
			for (int j = 1; j < pArr.length; j++) {
				max = j + 1;
				if ((Math.pow(j, i) == pArr[j - 1] && Math.pow(j + 1, i) == pArr[j]) != true) {
					returnResult = 0;
					break;
				}

				pow = i;
			}

			if (returnResult == 1) {
				break;
			}
		}

		arr.add(returnResult);
		arr.add(max);
		arr.add(pow);

		return arr;
	}

	static int[] countOfNumbers(String pStr) {

		char[] charArray;
		int[] intArray;
		int intLength;

		pStr = pStr.trim();
		charArray = pStr.toCharArray();

		int counter = 0;
		for (char x : charArray) {
			if (x == ',' || x == '.') {
				counter = counter + 1;
			}
		}

		intLength = counter;

		intArray = new int[intLength];

		int i = 0;

		String number = "";

		for (char x : charArray) {

			if (x == ',' || x == '.') {
				i = i + 1;
				intArray[i - 1] = Integer.parseInt(number);
				number = "";
			} else {
				number = number + x;
			}
		}

		return intArray;
	}

}
