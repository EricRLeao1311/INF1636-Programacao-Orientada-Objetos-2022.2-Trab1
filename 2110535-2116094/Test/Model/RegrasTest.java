package Model;
import org.junit.*;
import static org.junit.Assert.*;

public class RegrasTest {
	private static final int DEFAULT_TIMEOUT = 5000;

	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void CriaBaralho() {
		assertNotNull(Baralho.getInstance().setCartasEmbaralhadas());
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaSuspeitos() {
		Baralho.getInstance().nullCartas();
		Carta[] baralho = Baralho.getInstance().setCartas();
		for(int i=0;i<6;i++) {
			System.out.println(baralho[i].nome);
			assertEquals(baralho[i].nome,Regras.suspeitos[i]);
			assertEquals(baralho[i].tipo,"Suspeito");
		}
	
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaArmas() { 
		Carta[] baralho = Baralho.getInstance().setCartas();
		for(int i=6;i<12;i++) {
			assertEquals(baralho[i].nome,Regras.armas[i-6]);
			assertEquals(baralho[i].tipo,"Arma");
		}
	
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaComodos() {
		Carta[] baralho = Baralho.getInstance().setCartas();
		for(int i=12;i<21;i++) {
			assertEquals(baralho[i].nome,Baralho.comodos[i-12]);
			assertEquals(baralho[i].tipo,"Cômodo");
		}
	
	}	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void CriaRespostaTipo() {
		Carta[] baralho = Baralho.getInstance().setCartas();
		Carta[] resposta = Resposta.criaResposta(baralho);
		
		assertEquals(resposta[0].tipo,"Cômodo");
		assertEquals(resposta[1].tipo,"Suspeito");
		assertEquals(resposta[2].tipo,"Arma");
		
		for (int i = 0;i<18;i++) {
			assertNotEquals(baralho[i].nome, resposta[0].nome);
			assertNotEquals(baralho[i].nome, resposta[1].nome);
			assertNotEquals(baralho[i].nome, resposta[2].nome);
		}
	}

	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaPalpiteErrado() {
		Carta[] baralho = Baralho.getInstance().setCartas();
		Carta[] resposta = Resposta.criaResposta(baralho);
		boolean [] arrayBool = {true, true, true, false, false, false};
		Jogador[] jogadores = Regras.criaJogadores(baralho, arrayBool);
		
		String[] palpite = new String[3];
		palpite[1] = resposta[1].nome;
		palpite[2] = resposta[2].nome;
		
		for(int i = 0;i<3;i++) {
			for(int d=0;d<3;d++) {
				palpite[0] = jogadores[i].cartasJogador[d].nome;
				assertNotNull(Regras.checaPalpite(resposta,palpite,jogadores[i], 3, baralho,jogadores));
			}
			
		}
		
		
		
		
	}

	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaPalpiteCorreto(){
		Carta[] baralho = Baralho.getInstance().setCartas();
		Carta[] resposta = Resposta.criaResposta(baralho);
		boolean [] arrayBool = {true, true, true, false, false, false};
		Jogador[] jogadores = Regras.criaJogadores(baralho, arrayBool);
		
		String[] palpite = new String[3];
		palpite[0] = resposta[0].nome;
		palpite[1] = resposta[1].nome;
		palpite[2] = resposta[2].nome;
		assertNull(Regras.checaPalpite(resposta,palpite,jogadores[0], 3, baralho,jogadores));
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaAcusacaoErrado() {
		Carta[] baralho = Baralho.getInstance().setCartas();
		Carta[] resposta = Resposta.criaResposta(baralho);
		boolean [] arrayBool = {true, true, true, false, false, false};
		Jogador[] jogadores = Regras.criaJogadores(baralho, arrayBool);
		String[] palpite = new String[3];
		palpite[1] = resposta[1].nome;
		palpite[2] = resposta[2].nome;
		palpite[0] = jogadores[1].cartasJogador[0].nome;
		assertFalse(Regras.checaAcusacao(resposta,palpite));
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaAcusacaoCorreto(){
		Carta[] baralho = Baralho.getInstance().setCartas();
		Carta[] resposta = Resposta.criaResposta(baralho);
		String[] palpite = new String[3];
		palpite[0] = resposta[0].nome;
		palpite[1] = resposta[1].nome;
		palpite[2] = resposta[2].nome;
		assertTrue(Regras.checaAcusacao(resposta,palpite));
	}
	
	@Test (timeout = DEFAULT_TIMEOUT)
	public void ChecaEliminado() {
		Carta[] baralho = Baralho.getInstance().setCartas();
		boolean [] arrayBool = {true, true, true, false, false, false};
		Jogador[] jogadores = Regras.criaJogadores(baralho, arrayBool);
		
		API.setEliminado(jogadores[0]);
		assertTrue(jogadores[0].eliminado);
	}

	
}