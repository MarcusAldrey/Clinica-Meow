package br.uefs.ClinicaMeow.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;

public class Principal {
			
	public void criarTela() {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		URL url = this.getClass().getResource("logo.png"); 
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
		telaPrincipal.setIconImage(iconeTitulo);
		telaPrincipal.setBackground(Color.black);
		int largura = 450;
		int altura = 600;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-largura)/2;
		int y = (screen.height-altura)/2;
		telaPrincipal.setSize(new Dimension(largura, altura));
		telaPrincipal.setResizable(false);
		telaPrincipal.setLocation(x, y);
		//SplashScreen splash = new SplashScreen(5000);
		//splash.mostrarSplashESair();
		telaPrincipal.setVisible(true);	
	}

	public static void main(String[] args) {
		new Principal().criarTela();
	}
}