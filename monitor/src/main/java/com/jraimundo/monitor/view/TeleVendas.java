package com.jraimundo.monitor.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TeleVendas  extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel label;
	
		private JPanel 		pnPrincipal, pnTable;
		private JButton 	btRemover, btAdicionar;
		private JScrollPane scrollTable;
		private JTable		table;
		private JLabel		lbNumero, lbTotal, lbProduto, lbPrecoUnitario, lbQuantidade;
		private JTextField 	tfNumero, tfTotal, tfProduto, tfPrecoUnitario, tfQuantidade;
		
		DecimalFormat df = new DecimalFormat("#,##0.00"); 		
		
		public TeleVendas() {		
			initComponents();
			handleEvents();		
		}	
		
		private void initComponents() {
			
			setLayout(null);
			lbProduto 		= new JLabel("Produto");
			lbQuantidade 	= new JLabel("Quantidade");
			lbPrecoUnitario = new JLabel("Preço Untiário");
			lbNumero		= new JLabel("Número do Pedido");
			lbTotal			= new JLabel("Total do Pedido");
			tfProduto		= new JTextField();
			tfPrecoUnitario = new JTextField();
			tfQuantidade 	= new JTextField();
			tfNumero		= new JTextField();
			tfTotal			= new JTextField();
			
			tfTotal.setEnabled(false);
			tfTotal.setHorizontalAlignment(JTextField.RIGHT);
			
			btAdicionar = new JButton("Adicionar");
			btAdicionar.setToolTipText("Adiciona um item ao pedido");
			
			btRemover = new JButton("Remover");
			btRemover.setToolTipText("remove os itens selecionados");
			
			lbNumero.setBounds(15,10,120,25);
			lbProduto.setBounds(15,60,200,25);
			lbQuantidade.setBounds(225,65,50,25);
			lbPrecoUnitario.setBounds(310,65,80,25);
			
			tfNumero.setBounds(130,10,50,25);
			tfTotal.setBounds(375,360,100,25);
			btAdicionar.setBounds(15,100,100,22);
			btRemover.setBounds(125,100,100,22);
			
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(null);
			pnPrincipal.setBounds(0,0,500,400);
			
			pnPrincipal.add(lbNumero);
			pnPrincipal.add(lbTotal);
			pnPrincipal.add(tfNumero);
			pnPrincipal.add(tfTotal);
			pnPrincipal.add(lbProduto);
			pnPrincipal.add(tfProduto);
			pnPrincipal.add(lbQuantidade);
			pnPrincipal.add(tfQuantidade);
			pnPrincipal.add(lbPrecoUnitario);
			pnPrincipal.add(tfPrecoUnitario);
			
			pnTable = new JPanel( new BorderLayout() );
			pnTable.setBorder(new TitledBorder("Itens do Pedido"));
			
			scrollTable = new JScrollPane();
			
			df.setMaximumFractionDigits(2);
			df.setMaximumFractionDigits(2);
			
			pnPrincipal.add(btAdicionar);
			pnPrincipal.add(btRemover);
			
			DefaultTableModel tableModel = new DefaultTableModel( new String[] {"Produto", "Quantidade","Preço Unitário","Total R$"},0) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int col) {
					if (col == 3) {
						return false;
					}
					
					return true;
				}
					
			};
			
			table = new JTable(tableModel);
			DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
			alinhaDireita.setHorizontalAlignment(SwingConstants.RIGHT);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(150);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setCellRenderer(alinhaDireita);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setCellRenderer(alinhaDireita);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setCellRenderer(alinhaDireita);
			
			table.getTableHeader().setReorderingAllowed(false);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollTable.setViewportView(table);
			pnTable.add(scrollTable);
			pnTable.setBounds(10,130,470,230);
			pnPrincipal.add(pnTable);
			add(pnPrincipal);	
		}

		private void handleEvents() {
			
			btAdicionar.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (tfProduto.getText().equals("")
						|| tfQuantidade.getText().equals("") 
						|| tfPrecoUnitario.getText().equals("")) {					
						JOptionPane.showMessageDialog(pnTable,"Preencha todos os campos !");
						return;					
					}
					
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.addRow(new Object[] {tfProduto.getText(), tfQuantidade.getText(), tfPrecoUnitario.getText(), 
							"" + df.format(Integer.parseInt(tfQuantidade.getText()) * Double.parseDouble(tfPrecoUnitario.getText()))} );
					
					limparCampos();
					calcularTotal();				
				}
			});
			
			btRemover.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int[] linhas = table.getSelectedRows();
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					for (int i = (linhas.length-1); i>=0; --i) {
						dtm.removeRow(linhas[i]);
					}
					
					calcularTotal();
					
				}
			});
		}
		
		private void calcularTotal() {
			double total = 0;
			for (int linhas=0;linhas < table.getRowCount(); linhas++) {
				String valor = "" + table.getValueAt(linhas,3);
				valor = valor.replace(".", "");
				valor = valor.replace(",",".");
				total += Double.parseDouble(valor);
			}
			
			tfTotal.setText("" + df.format(total));		
		}
		
		private void limparCampos() {
			tfProduto.setText("");
			tfQuantidade.setText("");
			tfPrecoUnitario.setText("");
			tfProduto.requestFocus();		
		}
		
}
