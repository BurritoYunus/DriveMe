package forms;

import modules.Dolphin;
import modules.Elephant;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalRegister extends JFrame {

    private JPanel mainPanel;
    private JPanel buttonsPanel;
    private JPanel cardLayoutPanel;
    private JButton dolphinCreatorButton;
    private JButton elephantCreatorButton;
    private JPanel Dolphin;
    private JPanel Elephant;
    private JTextField nameField;
    private JTextField ageField;
    private JList<Dolphin> dolphinJList;
    private JList<Elephant> elephantJList;
    private JTextField iqField;
    private JButton createDolphinButton;
    private JButton createElephantButton;

    private JTextField childrenField;

    private DefaultListModel<Dolphin> dolphinListModel = new DefaultListModel<>();
    private DefaultListModel<Elephant> elephantListModel = new DefaultListModel<>();

    public AnimalRegister(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        dolphinJList.setModel(dolphinListModel);
        elephantJList.setModel(elephantListModel);


        //dolphin
        createDolphinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                int iq = Integer.parseInt(iqField.getText());


                Dolphin createdAnimal = new Dolphin(name, age, iq);

                dolphinListModel.addElement(createdAnimal);
            }
        });


        dolphinJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                Dolphin selectedAnimal = dolphinJList.getSelectedValue();

                nameField.setText(selectedAnimal.getName());
                ageField.setText(Integer.toString(selectedAnimal.getAge()));
                iqField.setText(Integer.toString(selectedAnimal.getIq()));


            }
        });



        //elephant


        createElephantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                int children = Integer.parseInt(childrenField.getText());


                Elephant createdAnimal = new Elephant(name, age, children);

                elephantListModel.addElement(createdAnimal);
            }
        });


        elephantJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                Elephant selectedAnimal = elephantJList.getSelectedValue();

                nameField.setText(selectedAnimal.getName());
                ageField.setText(Integer.toString(selectedAnimal.getAge()));
                childrenField.setText(Integer.toString(selectedAnimal.getTotalChildren()));

            }
        });










        //buttonpanel

        dolphinCreatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.removeAll(); // Fjerner alt innhold i cardLayoutPanel
                cardLayoutPanel.add(Dolphin); // Spesifiserer at vi nå skal vise page2Panel
                cardLayoutPanel.repaint();
                cardLayoutPanel.revalidate();
            }
        });



        elephantCreatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.removeAll(); // Fjerner alt innhold i cardLayoutPanel
                cardLayoutPanel.add(Elephant); // Spesifiserer at vi nå skal vise page2Panel
                cardLayoutPanel.repaint();
                cardLayoutPanel.revalidate();
            }
        });
    }
}