package com.micromatic.basicmatics.potence;

import com.micromatic.basicmatics.Ops.Potence;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class PotenceManager extends JFrame {
	
	private static int base, exp;
	private static double dbase, dexp;
	private static float fbase, fexp;
	
	private static String stra, strb;
	private static String strda, strdb;
	private static String strfa, strfb;
	
	private static final Potence ptnc = new Potence();
	
	private static final String title = "Basic Matics - Potences";
	
	public PotenceManager() {
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
		JMenu ptncMenu = new JMenu(title);
		ptncMenu.setMnemonic(KeyEvent.VK_X);
		menuBar.add(ptncMenu);
		setJMenuBar(menuBar);
		
		JPanel console = new JPanel();
		console.setSize(10, 30);
		JTextArea output = new JTextArea();
		output.setEditable(false);
		console.add(output);
		menuBar.add(console);

		JPanel pptncd = new JPanel();
		JTextField basetd = new JTextField(15);
		JTextField exptd = new JTextField(15);
		pptncd.add(basetd);
		pptncd.add(exptd);
		JButton bptncd = new JButton("Potence");
		bptncd.addActionListener(ae -> {
			strda = basetd.getText();
			strdb = exptd.getText();
			try {
				dbase = Double.parseDouble(strda);
				dexp = Double.parseDouble(strdb);
				output.setText(null);
				output.append("The result is " + ptnc.ptncDouble(dbase, dexp));
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application has encountered a " + e);
			}
		});
		pptncd.add(bptncd);

		ActionListener full = ae -> {
			strda = basetd.getText();
			strdb = exptd.getText();
			try {
				dbase = Double.parseDouble(strda);
				dexp = Double.parseDouble(strdb);
				double res = ptnc.ptncDouble(dbase, dexp);
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
			strfa = basetd.getText();
			strfb = exptd.getText();
			try {
				fbase = Float.parseFloat(strfa);
				fexp = Float.parseFloat(strfb);
				float res = ptnc.ptncFloat(fbase, fexp);
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
		bptncd.addActionListener(full);

		Choice dec = new Choice();
		dec.add("Exact");
		dec.add("Approximated");
		dec.addItemListener(l -> {
			if (dec.getSelectedItem().equals("Approximated")) {
				bptncd.removeActionListener(full);
				bptncd.addActionListener(ap);
			} else {
				bptncd.removeActionListener(ap);
				bptncd.addActionListener(full);
			}
		});
		pptncd.add(dec);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pptncd, BorderLayout.CENTER);
	}

	public static class PotenceManagerES extends JFrame {
		public PotenceManagerES() {
			setTitle("Basic Matics - Potencias");
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
			JMenu ptncMenu = new JMenu("Basic Matics - Potencias");
			ptncMenu.setMnemonic(KeyEvent.VK_X);
			menuBar.add(ptncMenu);
			setJMenuBar(menuBar);

			JPanel console = new JPanel();
			console.setSize(10, 30);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			console.add(output);
			menuBar.add(console);

			JPanel pptncd = new JPanel();
			JTextField basetd = new JTextField(15);
			JTextField exptd = new JTextField(15);
			pptncd.add(basetd);
			pptncd.add(exptd);
			JButton bptncd = new JButton("Potencia");
			bptncd.addActionListener(ae -> {
				strda = basetd.getText();
				strdb = exptd.getText();
				try {
					dbase = Double.parseDouble(strda);
					dexp = Double.parseDouble(strdb);
					output.setText(null);
					output.append("El resultado es " + ptnc.ptncDouble(dbase, dexp));
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicación encontró una " + e);
				}
			});
			pptncd.add(bptncd);

			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(pptncd, BorderLayout.CENTER);
		}
	}
}