package nl.hendriks.work;

public class TestUitvoerder implements Uitvoerder<Integer, Integer> {

	@Override
	public Integer doeWerk(Integer werk) throws InterruptedException {
			Thread.sleep(50);
		return werk.intValue() * werk.intValue();
	}

}
