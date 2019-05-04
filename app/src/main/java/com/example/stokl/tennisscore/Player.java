package com.example.stokl.tennisscore;

public class Player {

    private int gameScore;
    private int setScore;
    private int score;

    void Player(){
    }

    public int getScore() {
        return score;
    }

    public int getGameScore() {
        return gameScore;
    }

    public int getSetScore() {
        return setScore;
    }

    public void lostAdv(){
        score--;
    }

    private void hasAdv(){
        score++;
    }

    public void reset(){
        score = 0;
        gameScore = 0;
        setScore = 0;
    }

    public int lostGame(){
        score = 0;
        return score;
    }

    public int scored(boolean wasDeuce){
        if (!wasDeuce) {
            switch (score) {
                case 0:
                    score += 15;
                    break;
                case 15:
                    score += 15;
                    break;
                case 30:
                    score += 10;
                    break;
                case 40:
                    scoredGame();
                    return score;
            }
            return score;
        } else if (score==40){
            hasAdv();
            return score;
        }
        else{
            scoredGame();
            return score;
        }

    }
    private int scoredGame(){
            gameScore++;
            score = 0;
        return gameScore;
    }
}
