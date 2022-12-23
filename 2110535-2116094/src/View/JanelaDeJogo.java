package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
		import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import Controller.*;
import Model.API;

public class JanelaDeJogo extends JFrame implements Observer {
	
	int alturaBotao = 40;
	int distanciaBotoes = 12;
	int posicaoFBotao = 15;
	JLabel jogadorDaVez = new JLabel(API.getNomeJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())), SwingConstants.CENTER);
	JSpinner dadoDev = new JSpinner(new SpinnerNumberModel(2,2,12,1));
	JButton jogarDadosDev = new JButton("Escolher Dados");
	JLabel qtdPassos = new JLabel(Controladora.getValorSomado().toString() + " passos", SwingConstants.CENTER);
	JButton jogarDados = new JButton("Jogar Dados");
	JButton passagemSecreta = new JButton("Passagem Secreta");
	JButton proximo = new JButton("Próximo");
	JButton salvarJogo = new JButton("Salvar Jogo");
	
	public JButton palpite = new JButton("Palpite");
	JButton acusar = new JButton("Acusar");
	public void attQtdPassos() {
		Controladora.setValorSomado();
		qtdPassos.setText(Controladora.getValorSomado().toString() + " passos");
	}
	
	public void clickProximo() {
		proximo.doClick();
	}
	
	public void attQtdPassos(int valor) {
		Controladora.setValorSomado(valor);
		qtdPassos.setText(Controladora.getValorSomado().toString() + " passos");
	}
	
	public Integer getDadoDev() {
		
		return (Integer)dadoDev.getValue();
		
	}
	
	public void botaoDadoAtivado(boolean aparece) {	
		jogarDados.setEnabled(aparece);
		jogarDadosDev.setEnabled(aparece);
	}

	public void botaoPassagemAtivado(boolean aparece) {
		passagemSecreta.setEnabled(aparece);
	}
	
	public void botaoPalpiteAtivado(boolean aparece) {
		palpite.setEnabled(aparece);
	}
	
	
	public void botaoProximoAtivado(boolean aparece) {
		
		proximo.setEnabled(aparece);
		
	}
	
	public void botaoSalvarAtivado(boolean aparece) {
		
		salvarJogo.setEnabled(aparece);
		
	}

	
	public JanelaDeJogo(){
		super("Detetive");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		API.addObservers(this);

		JPanel newp = new JPanel() {
			 @Override
			    public void paintComponent(Graphics g) {
			        super.paintComponent(g);
					setJogadorVez();
			        Image tabuleiro;
			        Image dado1;
			        Image dado2;
					try {
						tabuleiro = ImageIO.read(new File("src/View/Tabuleiros/Tabuleiro-Clue-B.jpg"));
						g.drawImage(tabuleiro,0, 0, 700, 725, null); 
						 Graphics2D g2 = (Graphics2D) g;
						 
						dado1 = ImageIO.read(new File("src/View/Tabuleiros/dado" + Controladora.getDado1().toString() + ".jpg"));
						dado2 = ImageIO.read(new File("src/View/Tabuleiros/dado" + Controladora.getDado2().toString() + ".jpg"));
						 
						 g2.setColor(new Color(238,238,238));
						 g2.fillRect(700, 0, 800, 760);
						 g.drawImage(dado1,850, 480, 95, 107, null);
						 g.drawImage(dado2,950, 480, 95, 107, null);
					}
					
					catch(IOException e){
						System.out.println(e.getMessage());
						System.exit(1);
					}
					
					paintPlayers(g);
			    }
			
			 
			    public void paintPlayers(Graphics g) {
			    	for (int c = 0; c < API.getQtdJogadores();c++) {

						Graphics2D g2 = (Graphics2D) g;
				    	g2.setColor(Color.BLACK);
				    	g2.drawOval(API.getPosicaoX(API.getJogador(c))-5, API.getPosicaoY(API.getJogador(c))-5, 10,10);
				    	g2.setColor(new Color(API.getRColor(API.getJogador(c)), API.getGColor(API.getJogador(c)), API.getBColor(API.getJogador(c))));
				    	g2.fillOval(API.getPosicaoX(API.getJogador(c))-5, API.getPosicaoY(API.getJogador(c))-5,10,10);
					}
			 }
		};
		
		
		newp.addMouseListener(new MouseAdapter() {
			   @Override 
			   public void mousePressed(MouseEvent m) {
				   if(!Controladora.getAndou() && Controladora.getJogouDado()) {
				   Controladora.movimenta(m.getX(), m.getY());
				   //só checa se não andou
				   botaoProximoAtivado(Controladora.getAndou());
				   }
			   }
		 });
		newp.setLayout(null);
		newp.setBackground(Color.BLACK);
		newp.setPreferredSize(new Dimension(400,500));
		add (newp);
		setLocationRelativeTo(null);
		setBounds(0,0,1280,760);
		//passagem secreta, proximo, mostrar cartas, bloco de notas, palpite, acusar, salvar jogo, 
		passagemSecreta.setBounds(800,posicaoFBotao,300,alturaBotao);
		passagemSecreta.addActionListener(new TratadorPassagemSecreta(this));
		passagemSecreta.setEnabled(API.checaPassagem(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))));
		newp.add(passagemSecreta);
		proximo.setBounds(800,posicaoFBotao + (alturaBotao) + distanciaBotoes,300,alturaBotao);
		proximo.addActionListener(new TratadorProximo(this));
		proximo.setEnabled(false);
		newp.add(proximo);
		JButton mostrar = new JButton("Mostrar Cartas");
		mostrar.setBounds(800,posicaoFBotao + (alturaBotao*2 + distanciaBotoes) + distanciaBotoes,300,alturaBotao);
		mostrar.addActionListener(new TratadorMostrar());
		newp.add(mostrar);
		JButton blocoDeNotas = new JButton("Bloco de Notas");
		blocoDeNotas.setBounds(800,posicaoFBotao + (alturaBotao*3 + distanciaBotoes*2) + distanciaBotoes,300,alturaBotao);
		blocoDeNotas.addActionListener(new TratadorBloco(this));
		newp.add(blocoDeNotas);
		palpite.setBounds(800,posicaoFBotao + (alturaBotao*4 + distanciaBotoes*3) + distanciaBotoes,300,alturaBotao);
		palpite.setEnabled(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))!=null);
		palpite.addActionListener(new TratadorPalpitar(this));
		newp.add(palpite);
		acusar.setBounds(800,posicaoFBotao + (alturaBotao*5 + distanciaBotoes*4) + distanciaBotoes,300,alturaBotao);
