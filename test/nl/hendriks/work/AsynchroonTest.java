package nl.hendriks.work;

public class AsynchroonTest {
	public static void main(String[] args) {

		UitvoerManager<Integer, Integer> uitvoerderManager = new UitvoerManager<Integer, Integer>(
				10, new TestWerkgever(), new TestUitvoerderMaker());
		uitvoerderManager.voerUit();
		uitvoerderManager.stop();

	}
}
