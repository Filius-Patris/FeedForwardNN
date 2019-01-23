package org.filiuspatris.ffnet;

import java.util.function.DoubleFunction;

public class Perceptron {
	
	private double w1, w2, b;
	public double getw1() { return w1; }
	public double getw2() { return w2; }
	public double getb() { return b; }

	public static final DoubleFunction<Double> ReLU = in -> in < 0 ? 0 : in;
	DoubleFunction<Double> activationFunction;

	public Perceptron () { this (Math.random(), Math.random(), Math.random(), Perceptron.ReLU); }

	public Perceptron (double w1, double w2, double b, DoubleFunction<Double> activationFunction) {
		this.w1 = w1;
		this.w2 = w2;
		this.b = b;
		this.activationFunction = activationFunction;
	}

	public void train (double i1, double i2) {
	}

	public double test (double i1, double i2) {
		double o = (i1 * w1) + (i2 * w2) + b;
		double a = activationFunction.apply(o);
		return a;
	}
}
