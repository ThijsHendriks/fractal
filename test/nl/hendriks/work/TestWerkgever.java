package nl.hendriks.work;

public class TestWerkgever implements Werkgever<Integer, Integer> {

	private int i = 0;
	
	@Override
	public void init() {
		
	}

	@Override
	public Integer geefWerk() {
		while (i < 1000) {
			return ++i;
		}
		return null;
	}

	@Override
	public void verwerkUitgevoerdWerk(Integer uitgevoerdWerk) {
		
		
	}

	@Override
	public void reset() {

		
	}

//	@Override
//	public void klaar() {
//		System.out.println("finish");
//	}

	@Override
	public void addKlaarListener(WerkKlaarListener listener) {
		// TODO Auto-generated method stub
		
	}

}
