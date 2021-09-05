package com.micromatic.basicmatics.rest;

import com.micromatic.basicmatics.Ops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class RestManagerES extends JFrame {

    private static int a, b;
    private static double c, d;
    private static float e, f;

    private static String stra, strb;
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

        JPanel res = new JPanel();
        res.setBorder(BorderFactory.createTitledBorder("Restar"));
        JTextField rsta = new JTextField(15);
        JTextField rstb = new JTextField(15);
        res.add(rsta);
        res.add(rstb);
        JButton rst = new JButton("Restar");
        rst.addActionListener(e -> {
            stra = rsta.getText();
            strb = rstb.getText();
            try {
                a = Integer.parseInt(stra);
                b = Integer.parseInt(strb);
                output.setText(null);
                output.append("El resultado es" + rest.rest(a, b));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n encontr\u00F3 una " + a);
            }
        });
        res.add(rst);

        JPanel resd = new JPanel();
        resd.setBorder(BorderFactory.createTitledBorder("Restar N\u00FAmeros Decimales"));
        JTextField rstda = new JTextField(15);
        JTextField rstdb = new JTextField(15);
        resd.add(rstda);
        resd.add(rstdb);
        JButton rstd = new JButton("Restar");
        rstd.addActionListener(e -> {
            strda = rsta.getText();
            strdb = rstb.getText();
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

        JPanel resf = new JPanel();
        resf.setBorder(BorderFactory.createTitledBorder("Restar N\u00FAmeros Float"));
        JTextField rstfa = new JTextField(15);
        JTextField rstfb = new JTextField(15);
        resf.add(rstfa);
        resf.add(rstfb);
        JButton rstf = new JButton("Restar");
        rstf.addActionListener(ae -> {
            strfa = rstfa.getText();
            strfb = rstfb.getText();
            try {
                e = Float.parseFloat(strfa);
                f = Float.parseFloat(strfb);
                output.setText(null);
                output.append("El resultado es" + rest.restFloat(e, f));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n encontr\u00F3 una " + a);
            }
        });
        resd.add(rstd);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(res, BorderLayout.NORTH);
        getContentPane().add(resd, BorderLayout.CENTER);
        getContentPane().add(resf, BorderLayout.SOUTH);
    }
}