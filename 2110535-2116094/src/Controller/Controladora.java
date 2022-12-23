package Controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import Model.API;
import Model.Posicao;

public class Controladora {

	static int rodada = 0;
	static boolean andou = false;
	static boolean palpitou = false;
	static boolean jogouDado = false;
	static Integer valorDado1 = 1;
	static Integer valorDado2 = 4;
	static Integer valorSomado = valorDado1 + valorDado2;
	
	
	public static void restartControladora() {
		andou = false;
		palpitou = false;
		jogouDado = false;
		rodada = 0;
	}
	public static Boolean acusa() {
		if (API.acusa()) {
			return true;
		}
			
		API.setEliminado(API.getJogador(rodada % API.getQtdJogadores()));
		return false;
	}
	
	
	public static String palpita() {
		palpitou = true;
		return API.palpita(API.getJogador(rodada % API.getQtdJogadores()),API.getQtdJogadores());
	}
	
	
	
	public static void setValorSomado() {
		valorSomado = valorDado1 + valorDado2;
		jogouDado = true;
	}
	
	public static void setValorSomado(Integer valorDadoDev) {	
		valorDado1 = valorDadoDev/2;
		valorDado2 = valorDadoDev - (valorDadoDev/2);
		valorSomado = valorDadoDev;
		jogouDado = true;
		return;
	}
	
	public static boolean getJogouDado() {	
		return jogouDado;
	}
	

	
	
	public static Integer getValorSomado() {
		return valorSomado;
	}
	

	
	public static Integer getDado1() {
		return valorDado1;
	}
	
	public static Integer getDado2() {
		return valorDado2;
	}
	
	public static void setDado1(Integer x) {
		valorDado1 = x;
	}
	
	public static void setDado2(Integer x) {
		valorDado2 = x;
	}
	
	public static void movimenta(int x, int y) {
		Posicao destino = new Posicao();
		destino.setPos(x, y);
		Posicao pos = API.checaPosicao(API.getJogador(rodada % API.getQtdJogadores()), destino, valorSomado);
		if (!andou && pos!=null) {
		if (API.getComodoJogador(API.getJogador(rodada % API.getQtdJogadores())) != null) {
			API.entraComodo(API.getJogador(rodada % API.getQtdJogadores()), API.getComodoJogador(API.getJogador(rodada % API.getQtdJogadores())));
		}
		API.setPosicao(API.getJogador(rodada % API.getQtdJogadores()), pos.getX(), pos.getY());
		setAndou(true);
		}
	}
	public static void passaRodada() {
		rodada++;
		while(API.checaEliminado(API.getJogador(rodada % API.getQtdJogadores()))) 
			rodada++;
		andou = false;
		palpitou = false;
		jogouDado = false;
	
	}
	public static void setAndou(boolean v) {
		andou = v;
	}
	
	public static boolean getAndou() {
		return andou;
	}
	
	public static void setPalpitou(boolean v) {
		palpitou = v;
	}
	
	public static boolean getPalpitou() {
		return palpitou;
	}
	
	public static int getRodada() {
		return rodada;
	}
	
	public static void setRodada(int c) {
		rodada = c;
		return;
	}


	public static ArrayList<String> imagemCartas(String dono){
		
		ArrayList<String> cartas = API.getCartasDono(dono);
		  Hashtable<String, String> nomeImagens = new Hashtable<String, String>();
		   nomeImagens.put("Senhorita Scarlet", "Suspeitos/Scarlet.jpg");
		   nomeImagens.put("Coronel Mustarda", "Suspeitos/Mustard.jpg");
		   nomeImagens.put("Senhorita White", "Suspeitos/White.jpg");
		   nomeImagens.put("Reverendo Green", "Suspeitos/Green.jpg");
		   nomeImagens.put("Senhorita Peacock", "Suspeitos/Peacock.jpg");
		   nomeImagens.put("Professor Plum", "Suspeitos/Plum.jpg");
		   nomeImagens.put("Corda", "Armas/Corda.jpg");
		   nomeImagens.put("Cano de Chumbo", "Armas/Cano.jpg");
		   nomeImagens.put("Faca", "Armas/Faca.jpg");
		   nomeImagens.put("Chave Inglesa", "Armas/ChaveInglesa.jpg");
		   nomeImagens.put("Castiçal", "Armas/Castical.jpg");
		   nomeImagens.put("Revólver", "Armas/Revolver.jpg");
		   nomeImagens.put("Biblioteca", "Comodos/Biblioteca.jpg");
		   nomeImagens.put("Cozinha", "Comodos/Cozinha.jpg");
		   nomeImagens.put("Entrada", "Comodos/Entrada.jpg");
		   nomeImagens.put("Escritório", "Comodos/Escritorio.jpg");
		   nomeImagens.put("Jardim de Inverno", "Comodos/JardimInverno.jpg");
		   nomeImagens.put("Sala de Estar", "Comodos/SalaDeEstar.jpg");
		   nomeImagens.put("Sala de Jantar", "Comodos/SalaDeJantar.jpg");
		   nomeImagens.put("Sala de Música", "Comodos/SalaDeMusica.jpg");
		   nomeImagens.put("Salão de Jogos", "Comodos/SalaoDeJogos.jpg");
		   
		   
		   
		   for(String carta:cartas) {
			   cartas.set(cartas.indexOf(carta), nomeImagens.get(carta));   
		   }
	return cartas;
			  
	}
	
public static String imagemCarta(String carta){
		
		  Hashtable<String, String> nomeImagens = new Hashtable<String, String>();
		   nomeImagens.put("Senhorita Scarlet", "Suspeitos/Scarlet.jpg");
		   nomeImagens.put("Coronel Mustarda", "Suspeitos/Mustard.jpg");
		   nomeImagens.put("Senhorita White", "Suspeitos/White.jpg");
		   nomeImagens.put("Reverendo Green", "Suspeitos/Green.jpg");
		   nomeImagens.put("Senhorita Peacock", "Suspeitos/Peacock.jpg");
		   nomeImagens.put("Professor Plum", "Suspeitos/Plum.jpg");
		   nomeImagens.put("Corda", "Armas/Corda.jpg");
		   nomeImagens.put("Cano de Chumbo", "Armas/Cano.jpg");
		   nomeImagens.put("Faca", "Armas/Faca.jpg");
		   nomeImagens.put("Chave Inglesa", "Armas/ChaveInglesa.jpg");
		   nomeImagens.put("Castiçal", "Armas/Castical.jpg");
		   nomeImagens.put("Revólver", "Armas/Revolver.jpg");
		   nomeImagens.put("Biblioteca", "Comodos/Biblioteca.jpg");
		   nomeImagens.put("Cozinha", "Comodos/Cozinha.jpg");
		   nomeImagens.put("Entrada", "Comodos/Entrada.jpg");
		   nomeImagens.put("Escritório", "Comodos/Escritorio.jpg");
		   nomeImagens.put("Jardim de Inverno", "Comodos/JardimInverno.jpg");
		   nomeImagens.put("Sala de Estar", "Comodos/SalaDeEstar.jpg");
		   nomeImagens.put("Sala de Jantar", "Comodos/SalaDeJantar.jpg");
		   nomeImagens.put("Sala de Música", "Comodos/SalaDeMusica.jpg");
		   nomeImagens.put("Salão de Jogos", "Comodos/SalaoDeJogos.jpg");
		   
	return nomeImagens.get(carta);
			  
	}
		
		
	}


