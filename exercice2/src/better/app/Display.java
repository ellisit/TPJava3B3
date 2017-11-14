package better.app;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Display extends JPanel {
    private final application app;
    JButton boutonEmployer = new JButton("ajouté un employé");
    JButton boutonAjout = new JButton("Afficher les employés");

    public Display(application app) {
        display();
        this.app = app;
    }

    public void display(){
        this.setLayout(new FlowLayout());
        this.add(boutonEmployer );
        boutonEmployer .addActionListener(e ->app.addEmlpoyee());
        this.add(boutonAjout);
        boutonAjout.addActionListener(e ->app.listEmployee());
    }
}