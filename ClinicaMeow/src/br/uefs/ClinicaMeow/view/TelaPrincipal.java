package br.uefs.ClinicaMeow.view;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

@SuppressWarnings("serial")

public class TelaPrincipal extends JFrame{

	URL url;
	ImageIcon icone;

	public TelaPrincipal() {
		super("Meow - Clínica Veterinária");
		criarMenu();
		criarpainelBotoes();
	}

	public void criarMenu() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JMenu menuArquivo = new JMenu("Cadastrar");

		//Cria item de cadastro de cliente
		JMenuItem menuItemCliente = new JMenuItem("Cliente", icone);
		menuItemCliente.addActionListener(new CadastroClienteAction());
		menuArquivo.add(menuItemCliente);
	
		
		//Cria item de cadastro de veterinário
		JMenuItem menuItemVeterinario = new JMenuItem("Veterinário", icone);
		menuItemVeterinario.addActionListener(new CadastroVeterinarioAction());
		menuArquivo.add(menuItemVeterinario);

		//Cria item de cadastro de animal
		JMenuItem menuItemAnimal = new JMenuItem("Animal", icone);
		menuItemAnimal.addActionListener(new CadastroAnimalAction());
		menuArquivo.add(menuItemAnimal);

		
		//Cria menu de consulta
		JMenu menuConsulta = new JMenu("Consulta");

		//Cria item de nova consulta
		JMenuItem menuItemconsulta = new JMenuItem("Gerar consulta", icone);
		menuItemconsulta.addActionListener(new NovaConsultaAction());
		menuConsulta.add(menuItemconsulta);

		menuArquivo.addSeparator();

		//Cria item de sair
		JMenuItem menuItemSair = new JMenuItem("Sair", icone);
		menuItemSair.addActionListener(new SairAction());
		menuArquivo.add(menuItemSair);

		//Cria barra de menu
		JMenuBar barraDeMenu = new JMenuBar();
		this.setJMenuBar(barraDeMenu);

		//insere os menus com itens na barra de menu
		barraDeMenu.add(menuArquivo);
		barraDeMenu.add(menuConsulta);

	}

	public void criarpainelBotoes() {

		this.setLayout(new FlowLayout(1,200,50));

		//Cria botão de cadastro de cliente
		url = this.getClass().getResource("iconeCliente.png");
		icone = new ImageIcon(url);
		JButton botaoCliente = new JButton("    Cadastrar cliente", icone);
		botaoCliente.addActionListener(new CadastroClienteAction());

		//Cria botão de cadastro de veterinário
		url = this.getClass().getResource("iconeVeterinario.png");
		icone = new ImageIcon(url);
		JButton botaoVeterinario = new JButton("Cadastrar veterinário", icone);
		botaoVeterinario.addActionListener(new CadastroVeterinarioAction());

		//Cria botão de cadastro de animal
		url = this.getClass().getResource("iconeAnimal.png");
		icone = new ImageIcon(url);
		JButton botaoAnimal = new JButton("     Cadastrar animal", icone);
		botaoAnimal.addActionListener(new CadastroAnimalAction());

		//Cria botão de gerar nova consulta
		url = this.getClass().getResource("iconeNovaConsulta.png");
		icone = new ImageIcon(url);
		JButton botaoNovaConsulta = new JButton("       Nova consulta", icone);
		botaoNovaConsulta.addActionListener(new NovaConsultaAction());

		//insere os botões no frame
		this.add(botaoNovaConsulta);
		this.add(botaoCliente);
		this.add(botaoAnimal);
		this.add(botaoVeterinario);		
	}

	private class CadastroClienteAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			new TelaCadastroCliente();
		}

	}

	private class CadastroAnimalAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			URL url = getClass().getResource("Gato.wav");
			AudioClip audio = Applet.newAudioClip(url);
			audio.play();
			new TelaCadastroAnimal();
		}
	}

	private class CadastroVeterinarioAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			new TelaCadastroVeterinario();
		}

	}

	public class NovaConsultaAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			new TelaNovaConsulta();
		}

	}

	private class SairAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evento) {
			System.exit(0);

		}
	}

}
