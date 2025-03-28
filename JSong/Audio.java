import javax.sound.sampled.*;
import javax.swing.*;
import java.net.URL;
import java.io.IOException;

public class Audio {

    public static void main(String[] args) {
        try {
            URL url = new URL("videoplayback.wav");
            Clip clip = AudioSystem.getClip();
            
            // Récupération du flux audio
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Affichage de la boîte de dialogue dans le thread Swing
            SwingUtilities.invokeLater(() -> 
                JOptionPane.showMessageDialog(null, "Fermez pour arrêter le son.")
            );

            // Fermeture des ressources après fermeture de la boîte de dialogue
            clip.stop();
            clip.close();
            ais.close();
            
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
