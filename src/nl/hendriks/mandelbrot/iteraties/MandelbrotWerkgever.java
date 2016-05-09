package nl.hendriks.mandelbrot.iteraties;

import java.util.ArrayList;
import java.util.List;

import nl.hendriks.work.WerkKlaarListener;
import nl.hendriks.work.Werkgever;

public class MandelbrotWerkgever implements	Werkgever<CoordinatenBlok, CoordinatenBlok> {

	private int x;
	private int y;
	private MandelbrotInvoer invoer;
	private int blokGrootte;
	private List<WerkKlaarListener> werkKlaarListeners = new ArrayList<>();
	private List<VerwerkBlokListener> verwerkBlokListeners = new ArrayList<>();
	private int aantalPackettenUitgegeven;
	private int aantalPackettenVerwerkt;
	private boolean klaar = false;
	private boolean laatstePakketUitgegeven = false;
	private List<CoordinatenBlok> blokPool = new ArrayList<>();


	public MandelbrotWerkgever(MandelbrotInvoer invoer, int blokGrootte) {
		super();
		this.invoer = invoer;
		this.blokGrootte = blokGrootte;
		verwerkBlokListeners.add(invoer);
	}

	@Override
	public void init() {
		reset();
	}

	@Override
	public CoordinatenBlok geefWerk() {
		if(laatstePakketUitgegeven) {
			return null;
		}
		int breedte = blokGrootte;
		int hoogte = blokGrootte;
		x += blokGrootte;

		if (x >= invoer.getBreedte()) {
			x = 0;
			y += blokGrootte;
		}
		if (y >= invoer.getHoogte()) {
			laatstePakketUitgegeven = true;
			return null;
		}
		klaar = false;
		aantalPackettenUitgegeven++;
		if(x + blokGrootte > invoer.getBreedte()) {
			breedte = invoer.getBreedte() - (x + blokGrootte);
		}
		if(y + blokGrootte > invoer.getHoogte()) {
			hoogte = invoer.getHoogte() - (y + blokGrootte);
		}
		CoordinatenBlok coordinaat = getCoordinatenBlok();
		coordinaat.reset(new Coordinaat(x, y),invoer.getX(), invoer.getY(),  breedte, hoogte, invoer.getZoomFactor(), invoer.getDetail());
		return coordinaat;
	}

	private CoordinatenBlok getCoordinatenBlok() {
		CoordinatenBlok coordinaat;
		if(blokPool.size() == 0) {
			coordinaat = new CoordinatenBlok(new Coordinaat(x, y),invoer.getX(), invoer.getY(),  blokGrootte, invoer.getZoomFactor(), invoer.getDetail());
		} else {
			coordinaat = blokPool.get(0);
			blokPool.remove(coordinaat);
		}
		return coordinaat;
	}

	private void geeftCoordinatenBlokTerug(CoordinatenBlok coordinaat) {
		blokPool.add(coordinaat);
	}
	
	@Override
	public void verwerkUitgevoerdWerk(CoordinatenBlok uitgevoerdWerk) {
		aantalPackettenVerwerkt++;
		for (VerwerkBlokListener verwerkBlokListener : verwerkBlokListeners) {
			verwerkBlokListener.verwerkBlok(uitgevoerdWerk);
		}
		geeftCoordinatenBlokTerug(uitgevoerdWerk);
		klaar();
	}

	@Override
	public void reset() {
		x = 0;
		y = 0;
		laatstePakketUitgegeven = false;
		klaar = false;

	}

	public void addKlaarListener(WerkKlaarListener listener) {
		synchronized (werkKlaarListeners) {
			if (!werkKlaarListeners.contains(listener)) {
				werkKlaarListeners.add(listener);
			}
		}
	}

	public void klaar() {
		if (!klaar && laatstePakketUitgegeven
				&& aantalPackettenVerwerkt == aantalPackettenUitgegeven) {
			klaar = true;
			for (WerkKlaarListener listener : werkKlaarListeners) {
				listener.klaar();
			}
			blokPool.clear();
		}
	}
}