//		acusar.addActionListener(new TratadorStart(this));
		newp.add(acusar);
		acusar.addActionListener(new TratadorAcusacao(this));
		setVisible(true);
		
		salvarJogo.setBounds(800,posicaoFBotao + (alturaBotao*6 + distanciaBotoes*5) + distanciaBotoes,300,alturaBotao);
		newp.add(salvarJogo);
		salvarJogo.addActionListener(new TratadorSalvar(this));
		
		//jogador da vez é gerado quando é instanciado
		jogadorDaVez.setBounds(800,posicaoFBotao + (alturaBotao*7 + distanciaBotoes*6) + distanciaBotoes,300,30);
		newp.add(jogadorDaVez);
		qtdPassos.setBounds(800,posicaoFBotao + (alturaBotao*7 + distanciaBotoes*6) + distanciaBotoes+20,300,alturaBotao);
		newp.add(qtdPassos);
		
		
		jogarDados.setBounds(800,posicaoFBotao + (alturaBotao*8 + distanciaBotoes*7) + distanciaBotoes,300,alturaBotao);
		jogarDados.addActionListener(new TratadorDado(this));
		
		newp.add(jogarDados);
		
		jogarDadosDev.setBounds(850,posicaoFBotao + (alturaBotao*11 + distanciaBotoes*10) + distanciaBotoes,250,alturaBotao);
		jogarDadosDev.addActionListener(new TratadorDadoDev(this));
		
		newp.add(jogarDadosDev);
		
		dadoDev.setBounds(800,posicaoFBotao + (alturaBotao*11 + distanciaBotoes*10) + distanciaBotoes,50,alturaBotao);
		dadoDev.setEditor(new JSpinner.DefaultEditor(dadoDev));
		newp.add(dadoDev);
		
		setVisible(true);
	}

	
	public void setJogadorVez() {
		jogadorDaVez.setText(API.getJogadorStr(Controladora.getRodada() % API.getQtdJogadores()));
		jogadorDaVez.setBorder(BorderFactory.createLineBorder(new Color(API.getRColor(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())), API.getGColor(API.getJogador(Controladora.getRodada() % API.getQtdJogadores())), API.getBColor(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))), 3));
		jogadorDaVez.repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg == null) {
			palpite.setEnabled(false);
		}
		else {
			if (arg.getClass().getSimpleName().equals("Comodo")) {
				API.setComodoAcusado(API.getNomeComodo(API.getComodoJogador(API.getJogador(Controladora.getRodada() % API.getQtdJogadores()))));
				if (!Controladora.getPalpitou()) {
				palpite.setEnabled(true);
				}
				
			}
			
			else if (arg.getClass().getSimpleName().equals("Boolean")) {
				repaint();
			}
			
		}
	}
}