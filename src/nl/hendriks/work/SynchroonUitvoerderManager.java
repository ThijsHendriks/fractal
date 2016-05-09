package nl.hendriks.work;

class SynchroonUitvoerderManager<W, U> {



	private Werkgever<W, U> werkgever;
	private UitvoerderMaker<W, U> uitvoerderMaker;
	private int aantalUitvoerders;


	public SynchroonUitvoerderManager(int aantalUitvoerders,
			Werkgever<W, U> werkgever, UitvoerderMaker<W, U> uitvoerderMaker) {
		super();
		this.aantalUitvoerders = aantalUitvoerders;
		this.werkgever = werkgever;
		this.uitvoerderMaker = uitvoerderMaker;
	}

	
	public void voerUit() {
		UitvoerManager<W, U> uitvoerManager = new  UitvoerManager<W, U> (aantalUitvoerders, new SynchroonWerkgever<>(werkgever, Thread.currentThread()), uitvoerderMaker);
		uitvoerManager.voerUit();
		wachtTotKlaar();
	}


	private void wachtTotKlaar() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}



}
