package nl.hendriks.work;

import java.util.ArrayList;
import java.util.List;

public class UitvoerManager<W, U> {

	private List<UitvoerderThread<W, U>> uitvoerders;
	private Werkgever<W, U> werkgever;
	private int aantalUitvoerders;
	private UitvoerderMaker<W, U> uitvoerderMaker;

	public UitvoerManager(int aantalUitvoerders, Werkgever<W, U> werkgever,
			UitvoerderMaker<W, U> uitvoerderMaker) {
		super();
		this.aantalUitvoerders = aantalUitvoerders;
		this.werkgever = werkgever;
		this.uitvoerderMaker = uitvoerderMaker;
	}

	public void voerUit() {
		werkgever.init();
		uitvoerders = new ArrayList<>();
		for (int i = 0; i < aantalUitvoerders; i++) {
			UitvoerderThread<W, U> uitvoerderThread = new UitvoerderThread<>(
					uitvoerderMaker.maakUitvoerder(), werkgever);
			uitvoerders.add(uitvoerderThread);
			uitvoerderThread.start();
		}
	}

	public void stop() {
		for (UitvoerderThread<W, U> uitvoerderThread : uitvoerders) {
			uitvoerderThread.setStop(true);
			uitvoerderThread.interrupt();
		}
	}
}
