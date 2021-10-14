package com.micromatic.basicmatics.sume;

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
public class SumeManagerES extends JFrame {
    private static int a, b;
    private static double c, d;
    private static float e, f;

    private static String stra, strb;
    private static String strda, strdb;
    private static String strfa, strfb;

    private static final Ops.Sume sume = new Ops.Sume();

    private static final String title = "Basic Matics - Suma";
    public SumeManagerES() {
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
        JMenu sumeMenu = new JMenu(title);
        sumeMenu.setMnemonic(KeyEvent.VK_X);
        menuBar.add(sumeMenu);
        setJMenuBar(menuBar);

        JPanel console = new JPanel();
        console.setSize(10, 30);
        JTextArea output = new JTextArea();
        output.setEditable(false);
        console.add(output);

        JPanel sumedP = new JPanel();
        JTextField sumeda = new JTextField(15);
        JTextField sumedb = new JTextField(15);
        sumedP.add(sumeda);
        sumedP.add(sumedb);
        JButton bsumed = new JButton("Sumar");
        bsumed.addActionListener(e -> {
            strda = sumeda.getText();
            strdb = sumedb.getText();
            try {
                c = Double.parseDouble(strda);
                d = Double.parseDouble(strdb);
                output.setText(null);
                output.append("El resultado es " + sume.sumeDouble(c, d));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n encontr\u00F3 una " + a);
            }
        });
        sumedP.add(bsumed);

        ActionListener full = ae -> {
            strda = sumeda.getText();
            strdb = sumedb.getText();
            try {
                c = Double.parseDouble(strda);
                d = Double.parseDouble(strdb);
                double res = sume.sumeDouble(c, d);
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
            strfa = sumeda.getText();
            strfb = sumedb.getText();
            try {
                e = Float.parseFloat(strfa);
                f = Float.parseFloat(strfb);
                float res = sume.sumeFloat(e, f);
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
        bsumed.addActionListener(full);

        Choice dec = new Choice();
        dec.add("Exacto");
        dec.add("Aproximado");
        dec.addItemListener(l -> {
            if (dec.getSelectedItem().equals("Approximado")) {
                bsumed.removeActionListener(full);
                bsumed.addActionListener(ap);
            } else {
                bsumed.removeActionListener(ap);
                bsumed.addActionListener(full);
            }
        });
        sumedP.add(dec);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sumedP, BorderLayout.CENTER);
    }
}