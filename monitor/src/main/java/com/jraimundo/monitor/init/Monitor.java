package com.jraimundo.monitor.init;


import javax.swing.JFrame;

import com.jraimundo.monitor.controller.MenuPullDown;

public class Monitor {

	public static void main(String[] args) {
		JFrame nenuPullDown = new MenuPullDown();
		nenuPullDown.setTitle("Monitor");
		nenuPullDown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nenuPullDown.setVisible(true);
	}
	
}

