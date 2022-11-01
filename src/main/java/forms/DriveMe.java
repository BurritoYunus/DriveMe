package forms;

import com.google.gson.Gson;
import modules.CarRegistration;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JPanel rentCarPanel;
    private JList<CarRegistration> carJList;
    private JButton checkCar;


    private DefaultListModel<CarRegistration> carListModel = new DefaultListModel<>();

    public DriveMe(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();


        carJList.setModel(carListModel);


















        //==================================================Listeners==================================================

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




        rentCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(rentCarPanel);
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









        actuallyRegisterCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int registrationNumber = Integer.parseInt(registrationNField.getText());
                int seats = Integer.parseInt(seatField.getText());
                String transmissionType = transmissionTField.getText();
                String engineType = engineField.getText();


                CarRegistration registeredCar = new CarRegistration(registrationNumber, seats, transmissionType, engineType);

                carListModel.addElement(registeredCar);

                Gson gson = new Gson();
                parentPanel.removeAll();
                parentPanel.add(userRentOrRegisterPanel);
                parentPanel.repaint();
                parentPanel.revalidate();


            }
        });

        carJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                CarRegistration selectedCar = carJList.getSelectedValue();

                registrationNField.setText(Integer.toString(selectedCar.getRegistrationNumber()));
                seatField.setText(Integer.toString(selectedCar.getSeats()));
                transmissionTField.setText(selectedCar.getTransmissionType());
                engineField.setText(selectedCar.getEngineType());

            }
        });
    }
}