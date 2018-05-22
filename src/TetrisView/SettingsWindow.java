package TetrisView;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsWindow extends JDialog{
    private static final int HEIGHT = 300;
    private static final int WIDTH = 200;

    private JLabel darkMode = new JLabel("Dark Mode");
    private JComboBox<String> darkModeChoice = new JComboBox<>();
    private JLabel defaultLevel = new JLabel("Default Level");
    private JComboBox<String> levelChoice = new JComboBox<>();


    SettingsWindow(JFrame owner)
    {
        super(owner, "Settings" , true);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        JPanel settingPanel = new JPanel();
        darkModeChoice.addItem("OFF");
        darkModeChoice.addItem("ON");

        levelChoice.addItem("1");
        levelChoice.addItem("2");
        levelChoice.addItem("3");
        levelChoice.addItem("4");
        levelChoice.addItem("5");
        levelChoice.addItem("6");
        levelChoice.addItem("7");
        levelChoice.addItem("8");
        levelChoice.addItem("9");
        levelChoice.addItem("10");

        settingPanel.add(darkMode);
        settingPanel.add(darkModeChoice);
        settingPanel.add(defaultLevel);
        settingPanel.add(levelChoice);


        this.add(settingPanel);
    }

    public void addComboListener(ActionListener l)
    {
        darkModeChoice.addActionListener(l);
        levelChoice.addActionListener(l);
    }

}//todo wybierz jakis fajny layout

