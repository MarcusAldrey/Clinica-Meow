package br.uefs.ClinicaMeow.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JWindow;

import br.uefs.ClinicaMeow.control.ClinicaMeowController;

public abstract class TelaCadastro {

	protected ClinicaMeowController controller;
	protected JDialog janela;
	protected JButton botaoAdicionar;
	protected JButton botaoVisualizar;
	protected JButton botaoLimpar;
	protected JButton botaoSair;
	JWindow visualizacao;
	
	public TelaCadastro() {
		// Configura a posição e o tamanho da janela
		janela = new JDialog();
		int largura = 600;
		int altura = 400;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-largura)/2;
		int y = (screen.height-altura)/2;
		janela.setBounds(x,y,largura,altura);
		janela.setVisible(true);
		controller = ClinicaMeowController.getInstance();
		inserirBotoes();
		inserirCampos();
	}

	public void inserirBotoes() {
		URL url;
		ImageIcon icone;
		
		janela.setLayout(new GridBagLayout());
		
		//Cria botão de Adicionar
		url = this.getClass().getResource("iconeAdicionar.png");
		icone = new ImageIcon(url);
		botaoAdicionar = new JButton("Adicionar", icone);
		
		//Cria botão de Visualizar
		url = this.getClass().getResource("iconeVisualizar.png");
		icone = new ImageIcon(url);
		botaoVisualizar = new JButton("Visualizar", icone);
		
		//Cria botão de Limpar
		url = this.getClass().getResource("iconeLimpar.png");
		icone = new ImageIcon(url);
		botaoLimpar = new JButton("Limpar", icone);
				
		//Cria botão de Sair
		url = this.getClass().getResource("iconeCancelar.png");
		icone = new ImageIcon(url);
		botaoSair = new JButton("Voltar", icone);
		botaoSair.addActionListener(new SairAction());
		
		janela.setLayout(new BorderLayout());
		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());
		painel.add(botaoAdicionar);
		painel.add(botaoVisualizar);
		painel.add(botaoLimpar);
		painel.add(botaoSair);

		janela.add(painel,BorderLayout.SOUTH);
				
	}
	
	private class SairAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			janela.dispose();
		}

	}
	
	public JWindow criarTelaDeVisualizacao() {
		visualizacao = new JWindow();
		int largura = 600;
		int altura = 400;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-largura)/2;
		int y = (screen.height-altura)/2;
		visualizacao.setBounds(x,y,largura,altura);
		visualizacao.setVisible(true);
		visualizacao.setLayout(new BorderLayout());
		URL url = this.getClass().getResource("iconeVoltar.png");
		ImageIcon icone = new ImageIcon(url);
		JButton voltar = new JButton("Voltar", icone);
		voltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				visualizacao.dispose();					
			}
		});
		visualizacao.add(voltar, BorderLayout.WEST);
		return visualizacao;	
	}	
	protected abstract void inserirCampos();

}
