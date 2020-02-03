package Aditya.Contest_29June;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class QA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();

		int l = 0;

		if (N % 2 == 0) {
			l = N / 2;
		} else {
			l = (N / 2) + 1;
		}

		for (int i = 0; i < N; i++) {
			int e = s.nextInt();

			if (map.containsKey(e)) {
				int v = map.get(e);
				map.put(e, v + 1);
			} else {
				map.put(e, 1);
			}
		}

		if (N == 1) {
			System.out.println("Yes");
			return;
		}

		int max = Collections.max(map.values());

		if (max > l) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}

	}

}
