package Extras;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = takeInput();
		spiralprint(arr);

	}

	public static int[][] takeInput() {
		Scanner s = new Scanner(System.in);
		int rows = s.nextInt();
		int cols = s.nextInt();
		int[][] retVal = new int[rows][cols];
		for (int row = 0; row < retVal.length; row++) {
			retVal[row] = new int[cols];
			for (int col = 0; col < retVal[row].length; col++) {
				retVal[row][col] = s.nextInt();
			}
		}
		return retVal;
	}

	public static void spiralprint(int[][] arr) {
		int left = 0, top = 0, right = arr[0].length - 1, bottom = arr.length - 1;
		while (left <= right && top <= bottom) {
			int dir = 1;
			if (dir == 1) {
				for (int i = left; i <= right; i++) {
					System.out.print(arr[top][i] + ", ");
				}
				dir = 2;
				top++;
			}
			if (dir == 2) {
				for (int i = top; i <= bottom; i++) {
					System.out.print(arr[i][right] + ", ");
				}
				dir = 3;
				right--;
			}
			if (top <= bottom) {
				if (dir == 3) {
					for (int i = right; i >= left; i--) {
						System.out.print(arr[bottom][i] + ", ");
					}
					dir = 4;
					bottom--;
				}
			}
			if (dir == 4) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(arr[i][left] + ", ");
				}
				left++;
				dir = 1;
			}
		}
		System.out.print("END");
	}

}
