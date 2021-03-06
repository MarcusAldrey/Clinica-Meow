package br.uefs.ClinicaMeow.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import br.uefs.ClinicaMeow.exceptions.AnimalNaoEncontradoException;
import br.uefs.ClinicaMeow.exceptions.ClienteNaoEncontradoException;
import br.uefs.ClinicaMeow.exceptions.VeterinarioNaoEncontradoException;
import br.uefs.ClinicaMeow.model.Animal;
import br.uefs.ClinicaMeow.model.Cliente;
import br.uefs.ClinicaMeow.model.Veterin�rio;

public class TelaNovaConsulta extends TelaCadastro {

	private JFormattedTextField cpfDoDono;
	private JButton continuar;
	private JComboBox<Cliente> dono;
	private JComboBox<Animal> animal;
	private JComboBox<Veterin�rio> veterinario;
	private JTextField preco;
	private JLabel labelDono;
	private JLabel labelVet;
	private JLabel labelAnimal;
	private JLabel labelPreco;

	public TelaNovaConsulta() {
		super();
		botaoAdicionar.addActionListener(new AdicionarAction());
		botaoLimpar.addActionListener(new LimparAction());		
		botaoVisualizar.addActionListener(new VisualizarAction());
	}

	@Override
	protected void inserirCampos() {
		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout(20,10,50));		
		painel.setBorder(BorderFactory.createLineBorder(Color.black));

		//Cria campo de cpfDoDono
		JLabel label = new JLabel("Cpf do cliente:");
		painel.add(label);
		try {
			cpfDoDono = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpfDoDono.setPreferredSize(new Dimension(100,20));
		painel.add(cpfDoDono);

		//Cria bot�o continuar
		continuar = new JButton("Continuar");
		continuar.addActionListener(new ContinuarAction());
		painel.add(continuar);

		//Cria campo de dono do animal
		labelDono = new JLabel("Dono:");
		painel.add(labelDono);
		labelDono.setVisible(false);
		List<Cliente> listaDeClientes = controller.getClientes();
		Cliente[] clientes = (Cliente[]) listaDeClientes.toArray(new Cliente[listaDeClientes.size()]);
		dono = new JComboBox<>(clientes);
		dono.setEnabled(false);
		dono.setSelectedItem(null);
		dono.setPreferredSize(new Dimension(200, 20));
		dono.setVisible(false);
		painel.add(dono);

		//Cria campo animal
		labelAnimal = new JLabel("Animal atendido:");
		labelAnimal.setVisible(false);
		painel.add(labelAnimal);
		animal = new JComboBox<Animal>();
		animal.setPreferredSize(new Dimension(75, 20));
		animal.setVisible(false);
		painel.add(animal);

		//cria campo de veterinario
		labelVet = new JLabel("Veterinario que atendeu:");
		labelVet.setVisible(false);
		painel.add(labelVet);
		List<Veterin�rio> listaDeVeterinarios = controller.getVeterinarios();
		Veterin�rio[] veterinarios = (Veterin�rio[]) listaDeVeterinarios.toArray(new Veterin�rio[listaDeVeterinarios.size()]);
		veterinario = new JComboBox<>(veterinarios);
		veterinario.setPreferredSize(new Dimension(200, 20));
		veterinario.setVisible(false);
		painel.add(veterinario);

		//cria campo preco da Consulta
		labelPreco = new JLabel("Pre�o da consulta (R$):");
		labelPreco.setVisible(false);
		painel.add(labelPreco);
		preco = new JTextField();
		preco.setPreferredSize(new Dimension(50, 20));
		preco.setVisible(false);
		preco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();

				if(!(Character.isDigit(c)|| c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE )){
					arg0.consume();
				}
			}
		});
		painel.add(preco);

		janela.add(painel);

	}

	public class LimparAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cpfDoDono.setText("");
			preco.setText("");
			dono.setSelectedIndex(0);
			animal.setSelectedIndex(0);
			veterinario.setSelectedIndex(0);
		}

	}

	public class AdicionarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Veterin�rio vet = (Veterin�rio) veterinario.getSelectedItem();
			Cliente donoDoAnimal = (Cliente) dono.getSelectedItem();
			Animal animalAtendido = (Animal) animal.getSelectedItem();
			float precoDaConsulta = Float.parseFloat(preco.getText());
			try {
				controller.gerarConsulta(vet, donoDoAnimal, animalAtendido, precoDaConsulta);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			} catch (ClienteNaoEncontradoException e1) {
				JOptionPane.showMessageDialog(null, "O cliente n�o est� cadastrado no sistema!");
				return;
			} catch (VeterinarioNaoEncontradoException e1) {
				JOptionPane.showMessageDialog(null, "O veterin�rio n�o est� cadastrado no sistema!");
				return;
			} catch (AnimalNaoEncontradoException e1) {
				JOptionPane.showMessageDialog(null, "O animal n�o est� cadastrado no sistema!");
				return;
			}
			try {
				controller.salvarConsultas();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Nova consulta gerada com sucesso!");
		}
	}

	public class ContinuarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Cliente cliente;
			try {
				cliente = controller.recuperarCliente(cpfDoDono.getText());
			} catch (ClienteNaoEncontradoException e1) {
				JOptionPane.showMessageDialog(null,"CPF inserido n�o pertence a um cliente cadastrado!");
				return;
			}
			dono.setVisible(true);
			dono.setSelectedItem(cliente);
			veterinario.setVisible(true);
			animal.setVisible(true);
			animal.removeAllItems();
			Iterator<Animal> iterador = cliente.getAnimais().iterator();
			while(iterador.hasNext())
				animal.addItem(iterador.next());
			labelAnimal.setVisible(true);
			labelDono.setVisible(true);
			labelPreco.setVisible(true);
			labelVet.setVisible(true);
			preco.setVisible(true);
		}

	}
	public class VisualizarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			criarTelaDeVisualizacao();
			JTextArea texto = new JTextArea();
			texto.setBackground(Color.CYAN);
			texto.append("---NOVA CONSULTA---\n");
			texto.append("\nNome do animal: " + animal.getSelectedItem().toString());
			texto.append("\nVeterin�rio que atendeu: " + veterinario.getSelectedItem().toString());
			texto.append("\nNome do Dono: " + dono.getSelectedItem().toString());
			texto.append("\nPre�o da consulta (R$): " + preco.getText());
			visualizacao.add(texto, BorderLayout.CENTER);

		}

	}	

}


