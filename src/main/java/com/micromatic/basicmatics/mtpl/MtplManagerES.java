package com.micromatic.basicmatics.mtpl;

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
public class MtplManagerES extends JFrame {
    private static int a, b;
    private static double c, d;
    private static float e, f;

    private static String stra, strb;
    private static String strda, strdb;
    private static String strfa, strfb;

    private static final Ops.Mtpl mtpl = new Ops.Mtpl();

    private static final String title = "Basic Matics - Multiplicaci\u00F3n";
    public MtplManagerES() {
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
        JMenu multi = new JMenu("Basic Matics - Multiplicaci\u00F3n");
        multi.setMnemonic(KeyEvent.VK_X);
        menuBar.add(multi);
        setJMenuBar(menuBar);

        JPanel console = new JPanel();
        console.setSize(10, 30);
        JTextArea output = new JTextArea();
        output.setEditable(false);
        console.add(output);
        menuBar.add(console);

        JPanel multipld = new JPanel();
        JTextField mtlpda = new JTextField(15);
        JTextField mtlpdb = new JTextField(15);
        multipld.add(mtlpda);
        multipld.add(mtlpdb);
        JButton mtlpd = new JButton("Multiplicar");
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
        mtlpd.addActionListener(full);

        Choice dec = new Choice();
        dec.add("Exacto");
        dec.add("Aproximado");
        dec.addItemListener(l -> {
            if (dec.getSelectedItem().equals("Approximado")) {
                mtlpd.removeActionListener(full);
                mtlpd.addActionListener(ap);
            } else {
                mtlpd.removeActionListener(ap);
                mtlpd.addActionListener(full);
            }
        });
        multipld.add(dec);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(multipld, BorderLayout.CENTER);
    }
}