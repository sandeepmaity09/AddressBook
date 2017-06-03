import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeletePage extends JFrame {

    private JPanel contentPane;
    private JTextField searchUserName;
    private JTextField searchUserContact;
    private JTable searchUserTable;
    private JButton homeButton;
    private JButton exitButton;
    private JEditorPane searchUserPane;

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    DeletePage sp = new DeletePage();
                    sp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeletePage() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,600,550);

        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        searchUserPane = new JEditorPane();
        searchUserPane.setEditable(false);
        searchUserPane.setBackground(Color.LIGHT_GRAY);
        searchUserPane.setText("Enter your Name and Contect number to start search ");
        searchUserPane.setBounds(50,70,200,20);
        contentPane.add(searchUserPane);

        JLabel name = new JLabel("Name");
        name.setBounds(300,60,50,20);
        contentPane.add(name);

        searchUserName = new JTextField();
        searchUserName.setBounds(400,60,170,20);
        contentPane.add(searchUserName);
//        searchUserName.setColumns(10);

        JLabel contact = new JLabel("Contact");
        contact.setBounds(300,90,80,20);
        contentPane.add(contact);

        searchUserContact = new JTextField();
        searchUserContact.setBounds(400,90,170,20);
        contentPane.add(searchUserContact);

        JButton find = new JButton("Delete");
        find.setBounds(365,120,100,20);
        contentPane.add(find);

        JScrollPane searchScrollPane = new JScrollPane();
        searchScrollPane.setBounds(30,150,540,280);
        contentPane.add(searchScrollPane);

        searchUserTable = new JTable();
        searchScrollPane.setViewportView(searchUserTable);

        homeButton = new JButton("Home Page");
        homeButton.setBounds(100,450,150,50);
        contentPane.add(homeButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(350,450,150,50);
        contentPane.add(exitButton);

        /* Action's Performed */

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                newWindow();
            }
        });

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","root");
                    PreparedStatement stmt = con.prepareStatement("SELECT * from information where name=? && contact=?");
                    stmt.setString(1,searchUserName.getText());
                    stmt.setLong(2,Long.parseLong(searchUserContact.getText()));
                    PreparedStatement delStmt = con.prepareStatement("DELETE FROM information WHERE Name=? && Contact=?");
                    delStmt.setString(1,searchUserName.getText());
                    delStmt.setLong(2,Long.parseLong(searchUserContact.getText()));

                    ResultSet rs = stmt.executeQuery();
                    delStmt.execute();

                    searchUserTable.setModel(DbUtils.resultSetToTableModel(rs));
                    stmt.close();
                    delStmt.close();
                    con.close();

                } catch (Exception ep){
//                    ep.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error Message");
                }
            }
        });

    }

    public void newWindow() {
        MainPage mp = new MainPage();
        mp.f.setVisible(true);
    }
}