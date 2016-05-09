package nl.hendriks.work;

class UitvoerderThread<W, U> extends Thread {

	private final Uitvoerder<W, U> uitvoerder;

	private final Werkgever<W, U> werkgever;

	private boolean stop = false;


	UitvoerderThread(Uitvoerder<W, U> uitvoerder, Werkgever<W, U> werkgever) {
		super();
		this.uitvoerder = uitvoerder;
		this.werkgever = werkgever;
	}

	@Override
	public final void run() {
		W werk = null;
		while (!stop) {
			synchronized (werkgever) {
				werk = werkgever.geefWerk();
			}
			while (werk != null) {
				U uitgevoerdWerk = null;
				try {
					uitgevoerdWerk = uitvoerder.doeWerk(werk);
				} catch (InterruptedException e) {
					if(stop) {
						return;
					}
					continue;
				}
				synchronized (werkgever) {
					werkgever.verwerkUitgevoerdWerk(uitgevoerdWerk);
					werk = werkgever.geefWerk();
				}
			}
			try {
				sleep(200);
			} catch (InterruptedException e) {
				if(stop) {
					return;
				}
				continue;
			}
		}
	}
	

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
