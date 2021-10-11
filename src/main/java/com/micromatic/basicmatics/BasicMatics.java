package com.micromatic.basicmatics;

import com.micromatic.basicmatics.divide.*;
import com.micromatic.basicmatics.mtpl.*;
import com.micromatic.basicmatics.rest.*;
import com.micromatic.basicmatics.sume.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BasicMatics extends JFrame {
	static final BasicMatics bsm = new BasicMatics();
	
	private static final DivideGManager dvdm = new DivideGManager();
	private static final MtplManager mtpl = new MtplManager();
	private static final SumeManager sume = new SumeManager();
	private static final RestManager rest = new RestManager();

	private static final DivideGManagerES dvdmes = new DivideGManagerES();
	private static final MtplManagerES mtples = new MtplManagerES();
	private static final RestManagerES restes = new RestManagerES();
	private static final SumeManagerES sumes = new SumeManagerES();
	
	private static final String title = "Basic Matics";
	private static final String r = "Rest";
	private static final String m = "Multiply";
	private static final String d = "Divide";
	private static final String s = "Sume";

	private final ActionListener dg = ae -> {
		dvdm.setVisible(true);
		bsm.setVisible(false);
	};
	private final ActionListener mp = ae -> {
		mtpl.setVisible(true);
		bsm.setVisible(false);
	};
	private final ActionListener rs = ae -> {
		rest.setVisible(true);
		bsm.setVisible(false);
	};
	private final ActionListener sm = ae -> {
		sume.setVisible(true);
		bsm.setVisible(false);
	};


	private final ActionListener dges = ae -> {
		dvdmes.setVisible(true);
		bsm.setVisible(false);
	};
	private final ActionListener mpes = ae -> {
		mtples.setVisible(true);
		bsm.setVisible(false);
	};
	private final ActionListener rses = ae -> {
		restes.setVisible(true);
		bsm.setVisible(false);
	};
	private final ActionListener smes = ae -> {
		sumes.setVisible(true);
		bsm.setVisible(false);
	};

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BasicMatics() {
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
		JMenu hcMenu = new JMenu(title);
		hcMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(hcMenu);
		setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();

		JButton div = new JButton(d);
		div.addActionListener(dg);
		panel.add(div);
		
		JButton mtp = new JButton(m);
		mtp.addActionListener(mp);
		panel.add(mtp);
		
		JButton sum = new JButton(s);
		sum.addActionListener(sm);
		panel.add(sum);
		
		JButton rst = new JButton(r);
		rst.addActionListener(rs);
		panel.add(rst);

		Choice lang = new Choice();
		lang.add("English");
		lang.add("Español");
		
		lang.addItemListener(ie -> {
			if (lang.getSelectedItem().equals("Español")) {
				trans(d, div, 1);
				trans(m, mtp, 1);
				trans(s, sum, 1);
				trans(r, rst, 1);
			} else {
				trans(d, div, 0);
				trans(m, mtp, 0);
				trans(s, sum, 0);
				trans(r, rst, 0);
			}
		});
		menuBar.add(lang);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.NORTH);
	}
	
	private void trans(String str, JButton b, int lang) {
		if (lang == 1)
			switch (str) {
				case d -> {
					str = "Dividir";
					b.setText(str);
					b.removeActionListener(dg);
					b.addActionListener(dges);
				}
				case m -> {
					str = "Multiplicar";
					b.setText(str);
					b.removeActionListener(mp);
					b.addActionListener(mpes);
				}
				case s -> {
					str = "Sumar";
					b.setText(str);
					b.removeActionListener(sm);
					b.addActionListener(smes);
				}
				case r -> {
					str = "Restar";
					b.setText(str);
					b.removeActionListener(rs);
					b.addActionListener(rses);
				}
			}
		else
			switch (str) {
				case d -> {
					str = "Divide";
					b.setText(str);
					b.removeActionListener(dges);
					b.addActionListener(dg);
				}
				case m -> {
					str = "Multiply";
					b.setText(str);
					b.removeActionListener(mpes);
					b.addActionListener(mp);
				}
				case s -> {
					str = "Sume";
					b.setText(str);
					b.removeActionListener(smes);
					b.addActionListener(sm);
				}
				case r -> {
					str = "Rest";
					b.setText(str);
					b.removeActionListener(rses);
					b.addActionListener(rs);
				}
			}
	}
	
	public static void main(String[] args) {
		bsm.setVisible(true);
	}
	
}