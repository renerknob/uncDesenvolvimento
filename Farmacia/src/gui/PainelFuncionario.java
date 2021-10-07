package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unc.rener.Funcionario;
import br.unc.rener.dao.ClienteDao;
import br.unc.rener.dao.FuncionarioDao;

public class PainelFuncionario extends JPanel implements ActionListener {

	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldEndereco;
	private JTextField textFieldPis;
	private JTextField textFieldPasep;
	private JTextField textFieldCarteiraTrabalho;
	private JTextField textFieldSalario;
	private JLabel labelNome;
	private JLabel labelCPF;
	private JLabel labelRG;
	private JLabel labelEndereco;
	private JLabel labelPis;
	private JLabel labelPasep;
	private JLabel labelCarteiraTrabalho;
	private JLabel labelSalario;
	private FuncionarioDao funcionarioDao ;
	private JButton btnSalvar;
	private JButton btnCancelar;
	public PainelFuncionario() {
		GridLayout gd = new GridLayout(0, 2);
		setLayout(gd);
		funcionarioDao = new FuncionarioDao();
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener((ActionListener) this);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener((ActionListener) this);
		textFieldNome = new JTextField(40);
		labelNome = new JLabel("Nome do Cliente:");
		textFieldCPF = new JTextField(40);
		labelCPF = new JLabel("CPF:");
		textFieldRG = new JTextField(40);
		labelRG = new JLabel("RG:");
		textFieldEndereco = new JTextField(40);
		labelEndereco = new JLabel("Endereco:");
		textFieldPis = new JTextField(40);
		labelPis = new JLabel("Pis:");
		textFieldPasep = new JTextField(40);
		labelPasep = new JLabel("Pasep:");
		textFieldCarteiraTrabalho = new JTextField(40);
		labelCarteiraTrabalho = new JLabel("Carteira Trabalho:");
		textFieldSalario = new JTextField(40);
		labelSalario = new JLabel("Salario:");
		add(labelNome);
		add(textFieldNome);
		add(labelCPF);
		add(textFieldCPF);
		add(labelRG);
		add(textFieldRG);
		add(labelEndereco);
		add(textFieldEndereco);
		add(labelPis);
		add(textFieldPis);
		add(labelPasep);
		add(textFieldPasep);
		add(labelCarteiraTrabalho);
		add(textFieldCarteiraTrabalho);
		add(labelSalario);
		add(textFieldSalario);
		add(btnCancelar);
		add(btnSalvar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalvar) {
			Funcionario f = new Funcionario(textFieldNome.getText(), textFieldCPF.getText(), textFieldRG.getText(), textFieldEndereco.getText(), textFieldPis.getText(), textFieldPasep.getText(), textFieldCarteiraTrabalho.getText(), Double.parseDouble(textFieldSalario.getText()));
			try {
				funcionarioDao.inserir(f);
				JOptionPane.showMessageDialog(this,"O funcionario foi salvo!", TOOL_TIP_TEXT_KEY, JOptionPane.OK_OPTION);
				limparFormulario();
				this.setVisible(false);
			}catch (Exception err) {
				JOptionPane.showMessageDialog(this,"Erro ao salvar o funcionario!", TOOL_TIP_TEXT_KEY, JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (e.getSource() == btnCancelar) {
			this.setVisible(false);
		}
	}

	private void limparFormulario() {
		textFieldNome.setText(null);
		textFieldCPF.setText(null);
		textFieldRG.setText(null);
		textFieldEndereco.setText(null);
	}
}
