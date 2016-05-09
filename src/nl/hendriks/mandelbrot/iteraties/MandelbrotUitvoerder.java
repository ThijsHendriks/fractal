package nl.hendriks.mandelbrot.iteraties;

import nl.hendriks.work.Uitvoerder;

public class MandelbrotUitvoerder implements Uitvoerder<CoordinatenBlok, CoordinatenBlok> {

	private final MandelbrotInvoer invoer;

	public MandelbrotUitvoerder(final MandelbrotInvoer invoer) {
		super();
		this.invoer = invoer;
	}
	@Override
	public CoordinatenBlok doeWerk(CoordinatenBlok werk) throws InterruptedException {
		werk.doeAantalIteraties(invoer.getMaximaalAantalHerhalingen());
		return werk;
	}

}
