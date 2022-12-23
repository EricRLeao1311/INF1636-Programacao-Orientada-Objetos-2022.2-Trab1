package Model;
import java.util.Collections;
import java.util.Hashtable;


class Carta{
  String nome;
  String tipo;
  Jogador dono;
  Carta (String nome, String tipo){
    this.nome = nome;
    this.tipo = tipo;
  }

  void setDono(Jogador dono){
    this.dono = dono;
  }
  
  static Jogador retornaDono(Carta[] cartas, String carta) {
	  
	    for (Carta cart : cartas) {
	      if (cart.nome.equals(carta)) {
	        return cart.dono;
	      }
	    }

	    return null;

	  }
  
static Integer idCarta(String carta) {
	  
	  Hashtable<String, Integer> nomeImagens = new Hashtable<String, Integer>();
	   nomeImagens.put("Senhorita Scarlet", 0);
	   nomeImagens.put("Coronel Mustarda", 1);
	   nomeImagens.put("Senhorita White", 2);
	   nomeImagens.put("Reverendo Green", 3);
	   nomeImagens.put("Senhorita Peacock", 4);
	   nomeImagens.put("Professor Plum", 5);
	   nomeImagens.put("Corda", 6);
	   nomeImagens.put("Cano de Chumbo", 7);
	   nomeImagens.put("Faca", 8);
	   nomeImagens.put("Chave Inglesa", 9);
	   nomeImagens.put("Castiçal", 10);
	   nomeImagens.put("Revólver", 11);
	   nomeImagens.put("Entrada", 12);
	   nomeImagens.put("Sala de Estar", 13);
	   nomeImagens.put("Sala de Jantar", 14);
	   nomeImagens.put("Cozinha", 15);
	   nomeImagens.put("Sala de Música", 16);
	   nomeImagens.put("Jardim de Inverno", 17);
	   nomeImagens.put("Salão de Jogos", 18);
	   nomeImagens.put("Biblioteca", 19);
	   nomeImagens.put("Escritório", 20);
	  
	  return nomeImagens.get(carta);
  }
  
}