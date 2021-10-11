package com.micromatic.basicmatics.sqrt;

import com.micromatic.basicmatics.Ops.Sqrt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class SqrtManager extends JFrame {
	
	private static int a;
	private static double c;
	private static float e;
	
	private static String stra;
	private static String strda;
	private static String strfa;
	
	private static final Sqrt sqrt = new Sqrt();
	
	private static final String title = "Basic Matics - Square Root";
	
	public SqrtManager() {
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
		JMenu sqrtMenu = new JMenu(title);
		sqrtMenu.setMnemonic(KeyEvent.VK_X);
		menuBar.add(sqrtMenu);
		setJMenuBar(menuBar);
		
		JPanel console = new JPanel();
		console.setSize(10, 30);
		JTextArea output = new JTextArea();
		output.setEditable(false);
		console.add(output);
		menuBar.add(console);
		
		JPanel psqrt = new JPanel();
		psqrt.setBorder(BorderFactory.createTitledBorder("Square Root of Integer Numbers"));
		JTextField sqrtt = new JTextField(15);
		psqrt.add(sqrtt);
		JButton bsqrt = new JButton("Square Root");
		bsqrt.addActionListener(ae -> {
			stra = sqrtt.getText();
			try {
				a = Integer.parseInt(stra);
				output.setText(null);
				output.append("The result is " + sqrt.sqrt(a));
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application found a " + e);
			}
		});
		psqrt.add(bsqrt);
		
		JPanel psqrtd = new JPanel();
		psqrtd.setBorder(BorderFactory.createTitledBorder("Square Root of Double Numbers"));
		JTextField sqrtdt = new JTextField(15);
		psqrtd.add(sqrtdt);
		JButton sqrtd = new JButton("Square Root");
		sqrtd.addActionListener(ae -> {
			strda = sqrtdt.getText();
			try {
				c = Double.parseDouble(strda);
				output.setText(null);
				output.append("The result is " + sqrt.sqrtDouble(c));
			} catch (NumberFormatException e) {
				output.setText(null);
				output.append("The application found a " + e);
			}
		});
		psqrtd.add(sqrtd);

		ActionListener full = ae -> {
			strda = sqrtt.getText();
			try {
				c = Double.parseDouble(strda);
				double res = sqrt.sqrtDouble(c);
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
			strfa = sqrtt.getText();
			try {
				e = Float.parseFloat(strfa);
				float res = sqrt.sqrtFloat(e);
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
		sqrtd.addActionListener(full);

		Choice dec = new Choice();
		dec.add("Exact");
		dec.add("Approximated");
		dec.addItemListener(l -> {
			if (dec.getSelectedItem().equals("Approximated")) {
				sqrtd.removeActionListener(full);
				sqrtd.addActionListener(ap);
			} else {
				sqrtd.removeActionListener(ap);
				sqrtd.addActionListener(full);
			}
		});
		psqrtd.add(dec);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(psqrt, BorderLayout.NORTH);
		getContentPane().add(psqrtd, BorderLayout.CENTER);
	}

	public static class SqrtManagerES extends JFrame {
		public SqrtManagerES() {
			setTitle("Basic Matics -  Raíces Cuadradas");
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
			JMenu sqrtMenu = new JMenu("Basic Matics - Raíces Cuadradas");
			sqrtMenu.setMnemonic(KeyEvent.VK_X);
			menuBar.add(sqrtMenu);
			setJMenuBar(menuBar);

			JPanel console = new JPanel();
			console.setSize(10, 30);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			console.add(output);
			menuBar.add(console);

			JPanel psqrt = new JPanel();
			psqrt.setBorder(BorderFactory.createTitledBorder("Raíces cuadradas de Enteros "));
			JTextField sqrtt = new JTextField(15);
			psqrt.add(sqrtt);
			JButton bsqrt = new JButton("Raíz Cuadrada");
			bsqrt.addActionListener(ae -> {
				stra = sqrtt.getText();
				try {
					a = Integer.parseInt(stra);
					output.setText(null);
					output.append("El resultado es " + sqrt.sqrt(a));
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicación encontró una " + e);
				}
			});
			psqrt.add(bsqrt);

			JPanel psqrtd = new JPanel();
			psqrtd.setBorder(BorderFactory.createTitledBorder("Square Root of Double Numbers"));
			JTextField sqrtdt = new JTextField(15);
			psqrtd.add(sqrtdt);
			JButton sqrtd = new JButton("Raíz Cuadrada");
			sqrtd.addActionListener(ae -> {
				strda = sqrtdt.getText();
				try {
					c = Double.parseDouble(strda);
					output.setText(null);
					output.append("El resultado es " + sqrt.sqrtDouble(c));
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicación encontró una " + e);
				}
			});
			psqrtd.add(sqrtd);

			ActionListener full = ae -> {
				strda = sqrtt.getText();
				try {
					c = Double.parseDouble(strda);
					double res = sqrt.sqrtDouble(c);
					String sres = Double.toString(res);
					int ind = sres.indexOf(".");
					if (sres.substring(ind + 1).equals("0")) {
						res = Double.parseDouble(sres);
						output.setText(null);
						output.append("El resultado es " + (int) res);
					} else {
						res = Double.parseDouble(sres);
						output.setText(null);
						output.append("El resultado es " + res);
					}
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicaci\u00f3n encontr\u00f3 una " + e);
				}
			};
			ActionListener ap = ae -> {
				strfa = sqrtt.getText();
				try {
					e = Float.parseFloat(strfa);
					float res = sqrt.sqrtFloat(e);
					String sres = Float.toString(res);
					int ind = sres.indexOf(".");
					if (sres.substring(ind + 1).equals("0")) {
						res = Float.parseFloat(sres);
						output.setText(null);
						output.append("El resultado es " + (int) res);
					} else {
						res = Float.parseFloat(sres);
						output.setText(null);
						output.append("El resultado es " + res);
					}
				} catch (NumberFormatException e) {
					output.setText(null);
					output.append("La aplicaci\u00f3n encontr\u00f3 una " + e);
				}
			};
			sqrtd.addActionListener(full);

			Choice dec = new Choice();
			dec.add("Exacto");
			dec.add("Aproximado");
			dec.addItemListener(l -> {
				if (dec.getSelectedItem().equals("Approximado")) {
					sqrtd.removeActionListener(full);
					sqrtd.addActionListener(ap);
				} else {
					sqrtd.removeActionListener(ap);
					sqrtd.addActionListener(full);
				}
			});
			psqrtd.add(dec);

			getContentPane().setLayout(new BorderLayout());
			getContentPane().add(psqrt, BorderLayout.NORTH);
			getContentPane().add(psqrtd, BorderLayout.CENTER);
		}
	}
}