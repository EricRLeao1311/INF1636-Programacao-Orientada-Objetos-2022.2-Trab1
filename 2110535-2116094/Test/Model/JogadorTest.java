package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogadorTest {

	private static final int DEFAULT_TIMEOUT = 5000;
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void inicializaBlocoDeNotasTest() {
		Carta novaCarta = new Carta("cartaTeste", "teste");
		Carta[] arrayCartas = {novaCarta,novaCarta,novaCarta};
		Jogador teste =  new Jogador(arrayCartas, "pedro", 1);
		
		assertNotNull(teste.getBloco());
	}
	
	public void jogadorEliminadoTest() {
		Carta novaCarta = new Carta("cartaTeste", "teste");
		Carta[] arrayCartas = {novaCarta,novaCarta,novaCarta};
		Jogador teste =  new Jogador(arrayCartas, "pedro", 1);
		teste.setEliminado(true);
		assertTrue(teste.getEliminado());
	}
}
