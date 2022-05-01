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
        else if (getHighScore() >= 20 && getHighScore() < 59) return 60;
        else if (getHighScore() >= 60 && getHighScore() < 109) return 110;
        else if (getHighScore() >= 110 && getHighScore() < 199) return 200;
        else if (getHighScore() >= 200 && getHighScore() < 299) return 300;
        else if (getHighScore() >= 300 && getHighScore() < 399) return 400;
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

