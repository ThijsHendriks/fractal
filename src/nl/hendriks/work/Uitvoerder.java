package nl.hendriks.work;

public interface Uitvoerder<W, U> {

	U doeWerk(W werk)  throws InterruptedException;
}
