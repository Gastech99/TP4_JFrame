import javax.swing.*;
import java.awt.event.*;

public class Image {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame frame = new JFrame("La fenetre image");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajout d'un écouteur de fermeture
        frame.addWindowListener(new GestionFenetre());

        // Chargement et affichage de l'image
        ImageIcon icon = new ImageIcon("java.png"); // Vérifie le chemin de l'image
        JLabel imageLabel = new JLabel(icon);
        frame.add(imageLabel);

        // Afficher la fenêtre après avoir ajouté l'image
        frame.setVisible(true);
    }
}

// Gestion de la fermeture de la fenêtre
class GestionFenetre extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
