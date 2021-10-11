package com.micromatic.basicmatics.rest;

import com.micromatic.basicmatics.Ops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class RestManagerES extends JFrame {

    private static double c, d;
    private static float e, f;

    private static String strda, strdb;
    private static String strfa, strfb;

    private static final Ops.Rest rest = new Ops.Rest();

    private static final String title = "Basic Matics - Resta";
    public RestManagerES() {
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

        JPanel resd = new JPanel();
        resd.setBorder(BorderFactory.createTitledBorder("Restar N\u00FAmeros Decimales"));
        JTextField rstda = new JTextField(15);
        JTextField rstdb = new JTextField(15);
        resd.add(rstda);
        resd.add(rstdb);
        JButton rstd = new JButton("Restar");
        rstd.addActionListener(e -> {
            strda = rstda.getText();
            strdb = rstdb.getText();
            try {
                c = Double.parseDouble(strda);
                d = Double.parseDouble(strdb);
                output.setText(null);
                output.append("El resultado es" + rest.restDouble(c, d));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n encontr\u00F3 una " + a);
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
        rstd.addActionListener(full);

        Choice dec = new Choice();
        dec.add("Exacto");
        dec.add("Aproximado");
        dec.addItemListener(l -> {
            if (dec.getSelectedItem().equals("Approximado")) {
                rstd.removeActionListener(full);
                rstd.addActionListener(ap);
            } else {
                rstd.removeActionListener(ap);
                rstd.addActionListener(full);
            }
        });
        resd.add(dec);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(resd, BorderLayout.CENTER);
    }
}