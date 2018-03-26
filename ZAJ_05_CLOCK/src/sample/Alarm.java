package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Alarm {
    private MediaPlayer mediaPlayer;

    public void playAlarm()
    {
        Media media = new Media(getClass().getResource("budzik.mp3").toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.play();
    }
}