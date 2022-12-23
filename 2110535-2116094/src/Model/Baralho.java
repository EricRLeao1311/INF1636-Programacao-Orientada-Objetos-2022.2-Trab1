package Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baralho {

	private static Carta[] cartas;
	private static Baralho baralhoSingleton;
	
	private static final String[] suspeitos = { "Senhorita Scarlet", "Coronel Mustarda", "Senhorita White","Reverendo Green",
		       "Senhorita Peacock", "Professor Plum" };

	private static final String[] armas = { "Corda", "Cano de Chumbo", "Faca", "Chave Inglesa", "Castiçal", "Revólver" };

	static final String[] comodos = { "Entrada", "Sala de Estar", "Sala de Jantar", "Cozinha", "Sala de Música",
		      "Jardim de Inverno", "Salão de Jogos", "Biblioteca", "Escritório" };
	//singleton
	private Baralho() {}	
	
	static Baralho getInstance() {
		if (baralhoSingleton == null) {
		    baralhoSingleton = new Baralho();
		    }
		    return baralhoSingleton;
	}
	
	void nullCartas() {
		cartas = null;
	}
	
	Carta[] getCartas() {
		return cartas;
	}
	
	Carta[] setCartasEmbaralhadas() {
		if (cartas == null) {
			    cartas = new Carta[21];
			    for (int c = 0; c < 6; c++) {
			      cartas[c] = new Carta(suspeitos[c], "Suspeito");
			    }
			    for (int c = 0; c < 6; c++) {
			      cartas[c + 6] = new Carta(armas[c], "Arma");
			    }
			    for (int c = 0; c < 9; c++) {
			      cartas[c + 12] = new Carta(comodos[c], "Cômodo");
			    } 
		}
		embaralhaCartas();
		return cartas;
	}	
	
	Carta[] setCartas() {
		
		    cartas = new Carta[21];
		    for (int c = 0; c < 6; c++) {
		      cartas[c] = new Carta(suspeitos[c], "Suspeito");
		    }
		    for (int c = 0; c < 6; c++) {
		      cartas[c + 6] = new Carta(armas[c], "Arma");
		    }
		    for (int c = 0; c < 9; c++) {
		      cartas[c + 12] = new Carta(comodos[c], "Cômodo");
		    } 
	
	return cartas;
	}
	

	Carta[] embaralhaCartas() {
		  List<Carta> cartaList = Arrays.asList(cartas);
			Collections.shuffle(cartaList);
			cartaList.toArray(cartas);
			return cartas;
	  }
	
}
