package Bingo;

import Main.ChooseStageScreen;

public class BingoScore {
    public static int highScore = 0;  //set initial score=0

    public BingoScore() {}

    public static int getHighScore() {
        return highScore;
    }

    public static int getNextUnlocked() {
        if (getHighScore() < 20) return 20;
        else if (getHighScore() >= 20 && getHighScore() < 49) return 50;
        else if (getHighScore() >= 50 && getHighScore() < 89) return 90;
        else if (getHighScore() >= 90 && getHighScore() < 149) return 150;
        else if (getHighScore() >= 150 && getHighScore() < 249) return 250;
        else if (getHighScore() >= 250 && getHighScore() < 349) return 350;
        else  //"YOU UNLOCKED ALL LEVELS"
            return 0;
    }

    public static int scoreYouWillGet() {
        if (ChooseStageScreen.numStage == 1) return 20;
        else if (ChooseStageScreen.numStage == 2) return 30;
        else if (ChooseStageScreen.numStage == 3) return 40;
        else if (ChooseStageScreen.numStage == 4) return 50;
        else if (ChooseStageScreen.numStage == 5) return 60;
        else if (ChooseStageScreen.numStage == 6) return 70;
        else if (ChooseStageScreen.numStage == 7) return 80;
        else return 0;
    }
}

