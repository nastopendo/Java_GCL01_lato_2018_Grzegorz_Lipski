package com.grzegorzlipski;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserList extends JFrame{
    private JPanel userlist;
    private JMenuBar menuBar;
    public JTable table;
    private JButton Delete;

    Object[] columns = {"Nazwa studenta","Temat pracy", "Stron pracy", "Nazwisko promotora", "Ocena promotora", "Nazwa recenzenta", "Ocena recenzenta"};
    DefaultTableModel model = new DefaultTableModel();

    public UserList(){

        this.setContentPane(userlist);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(850,250));
        this.setLocation(new Point(400,250));
        this.setVisible(true);

        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Program");
        JMenu menu1=new JMenu("Praca");
        menuBar.add(menu1);
        menuBar.add(menu);
        JMenuItem item1=new JMenuItem("Dodaj");
        JMenuItem item = new JMenuItem("Zamknij");

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddOptions frame2 = new AddOptions();
                frame2.setVisible(true);
                frame2.setSize(400, 500);
                frame2.setTitle("Table editor");

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

        model.setColumnIdentifiers(columns);
        table.setModel(model);

        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                if(table.getSelectedRow()==-1){
                    if(table.getRowCount()==0){
                        //table is empty
                    }else {
                        //not selected any product
                    }
                }else{
                    model.removeRow(table.getSelectedRow());
                }
            }
        });
    }
}
