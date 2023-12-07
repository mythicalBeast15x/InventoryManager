package src.main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InventoryUI extends JFrame implements ActionListener {


    JLabel headTitle;
    JButton backBtn;
    JTable jt;
    String[] columnNames;
    int numrows;
    DefaultTableModel model;
    JScrollPane scrollPane;


    public InventoryUI(){
        setTitle("Inventory");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        this.setLayout(null);

        //String Array for Titles of Columns, you can edit this to whatever necessary
        columnNames = new String[]{"Column1", "Column2", "Column3", "Column4", "Column5"};

        numrows = 5;
        model = new DefaultTableModel();
        model.setColumnCount(5);
        //this was just filler data I was using to make the table show up, you can remove this when you populate it
        for (int row = 0; row < numrows; row++) {
            Object[] data = new Object[columnNames.length];
            data[0] = "Value1";
            data[1] = "Value2";
            data[2] = "Value3";
            data[3] = "Value4";
            data[4] = "Value5";
            model.addRow(data);
        }
        jt = new JTable(model);
        model.setColumnIdentifiers(columnNames);
        scrollPane = new JScrollPane(jt);
        scrollPane.setBounds(10, 60, 765, 430);

        headTitle = new JLabel("Star Spangled Snacks");
        headTitle.setFont(headTitle.getFont().deriveFont(24.0F));
        headTitle.setBounds(10, 10, 400, 40);

        backBtn = new JButton("Return");
        backBtn.setBounds(340,500,100,40); //edit this
        backBtn.addActionListener(this);


        this.add(backBtn);
        this.add(headTitle);
        this.add(scrollPane);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn){
            GUI myGui = new GUI();
            myGui.show();
            dispose();
        }

    }
}


