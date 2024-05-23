package com.etixapp.java.base.basics;

import java.util.Arrays;

public class Mutation {

	public static void main(String[] args) {

		//abc123
		int[] arr = new int[] { 1, 2, 3 };

		// this one could change the original array
		predict(arr);

		totalSale(arr);

	}

	private static void predict(int[] a) {

		//def23
		a = Arrays.copyOf(a,
				a.length); // without this line the original array will be modified and the output will be different
		a[0]++;
		a[1]++;
		System.out.println("Prediction for next month :: " + (a[0] + a[1] + a[2]));
	}

	//abc123
	private static void totalSale(int[] a) {

		//abc123
		System.out.println("Total Sale for this month :: " + (a[0] + a[1] + a[2]));

	}
}
