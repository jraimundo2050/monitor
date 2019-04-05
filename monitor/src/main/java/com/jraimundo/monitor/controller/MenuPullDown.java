package com.jraimundo.monitor.controller;

import java.awt.EventQueue;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.jraimundo.monitor.view.ContatoClienteView;
import com.jraimundo.monitor.view.TeleVendas;

public class MenuPullDown extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private	JMenuBar menuBar = new JMenuBar();
	private Toolkit  tk;
    private Dimension dim;
	private JMenu menu = new JMenu("Arquivo");
	private JMenuItem cadContato = new JMenuItem("Contato");
	private JMenuItem teleVendas = new JMenuItem("TeleVendas");
	private JMenuItem exitItem   = new JMenuItem("Exit");
	
	public MenuPullDown() {
		setComponents();
		handleEvents();
	}

	private void handleEvents() {
		
		teleVendas.addActionListener(event-> {
			JPanel pnTeleVendas = new TeleVendas();
			pnTeleVendas.setSize(dim.width-10, dim.height-10);
			this.add(pnTeleVendas);
			pnTeleVendas.repaint();
			pnTeleVendas.setVisible(true);
		});

		cadContato.addActionListener(event-> {
			JPanel pnContatoClientes = new ContatoClienteView();
			pnContatoClientes.setSize(dim.width-10, dim.height-10);
			this.add(pnContatoClientes);
			pnContatoClientes.repaint();
			pnContatoClientes.setVisible(true);
		});
		
		exitItem.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Saiu");
				System.exit(0);
				
			}
		});		
	}

	private void setComponents() {
		
		EventQueue.invokeLater(()-> {
	
			// captura resolucao da tela
			tk  = Toolkit.getDefaultToolkit();
		    dim = tk.getScreenSize();
			
			this.setSize(dim.width, dim.height);
			
			// menu
			setJMenuBar(menuBar);
			menuBar.add(menu);
			
			menu.add(cadContato);
			menu.add(teleVendas);
			menu.add(exitItem);
			
		});			
	}		
}
