package Assignment4;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		System.out.println("If The Array Is Mirror Inverse :" + ChkInverse(arr));

	}

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter The size of the array");
		int N = s.nextInt();
		int[] retVal = new int[N];
		for (int i = 0; i < retVal.length; i++) {
			System.out.println("Please Enter the" + i + "th element");
			retVal[i] = s.nextInt();
		}
		return retVal;
	}

	public static boolean ChkInverse(int[] arr) {
		int[] chk = new int[arr.length];
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			chk[i] = arr[i];
		}
		int[] arr1;
		int j = 0;
		arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++, j++) {
			arr1[arr[i]] = j;
		}
		for (int k = 0; k < arr1.length; k++) {
			if (arr1[k] == chk[k]) {
				counter++;
			}
		}

		if (counter == arr.length) {
			return true;
		} else {
			return false;
		}

	}

}
