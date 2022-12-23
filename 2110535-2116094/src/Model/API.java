package Model;

import java.io.IOException;
import java.util.*;

public class API {

  static Carta[] cartas = Baralho.getInstance().setCartasEmbaralhadas();
  static Carta[] resposta = Resposta.criaResposta(cartas);
  static Jogador[] jogadores;
  private static boolean[] jogadoresEscolhidos = {true,true,true,false,false,false};
  private static int numJogadores = 0; //valor default
  static Comodo[] comodos = new Comodo[9];
  public static String suspeitoAcusado = Regras.suspeitos[0];
  public static String armaAcusada = Regras.armas[0];
  public static String comodoAcusado = Regras.comodos[0];
  
  public static void setDono(String carta, Jogador jog) {
	  for (Carta cart:cartas) {
		  if (cart.nome.equals(carta))
			  cart.dono = jog;
	  }
  }
  
  public static boolean Terminado() {
	 for (Jogador jog:jogadores) {
		 if(!jog.eliminado) {
			 return false;
		 }
	 }
	return true;
  }
  
  public static boolean checaPassagem(Comodo comodo) {
	  if (comodo == null)
		  return false;
	  if(comodo.nome.equals("Sala de Estar"))
		  return true;
	  if(comodo.nome.equals("Jardim de Inverno"))
		  return true;
	  if(comodo.nome.equals("Cozinha"))
		  return true;
	  if(comodo.nome.equals("Escritório"))
		  return true;
	return false;
  }
  
  public static String getNomeJogador(Jogador jogador) {
	  return jogador.nome;
  }
  
  public static ArrayList<String> getCartasDono(String dono) {
	  ArrayList<String> retorno = new ArrayList<String>();
	  Jogador jog;
	  for(int i=0;i<21;i++) {
		  jog = getDono(cartas[i].nome);
		  if (jog != null && jog.nome.equals(dono)) {
			  retorno.add(cartas[i].nome);
		  }
	  }
	  return retorno;
  }
  public static void setNumJogadores(int i) {
	  numJogadores = i;
	  return;
  }
  public static void restartAPI() {
	  restartCartas();
	  recriaResposta();
	  numJogadores = 0;
	  restartJogadoresEscolhidos();
  }
  
  public static void restartCartas() {
	  Baralho.getInstance().nullCartas();
	  cartas = Baralho.getInstance().setCartasEmbaralhadas();
  }
  
  public static void recriaResposta() {
	  resposta = Resposta.criaResposta(cartas);
  }
  
  public static void restartJogadoresEscolhidos() {
	  for(int i=0;i<6;i++){
		  if(i<3) {
		  jogadoresEscolhidos[i] = true;
		  }
		  else {
		  jogadoresEscolhidos[i] = false;
		  }
	  }
  }
  
  public static String getNomeComodo(Comodo comodo) {
	  return comodo.getNome();
  }
  public static Carta getCarta(String nome) {
	  for (Carta cart:API.cartas) {
		  if (cart.nome.equals(nome))
			  return cart;
	  }
	  return null;
  }
  
  public static int getQtdJogadores() {
	  return numJogadores;
  }

  public static void addObservers(Observer o) {
	  for(Jogador jogador:jogadores) {
		  jogador.addObserver(o);
	  }
  }
  
  public static void incQtdJogadores(boolean bool) {
	  if (bool) {numJogadores++;return;}
	  numJogadores--;
	  
  }
  
  public static void mudaEscolhido(int i, boolean bool) {
	  jogadoresEscolhidos[i] = bool;
  }
  
  public static String getNome(int i) {
	  return Regras.suspeitos[i];
  }
  
  public static String getArma(int i) {
	  return Regras.armas[i];
  }
  
  public static String getComodo(int i) {
	  return Regras.comodos[i];
  }
  
  
  public static void setQtdJogadores(int qtdJogadores) {
	  API.numJogadores = qtdJogadores;
  }
  
  public static Carta[] getResposta() {
	  return resposta;
  }
  
  public static void setResposta(Carta[] resposta) {
	  API.resposta = resposta;
  }
  public static int jogaDado() {
    Dado.jogaDado();
    return Dado.dado;
  }

  
  
  
  public static Jogador getJogador(int pos) {
    return jogadores[pos];
  }
  
  public static Jogador getJogadorWithString(String name) {
	    for (Jogador jog: jogadores) {
//	    	System.out.println(name);
	    	if (jog.nome.equals(name))
	    		return jog;
	    }
	    return null;
	  }
  
