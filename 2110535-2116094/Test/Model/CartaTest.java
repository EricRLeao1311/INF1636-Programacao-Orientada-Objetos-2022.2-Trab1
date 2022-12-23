package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartaTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	@Test (timeout = DEFAULT_TIMEOUT)
	public void cartaDonoTest() {
		Carta novaCarta = new Carta("cartaTeste", "teste");
		Carta[] arrayCartas = {novaCarta,novaCarta,novaCarta};
		
		Jogador teste =  new Jogador(arrayCartas, "pedro", 1) ;
		novaCarta.setDono(teste);
		
		assertEquals(novaCarta.dono, teste);
	}

}
