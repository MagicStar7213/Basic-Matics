package com.micromatic.basicmatics.divide;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({ "unchecked", "rawtypes"})
public class DivideGManager extends JFrame {
	
	private static final DivideGManager dvdg = new DivideGManager();
	private static final DivideManager dvd = new DivideManager();
	private static final DivideRManager dvdr = new DivideRManager();
	
	private static final String d = "Divide";
	private static final String dr = "Division Rest";
	private static final String title = "Basic Matics- Divide Home";
	
	public DivideGManager() {
		setTitle(title);
		setSize(500, 400);

		Image img16 = null;
		Image img32 = null;
		Image img64 = null;
		Image img128 = null;
		try {
			img16 = ImageIO.read(new File("src/main/resources/bsm-16.png"));
			img32 = ImageIO.read(new File("src/main/resources/bsm-16.png"));
			img64 = ImageIO.read(new File("src/main/resources/bsm-16.png"));
			img128 = ImageIO.read(new File("src/main/resources/bsm-16.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList icons = new ArrayList();
		icons.add(img16);
		icons.add(img32);
		icons.add(img64);
		icons.add(img128);

		setIconImages(icons);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu divideMenu = new JMenu(d);
		divideMenu.setMnemonic(KeyEvent.VK_F);
		setJMenuBar(menuBar);
		
		JPanel home = new JPanel();
		JButton dvdm = new JButton(d);
		dvdm.addActionListener(e -> {
			dvd.setVisible(true);
			dvdg.setVisible(false);
		});
		home.add(dvdm);
		JButton dvdrm = new JButton(dr);
		dvdrm.addActionListener(e -> {
			dvdr.setVisible(true);
			dvdg.setVisible(false);
		});
		home.add(dvdrm);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(home, BorderLayout.CENTER);
	}
}