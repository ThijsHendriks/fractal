package nl.hendriks.mandelbrot.iteraties;

import nl.hendriks.work.Uitvoerder;
import nl.hendriks.work.UitvoerderMaker;

public class MandelbrotUitvoerderMaker implements UitvoerderMaker<CoordinatenBlok, CoordinatenBlok> {

	private final MandelbrotInvoer invoer;

	public MandelbrotUitvoerderMaker(final MandelbrotInvoer invoer) {
		super();
		this.invoer = invoer;
	}
	
	@Override
	public Uitvoerder<CoordinatenBlok, CoordinatenBlok> maakUitvoerder() {
		return new MandelbrotUitvoerder(invoer);
	}

}
