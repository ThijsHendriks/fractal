package nl.hendriks.work;

class SynchroonWerkgever<W, U> implements Werkgever<W, U> {

	private final Werkgever<W, U> werkgever;
	
	public SynchroonWerkgever(Werkgever<W, U> werkgever,
			Thread aanroependeThread) {
		super();
		this.werkgever = werkgever;
		this.aanroependeThread = aanroependeThread;
	}

	private final Thread aanroependeThread;

	public void init() {
		werkgever.init();
	}

	public W geefWerk() {
		return werkgever.geefWerk();
	}

	public void verwerkUitgevoerdWerk(U uitgevoerdWerk) {
		werkgever.verwerkUitgevoerdWerk(uitgevoerdWerk);
	}

	public void reset() {
		werkgever.reset();
	}

	public void klaar() {
//		werkgever.klaar();
		aanroependeThread.interrupt();
	}

	@Override
	public void addKlaarListener(WerkKlaarListener listener) {
		// TODO Auto-generated method stub
		
	}


}
