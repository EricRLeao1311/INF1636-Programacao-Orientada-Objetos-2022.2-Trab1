package Model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

import View.JanelaDeJogo;

class Regras {

  static String[] suspeitos = { "Senhorita Scarlet", "Coronel Mustarda", "Senhorita White","Reverendo Green",
       "Senhorita Peacock", "Professor Plum" };

  static String[] armas = { "Corda", "Cano de Chumbo", "Faca", "Chave Inglesa", "Castiçal", "Revólver" };

  static String[] comodos = {"Sala de Estar","Sala de Música" , "Cozinha", "Escritório", "Entrada", "Salão de Jogos", "Sala de Jantar",
      "Jardim de Inverno", "Biblioteca" };

  
  static Jogador[] criaJogadores(Carta[] cartas, boolean[] jogadoresEscolhidos) {
    

    int i = 0;
    int iValido = 0;
    int qtdAux = 0;
    int qtd=0;
    
    for(boolean escolhido: jogadoresEscolhidos) {
    	if (escolhido) {qtd++;}
    }
    
    Jogador[] auxJogador = new Jogador[qtd];
    int cartaAtual = -1;
    
    while (i < 6) {
    if (!jogadoresEscolhidos[i]) {i++;}
    else {
      auxJogador[iValido] = new Jogador(new Carta[6], suspeitos[i], i);
      i++;
      iValido++;
    	}
    }

    i = 0;

    while (i < 18) {
      if (qtdAux == 0) {
        cartaAtual += 1;
      }
      auxJogador[qtdAux].cartasJogador[cartaAtual] = cartas[i];
      cartas[i].setDono(auxJogador[qtdAux]);
//      System.out.printf("carta: %s, numero: %d\n", cartas[i].nome,API.idCarta(cartas[i].nome));
      auxJogador[qtdAux].blocoDeNotas.set(API.idCarta(cartas[i].nome), Selecionado.SELECIONADOJOGO);
      auxJogador[qtdAux].numCartas = auxJogador[qtdAux].numCartas + 1;
      qtdAux++;
      qtdAux = qtdAux % qtd;
      i++;

    }

    return auxJogador;
  }

  static String[] criaPalpite(Carta[] resposta, Jogador jogador, Carta[] cartas) {
    Scanner scan = new Scanner(System.in);
    int p[] = new int[3];
    Hashtable<Integer, String> my_dict = new Hashtable<Integer, String>();

    p[0] = scan.nextInt();
    p[1] = scan.nextInt();
    p[2] = scan.nextInt();
    for (int c = 0; c < 21; c++) {
      if (c < 9)
        my_dict.put(c + 1, comodos[c]);
      else if (c < 15)
        my_dict.put(c + 1, suspeitos[c - 9]);
      else
        my_dict.put(c + 1, armas[c - 15]);
    }
    String[] retorno = { my_dict.get(p[0]), my_dict.get(p[1] + 9), my_dict.get(p[2] + 15) };
    for (int c = 0; c < 3; c++)
      if (resposta[c].nome.equals(retorno[c]) == false) {
        if (Carta.retornaDono(cartas, retorno[c]).nome.equals(jogador.nome)) {
          return criaPalpite(resposta, jogador, cartas);
        }
      }

    return retorno;
  }

  static String checaPalpite(Carta[] resposta, String[] palpite, Jogador jogador, int qtdJogadores, Carta[] cartas, Jogador[] jogadores) {
    String[] aux = new String[3];
    String retornoNome = null;
    int i = 0;
    int c = 0;
    int pos;
    for (c = 0; c < 3; c++)
      if (!resposta[c].nome.equals(palpite[c])) {
//    	System.out.println(palpite[c]);
        aux[i] = palpite[c];
        i++;
      }
    if (i == 0) {
      return null;
    }
    for(pos = 0; pos<6;pos++) {
    	if(jogadores[pos] == jogador)
    		break;
    }
    for (c = 0; c < jogadores.length; c++) {
      for (int d = 0; d < i; d++) {
        if ((Carta.retornaDono(cartas, aux[d])) == jogadores[(pos + c) % jogadores.length]) {
          return aux[d];
        }
      }

    }
    return retornoNome;
  }

  static String[] criaAcusacao() {
    String[] retorno = { API.comodoAcusado, API.suspeitoAcusado, API.armaAcusada };
    return retorno;
  }

  static Boolean checaAcusacao(Carta[] resposta, String[] palpite) {
    int c;
    
    for (c = 0; c < 3; c++)
      if (resposta[c].nome.equals(palpite[c]) == false) {
        return false;
      }
    return true;
  }


}
