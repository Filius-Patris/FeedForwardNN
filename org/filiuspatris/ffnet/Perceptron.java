package org.filiuspatris.ffnet;

import java.util.function.DoubleFunction;

public class Perceptron {
	
	public double w1, w2, b;
	public double getw1() { return w1; }
	public double getw2() { return w2; }
	public double getb() { return b; }

	public double i1, i2, o, a;

	public double dadw1, dadw2, dadb;

	public double dado, dodw1, dodw2, dodb;

	public static final DoubleFunction<Double> ReLU = in -> in < 0 ? 0 : in;
	public DoubleFunction<Double> activationFunction;
	public static final DoubleFunction<Double> dReLUdx = in -> in < 0 ? 0 : 1.0;
	public DoubleFunction<Double> derActivationFunction = dReLUdx;

	public Perceptron () { this (Perceptron.ReLU); }

	public Perceptron (DoubleFunction<Double> activationFunction) {
		this.w1 = Math.random();
		this.w2 = Math.random();
		this.b = Math.random();
		this.activationFunction = activationFunction;
	}

	public void train (double i1, double i2) {
	}

	public double test (double i1, double i2) {
		this.i1 = i1;
		this.i2 = i2;
		o = (i1 * w1) + (i2 * w2) + b;
		a = activationFunction.apply(o);

		dado = derActivationFunction.apply (o);
		dodw1 = i1;
		dodw2 = i2;
		dodb = 1;

		dadw1 = dado * dodw1;
		dadw2 = dado * dodw2;
		dadb = dado * dodb;

		return a;
	}
}
