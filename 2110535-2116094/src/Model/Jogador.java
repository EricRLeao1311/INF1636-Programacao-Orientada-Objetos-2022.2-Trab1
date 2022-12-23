package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


class Jogador extends Observable{
  Carta cartasJogador[];
  Comodo comodo = null;
  String nome;
  int ordem;
  Posicao pos = new Posicao();
  ArrayList<Selecionado> blocoDeNotas = new ArrayList<Selecionado>(21);
  int R;
  int G;
  int B;
  Boolean eliminado = false;
  Integer numCartas = 0;
  Jogador (Carta cartasJogador[], String nome, int ordem){
    this.cartasJogador = cartasJogador;
    this.nome = nome;
    this.ordem = ordem;
    inicializaBlocoDeNotas();
    if (nome.equals(Regras.suspeitos[0])) {
    	pos.setPos(API.arrumaX(237), API.arrumaY(654));
    	R = 255;
    	G = 0;
    	B = 0;
    }
    if (nome.equals(Regras.suspeitos[1])) {
    	pos.setPos(API.arrumaX(69), API.arrumaY(488));
    	R = 255;
    	G = 239;
    	B = 0;
    }
    if (nome.equals(Regras.suspeitos[2])) {
    	pos.setPos(API.arrumaX(285), API.arrumaY(69));    	
    	R = 255;
    	G = 255;
    	B = 255;
    }
    if (nome.equals(Regras.suspeitos[3])) {
    	pos.setPos(API.arrumaX(411), API.arrumaY(66));    	
    	R = 0;
    	G = 255;
    	B = 60;
    }
    if (nome.equals(Regras.suspeitos[4])) {
    	pos.setPos(API.arrumaX(631), API.arrumaY(209));
    	R = 0;
    	G = 26;
    	B = 255;
    }
    if (nome.equals(Regras.suspeitos[5])) {
    	pos.setPos(API.arrumaX(630), API.arrumaY(536));
    	R = 145;
    	G = 100;
    	B = 255;
    }
  }
  void setPosicaoJogador (int x, int y) {
	  pos.setPos(API.arrumaX(x), API.arrumaY(y));
	  setChanged();
	  notifyObservers(true);
  }
  int getPosicaoX () {
	  return pos.getX();
  }
  int getPosicaoY () {
	  return pos.getY();
  }
  
  boolean getEliminado() {
	  return eliminado;
  }
  
  void setEliminado(boolean eliminado) {
	  this.eliminado = eliminado;
  }
  
  void setComodo(Comodo comodo) {
	  this.comodo = comodo;
	  setChanged();
	  notifyObservers(comodo);
	  
  }
  Comodo getComodo() {
	 return comodo; 
  }

  ArrayList<Selecionado> getBloco(){
	  return blocoDeNotas;
  }
  
  void inicializaBlocoDeNotas() {
	  for (int i=0;i<21;i++) {
		  blocoDeNotas.add(Selecionado.NAOSELECIONADO);
	  }
  }

}