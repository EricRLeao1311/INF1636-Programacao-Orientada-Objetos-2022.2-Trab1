package Model;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BaralhoTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	@Test (timeout = DEFAULT_TIMEOUT)
	public void BaralhoSingletonTest() {
		
		Baralho example = Baralho.getInstance();
		Carta[] baralho = example.setCartasEmbaralhadas();
		
		Baralho testSingleton = Baralho.getInstance();
		Carta[] baralhoTest = testSingleton.getCartas();
		
		assertArrayEquals(baralho,baralhoTest);
		
	}
	@Test (timeout = DEFAULT_TIMEOUT)
	public void BaralhoResetTest() {
		Baralho example = Baralho.getInstance();
		Carta[] antes = example.setCartasEmbaralhadas();
		API.restartCartas();
		Carta[] depois = example.getCartas();
		assertFalse(Arrays.equals(antes, depois));
	}
}
