package nl.hendriks.mandelbrot.iteraties;

public class MandelbrotCoordinaat {
	private int iteratie = 0;

	private double x;

	private double y;

	private double detail;

	private double zx = 0.0;
	private double zy = 0.0;
	private double zx2 = 0.0;
	private double zy2 = 0.0;

	public MandelbrotCoordinaat(double x, double y, double detail) {
		super();
		this.x = x;
		this.y = y;
		this.detail = detail;
	}
	
	public void doeIteraties(int maximumAantalInteraties) {
		for (int i = iteratie; i < maximumAantalInteraties && zx2 + zy2 < detail; i++) {
			zy = 2.0 * zx * zy + y;
			zx = zx2 - zy2 + x;
			zx2 = zx * zx;
			zy2 = zy * zy;
			iteratie++;
		}
	}
	

	public void reset(double x, double y, double detail) {
		iteratie = 0;
		this.x = x;
		this.y = y;
		this.detail = detail;
		zx = 0.0;
		zy = 0.0;
		zx2 = 0.0;
		zy2 = 0.0;
	}


	public int getIteratie() {
		return iteratie;
	}


}
