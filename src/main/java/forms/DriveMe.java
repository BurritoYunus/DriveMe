package forms;

import modules.CarRegistration;

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
    private JTextField registrationNField;
    private JTextField seatField;
    private JTextField transmissionTField;
    private JTextField engineField;
    private JButton actuallyRegisterCar;

    public DriveMe(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();






        actuallyRegisterCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int registrationNumber = Integer.parseInt(registrationNField.getText());
                int seats = Integer.parseInt(seatField.getText());
                String transmissionType = transmissionTField.getText();
                String engineType = engineField.getText();


                CarRegistration registeredCar = new CarRegistration(registrationNumber, seats, transmissionType, engineType);
            }
        });




































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