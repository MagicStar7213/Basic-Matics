package com.micromatic.basicmatics.divide;

import com.micromatic.basicmatics.Ops.Divide;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class DivideRManager extends JFrame {
	
	private static int a, b;
	private static double c, d;
	private static float e, f;
	
	private static String stra, strb;
	private static String strda, strdb;
	private static String strfa, strfb;
	
	private static final Divide dvd = new Divide();
	
	private static final String title = "Basic Matics - Division Rest";

	public DivideRManager() {
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
		
		setIconImages(icons);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu divideMenu = new JMenu(title);
		divideMenu.setMnemonic(KeyEvent.VK_F);
		setJMenuBar(menuBar);
		
		JPanel console = new JPanel();
		console.setSize(10, 30);
		JTextArea output = new JTextArea();
		output.setEditable(false);
		console.add(output);
		menuBar.add(console);
		
		JPanel divideR = new JPanel();
		divideR.setBorder(BorderFactory.createTitledBorder("Division Rest"));
		JTextField divra = new JTextField(15);
		JTextField divrb = new JTextField(15);
		divideR.add(divra);
		divideR.add(divrb);
		JButton divr = new JButton("Division Rest");
		divr.addActionListener(e -> {
			stra = divra.getText();
			strb = divrb.getText();
			try {
				a = Integer.parseInt(stra);
				b = Integer.parseInt(strb);
				output.setText(null);
				output.append("The rest of the division is " + dvd.divisionRest(a, b));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		divideR.add(divr);
		
		JPanel dividedR = new JPanel();
		dividedR.setBorder(BorderFactory.createTitledBorder("Decimal Division Rest"));
		JTextField divdra = new JTextField(15);
		JTextField divdrb = new JTextField(15);
		dividedR.add(divdra);
		dividedR.add(divdrb);
		JButton divdr = new JButton("Division Rest");
		divdr.addActionListener(e -> {
			strda = divdra.getText();
			strdb = divdrb.getText();
			try {
				c = Double.parseDouble(strda);
				d = Double.parseDouble(strdb);
				output.setText(null);
				output.append("The rest of the division is " + dvd.divisionDoubleRest(c, d));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		dividedR.add(divdr);
		
		JPanel dividefR = new JPanel();
		dividefR.setBorder(BorderFactory.createTitledBorder("Float Division Rest"));
		JTextField divfra = new JTextField(15);
		JTextField divfrb = new JTextField(15);
		dividefR.add(divfra);
		dividefR.add(divfrb);
		JButton divfr = new JButton("Division Rest");
		divfr.addActionListener(ae -> {
			strfa = divfra.getText();
			strfb = divfrb.getText();
			try {
				e = Float.parseFloat(strfa);
				f = Float.parseFloat(strfb);
				output.setText(null);
				output.append("The rest of the division is " + dvd.divisionFloatRest(e, f));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered " + a);
			}
		});
		dividefR.add(divfr);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(divideR, BorderLayout.NORTH);
		getContentPane().add(dividedR, BorderLayout.CENTER);
		getContentPane().add(dividefR, BorderLayout.SOUTH);
	}
}