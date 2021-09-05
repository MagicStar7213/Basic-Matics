package com.micromatic.basicmatics.mtpl;

import com.micromatic.basicmatics.Ops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

        JPanel multipl = new JPanel();
        multipl.setBorder(BorderFactory.createTitledBorder("Multiplicar"));
        JTextField mtlpa = new JTextField(15);
        JTextField mtlpb = new JTextField(15);
        multipl.add(mtlpa);
        multipl.add(mtlpb);
        JButton mtlp = new JButton("Multiplicar");
        mtlp.addActionListener(e -> {
            stra = mtlpa.getText();
            strb = mtlpb.getText();
            try {
                a = Integer.parseInt(stra);
                b = Integer.parseInt(strb);
                output.setText(null);
                output.append("El resultado es " + mtpl.mtpl(a, b));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n se eencontr\u00F3 con una " + a);
            }
        });
        multipl.add(mtlp);

        JPanel multipld = new JPanel();
        multipld.setBorder(BorderFactory.createTitledBorder("Multiplicar N\u00FAmeros Decimales"));
        JTextField mtlpda = new JTextField(15);
        JTextField mtlpdb = new JTextField(15);
        multipld.add(mtlpda);
        multipld.add(mtlpdb);
        JButton mtlpd = new JButton("Multiplicar");
        mtlpd.addActionListener(e -> {
            strda = mtlpda.getText();
            strdb = mtlpdb.getText();
            try {
                c = Double.parseDouble(strda);
                d = Double.parseDouble(strdb);
                output.setText(null);
                output.append("El resultado es " + mtpl.mtplDouble(c, d));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n se eencontr\u00F3 con una " + a);
            }
        });
        multipld.add(mtlpd);

        JPanel multiplf = new JPanel();
        multiplf.setBorder(BorderFactory.createTitledBorder("Multiplicar N\u00FAmeros Float"));
        JTextField mtlpfa = new JTextField(15);
        JTextField mtlpfb = new JTextField(15);
        multiplf.add(mtlpfa);
        multiplf.add(mtlpfb);
        JButton mtlpf = new JButton("Multiplicar");
        mtlpf.addActionListener(ae -> {
            strfa = mtlpfa.getText();
            strfb = mtlpfb.getText();
            try {
                e = Float.parseFloat(strfa);
                f = Float.parseFloat(strfb);
                output.setText(null);
                output.append("El resultado es " + mtpl.mtplFloat(e, f));
            } catch (NumberFormatException a) {
                output.setText(null);
                output.append("La aplicaci\u00F3n se encontr\u00F3 con una " + a);
            }
        });
        multiplf.add(mtlpf);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(multipl, BorderLayout.NORTH);
        getContentPane().add(multipld, BorderLayout.CENTER);
        getContentPane().add(multiplf, BorderLayout.SOUTH);
    }
}