package Model;
class Tabuleiro{
	static void geraPosicoes(Jogador jogador, Posicao posicoes[], Posicao atual, Posicao caminhos[], int passos, int total) {
		if (passos == 0) {
	  		for (Jogador jog: API.jogadores) {
				if (jog != jogador && arrumaX(atual.getX()) == arrumaX(jog.getPosicaoX()) && arrumaY(atual.getY()) == arrumaY(jog.getPosicaoY())) {
					return;
				}
			}
	  	}
	  	if (passos != 0) {
			//checa se alguem ja esta na posicao que o caminho passa
			for (Jogador jog: API.jogadores) {
				if (arrumaX(atual.getX()) == arrumaX(jog.getPosicaoX()) && arrumaY(atual.getY()) == arrumaY(jog.getPosicaoY())) {
					return;
				}
			}
	  		//colocar tudo que esta fora do tabuleiro onde se pode andar
	  		if (atual.getX() >= 625) {
	  			return;
	  		}
	  		if (atual.getX() <= 51) {
	  			return;
	  		}
	  		if (atual.getX() <= 75 && (atual.getY()>=253 || atual.getY()<=227)) {
	  			return;
	  		}
	  		if (atual.getY() <= 77) {
	  			return;
	  		}
	  		if (atual.getY() <= 103 && (atual.getX()<=227 || atual.getX()>=475)) {
	  			return;
	  		}
	  		if (atual.getY() >= 675) {
	  			return;
	  		}
	  		if (atual.getY() >= 651 && (atual.getX() <= 451 || atual.getX() >= 475)) {
	  			return;
	  		}
	  		//sala de estar
	  		if (atual.getY() >= 527 && atual.getX()<=227) {
	  			return;
	  		}
	  		//clue meio
	  		if (atual.getY() >= 301 && atual.getY()<=477 && atual.getX()>=301 && atual.getX()<=425) {
	  			return;
	  		}
	  		//cozinha
	  		if (atual.getY() <= 227 && atual.getX()<=203) {
	  			return;
	  		}
	  		//escritorio
	  		if (atual.getY() >= 575 && atual.getX()>=476) {
	  			return;
	  		}
	  		//entrada
	  		if (atual.getX() >= 275 && atual.getX()<=427 && atual.getY()>=503) {
	  			return;
	  		}
	  		//salao de jogos
	  		if (atual.getY() >= 251 && atual.getX()>=500 && atual.getY()<=376) {
	  			return;
	  		}
	  		//sala de jantar
	  		if (atual.getY()<=453 && ((atual.getX()<=251 && atual.getY()>=301) || (atual.getY()>=275 && atual.getX() <=177))) {
	  			return;
	  		}
	  		//jardim do inverno
	  		if ((atual.getY() <= 177 && atual.getX()>=499) || (atual.getY()<=203 && atual.getX()>=525)) {
	  			return;
	  		}
	  		//biblioteca
	  		if ((atual.getX() >= 475 && atual.getY()>=425 && atual.getY()<=501) || (atual.getX()>=501 && atual.getY()>=399 && atual.getY()<=527)) {
	  			return;
	  		}
	  		//sala de musica
	  		if (atual.getY() <= 251 && ((atual.getX()>=251 && atual.getX()<=451 && atual.getY()>=101) || (atual.getX()>=299 && atual.getX()<=403))) {
	  			return;
	  		}
	  	}
		if (passos != 0) {
			Posicao copia [] = new Posicao [total];
			for (int c = 0; c < total; c++) {
				if (c < passos-1) {
					copia[c] = new Posicao(caminhos[c].getX(),caminhos[c].getY());
				}
				else if (c > passos-1) {
					copia[c] = new Posicao(-1,-1);
				}
				else {
					copia[c] = new Posicao(atual.getX(), atual.getY());
				}
			}
			for(int c = 0; c < passos - 1; c++) {
//				System.out.println(copia[c].getX());
				if(copia[c].getX() == -1) {
					break;
				}
				if(arrumaX(copia[c].getX()) == arrumaX(atual.getX()) && arrumaY(copia[c].getY()) == arrumaY(atual.getY())) {
					return;
				}
			}
			caminhos = copia;
		}
		if (passos == total) {
			for(Posicao pos:posicoes) {
				if(pos.getX() == -1) {
					pos.setPos(atual.getX(), atual.getY());
//					System.out.printf("%d = %d - %d\n", total, arrumaX(atual.getX()), arrumaY(atual.getY()));
					break;
				}
			}
			return;
		}
		Posicao cima = new Posicao(arrumaX(atual.getX()), arrumaY(atual.getY() - 22));
		geraPosicoes(jogador, posicoes, cima, caminhos, passos + 1, total);
		Posicao baixo = new Posicao(arrumaX(atual.getX()), arrumaY(atual.getY() + 22));
		geraPosicoes(jogador, posicoes, baixo, caminhos, passos + 1, total);
		Posicao direita = new Posicao(arrumaX(atual.getX()) + 22, arrumaY(atual.getY()));
		geraPosicoes(jogador, posicoes, direita, caminhos, passos + 1, total);
		Posicao esquerda = new Posicao(arrumaX(atual.getX()) - 22, arrumaY(atual.getY()));
		geraPosicoes(jogador, posicoes, esquerda, caminhos, passos + 1, total);
		return;
	}

	static int arrumaX(int x) {
		return 52 + (x - 52)/25 *25 + 10;
		
	}

	static int arrumaY(int y) {
		return 54 + (y - 54)/25 *25 + 10;
	}

