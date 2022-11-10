package forms;

import com.google.gson.Gson;
import modules.CarRegistration;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



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
    private JPanel paymentPanel;
    private JButton vippsButton;
    private JButton bankIDButton;
    private JList carJListss;
    private JButton mainMenuButton;


    private DefaultListModel<CarRegistration> carListModel = new DefaultListModel<>();

    public DriveMe(String title) {
        super(title);

        this.setContentPane(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });


        carJList.setModel(carListModel);
        carJListss.setModel(carListModel);


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


        //rentCar
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
                try {


                int registrationNumber = Integer.parseInt(registrationNField.getText());
                int seats = Integer.parseInt(seatField.getText());
                String transmissionType = transmissionTField.getText();
                String engineType = engineField.getText();


                CarRegistration registeredCar = new CarRegistration(registrationNumber, seats, transmissionType, engineType);

                Gson gson = new Gson();
                String json = gson.toJson(registeredCar);

                carListModel.addElement(registeredCar);
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "You must input valid numbers.");
                }



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
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(userRentOrRegisterPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });
    }

    public void exitProcedure() {
        this.dispose();
        System.exit(0);
    }

}