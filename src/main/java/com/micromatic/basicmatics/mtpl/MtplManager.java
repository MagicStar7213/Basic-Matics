package com.micromatic.basicmatics.mtpl;

import com.micromatic.basicmatics.Ops.Mtpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MtplManager extends JFrame {

	private static int a, b;
	private static double c, d;
	private static float e, f;

	private static String stra, strb;
	private static String strda, strdb;
	private static String strfa, strfb;

	private static final Mtpl mtpl = new Mtpl();
	
	private static final String title = "Basic Matics - Multiply";

	public MtplManager() {
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
		JMenu multi = new JMenu(title);
		multi.setMnemonic(KeyEvent.VK_X);
		menuBar.add(multi);
		setJMenuBar(menuBar);
		
		JPanel console = new JPanel();
		console.setSize(10, 30);
		JTextArea output = new JTextArea();
		output.setEditable(false);
		console.add(output);
		menuBar.add(console);
		
		JPanel multipl = new JPanel();
		multipl.setBorder(BorderFactory.createTitledBorder("Multiply"));
		JTextField mtlpa = new JTextField(15);
		JTextField mtlpb = new JTextField(15);
		multipl.add(mtlpa);
		multipl.add(mtlpb);
		JButton mtlp = new JButton("Multiply");
		mtlp.addActionListener(e -> {
			stra = mtlpa.getText();
			strb = mtlpb.getText();
			try {
				a = Integer.parseInt(stra);
				b = Integer.parseInt(strb);
				output.setText(null);
				output.append("The result is " + mtpl.mtpl(a, b));
			} catch (NumberFormatException a) {
				output.setText(null);
				output.append("The application has encountered " + a);
			}
		});
		multipl.add(mtlp);
		
		JPanel multipld = new JPanel();
		multipld.setBorder(BorderFactory.createTitledBorder("Multiply Decimal Numbers"));
		JTextField mtlpda = new JTextField(15);
		JTextField mtlpdb = new JTextField(15);
		multipld.add(mtlpda);
		multipld.add(mtlpdb);
		JButton mtlpd = new JButton("Multiply");
		multipld.add(mtlpd);

		ActionListener full = ae -> {
			strda = mtlpda.getText();
			strdb = mtlpdb.getText();
			try {
				c = Double.parseDouble(strda);
				d = Double.parseDouble(strdb);
				double res = mtpl.mtplDouble(c, d);
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
			strfa = mtlpda.getText();
			strfb = mtlpdb.getText();
			try {
				e = Float.parseFloat(strfa);
				f = Float.parseFloat(strfb);
				float res = mtpl.mtplFloat(e, f);
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
		mtlpd.addActionListener(full);

		Choice dec = new Choice();
		dec.add("Exact");
		dec.add("Approximated");
		dec.addItemListener(l -> {
			if (dec.getSelectedItem().equals("Approximated")) {
				mtlpd.removeActionListener(full);
				mtlpd.addActionListener(ap);
			} else {
				mtlpd.removeActionListener(ap);
				mtlpd.addActionListener(full);
			}
		});
		multipld.add(dec);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(multipl, BorderLayout.NORTH);
		getContentPane().add(multipld, BorderLayout.CENTER);
	}
}