	static Posicao checaPosicao(Jogador jogador, Posicao destino, int passos) {
		Comodo comodoDest = null;
		Posicao atual = new Posicao(jogador.getPosicaoX(),jogador.getPosicaoY());
		{
			//retorna falso se o destino estiver fora do tabuleiro
	  		if (destino.getX() >= 625) {
	  			return null;
	  		}
	  		if (destino.getX() <= 51) {
	  			return null;
	  		}
	  		if (destino.getX() <= 75 && (destino.getY()>=253 || destino.getY()<=227)) {
	  			return null;
	  		}
	  		if (destino.getY() <= 77) {
	  			return null;
	  		}
	  		if (destino.getY() <= 102 && (destino.getX()<=103 || destino.getX()>=475)) {
	  			return null;
	  		}
	  		if (destino.getY() >= 675) {
	  			return null;
	  		}
	  		if (destino.getY() >= 651 && (destino.getX() <= 451 || destino.getX() >= 475)) {
	  			return null;
	  		}
	  		//clue meio
	  		if (destino.getY() >= 301 && destino.getY()<=477 && destino.getX()>=301 && destino.getX()<=425) {
	  			return null;
	  		}
	  		//sala de estar
	  		if (destino.getY() >= 527 && destino.getX()<=227) {
	  			comodoDest = API.comodos[0];
	  		}
	  		//sala de musica
	  		if (destino.getY() <= 251 && ((destino.getX()>=251 && destino.getX()<=451 && destino.getY()>=101) || (destino.getX()>=299 && destino.getX()<=403))) {
	  			comodoDest = API.comodos[1];
	  		}
	  		//cozinha
	  		if (destino.getY() <= 227 && destino.getX()<=203) {
	  			comodoDest = API.comodos[2];
	  		}
	  		//escritorio
	  		if (destino.getY() >= 575 && destino.getX()>=476) {
	  			comodoDest = API.comodos[3];
	  		}
	  		//entrada
	  		if (destino.getX() >= 275 && destino.getX()<=427 && destino.getY()>=503) {
	  			comodoDest = API.comodos[4];
	  		}
	  		//salao de jogos
	  		if (destino.getY() >= 251 && destino.getX()>=500 && destino.getY()<=376) {
	  			comodoDest = API.comodos[5];
	  		}
	  		//sala de jantar
	  		if (destino.getY()<=453 && ((destino.getX()<=251 && destino.getY()>=301) || (destino.getY()>=275 && destino.getX() <=177))) {
	  			comodoDest = API.comodos[6];
	  		}
	  		//jardim do inverno
	  		if ((destino.getY() <= 177 && destino.getX()>=499) || (destino.getY()<=203 && destino.getX()>=525)) {
	  			comodoDest = API.comodos[7];
	  		}
	  		//biblioteca
	  		if ((destino.getX() >= 475 && destino.getY()>=425 && destino.getY()<=501) || (destino.getX()>=501 && destino.getY()>=399 && destino.getY()<=527)) {
	  			comodoDest = API.comodos[8];
	  		}

		}
//		System.out.println(arrumaX(x));System.out.println(arrumaY(y));
		Posicao possibilidades [] = new Posicao [(int) Math.pow((double)4, (double)passos)];
		for (int c = 0; c < (int) Math.pow((double)4, (double)passos); c++) {
				possibilidades[c] = new Posicao(-1,-1);
			}
		Posicao caminhos [] = new Posicao [passos];
		for (int c = 0; c < passos; c++) {
			caminhos[c] = new Posicao(-1,-1);
		}
		int loopSair;
		if (jogador.comodo == null) {
			loopSair = 1;
		}
		else {
			loopSair = jogador.comodo.qtdEntradas;
		}
		int loopEntrar;
		if (comodoDest == null) {
			for(int i = 0; i < loopSair; i++) {
			if(jogador.comodo != null) {
				atual = jogador.getComodo().entradas[i];
			}
			geraPosicoes(jogador, possibilidades, atual, caminhos, 0, passos);
			for (Posicao pos:possibilidades) {
				if (pos.getX() == -1) {
					break;
				}
				if (arrumaX(pos.getX()) == arrumaX(destino.getX()) && arrumaY(pos.getY()) == arrumaY(destino.getY())) {
					if (jogador.getComodo() != null) {
						jogador.getComodo().saiComodo(jogador.nome);
						}
					jogador.setComodo(null);
					return new Posicao(arrumaX(destino.getX()), arrumaY(destino.getY()));
					}
				}
			}
			return null;
		}
		else {
			loopEntrar = comodoDest.qtdEntradas;
//			System.out.println();
			for(int i = 0; i < loopSair; i++) {
				if(jogador.comodo != null) {
					atual = jogador.getComodo().entradas[i];
				}
				for (int k = passos -1; k >=0;k--){
				geraPosicoes(jogador, possibilidades, atual, caminhos, 0, k);
				for (Posicao pos:possibilidades) {
					if (pos.getX() == -1) {
						break;
					}
					for(int j = 0; j < loopEntrar; j++) {
						if (arrumaX(pos.getX()) == arrumaX(comodoDest.entradas[j].getX()) && arrumaY(pos.getY()) == arrumaY(comodoDest.entradas[j].getY())) {
							if (jogador.getComodo() != comodoDest && jogador.getComodo() != null) {
								jogador.getComodo().saiComodo(jogador.nome);
							}
							jogador.setComodo(comodoDest);
							return comodoDest.getLivre();
						}
					}
					}
				}
				}
		}
		return null;
	}

}