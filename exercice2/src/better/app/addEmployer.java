package better.app;


import better.domain.Employee;
import better.service.Personnel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addEmployer extends JPanel implements ActionListener {
    private final application app;
    private final Personnel listEmployee;
    private  static String[] profession = new String[] {"Manutentionnaire", "ManutARisque", "Representant", "Vendeur", "Technicien", "TechnARisque"};

    private static JLabel labelLastName = new JLabel("Last name :");
    private static JLabel labelFirstName = new JLabel("First name :");
    private static JLabel labelAge = new JLabel("Age :");
    private static JLabel labelProfession = new JLabel("Profession :");
    private static JLabel labelEntryDate = new JLabel("Entry date :");
    private static JLabel labelSalary = new JLabel("Salary :");

    private static JTextField getLastName = new JTextField(20);
    private static JTextField getFirstName = new JTextField(20);
    private static JTextField getAge = new JTextField(3);
    private static JTextField getEntryDate = new JTextField(4);
    private static JTextField getSalary = new JTextField(9);

    private static JComboBox<String> comboBox = new JComboBox<String>();

    public addEmployer(application app, Personnel listEmployee){
        this.runMenu();
        this.app = app;
        this.listEmployee = listEmployee;
    }

    private static JButton submitButton = new JButton("Submit");
    private static JButton backButton = new JButton("Back");

    public void runMenu() {
        for (int i = 0; i < profession.length; i++){
            comboBox.addItem(profession[i]);
        }
        this.setLayout(new FlowLayout());
        this.add(labelLastName);
        this.add(getLastName);
        this.add(labelFirstName);
        this.add(getFirstName);
        this.add(labelAge);
        this.add(getAge);
        this.add(labelProfession);
        this.add(comboBox);
        this.add(labelEntryDate);
        this.add(getEntryDate);
        this.add(labelSalary);
        this.add(getSalary);
        this.add(submitButton);
        submitButton.addActionListener(this);
        this.add(backButton);
        backButton.addActionListener(e -> app.displayMenu());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputLastName = getLastName.getText();
        String inputFirstName = getFirstName.getText();
        int inputAge = Integer.parseInt(getAge.getText());
        String inputProfession = (String) comboBox.getSelectedItem();
        String inputEntryDate = getEntryDate.getText();
        Double inputSalary = Double.valueOf(getSalary.getText());

        try {
            Employee newEmployee = (Employee) Class.forName("better.domain." + inputProfession)
                    .getConstructor(String.class, String.class, int.class, String.class, double.class)
                    .newInstance((String)inputFirstName, (String)inputLastName, (int)inputAge, (String)inputEntryDate, (double)inputSalary);
            listEmployee.ajouterEmploye(newEmployee);
            app.displayMenu();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}