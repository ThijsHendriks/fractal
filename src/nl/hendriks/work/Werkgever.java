package nl.hendriks.work;

public interface Werkgever<W, U> {

	void init();
	
	W geefWerk();
	
	void verwerkUitgevoerdWerk(U uitgevoerdWerk);
	
	void reset();
	
	void addKlaarListener(WerkKlaarListener listener);
	
}
