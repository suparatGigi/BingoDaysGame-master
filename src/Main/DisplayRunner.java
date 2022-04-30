package Main;


import java.net.URL;
import sound.Music;
import static Main.MainDisplay.window;

public class DisplayRunner {
    public static URL fieldMusic = DisplayRunner.class.getClassLoader().getResource("sound/sound.wav");
    public static URL currentMusic;
    Music music = new Music();

    public static void main(String[] args) {
        new MainDisplay();
        window.setVisible(true);

        new DisplayRunner();
    }

    public DisplayRunner(){
        currentMusic = fieldMusic;
        playMusic(currentMusic);
    }
    //play game music
    public void playMusic(URL url) {
        music.setFile(url);
        music.play(url);
        music.loop(url);
    }

    //stop game music
    public void stopMusic(URL url) {
        music.stop(url);
    }

}
