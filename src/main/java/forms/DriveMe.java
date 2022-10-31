package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriveMe extends JFrame{
    private JPanel mainPanel;
    private JPanel parentPanel;
    private JPanel loginPanel;
    private JButton adminLogin;
    private JButton userLogin;
    private JPanel userRentOrRegisterPanel;
    private JButton registerCar;
    private JButton rentCar;
    private JPanel registerCarPanel;
    private JTextField HF54432TextField;
    private JTextField a4TextField;
    private JTextField autoTextField;
    private JTextField dieselTextField;
    private JButton button1;

    public DriveMe(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();







































        //listeners

        //userLogin
        userLogin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            parentPanel.removeAll();
            parentPanel.add(userRentOrRegisterPanel);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    });

        //registerCar
        registerCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            parentPanel.removeAll();
            parentPanel.add(registerCarPanel);
            parentPanel.repaint();
            parentPanel.revalidate();
            }
        });
    }
}