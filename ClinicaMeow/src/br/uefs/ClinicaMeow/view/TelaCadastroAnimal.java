package br.uefs.ClinicaMeow.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.uefs.ClinicaMeow.exceptions.ClienteNaoEncontradoException;

public class TelaCadastroAnimal extends TelaCadastro {
	
	private JTextField nome;
	private JTextField idade;
	private JFormattedTextField cpfDoDono;
	private JComboBox<String> especies;
	private JTextField cor;


	public TelaCadastroAnimal() {
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

		//Cria campo de nome
		JLabel label = new JLabel("Nome:");
		painel.add(label);
		nome = new JTextField(30);
		painel.add(nome);

		//cria campo de idade do Animal
		label = new JLabel("Idade:");
		painel.add(label);
		idade = new JTextField(2);
		painel.add(idade);

		//Cria campo de CPF do dono
		label = new JLabel("CPF do dono:");
		painel.add(label);
		try {
			cpfDoDono = new JFormattedTextField(new MaskFormatter("###.###.###-##            "));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		painel.add(cpfDoDono);
		
		//cria campo de cor do Animal
		label = new JLabel("   Cor:");
		painel.add(label);
		cor = new JTextField(10);
		painel.add(cor);

		//Cria ComboBox de espécie
		painel.add(new JLabel("Espécie"));
		String[] tipos = new String[4];
		tipos[0] = "Gato";
		tipos[1] = "Cachorro";
		tipos[2] = "Cavalo";
		tipos[3] = "Outro";
		especies = new JComboBox<String>(tipos);
		painel.add(especies);

		janela.add(painel, BorderLayout.CENTER);
	}

	public class LimparAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			nome.setText("");
			cpfDoDono.setText("");
			cor.setText("");
			idade.setText("");
			especies.setSelectedIndex(0);
		}

	}

	public class AdicionarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				controller.cadastrarAnimal(nome.getText(), especies.getSelectedItem().toString(), cor.getText(), Integer.parseInt(idade.getText()), cpfDoDono.getText());
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (ClienteNaoEncontradoException e1) {
				JOptionPane.showMessageDialog(null, "O dono do animal não está cadastrado no sistema!");
				return;
			}
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
		}

	}

	public class VisualizarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			criarTelaDeVisualizacao();
			JTextArea texto = new JTextArea();
			texto.setBackground(Color.CYAN);
			texto.append("---NOVO ANIMAL---\n");
			texto.append("Nome: " + nome.getText());
			texto.append("\nCPF do dono: " + cpfDoDono.getText());
			texto.append("\nIdade do animal: " + idade.getText());
			texto.append("\nEspécie: " + especies.getSelectedItem());
			texto.append("\nCor: " + cor.getText());
			visualizacao.add(texto, BorderLayout.CENTER);
		}

	}	
}
