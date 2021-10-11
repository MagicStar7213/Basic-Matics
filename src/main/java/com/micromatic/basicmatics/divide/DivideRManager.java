package com.micromatic.basicmatics.divide;

import com.micromatic.basicmatics.Ops.Divide;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
		dividedR.add(divdr);

		ActionListener full = ae -> {
			strda = divdra.getText();
			strdb = divdrb.getText();
			try {
				c = Double.parseDouble(strda);
				d = Double.parseDouble(strdb);
				double res = dvd.divideDouble(c, d);
				String sres = Double.toString(res);
				int ind = sres.indexOf(".");
				if (sres.substring(ind + 1).equals("0")) {
					res = Double.parseDouble(sres);
					output.setText(null);
					output.append("The result is " + (int) res);
				} else {
					res = Double.parseDouble(sres);
					output.setText(null);
					output.append("The result is " + res);
				}
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application found the exception " + e);
			}
		};
		ActionListener ap = ae -> {
			strfa = divdra.getText();
			strfb = divdrb.getText();
			try {
				e = Float.parseFloat(strfa);
				f = Float.parseFloat(strfb);
				float res = dvd.divideFloat(e, f);
				String sres = Float.toString(res);
				int ind = sres.indexOf(".");
				if (sres.substring(ind + 1).equals("0")) {
					res = Float.parseFloat(sres);
					output.setText(null);
					output.append("The result is " + (int) res);
				} else {
					res = Float.parseFloat(sres);
					output.setText(null);
					output.append("The result is " + res);
				}
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application found the exception " + e);
			}
		};
		divdr.addActionListener(full);

		Choice dec = new Choice();
		dec.add("Exact");
		dec.add("Approximated");
		dec.addItemListener(l -> {
			if (dec.getSelectedItem().equals("Approximated")) {
				divdr.removeActionListener(full);
				divdr.addActionListener(ap);
			} else {
				divdr.removeActionListener(ap);
				divdr.addActionListener(full);
			}
		});
		dividedR.add(dec);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(divideR, BorderLayout.NORTH);
		getContentPane().add(dividedR, BorderLayout.CENTER);
	}
}