  public static Comodo getComodoWithString(String comodoAcusado) {
	    for (Comodo comod:comodos) {
	    	if (comod.nome.equals(comodoAcusado))
	    		return comod;
	    }
	    return null;
	  }
  
  public static Posicao getPos(Jogador jog) {
	    return jog.pos;
	  }
  
  public static void setPosicao (Jogador jogador, int x, int y) {
	  jogador.setPosicaoJogador(x, y);
	  
  }
  
  public static int getPosicaoX (Jogador jogador) {
	  return jogador.getPosicaoX();
  }
  
  public static int getPosicaoY (Jogador jogador) {
	  return jogador.getPosicaoY();
  }
  
  public static int getRColor (Jogador jogador) {
	  return jogador.R;
  }
  
  public static int getGColor (Jogador jogador) {
	  return jogador.G;
  }

  public static int getBColor (Jogador jogador) {
	  return jogador.B;
  }


  public static String getJogadorStr(int pos) {
    return jogadores[pos].nome;
  }
  
  public static ArrayList<Selecionado> getJogadorBloco(int pos) {
	    return jogadores[pos].blocoDeNotas;
	  }

//  public static void printaCartas() {
//    for (int c = 0; c < 21; c++) {
////      System.out.printf("Nome: %s, Tipo: %s\n", cartas[c].nome, cartas[c].tipo);
//    }
//  }

//  public static void printaResposta() {
//    System.out.printf("Resposta = %s, %s, %s\n", resposta[0].nome, resposta[1].nome, resposta[2].nome);
//
//  }


  public static void criaJogadores(int qtd) {
    numJogadores = qtd;
    jogadores = Regras.criaJogadores(cartas, jogadoresEscolhidos);
  }

//  public static void printaJogadores() {
//    for (int i = 0; i < numJogadores; i++) {
//      System.out.println("-----------------");
//      System.out.println(jogadores[i].nome);
//      System.out.println("-----------------");
//      for (int j = 0; j < jogadores[i].numCartas; j++) {
//        System.out.println(jogadores[i].cartasJogador[j].nome);
//      }
//    }
//  }

  public static String palpita(Jogador jogador, int qtdJogadores) {
    return Regras.checaPalpite(resposta, Regras.criaAcusacao(), jogador, qtdJogadores, cartas, jogadores);
  }

  public static Jogador getDono(String carta) {
    return Carta.retornaDono(cartas, carta);

  }

  public static void setEliminado(Jogador jogador) {
    jogador.setEliminado(true);
  }
  
  public static void setParticipando(Jogador jogador) {
	    jogador.setEliminado(false);
	  }

  public static Boolean checaEliminado(Jogador jogador) {
    return jogador.getEliminado();
  }

  public static Boolean acusa() {
//	System.out.println(resposta[0].nome);
    return Regras.checaAcusacao(resposta, Regras.criaAcusacao());
  }
  
  public static void setPersonagemAcusado(String personagem) {
	  suspeitoAcusado = personagem;
  };
  
  public static void setArmamAcusada(String arma) {
	  armaAcusada = arma;
  };

  
  public static void setComodoAcusado(String comodo) {
	  comodoAcusado = comodo;
  };

  
	  
  public static Posicao checaPosicao(Jogador jogador, Posicao destino, int passos) {
		return Tabuleiro.checaPosicao(jogador,destino, passos);
	}	
  public static void PuxaComodo (Jogador jogador, Comodo comodo) {
	if (jogador != null) {
	if (jogador.getComodo() != null) {
		jogador.getComodo().saiComodo(jogador.nome);
	}
	jogador.setComodo(comodo);
	API.setPosicao(jogador, comodo.getLivre().getX(), comodo.getLivre().getY());
	comodo.entraComodo(jogador.nome);
	return;
	}
}
	
	
public static int arrumaX(int x) {
	return Tabuleiro.arrumaX(x);
	
}

public static int arrumaY(int y) {
	return Tabuleiro.arrumaY(y);
}

public static Integer idCarta(String carta) {
	return Carta.idCarta(carta);
}

static {
	for (int c = 0; c < 9; c++) {
		comodos[c] = new Comodo(Regras.comodos[c]);
	}
}

public static void entraComodo(Jogador jogador, Comodo comodo) {
	comodo.entraComodo(jogador.nome);
}

public static Comodo getComodoJogador(Jogador jogador) {
	return jogador.getComodo();
}
public static void salvaJogo() {
	Salvamento.coletaInfo();
	try {
		Salvamento.salvaInfo();
	} catch (IOException e) {
	}
	return;
}

public static boolean carregaJogo() throws IOException {
	return Salvamento.carregaInfo();
}
}