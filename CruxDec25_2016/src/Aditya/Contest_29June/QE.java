package Aditya.Contest_29June;

import java.util.Scanner;

public class QE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int maxsum = Integer.MIN_VALUE;
		int ibeg = 0;
		int iend = 0;

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = s.nextInt();

		}

		if (N == 0) {
			System.out.println(0);
			return;
		}

		for (int i = 1; i < N; i++) {
			int e = arr[i] + arr[i - 1];
			if (e > maxsum) {
				maxsum = e;
				ibeg = i - 1;
				iend = i;
			}
		}

		// System.out.println(maxsum + " " + ibeg + " " + iend);

		int result = 0;

		while (ibeg != 0 || iend != N - 1) {

			result += maxsum;

			int e = 0;

			if (iend == N - 1) {
				ibeg--;
				e = arr[ibeg];
			} else if (ibeg == 0) {
				iend++;
				e = arr[iend];
			} else if (arr[iend + 1] >= arr[ibeg - 1]) {
				iend++;
				e = arr[iend];
			} else if (arr[iend + 1] < arr[ibeg - 1]) {
				ibeg--;
				e = arr[ibeg];
			}

			maxsum += e;

		}

		System.out.println(result + maxsum);

	}

}
