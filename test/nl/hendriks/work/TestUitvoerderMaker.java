package nl.hendriks.work;

public class TestUitvoerderMaker implements UitvoerderMaker<Integer, Integer> {

	@Override
	public Uitvoerder<Integer, Integer> maakUitvoerder() {
		return new TestUitvoerder();
	}

}
