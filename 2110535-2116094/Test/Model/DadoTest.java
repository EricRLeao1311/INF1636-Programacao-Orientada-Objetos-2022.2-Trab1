package Model;
import org.junit.*;
import static org.junit.Assert.*;

public class DadoTest {
	private static final int DEFAULT_TIMEOUT = 5000;
	@Test (timeout = DEFAULT_TIMEOUT)
	public void JogaDadoTest() {
		
		boolean checaErro = true;
		
		for(int i=0;i<500;i++) {
			Dado.jogaDado();
			int valor = Dado.getDado();
			if (valor<0 || valor>6) {
				checaErro = false;
			}
		}
		assertTrue(checaErro);
	}
}