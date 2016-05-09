package nl.hendriks.mandelbrot.iteraties;

public class MandelbrotBerekening {



	public static int bereken(double px, double py, int maximaalAantalHerhalingen, double detail) {
		double zx = 0.0;
		double zy = 0.0;
		double zx2 = 0.0;
		double zy2 = 0.0;
		int waarde = 0;
		while (waarde < maximaalAantalHerhalingen && zx2 + zy2 < detail) {
			zy = 2.0 * zx * zy + py;
			zx = zx2 - zy2 + px;
			zx2 = zx * zx;
			zy2 = zy * zy;
			waarde++;
		}
		return waarde;
	}

	// public int MBrot(float x, float y)
	// {
	// float epsilon = 0.0001f; // The step size across the X and Y axis
	// int maxIterations = 10; // increasing this will give you a more detailed
	// fractal
	// int maxColors = 256; // Change as appropriate for your display.
	//
	// Complex Z;
	// Complex C;
	// int iterations;
	// // for(x=-2; x<=2; x+= epsilon)
	// // {
	// // for(y=-2; y<=2; y+= epsilon)
	// // {
	// iterations = 0;
	// C = new Complex(x, y);
	// Z = new Complex(0,0);
	// while(Complex.Abs(Z) < 2 && iterations < maxIterations)
	// {
	// Z = Z*Z + C;
	// iterations++;
	// }
	// return maxColors % iterations; // depending on the number of iterations,
	// color a pixel.
	// // }
	// // }
	// }

}
