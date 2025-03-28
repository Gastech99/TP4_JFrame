import javax.sound.sampled.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Song {
    public static void main(String[] args) {
        try {
            File file = new File("videoplayback.wav"); // Remplace par ton fichier audio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            Scanner scanner = new Scanner(System.in);
            String response = ""; // Déclaration correcte

            while (!response.equals("q")) { // Tant que l'utilisateur ne tape pas 'q'
                System.out.println("Commandes : (p) play, (s) stop, (r) restart, (q) quit");
                System.out.print("Votre choix : ");
                response = scanner.nextLine().toLowerCase(); // Lire la réponse sans redéclarer la variable

                switch (response) {
                    case "p":
                        clip.start();
                        break;
                    case "s":
                        clip.stop();
                        break;
                    case "r":
                        clip.setFramePosition(0);
                        clip.start();
                        break;
                    case "q":
                        System.out.println("Fermeture du programme...");
                        break;
                    default:
                        System.out.println("Commande invalide !");
                        break;
                }
            }

            clip.close();
            scanner.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
