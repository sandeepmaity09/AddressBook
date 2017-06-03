import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {

    public JFrame f;

    public MainPage() {
        initialize();
    }

    public static void main(String args[]) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainPage window = new MainPage();
                    window.f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {

        /* Code for Frame */
        f = new JFrame();
        f.setTitle("Address Book\r\n");
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setBounds(100, 100, 600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);

        JLabel heading = new JLabel("Address Book");
        heading.setBounds(50, 50, 500, 140);
        heading.setForeground(Color.PINK);
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.CENTER);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setVerticalAlignment(SwingConstants.CENTER);
        heading.setFont(Font.getFont("Allegro"));
        f.getContentPane().add(heading);


        /* Code for Register Button */
        JButton register = new JButton("Register");
//        register.setForeground(Color.BLACK);
//        register.setBackground(Color.YELLOW);
        register.setBounds(150, 200, 300, 50);
        f.getContentPane().add(register);

        /* Action Performed on Register Button */

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                RegistrationPage rp = null;
                try {
                    rp = new RegistrationPage();
                } catch (Exception ep) {
                    ep.printStackTrace();
                }
                rp.setVisible(true);
            }
        });

//        f.add(register);

        /* Code for Search Button */
        JButton search = new JButton("Search");
//        search.setForeground(Color.BLACK);
//        search.setBackground(Color.WHITE);
        search.setBounds(150, 260, 300, 50);
        f.getContentPane().add(search);

        /* Action Performed on Search Button */

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                /*
                SearchPage sp = null;
                try {
                    sp = new SearchPage();
                } catch (Exception ep){
                    ep.printStackTrace();
                }
                sp.setVisible(true);
                */
                SearchPage sp = new SearchPage();
                sp.setVisible(true);
            }
        });

        /* Code for Delete Button */
        JButton delete = new JButton("Delete");
//        delete.setForeground(Color.BLACK);
//        delete.setBackground(Color.RED);
        delete.setBounds(150, 320, 300, 50);
        f.getContentPane().add(delete);

        /* Action Performed on Delete Button */

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                DeletePage dp = new DeletePage();
                dp.setVisible(true);
            }
        });

        /* Code for Exit Button */
        JButton exit = new JButton("Exit");
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.RED);
        exit.setBounds(150, 380, 300, 50);
        f.getContentPane().add(exit);

        /* Action Performed on Exit Button */

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }
}