package forms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modules.CarRegistration;
import modules.CarRepository;

import javax.swing.*;
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
    private JButton actuallyRegisterCar;
    private JPanel rentCarPanel;
    private JList<CarRegistration> carJList;
    private JButton rentCarWithVipps;
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
    private JPanel adminListPanel;
    private JList adminList;
    private JButton logOutFromAdmin;
    private JButton editCarPageButton;
    private JPanel editCarsPanel;
    private JTextField registrationNFieldEdit;
    private JTextField seatsFieldEdit;
    private JTextField tranmissionTFieldEdit;
    private JTextField engineTFieldEdit;
    private JButton goBackButton;
    private JButton editCarButton;
    private JButton deleteCarButton;
    private JCheckBox rentedCheckBox;
    private JCheckBox notRentedCheckBox;
    private JButton logOutButton;
    private JButton rentCarWithCard;

    CarRepository carRepository = new CarRepository("carList.json");
    private DefaultListModel<CarRegistration> carListModel = new DefaultListModel<>();
    GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
    Gson gson = gsonBuilder.create();
    File file = new File(carRepository.getRepositoryName());

    public DriveMe(String title) {
        super(title);

        this.setContentPane(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(file));
            carRepository = gson.fromJson(br, CarRepository.class);
        } catch (FileNotFoundException e) {
            System.out.println("No save file to read from. It will be made when this application closes.");
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        carJList.setModel(carListModel);
        allCarsList.setModel(carListModel);
        adminList.setModel(carListModel);


        //==================================================Listeners==================================================
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

                    if(registrationNField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(registerCarPanel, "Please do not enter an empty registration number");
                    }
                    else {
                        carRepository.addCar(registeredCar);
                        carListModel.addElement(registeredCar);
                        JOptionPane.showMessageDialog(registerCarPanel, "You have just registered the car with registration number: " + registeredCar.getRegistrationNumber());

                        registrationNField.setText("");
                        rented.setSelected(false);
                        notRented.setSelected(false);
                    }

                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(null, "You must input valid numbers.");
                }
            }
        });

        rentCarWithVipps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRegistration selectedCar = carJList.getSelectedValue();
                selectedCar.setRented(true);
                JOptionPane.showMessageDialog(rentCarPanel, "You have successfully rented the car with the registration number: " + selectedCar.getRegistrationNumber() + ", with vipps");

                all_Cars_List(carRepository.getAllAvailableCars());
            }
        });

        rentCarWithCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRegistration selectedCar = carJList.getSelectedValue();
                selectedCar.setRented(true);
                JOptionPane.showMessageDialog(rentCarPanel, "You have successfully rented the car with the registration number: " + selectedCar.getRegistrationNumber() + ", with a card");

                all_Cars_List(carRepository.getAllAvailableCars());
            }
        });


        adminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(adminListPanel);
                parentPanel.repaint();
                parentPanel.revalidate();

                all_Cars_List(carRepository.getCarArrayList());
            }
        });
        editCarPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(editCarsPanel);
                parentPanel.repaint();
                parentPanel.revalidate();

                CarRegistration selectedCar = (CarRegistration) adminList.getSelectedValue();
                registrationNFieldEdit.setText(selectedCar.getRegistrationNumber());
                seatsFieldEdit.setText(selectedCar.getSeats());
                tranmissionTFieldEdit.setText(selectedCar.getTransmissionType());
                engineTFieldEdit.setText(selectedCar.getEngineType());
            }
        });


        deleteCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRegistration selectedCar = (CarRegistration) adminList.getSelectedValue();
                carRepository.removeCar(selectedCar);
                carListModel.removeElement(selectedCar);

                JOptionPane.showMessageDialog(adminListPanel, "Successfully removed car with the registration number:" + selectedCar.getRegistrationNumber());


                all_Cars_List(carRepository.getCarArrayList());
            }
        });

        editCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarRegistration selectedCar = (CarRegistration) adminList.getSelectedValue();

                String currentRegistrationNumber = selectedCar.getRegistrationNumber();
                String currentSeats = selectedCar.getSeats();
                String currentTransmissionType = selectedCar.getTransmissionType();
                String currentEngineType = selectedCar.getEngineType();

                String registrationNumber = registrationNFieldEdit.getText();
                String seats = seatsFieldEdit.getText();
                String transmissionType = tranmissionTFieldEdit.getText();
                String engineType = engineTFieldEdit.getText();

                selectedCar.setRegistrationNumber(registrationNumber);
                selectedCar.setSeats(seats);
                selectedCar.setTransmissionType(transmissionType);
                selectedCar.setEngineType(engineType);


                if (rentedCheckBox.isSelected()) {
                    selectedCar.setRented(true);

                } else if (notRentedCheckBox.isSelected()) {
                    selectedCar.setRented(false);
                }

                JOptionPane.showMessageDialog(editCarsPanel, "Successfully changed the car's information from:\n" +
                        "Registration number: " + currentRegistrationNumber + ", Seats: " + currentSeats + ", Transmission type: " +
                        currentTransmissionType + ", Engine type: " + currentEngineType +
                        "\n To: \n" +
                        "Registration number: " + selectedCar.getRegistrationNumber() + ", Seats: " + selectedCar.getSeats() + ", Transmission type: " +
                        selectedCar.getTransmissionType() + ", Engine type: " + selectedCar.getEngineType());

                parentPanel.removeAll();
                parentPanel.add(adminListPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });

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

                all_Cars_List(carRepository.getAllAvailableCars());
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(loginPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });
        browseAllCarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(allCarsPanel);
                parentPanel.repaint();
                parentPanel.revalidate();

                all_Cars_List(carRepository.getCarArrayList());
            }
        });

        logOutFromAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(loginPanel);
                parentPanel.repaint();
                parentPanel.revalidate();
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentPanel.removeAll();
                parentPanel.add(adminListPanel);
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
    }

    private void all_Cars_List(ArrayList<CarRegistration> carList) {
        carListModel.clear();
        for (CarRegistration i : carList) {
            carListModel.addElement(i);
        }
    }

    public void exitProcedure( ) {
        String json = gson.toJson(carRepository);
        carRepository.writeToJson(json);
        this.dispose();
        System.exit(0);
    }

}