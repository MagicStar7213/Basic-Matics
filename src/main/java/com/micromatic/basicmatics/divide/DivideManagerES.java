package com.micromatic.basicmatics.divide;

import com.micromatic.basicmatics.Ops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

        JPanel divide = new JPanel();
        divide.setBorder(BorderFactory.createTitledBorder(dv));
        JTextField diva = new JTextField(15);
        JTextField divb = new JTextField(15);
        divide.add(diva);
        divide.add(divb);
        JButton div = new JButton(dv);
        div.addActionListener(ae -> {
            stra = diva.getText();
            strb = divb.getText();
            try {
                a = Integer.parseInt(stra);
                b = Integer.parseInt(strb);
                output.setText(null);
                output.append("El resultado es " + dvd.division(a, b));
            } catch (NumberFormatException nfe) {
                output.setText(null);
                output.append("La aplicaci\u00F3n se encontr\u00F3 con el problema " + nfe);
            }
        });
        divide.add(div);

        JPanel divided = new JPanel();
        divided.setBorder(BorderFactory.createTitledBorder("Dividir N\u00FAmeros Decimales"));
        JTextField divda = new JTextField(15);
        JTextField divdb = new JTextField(15);
        divided.add(divda);
        divided.add(divdb);
        JButton divd = new JButton(dv.replaceAll(dv, "Dividir"));
        divd.addActionListener(ae -> {
            strda = divda.getText();
            strdb = divdb.getText();
            try {
                c = Double.parseDouble(strda);
                d = Double.parseDouble(strdb);
                output.setText(null);
                output.append("El resultado es " + dvd.divisionDouble(c, d));
            } catch (NumberFormatException nfe) {
                output.setText(null);
                output.append("La aplicaci\u00F3n se encontr\u00F3 con el problema " + nfe);
            }
        });
        divided.add(divd);

        JPanel dividef = new JPanel();
        dividef.setBorder(BorderFactory.createTitledBorder("Dividir N\u00FAmeros Float"));
        JTextField divfa = new JTextField(15);
        JTextField divfb = new JTextField(15);
        dividef.add(divfa);
        dividef.add(divfb);
        JButton divf = new JButton(dv);
        divf.addActionListener(ae -> {
            strfa = divfa.getText();
            strfb = divfb.getText();
            try {
                e = Float.parseFloat(strfa);
                f = Float.parseFloat(strfb);
                output.setText(null);
                output.append("El resultado es " + dvd.divisionFloat(e, f));
            } catch (NumberFormatException nfe) {
                output.setText(null);
                output.append("La aplicaci\u00F3n se encontr\u00F3 con el problema " + nfe);
            }
        });
        dividef.add(divf);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(divide, BorderLayout.NORTH);
        getContentPane().add(divided, BorderLayout.CENTER);
        getContentPane().add(dividef, BorderLayout.SOUTH);
    }
}