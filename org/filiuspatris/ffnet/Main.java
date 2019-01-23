package org.filiuspatris.ffnet;

import java.util.function.DoubleFunction;

public class Main {
	public static void main(String... args) {
		Network network = new Network();

		for (int i = 0; i < 100; i++) {
			System.out.println(network.train());
		}
	}
}
