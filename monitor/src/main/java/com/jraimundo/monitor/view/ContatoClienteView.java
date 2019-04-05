package com.jraimundo.monitor.view;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ContatoClienteView extends JPanel {
	
	private JLabel lbNome, lbDocumento, lbTelefone, lbCelular, lbEmail, lbCep;
	private JFormattedTextField tfDocumento, tfTelefone, tfCelular, tfCep;
	private JTextField tfNome, tfEmail;
	private MaskFormatter msDocumento, msTelefone, msCelular, msCep;
	private JButton btMostrar;
	
	public ContatoClienteView() {
		inicializarComponente();
		DefinirEventos();
	}

	private void inicializarComponente() {
		try {
			
			msDocumento	= new MaskFormatter("###.###.###-##");
			msTelefone	= new MaskFormatter("(##)#####-####");
			msCelular 	= new MaskFormatter("(##)#####-####");
			msCep		= new MaskFormatter("##.###-###");
			
			setBounds(0,0,250,220);
			setLayout(null);
			
			lbDocumento	=  new JLabel("Documento");
			lbDocumento.setBounds(15,20,100,20);
			tfDocumento	= new JFormattedTextField(msDocumento);
			tfDocumento.setBounds(100,20,100,20);
			
			lbNome	=  new JLabel("Nome");
			lbNome.setBounds(15,50,100,20);
			tfNome	= new JTextField();
			tfNome.setBounds(100,50,300,20);
/*			
			lbEmail	=  new JLabel("Email");
			lbEmail.setBounds(15,50,100,20);
			tfEmail	= new JTextField();
			tfEmail.setBounds(50, 50, 100, 20);

			lbTelefone	= new JLabel("Tel:");
			lbTelefone.setBounds(15,80,100,20);
			tfTelefone = new JFormattedTextField(msTelefone);;
			tfTelefone.setBounds(50,80,100,20);
			
			lbCep = new JLabel("CEP:");
			lbCep.setBounds(15, 110, 100,20);
			tfCep = new JFormattedTextField(msCep);
			tfCep.setBounds(50,110,100,20);
			*/
			btMostrar = new JButton("Mostrar");
			btMostrar.setBounds(15,140,100,22);
			
			add(lbDocumento);
			add(tfDocumento);
			add(lbNome);
			add(tfNome);
//			add(lbEmail);
//			add(lbTelefone);
//			add(lbCep);
			add(btMostrar);
			
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	private void DefinirEventos() {
		btMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						tfDocumento.getText()	+ "\n" 
						+ tfTelefone.getText() + "\n"
						+ tfCep.getText());
				
				JOptionPane.showMessageDialog(null, tfDocumento.getValue());
				String cnpjSoNumeros = tfDocumento.getText();
				cnpjSoNumeros = cnpjSoNumeros.replace(".", "");
				cnpjSoNumeros = cnpjSoNumeros.replace("/", "");
				cnpjSoNumeros = cnpjSoNumeros.replace("-", "");
				JOptionPane.showMessageDialog(null, cnpjSoNumeros);
				
			}
		});
	}
	

}
