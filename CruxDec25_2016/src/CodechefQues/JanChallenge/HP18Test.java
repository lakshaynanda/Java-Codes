package CodechefQues.JanChallenge;

import java.util.Scanner;

class HP18Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int NOTC = s.nextInt();

		for (int n = 0; n < NOTC; n++) {
			int acount = 0, bcount = 0;
			boolean is = false;
			int N = s.nextInt();
			int a = s.nextInt();
			int b = s.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				int element = s.nextInt();
				arr[i] = element;
			}
			if (a == b || b % a == 0) {
				System.out.println("BOB");
				continue;
			}

			for (int i = 0; i < arr.length; i++) {

				if ((arr[i] % a == 0) && (arr[i] % b == 0)) {
					acount++;
					bcount++;
					is = true;
					continue;
				}

				if (arr[i] % a == 0) {
					acount++;
				}
				if (arr[i] % b == 0) {
					bcount++;
				}
			}

			if (acount > bcount) {
				System.out.println("BOB");
			} else if (bcount > acount) {
				System.out.println("ALICE");
			} else {
				if (is) {
					System.out.println("BOB");
				} else {
					System.out.println("ALICE");
				}
			}
		}
	}
}
