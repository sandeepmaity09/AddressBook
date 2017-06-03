import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationPage extends JFrame {

    private JPanel userPane;
    private JTextField userName;
    private JTextField userFatherName;
    private JTextField userContact;
    private JTextField userStreet;
    private JTextField userCity;
    private JTextField userState;
    private JTextField userPinCode;
    private JTextField userEmail;

    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    RegistrationPage rp = new RegistrationPage();
                    rp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegistrationPage() throws Exception {

        setBounds(100,100,600,410);

        userPane = new JPanel();
        userPane.setBackground(Color.LIGHT_GRAY);
        userPane.setBorder(new EmptyBorder(5,5,5,5));
        userPane.setLayout(null);
        setContentPane(userPane);

        JLabel name = new JLabel("Name");
        name.setBounds(50,50,100,20);
        userPane.add(name);

        userName = new JTextField();
        userName.setBounds(150,50,400,20);
        userPane.add(userName);

        JLabel fatherName = new JLabel("Father's Name");
        fatherName.setBounds(20,80,120,20);
        userPane.add(fatherName);

        userFatherName = new JTextField();
        userFatherName.setBounds(150,80,400,20);
        userPane.add(userFatherName);

        JLabel contactNumber = new JLabel("Contact");
        contactNumber.setBounds(50,110,100,20);
        userPane.add(contactNumber);

        userContact = new JTextField();
        userContact.setBounds(150,110,400,20);
        userPane.add(userContact);

        JLabel street = new JLabel("Street");
        street.setBounds(50,140,100,20);
        userPane.add(street);

        userStreet = new JTextField();
        userStreet.setBounds(150,140,400,20);
        userPane.add(userStreet);

        JLabel city = new JLabel("City");
        city.setBounds(50,170,100,20);
        userPane.add(city);

        userCity = new JTextField();
        userCity.setBounds(150,170,400,20);
        userPane.add(userCity);

        JLabel state = new JLabel("State");
        state.setBounds(50,200,100,20);
        userPane.add(state);

        userState = new JTextField();
        userState.setBounds(150,200,400,20);
        userPane.add(userState);

        JLabel pincode = new JLabel("PinCode");
        pincode.setBounds(50,230,100,20);
        userPane.add(pincode);

        userPinCode = new JTextField();
        userPinCode.setBounds(150,230,400,20);
        userPane.add(userPinCode);

        JLabel email = new JLabel("Email");
        email.setBounds(50,260,100,20);
        userPane.add(email);

        userEmail = new JTextField();
        userEmail.setBounds(150,260,400,20);
        userPane.add(userEmail);

        JButton home = new JButton("Home");
        home.setBounds(100,310,150,50);
        userPane.add(home);

        JButton submit = new JButton("Submit");
        submit.setBounds(350,310,150,50);
        userPane.add(submit);


        /* Action's Performed By Submit & Home */

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getData();
//                setData();
                dispose();
                newWindow();

//                MainPage window = new MainPage();
//                window.f.setVisible(true);
            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                newWindow();

//                MainPage window = new MainPage();
//                window.f.setVisible(true);
            }
        });
    }

    public void getData(){

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/addressbook","root","root");
            PreparedStatement stmt = con.prepareStatement("INSERT into information values(?,?,?,?,?,?,?,?)");

            stmt.setString(1,userName.getText());
            stmt.setString(2,userFatherName.getText());
            stmt.setLong(3,Long.parseLong(userContact.getText()));
            stmt.setString(4,userStreet.getText());
            stmt.setString(5,userCity.getText());
            stmt.setString(6,userState.getText());
            stmt.setInt(7,Integer.parseInt(userPinCode.getText()));
            stmt.setString(8,userEmail.getText());

            stmt.execute();
            JOptionPane.showMessageDialog(null,"Form Filled Successfully");

            stmt.close();
            con.close();

        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Errors in form");
        }
    }

    public void setData(){

        userName.setText("");
        userFatherName.setText("");
        userContact.setText("");
        userStreet.setText("");
        userCity.setText("");
        userState.setText("");
        userPinCode.setText("");
        userEmail.setText("");
        dispose();
    }

    public void newWindow(){
        MainPage window = new MainPage();
        window.f.setVisible(true);
    }

}
