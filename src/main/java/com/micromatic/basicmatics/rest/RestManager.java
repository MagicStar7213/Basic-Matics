package com.micromatic.basicmatics.rest;

import com.micromatic.basicmatics.Ops.Rest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class RestManager extends JFrame {
	
	private static int a, b;
	private static double c, d;
	private static float e, f;

	private static String stra, strb;
	private static String strda, strdb;
	private static String strfa, strfb;

	private static final Rest rest = new Rest();
	
	private static final String title = "Basic Matics - Rest";

	public RestManager() {
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
		JMenu restMenu = new JMenu(title);
		restMenu.setMnemonic(KeyEvent.VK_X);
		menuBar.add(restMenu);
		setJMenuBar(menuBar);
		
		JPanel console = new JPanel();
		console.setSize(10, 30);
		JTextArea output = new JTextArea();
		output.setEditable(false);
		console.add(output);
		menuBar.add(console);
		
		JPanel ret = new JPanel();
		ret.setBorder(BorderFactory.createTitledBorder("Rest"));
		JTextField rsta = new JTextField(15);
		JTextField rstb = new JTextField(15);
		ret.add(rsta);
		ret.add(rstb);
		JButton rst = new JButton("Rest");
		rst.addActionListener(e -> {
			stra = rsta.getText();
			strb = rstb.getText();
			try {
				a = Integer.parseInt(stra);
				b = Integer.parseInt(strb);
				output.setText(null);
				output.append("The result is " + rest.rest(a, b));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		ret.add(rst);
		
		JPanel resd = new JPanel();
		resd.setBorder(BorderFactory.createTitledBorder("Rest Decimal Numbers"));
		JTextField rstda = new JTextField(15);
		JTextField rstdb = new JTextField(15);
		resd.add(rstda);
		resd.add(rstdb);
		JButton rstd = new JButton("Rest");
		rstd.addActionListener(e -> {
			strda = rsta.getText();
			strdb = rstb.getText();
			try {
				c = Double.parseDouble(strda);
				d = Double.parseDouble(strdb);
				output.setText(null);
				output.append("The result is " + rest.restDouble(c, d));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered a " + a);
			}
		});
		resd.add(rstd);

		ActionListener full = ae -> {
			strda = rstda.getText();
			strdb = rstdb.getText();
			try {
				c = Double.parseDouble(strda);
				d = Double.parseDouble(strdb);
				double res = rest.restDouble(c, d);
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
			strfa = rstda.getText();
			strfb = rstdb.getText();
			try {
				e = Float.parseFloat(strfa);
				f = Float.parseFloat(strfb);
				float res = rest.restFloat(e, f);
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
		rstd.addActionListener(full);

		Choice dec = new Choice();
		dec.add("Exact");
		dec.add("Approximated");
		dec.addItemListener(l -> {
			if (dec.getSelectedItem().equals("Approximated")) {
				rstd.removeActionListener(full);
				rstd.addActionListener(ap);
			} else {
				rstd.removeActionListener(ap);
				rstd.addActionListener(full);
			}
		});
		resd.add(dec);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(ret, BorderLayout.NORTH);
		getContentPane().add(resd, BorderLayout.CENTER);
	}
}
