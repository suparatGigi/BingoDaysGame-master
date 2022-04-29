package Bingo;

import Main.ChooseStageScreen;

public class BingoScore {
    public static int highScore = 200;

    public static void checkHighScore(){
        if (ChooseStageScreen.numStage == 1 && BingoGame.winner)   highScore += 20;
        else if (ChooseStageScreen.numStage == 2 && BingoGame.winner)  highScore += 30;
        else if (ChooseStageScreen.numStage == 3 && BingoGame.winner)  highScore += 40;
        else if (ChooseStageScreen.numStage == 4 && BingoGame.winner)  highScore += 50;
        else if (ChooseStageScreen.numStage == 5 && BingoGame.winner)  highScore += 60;
        else if (ChooseStageScreen.numStage == 6 && BingoGame.winner)  highScore += 70;
        else if (ChooseStageScreen.numStage == 7 && BingoGame.winner)  highScore += 80;
    }

    public static int getHighScore(){
        return highScore;
    }

    public static int getNextUnlocked(){
        if (getHighScore() < 20 ) return 20;
        else if (getHighScore() >= 20 && getHighScore() <59) return 60;
        else if (getHighScore() >= 60 && getHighScore() <109) return 110;
        else if (getHighScore() >= 110 && getHighScore() <199) return 200;
        else if (getHighScore() >= 200 && getHighScore() <299) return 300;
        else if (getHighScore() >= 300 && getHighScore() <399) return 400;
        else  //"YOU UNLOCKED ALL LEVELS"
        return 0;
    }



    public BingoScore(){


        }
    }

