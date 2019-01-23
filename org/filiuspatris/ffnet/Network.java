package org.filiuspatris.ffnet;

public class Network {
	
	public Perceptron perceptron;

	public Network () {
		perceptron = new Perceptron();
	}
	
	public double train () {
		double[] inputs1 = new double[] {0, 0, 1, 1};
		double[] inputs2 = new double[] {0, 1, 0, 1};
		double[] outputs = new double[] {0, 0, 0, 1};

		double avgC = 0;
		double deltaW1 = 0;
		double deltaW2 = 0;
		double deltaB = 0;

		for (int i = 0; i < 4; i++) {
			double y = perceptron.test(inputs1[i], inputs2[i]);
			
			avgC += 0.5 * Math.pow(outputs[i] - y, 2);

			double dCda = outputs[i] - y;

			double dCdw1 = dCda * perceptron.dadw1;
			double dCdw2 = dCda * perceptron.dadw2;
			double dCdb = dCda * perceptron.dadb;

			deltaW1 += dCdw1;
			deltaW2 += dCdw2;
			deltaB += dCdb;
		}

		avgC /= 4;
		deltaW1 /= 4;
		deltaW2 /= 4;
		deltaB /= 4;

		perceptron.w1 += deltaW1;
		perceptron.w2 += deltaW2;
		perceptron.b += deltaB;

		return avgC;
	}
}
