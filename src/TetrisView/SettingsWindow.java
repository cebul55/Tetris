package TetrisView;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class SettingsWindow extends JDialog{
    private static final int HEIGHT = 800;
    private static final int WIDTH = 600;

    private JLabel darkMode = new JLabel("Dark Mode");
    private JCheckBox on = new JCheckBox("ON");
    private JCheckBox off = new JCheckBox("OFF");
    private JLabel defaultLevel = new JLabel("Default Level");
    private JCheckBox level1 = new JCheckBox("1");
    private JCheckBox level2 = new JCheckBox("2");
    private JCheckBox level3 = new JCheckBox("3");
    private JCheckBox level4 = new JCheckBox("4");
    private JCheckBox level5 = new JCheckBox("5");
    private JCheckBox level6 = new JCheckBox("6");
    private JCheckBox level7 = new JCheckBox("7");
    private JCheckBox level8 = new JCheckBox("8");
    private JCheckBox level9 = new JCheckBox("9");
    private JCheckBox level10 = new JCheckBox("10");



    SettingsWindow(JFrame owner)
    {
        super(owner, "Settings" , true);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        JPanel settingPanel = new JPanel();
        settingPanel.add(darkMode);
        settingPanel.add(on);
        settingPanel.add(off);
        settingPanel.add(defaultLevel);
        settingPanel.add(level1);
        settingPanel.add(level2);
        settingPanel.add(level3);
        settingPanel.add(level4);
        settingPanel.add(level5);
        settingPanel.add(level6);
        settingPanel.add(level7);
        settingPanel.add(level8);
        settingPanel.add(level9);
        settingPanel.add(level10);

        this.add(settingPanel);
    }


}//todo wybierz jakis fajny layout

//todo zmiana koloru kafelków, zmiana defaultowej predkosci ,