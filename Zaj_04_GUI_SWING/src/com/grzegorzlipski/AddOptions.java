package com.grzegorzlipski;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddOptions extends JFrame{
    private JPanel panelOptions;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox1;
    private JButton dodajButton;
    private JLabel l1;
    private JLabel l2;
    private JPanel l3;
    private JLabel l4;
    private JComboBox comboBox2;
    private JMenuBar menuBar;

    public AddOptions() {

        this.setContentPane(panelOptions);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(new Point(500, 600));


        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Program");
        JMenu menu1=new JMenu("Okno");
        menuBar.add(menu1);
        menuBar.add(menu);
        JMenuItem item1=new JMenuItem("Zamknij");
        JMenuItem item = new JMenuItem("Zamknij");

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        menu.add(item);
        menu1.add(item1);
        setJMenuBar(menuBar);
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                        if ((textField1).toString().length()<3 || (textField1).toString().length()>30) {
                            l1.setText("Niepoprawna dlugosc");
                        }
                    }
                });

        textField4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if ((textField4).toString().length()<3 || (textField4).toString().length()>30) {
                    l4.setText("Niepoprawna dlugosc");
                }
            }
        });
        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if ((textField2).toString().length()<3 || (textField2).toString().length()>30) {
                    l2.setText("Niepoprawna dlugosc");
                }
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),
                            comboBox1.getSelectedItem().toString(),textField5.getText(), comboBox2.getSelectedItem().toString()});
            }
        });
    }
        };
