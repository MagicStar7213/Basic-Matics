package com.micromatic.basicmatics.divide;

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
public class DivideRManagerES extends JFrame {

    private static int a, b;
    private static double c, d;
    private static float e, f;

    private static String stra, strb;
    private static String strda, strdb;
    private static String strfa, strfb;

    private static final Ops.Divide dvd = new Ops.Divide();

    private static final String title = "Basic Matics - Resto de Divisi\u00F3";
    private static final String dvr = "Calcular Resto";
    public DivideRManagerES() {
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

        JPanel dividedR = new JPanel();
        JTextField divdra = new JTextField(15);
        JTextField divdrb = new JTextField(15);
        dividedR.add(divdra);
        dividedR.add(divdrb);
        JButton divdr = new JButton(dvr);
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
        divdr.addActionListener(full);

        Choice dec = new Choice();
        dec.add("Exacto");
        dec.add("Aproximado");
        dec.addItemListener(l -> {
            if (dec.getSelectedItem().equals("Approximado")) {
                divdr.removeActionListener(full);
                divdr.addActionListener(ap);
            } else {
                divdr.removeActionListener(ap);
                divdr.addActionListener(full);
            }
        });
        dividedR.add(dec);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(dividedR, BorderLayout.CENTER);
    }
}