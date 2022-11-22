package forms;

import com.google.gson.Gson;
import modules.CarRegistration;
import modules.CarRepository;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


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
    private JButton mainMenuButton;

    private JComboBox comboBoxSeats;
    private JComboBox comboBoxTType;
    private JComboBox comboBoxEType;
    private JButton mainMenuButtonFromRent;
    private JCheckBox rented;
    private JCheckBox notRented;
    private JButton browseAllCarsButton;
    private JPanel allCarsPanel;
    private JList allCarsList;
    private JButton mainMenuButtonFromAllCars;

    CarRepository testRepository = new CarRepository("CarList");
    private DefaultListModel<CarRegistration> carListModel = new DefaultListModel<>();

    Gson gson = new Gson();

    private void all_Cars_List(ArrayList<CarRegistration> carList) {
        carListModel.clear();
        for (CarRegistration i : carList) {
            carListModel.addElement(i);
        }
    }


    public DriveMe(String title) {
        super(title);

        this.setContentPane(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("carList.json"));
            testRepository = gson.fromJson(br, CarRepository.class);
        } catch (FileNotFoundException e) {
            System.out.println("No save file to read from. It will be made when this application closes.");
        }catch (IOException e) {
            e.printStackTrace();
        }


        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });


        carJList.setModel(carListModel);
        allCarsList.setModel(carListModel);


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

                all_Cars_List(testRepository.getAllAvailableCars());
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

                    String registrationNumber = registrationNField.getText();
                    String selectedValueSeats = comboBoxSeats.getSelectedItem().toString();
                    String selectedValueTType = comboBoxTType.getSelectedItem().toString();
                    String selectedValueEType = comboBoxEType.getSelectedItem().toString();

                    CarRegistration registeredCar = new CarRegistration(registrationNumber, selectedValueSeats, selectedValueTType, selectedValueEType);
                    if (rented.isSelected()) {
                        registeredCar.setRented(true);

                    } else if (notRented.isSelected()) {
                        registeredCar.setRented(false);
                    }

                    testRepository.addCar(registeredCar);
                    carListModel.addElement(registeredCar);
                    JOptionPane.showMessageDialog(registerCarPanel, "You have just registered the car with registrationnumber: " + registeredCar.getRegistrationNumber());

                    registrationNField.setText("");
                    rented.setSelected(false);
                    notRented.setSelected(false);
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "You must input valid numbers.");
                }



            }
        });



        carJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                CarRegistration selectedCar = carJList.getSelectedValue();
                registrationNField.setText(selectedCar.getRegistrationNumber());
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

        mainMenuButtonFromRent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(userRentOrRegisterPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });

        mainMenuButtonFromAllCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(userRentOrRegisterPanel);
                parentPanel.repaint();
                parentPanel.revalidate();

            }
        });


        checkCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRegistration selectedCar = carJList.getSelectedValue();
                selectedCar.setRented(true);
                JOptionPane.showMessageDialog(rentCarPanel, "You have just rented car with the registrationnumber: " + selectedCar.getRegistrationNumber());
            }
        });

        browseAllCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(allCarsPanel);
                parentPanel.repaint();
                parentPanel.revalidate();

                all_Cars_List(testRepository.getCarArrayList());
            }
        });

    }





    public void exitProcedure( ) {
        String json = gson.toJson(testRepository);
        try {
            FileWriter writer = new FileWriter("carList.json");
            writer.write(json);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.dispose();
        System.exit(0);
    }

}