import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.layout.StackPane;

public class Video {

    JFrame window;
    Container con;
    JPanel buttonPanel;
    JButton videoButton;
    ButtonHandler bHandler = new ButtonHandler();
    JFXPanel jfxPanel = new JFXPanel(); // Panel pour intégrer JavaFX dans Swing
    MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        new Video();
    }

    public Video() {
        window = new JFrame("Lecteur Video");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300, 500, 200, 50);
        buttonPanel.setBackground(Color.black);
        con.add(buttonPanel);

        videoButton = new JButton("Lire Vidéo");
        videoButton.setFocusPainted(false);
        videoButton.addActionListener(bHandler);
        buttonPanel.add(videoButton);

        // Ajout du JFXPanel pour afficher la vidéo
        jfxPanel.setBounds(50, 50, 700, 400);
        con.add(jfxPanel);

        window.setVisible(true);
    }

    public class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Platform.runLater(() -> {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }

                File videoFile = new File("video.mp4");
                if (!videoFile.exists()) {
                    System.out.println("Fichier vidéo introuvable !");
                    return;
                }

                Media media = new Media(videoFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);

                StackPane root = new StackPane();
                root.getChildren().add(mediaView);
                Scene scene = new Scene(root, 700, 400);

                jfxPanel.setScene(scene);
                mediaPlayer.play();
            });
        }
    }
}
