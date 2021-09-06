package com.micromatic.basicmatics.sume;

import com.micromatic.basicmatics.Ops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class
SumeManager extends JFrame {
	
	private static int a, b;
	private static double c, d;
	private static float e, f;

	private static String stra, strb;
	private static String strda, strdb;
	private static String strfa, strfb;

	private static final Ops.Sume sume = new Ops.Sume();
	
	private static final String title = "Basic Matics - Sume";
	
	public SumeManager() {
		setTitle(title);
		setSize(500, 400);

		Image img16 = null;
		Image img32 = null;
		Image img64 = null;
		Image img128 = null;
		try {
			img16 = ImageIO.read(new File("src/main/resources/bsm-16.png"));
			img32 = ImageIO.read(new File("src/main/resources/bsm-32.png"));
			img64 = ImageIO.read(new File("src/main/resources/bsm-64.png"));
			img128 = ImageIO.read(new File("src/main/resources/bsm-128.png"));
		} catch (IOException e) { e.printStackTrace(); }

		ArrayList icons = new ArrayList();
		icons.add(img16);
		icons.add(img32);
		icons.add(img64);
		icons.add(img128);

		setIconImages(icons);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu sumeMenu = new JMenu(title);
		sumeMenu.setMnemonic(KeyEvent.VK_X);
		menuBar.add(sumeMenu);
		setJMenuBar(menuBar);
		
		JPanel console = new JPanel();
		console.setSize(10, 30);
		JTextArea output = new JTextArea();
		output.setEditable(false);
		console.add(output);
		
		JPanel sumeP = new JPanel();
		sumeP.setBorder(BorderFactory.createTitledBorder("Sume"));
		JTextField sumea = new JTextField(15);
		JTextField sumeb = new JTextField(15);
		sumeP.add(sumea);
		sumeP.add(sumeb);
		JButton bsume = new JButton("Sume");
		bsume.addActionListener(e -> {
			stra = sumea.getText();
			strb = sumeb.getText();
			try {
				a = Integer.parseInt(stra);
				b = Integer.parseInt(strb);
				output.setText(null);
				output.append("The result is " + sume.sume(a, b));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		sumeP.add(bsume);
		
		JPanel sumedP = new JPanel();
		sumedP.setBorder(BorderFactory.createTitledBorder("Sume Decimal Numbers"));
		JTextField sumeda = new JTextField(15);
		JTextField sumedb = new JTextField(15);
		sumedP.add(sumeda);
		sumedP.add(sumedb);
		JButton bsumed = new JButton("Sume");
		bsumed.addActionListener(e -> {
			strda = sumeda.getText();
			strdb = sumedb.getText();
			try {
				c = Double.parseDouble(strda);
				d = Double.parseDouble(strdb);
				output.setText(null);
				output.append("The result is " + sume.sumeDouble(c, d));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		sumedP.add(bsumed);
		
		JPanel sumefP = new JPanel();
		sumefP.setBorder(BorderFactory.createTitledBorder("Sume Float Numbers"));
		JTextField sumefa = new JTextField(15);
		JTextField sumefb = new JTextField(15);
		sumefP.add(sumefa);
		sumefP.add(sumefb);
		JButton bsumef = new JButton("Sume");
		bsumef.addActionListener(ae -> {
			strfa = sumefa.getText();
			strfb = sumefb.getText();
			try {
				e = Float.parseFloat(strfa);
				f = Float.parseFloat(strfb);
				output.setText(null);
				output.append("The result is " + sume.sumeFloat(e, f));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		sumefP.add(bsumef);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(sumeP, BorderLayout.NORTH);
		getContentPane().add(sumedP, BorderLayout.CENTER);
		getContentPane().add(sumefP, BorderLayout.SOUTH);
	}
}