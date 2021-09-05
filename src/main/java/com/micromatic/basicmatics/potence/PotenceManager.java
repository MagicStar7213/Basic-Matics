package com.micromatic.basicmatics.potence;

import com.micromatic.basicmatics.Ops.Potence;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
		
		JPanel pptnc = new JPanel();
		pptnc.setBorder(BorderFactory.createTitledBorder("Potences with Integer Numbers"));
		JTextField baset = new JTextField(15);
		JTextField expt = new JTextField(15);
		pptnc.add(baset);
		pptnc.add(expt);
		JButton bptnc = new JButton("Potence");
		bptnc.addActionListener(ae -> {
			stra = baset.getText();
			strb = expt.getText();
			try {
				base = Integer.parseInt(stra);
				exp = Integer.parseInt(strb);
				output.setText(null);
				output.append("The result is " + ptnc.ptnc(base, exp));
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application has encountered a " + e);
			}
		});
		pptnc.add(bptnc);
		
		JPanel pptncd = new JPanel();
		pptncd.setBorder(BorderFactory.createTitledBorder("Potences with Decimal Numbers"));
		JTextField basetd = new JTextField(15);
		JTextField exptd = new JTextField(15);
		pptnc.add(basetd);
		pptnc.add(exptd);
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
		
		JPanel pptncf = new JPanel();
		pptncf.setBorder(BorderFactory.createTitledBorder("Potences with Float Numbers"));
		JTextField basetf = new JTextField(15);
		JTextField exptf = new JTextField(15);
		pptnc.add(basetf);
		pptnc.add(exptf);
		JButton bptncf = new JButton("Potence");
		bptncf.addActionListener(ae -> {
			strfa = basetf.getText();
			strfb = exptf.getText();
			try {
				fbase = Float.parseFloat(strfa);
				fexp = Float.parseFloat(strfb);
				output.setText(null);
				output.append("The result is " + ptnc.ptncFloat(fbase, fexp));
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application has encountered a " + e);
			}
		});
		pptncf.add(bptncf);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pptnc, BorderLayout.NORTH);
		getContentPane().add(pptncd, BorderLayout.CENTER);
		getContentPane().add(pptncf, BorderLayout.SOUTH);
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

			JPanel pptnc = new JPanel();
			pptnc.setBorder(BorderFactory.createTitledBorder("Potencias con Números Enteros"));
			JTextField baset = new JTextField(15);
			JTextField expt = new JTextField(15);
			pptnc.add(baset);
			pptnc.add(expt);
			JButton bptnc = new JButton("Potencia");
			bptnc.addActionListener(ae -> {
				stra = baset.getText();
				strb = expt.getText();
				try {
					base = Integer.parseInt(stra);
					exp = Integer.parseInt(strb);
					output.setText(null);
					output.append("El resultado es " + ptnc.ptnc(base, exp));
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicación encontró una " + e);
				}
			});
			pptnc.add(bptnc);

			JPanel pptncd = new JPanel();
			pptncd.setBorder(BorderFactory.createTitledBorder("Potencias con Números Decimales"));
			JTextField basetd = new JTextField(15);
			JTextField exptd = new JTextField(15);
			pptnc.add(basetd);
			pptnc.add(exptd);
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

			JPanel pptncf = new JPanel();
			pptncf.setBorder(BorderFactory.createTitledBorder("Potencias con Números Float"));
			JTextField basetf = new JTextField(15);
			JTextField exptf = new JTextField(15);
			pptnc.add(basetf);
			pptnc.add(exptf);
			JButton bptncf = new JButton("Potencia");
			bptncf.addActionListener(ae -> {
				strfa = basetf.getText();
				strfb = exptf.getText();
				try {
					fbase = Float.parseFloat(strfa);
					fexp = Float.parseFloat(strfb);
					output.setText(null);
					output.append("El resultado es " + ptnc.ptncFloat(fbase, fexp));
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicación encontró una " + e);
				}
			});
			pptncf.add(bptncf);

			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(pptnc, BorderLayout.NORTH);
			getContentPane().add(pptncd, BorderLayout.CENTER);
			getContentPane().add(pptncf, BorderLayout.SOUTH);
		}
	}
}