package Model;

public class Comodo {
	String nome;
	private String [] ocupado = {null,null,null,null,null,null};
	Posicao posicoes[] = new Posicao[6];
	Posicao entradas[];
	int qtdEntradas;
	Comodo(String nome) {
		if (nome.equals("Entrada")) {
			posicoes[0] = new Posicao (API.arrumaX(287), API.arrumaY(539));
			posicoes[1]= new Posicao(API.arrumaX(314), API.arrumaY(536));
			posicoes[2]= new Posicao(API.arrumaX(339), API.arrumaY(538));
			posicoes[3]= new Posicao(API.arrumaX(365), API.arrumaY(539));
			posicoes[4]= new Posicao(API.arrumaX(392), API.arrumaY(541));
			posicoes[5]= new Posicao(API.arrumaX(418), API.arrumaY(540));
			qtdEntradas = 3;
			entradas = new Posicao[3];
			entradas[0] = new Posicao(API.arrumaX(335), API.arrumaY(483));
			entradas[1] = new Posicao(API.arrumaX(358), API.arrumaY(485));
			entradas[2] = new Posicao(API.arrumaX(437), API.arrumaY(564));
		}
		if (nome.equals("Sala de Estar")) {
			posicoes[0] = new Posicao (API.arrumaX(89), API.arrumaY(566));
			posicoes[1]= new Posicao(API.arrumaX(114), API.arrumaY(564));
			posicoes[2]= new Posicao(API.arrumaX(140), API.arrumaY(566));
			posicoes[3]= new Posicao(API.arrumaX(88), API.arrumaY(594));
			posicoes[4]= new Posicao(API.arrumaX(118), API.arrumaY(588));
			posicoes[5]= new Posicao(API.arrumaX(141), API.arrumaY(584));
			qtdEntradas = 1;
			entradas = new Posicao[1];
			entradas[0] = new Posicao(API.arrumaX(214), API.arrumaY(510));
		}
		if (nome.equals("Sala de Jantar")) {
			posicoes[0] = new Posicao (API.arrumaX(111), API.arrumaY(337));
			posicoes[1]= new Posicao(API.arrumaX(140), API.arrumaY(337));
			posicoes[2]= new Posicao(API.arrumaX(164), API.arrumaY(337));
			posicoes[3]= new Posicao(API.arrumaX(165), API.arrumaY(365));
			posicoes[4]= new Posicao(API.arrumaX(135), API.arrumaY(363));
			posicoes[5]= new Posicao(API.arrumaX(107), API.arrumaY(362));
			qtdEntradas = 2;
			entradas = new Posicao[2];
			entradas[0] = new Posicao(API.arrumaX(211), API.arrumaY(460));
			entradas[1] = new Posicao(API.arrumaX(259), API.arrumaY(365));
		}
		if (nome.equals("Cozinha")) {
			posicoes[0] = new Posicao (API.arrumaX(160), API.arrumaY(144));
			posicoes[1]= new Posicao(API.arrumaX(137), API.arrumaY(144));
			posicoes[2]= new Posicao(API.arrumaX(112), API.arrumaY(142));
			posicoes[3]= new Posicao(API.arrumaX(114), API.arrumaY(165));
			posicoes[4]= new Posicao(API.arrumaX(140), API.arrumaY(162));
			posicoes[5]= new Posicao(API.arrumaX(164), API.arrumaY(167));
			qtdEntradas = 1;
			entradas = new Posicao[1];
			entradas[0] = new Posicao(API.arrumaX(161), API.arrumaY(239));
		}
		if (nome.equals("Sala de Música")) {
			posicoes[0] = new Posicao (API.arrumaX(341), API.arrumaY(186));
			posicoes[1]= new Posicao(API.arrumaX(363), API.arrumaY(188));
			posicoes[2]= new Posicao(API.arrumaX(391), API.arrumaY(186));
			posicoes[3]= new Posicao(API.arrumaX(390), API.arrumaY(216));
			posicoes[4]= new Posicao(API.arrumaX(363), API.arrumaY(212));
			posicoes[5]= new Posicao(API.arrumaX(335), API.arrumaY(210));
			qtdEntradas = 4;
			entradas = new Posicao[4];
			entradas[0] = new Posicao(API.arrumaX(238), API.arrumaY(188));
			entradas[1] = new Posicao(API.arrumaX(287), API.arrumaY(258));
			entradas[2] = new Posicao(API.arrumaX(413), API.arrumaY(261));
			entradas[3] = new Posicao(API.arrumaX(462), API.arrumaY(184));
		}
		if (nome.equals("Jardim de Inverno")) {
			posicoes[0] = new Posicao (API.arrumaX(542), API.arrumaY(134));
			posicoes[1]= new Posicao(API.arrumaX(565), API.arrumaY(134));
			posicoes[2]= new Posicao(API.arrumaX(592), API.arrumaY(135));
			posicoes[3]= new Posicao(API.arrumaX(587), API.arrumaY(158));
			posicoes[4]= new Posicao(API.arrumaX(563), API.arrumaY(156));
			posicoes[5]= new Posicao(API.arrumaX(537), API.arrumaY(155));
			qtdEntradas = 1;
			entradas = new Posicao[1];
			entradas[0] = new Posicao(API.arrumaX(517), API.arrumaY(191));
		}
		if (nome.equals("Salão de Jogos")) {
			posicoes[0] = new Posicao (API.arrumaX(536), API.arrumaY(313));
			posicoes[1]= new Posicao(API.arrumaX(565), API.arrumaY(316));
			posicoes[2]= new Posicao(API.arrumaX(588), API.arrumaY(313));
			posicoes[3]= new Posicao(API.arrumaX(589), API.arrumaY(332));
			posicoes[4]= new Posicao(API.arrumaX(564), API.arrumaY(335));
			posicoes[5]= new Posicao(API.arrumaX(538), API.arrumaY(337));
			qtdEntradas = 2;
			entradas = new Posicao[2];
			entradas[0] = new Posicao(API.arrumaX(483), API.arrumaY(286));
			entradas[1] = new Posicao(API.arrumaX(609), API.arrumaY(386));
		}
		if (nome.equals("Biblioteca")) {
			posicoes[0] = new Posicao (API.arrumaX(589), API.arrumaY(482));
			posicoes[1]= new Posicao(API.arrumaX(563), API.arrumaY(484));
			posicoes[2]= new Posicao(API.arrumaX(531), API.arrumaY(482));
			posicoes[3]= new Posicao(API.arrumaX(532), API.arrumaY(461));
			posicoes[4]= new Posicao(API.arrumaX(561), API.arrumaY(469));
			posicoes[5]= new Posicao(API.arrumaX(587), API.arrumaY(470));
			qtdEntradas = 2;
			entradas = new Posicao[2];
			entradas[0] = new Posicao(API.arrumaX(463), API.arrumaY(465));
			entradas[1] = new Posicao(API.arrumaX(563), API.arrumaY(384));
		}
		if (nome.equals("Escritório")) {
			posicoes[0] = new Posicao (API.arrumaX(513), API.arrumaY(586));
			posicoes[1]= new Posicao(API.arrumaX(536), API.arrumaY(587));
			posicoes[2]= new Posicao(API.arrumaX(562), API.arrumaY(587));
			posicoes[3]= new Posicao(API.arrumaX(563), API.arrumaY(616));
			posicoes[4]= new Posicao(API.arrumaX(538), API.arrumaY(613));
			posicoes[5]= new Posicao(API.arrumaX(513), API.arrumaY(612));
			qtdEntradas = 1;
			entradas = new Posicao[1];
			entradas[0] = new Posicao(API.arrumaX(487), API.arrumaY(560));
		}
		this.nome = nome;
		
	}

	Posicao getLivre() {
		for (int c = 0; c<6; c++) {
			if (ocupado[c]==null)
				return posicoes[c];
		}
		return null;
	}
	
	void entraComodo(String jogador){
		for (int c = 0; c<6; c++) {
			if (ocupado[c]==null && encontraNoComodo(jogador)) {
				ocupado[c] = jogador;
				break;
			}
		}
	}
	
	void saiComodo(String jogador) {
		for (int c = 0; c<6; c++) {
			if (jogador.equals(ocupado[c])) {
				ocupado[c] = null;
				break;
			}
		}
	}
	boolean encontraNoComodo(String jogador) {
		for (int c = 0; c<6; c++) {
			if (jogador.equals(ocupado[c])) {
				ocupado[c] = jogador;
				return false;
			}
		}
		return true;
	}
	
	String getNome() {
		return nome;
	}
}
