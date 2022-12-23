package Model;

import java.io.*;
import java.util.*;
import Controller.Controladora;
import Model.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
class Salvamento {
	PrintWriter out = null;
	static Jogador[] jogadores;
	static Carta[] resposta;
	static Integer rodada;
	static void coletaInfo() {
		 jogadores = API.jogadores;
		 resposta = API.getResposta();
		 rodada = Controladora.getRodada();
	}
	static void salvaInfo() throws IOException {
		int qtdCartas=0;
		FileWriter outputStream = null;
		JFileChooser f = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r = f.showSaveDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
		try {
			outputStream = new FileWriter(f.getSelectedFile().getAbsolutePath()+"/detetivesalvo.txt");
			outputStream.write(Integer.toString(Controladora.getRodada())+'\n');
            for(int i = 0; i < 3; i++) {
            	outputStream.write(API.getResposta()[i].nome+'\n');
            }
            outputStream.write(Integer.toString(API.getQtdJogadores())+'\n');
            for (int i = 0 ; i < API.getQtdJogadores();i++) {
            	outputStream.write(API.jogadores[i].nome+'\n');
            	outputStream.write(Integer.toString(API.jogadores[i].numCartas)+'\n');
            	for(int j = 0; j < API.jogadores[i].numCartas; j++) {
            		outputStream.write(API.jogadores[i].cartasJogador[j].nome+'\n');
            	}
            	outputStream.write(Integer.toString(API.jogadores[i].getPosicaoX())+'\n');
            	outputStream.write(Integer.toString(API.jogadores[i].getPosicaoY())+'\n');
            	if(API.jogadores[i].getComodo()!= null)
            		outputStream.write(API.jogadores[i].getComodo().nome+'\n');
            	else
            		outputStream.write("-\n");
                	ArrayList<Selecionado> blocoDeNotas = jogadores[i].getBloco();
                	for (Selecionado status:blocoDeNotas) {
                		if(status == Selecionado.NAOSELECIONADO)
                			outputStream.write(Integer.toString(0) + '\n');
                		if(status == Selecionado.SELECIONADOJOGO)
                			outputStream.write(Integer.toString(2) + '\n');
                		if(status == Selecionado.SELECIONADOUSUARIO)
                			outputStream.write(Integer.toString(1) + '\n');
                	}
                	if(jogadores[i].eliminado)
                		outputStream.write(Integer.toString(0) + '\n');
                	else
                		outputStream.write(Integer.toString(1) + '\n');
            }
			} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			}
		}
	}
	
	static boolean carregaInfo() throws IOException {
		BufferedReader s = null;
		JFileChooser f = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r = f.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
			s = new BufferedReader(new FileReader(f.getSelectedFile().getAbsolutePath()+"/detetivesalvo.txt"));
			API.restartCartas();
			Controladora.setRodada(Integer.parseInt(s.readLine()));
			API.resposta[0] = new Carta(s.readLine(),"Cômodo");
			API.resposta[1] = new Carta(s.readLine(),"Suspeito");
			API.resposta[2] = new Carta(s.readLine(),"Arma");
			int max = Integer.parseInt(s.readLine());
			API.setNumJogadores(max);
			Jogador[] jogadores = new Jogador [max];
			String nome;
			String comodo;
			int qtdCarta = 0;
			Carta[] carta;			
			for (int i = 0; i < max;i++) {
				nome = s.readLine();
				qtdCarta = Integer.parseInt(s.readLine());
				carta = new Carta[qtdCarta];
				for (int j = 0; j < qtdCarta; j++) {
					carta[j] = API.getCarta(s.readLine());
					carta[j].setDono(jogadores[i]);
				}
				jogadores[i] = new Jogador(carta,nome, i);
				jogadores[i].numCartas = qtdCarta;
				for (int j = 0; j < qtdCarta; j++) {
					for(Carta cart : API.cartas) {
						if(cart.nome.equals(carta[j].nome)) {
							cart.dono = jogadores[i];
						}
					}
				}
				jogadores[i].setPosicaoJogador(Integer.parseInt(s.readLine()), Integer.parseInt(s.readLine()));
				comodo = s.readLine();
				if (comodo.equals("-"))
					jogadores[i].comodo = null;
				else {
					jogadores[i].comodo = API.getComodoWithString(comodo);
					jogadores[i].pos = API.getComodoWithString(comodo).getLivre();
					API.getComodoWithString(comodo).entraComodo(jogadores[i].nome);
				}
				ArrayList<Selecionado> blocoDeNotas =  new ArrayList<Selecionado>(21);
				int status;
            	for (int j = 0; j<21;j++) {
            		status = Integer.parseInt(s.readLine());
            		if(status == 0)
            			blocoDeNotas.add(Selecionado.NAOSELECIONADO);
            		if(status == 2)
            			blocoDeNotas.add(Selecionado.SELECIONADOJOGO);
            		if(status == 1)
            			blocoDeNotas.add(Selecionado.SELECIONADOUSUARIO);
            	}
            	jogadores[i].blocoDeNotas = blocoDeNotas;
            	int jogando;
            	jogando = Integer.parseInt(s.readLine());
            	if(jogando == 1) {jogadores[i].eliminado = false;}
            	else {jogadores[i].eliminado = true;}
			}
			API.jogadores = jogadores;
            } finally {
            	if (s!=null) {
            		s.close();
            	}
            }
            return true;
        }
        return false;
	}
}




	