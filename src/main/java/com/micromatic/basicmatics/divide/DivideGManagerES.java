package com.micromatic.basicmatics.divide;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unchecked", "rawtypes"})
public class DivideGManagerES extends JFrame {

    private static final DivideGManagerES dvdges = new DivideGManagerES();
    private static final DivideManagerES dvdes = new DivideManagerES();
    private static final DivideRManagerES dvdres = new DivideRManagerES();
    public DivideGManagerES() {
        setTitle("Basic Matics - Inicio Divisi\u00F3n");
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
        JMenu divideMenu = new JMenu("Inicio Divisi\u00F3n");
        divideMenu.setMnemonic(KeyEvent.VK_F);
        setJMenuBar(menuBar);

        JPanel home = new JPanel();
        JButton dvdm = new JButton("Dividir");
        dvdm.addActionListener(e -> {
            dvdes.setVisible(true);
            dvdges.setVisible(false);
        });
        home.add(dvdm);
        JButton dvdrm = new JButton("Resto de Divisi\u00F3n");
        dvdrm.addActionListener(e -> {
            dvdres.setVisible(true);
            dvdges.setVisible(false);
        });
        home.add(dvdrm);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(home, BorderLayout.CENTER);
    }
}