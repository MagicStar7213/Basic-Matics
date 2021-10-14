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

public class DivideManagerES extends JFrame {

    private static int a, b;
    private static double c, d;
    private static float e, f;

    private static String stra, strb;
    private static String strda, strdb;
    private static String strfa, strfb;

    private static final Ops.Divide dvd = new Ops.Divide();

    private static final String title = "Basic Matics - Dividir";
    private static final String dv = "Dividir";
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public DivideManagerES() {
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
        JMenu divideMenu = new JMenu(title);
        divideMenu.setMnemonic(KeyEvent.VK_F);
        setJMenuBar(menuBar);

        JPanel console = new JPanel();
        JTextArea output = new JTextArea();
        output.setEditable(false);
        console.add(output);
        menuBar.add(console);

        JPanel divided = new JPanel();
        JTextField divda = new JTextField(15);
        JTextField divdb = new JTextField(15);
        divided.add(divda);
        divided.add(divdb);
        JButton divd = new JButton(dv.replaceAll(dv, "Dividir"));
        divided.add(divd);

        ActionListener full = ae -> {
            strda = divda.getText();
            strdb = divdb.getText();
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
            strfa = divda.getText();
            strfb = divdb.getText();
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
        divd.addActionListener(full);

        Choice dec = new Choice();
        dec.add("Exacto");
        dec.add("Aproximado");
        dec.addItemListener(l -> {
            if (dec.getSelectedItem().equals("Approximado")) {
                divd.removeActionListener(full);
                divd.addActionListener(ap);
            } else {
                divd.removeActionListener(ap);
                divd.addActionListener(full);
            }
        });
        divided.add(dec);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(divided, BorderLayout.CENTER);
    }
}