package nl.hendriks.work;

public class SynchroonTest {

	public static void main(String[] args) {
		SynchroonUitvoerderManager<Integer, Integer> synchroonUitvoerderManager = new SynchroonUitvoerderManager<>(
				10, new TestWerkgever(), new TestUitvoerderMaker());
		synchroonUitvoerderManager.voerUit();
	}
}
