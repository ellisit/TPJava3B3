package better.app;
import javax.swing.*;
import better.service.*;


public class listeEmployer extends JPanel{
    private final application app;
    private Personnel p;
    String title[] = {"Nom", "Prénom", "Age", "Profession","Salaire","Date d'entrée"};
    JTable tabList;
    JButton back = new JButton("Retour au menu") ;

    public listeEmployer(application app, Personnel p){
        this.app = app;
        this.p=p;

        listEmployee();
    }

    public void listEmployee(){
        this.add(new JScrollPane(tabList));
        this.add(back);
        back.addActionListener(e ->app.displayMenu());
    }
}