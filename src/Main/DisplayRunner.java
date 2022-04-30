package Main;


import java.net.URL;

import sound.MessageSound;
import sound.Music;
import static Main.MainDisplay.window;

public class DisplayRunner {
    public static URL fieldMusic = DisplayRunner.class.getClassLoader().getResource("sound/sound.wav");
    public static URL Message1Music = DisplayRunner.class.getClassLoader().getResource("sound/Hi-there.wav");
    public static URL Message2Music = DisplayRunner.class.getClassLoader().getResource("sound/Here-are-7-days.wav");
    public static URL Message3Music = DisplayRunner.class.getClassLoader().getResource("sound/Ready.wav");
    public static URL currentMusic;
    public static Music music = new Music();
    public static MessageSound ms = new MessageSound();

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

    //play message sound
    public static void playMessage(URL url){
        ms.setFile(url);
        ms.play(url);
    }

}
