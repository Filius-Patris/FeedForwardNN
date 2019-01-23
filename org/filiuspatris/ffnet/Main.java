package org.filiuspatris.ffnet;

import java.util.function.DoubleFunction;

public class Main {
	public static void main(String... args) {
		DoubleFunction<Double> lReLU = in -> in < 0 ? 0 : in;
		DoubleFunction<Double> dlReLUdx = in -> in < 0 ? 0.0 : 1;
		
		double[] inputs1 = new double[] {0, 0, 1, 1};
		double[] inputs2 = new double[] {0, 1, 0, 1};
		double[] outputs = new double[] {0, 0, 0, 1};
		
		double w1 = 0;
		double w2 = 0;
		double b = 0;
		double i1, i2, o, a, y, C, dCda, dado, dodw1, dodw2, dodb, dCdw1, dCdw2, dCdb;
		
		double avgC = 0;
		double avgdCdw1 = 0;
		double avgdCdw2 = 0;
		double avgdCdb = 0;
		
		for (int j = 0; j < 1000; j++) {
			for (int i = 0; i < 4; i++) {
				i1 = inputs1[i];
				i2 = inputs2[i];
				y = outputs[i];
				
				o = (i1 * w1) + (i2 * w2) + b;
				
				a = lReLU.apply(o);
				
				C = 0.5 * Math.pow(y-a, 2);
				
				dCda = y-a;
				
				dado = dlReLUdx.apply(o);
				
				dodw1 = i1;
				dodw2 = i2;
				dodb = 1;
				
				dCdw1 = dCda * dado * dodw1;
				dCdw2 = dCda * dado * dodw2;
				dCdb = dCda * dado * dodb;
				
				avgC += C;
				avgdCdw1 += dCdw1;
				avgdCdw2 += dCdw2;
				avgdCdb += dCdb;
			}
			
			avgC /= 4;
			avgdCdw1 /= 4;
			avgdCdw2 /= 4;
			avgdCdb /= 4;
			
			System.out.println(avgC);
			
			w1 += avgdCdw1;
			w2 += avgdCdw2;
			b += avgdCdb;
		}
	}
}
