package com.example.stokl.tennisscore;

public class Court {

    private Player first = new Player();
    private Player second = new Player();

    Court(){
    }

    public void reset(){
        first.reset();
        second.reset();
    }

    public String getPlayerOneScore(){
        return inTennisPoints(first.getScore());
    }

    public String getPlayerTwoScore(){
        return inTennisPoints(second.getScore());
    }

    public String getPlayerOneGameScore(){
        return inTennisPoints(first.getGameScore());
    }

    public String getPlayerTwoGameScore(){
        return inTennisPoints(second.getGameScore());
    }

    public String playerOneScored(){
        if(first.getScore()<40)
            return inTennisPoints(
                    first.scored(false)
            );
        else if(first.getScore()==40&&second.getScore()<40) {
            second.lostGame();
            return inTennisPoints(
                    first.scored(false)
            );
        }
        else if(first.getScore()==40&&second.getScore()==40)
            return inTennisPoints(first.scored(true));
        else if(first.getScore()==40&&second.getScore()==41){
            second.lostAdv();
            return inTennisPoints(
                    first.getScore()
            );
        }else {
            second.lostGame();
            return inTennisPoints(
                    first.scored(true)
            );
        }
    }

    public String playerTwoScored(){
        if(second.getScore()<40)
            return inTennisPoints(
                    second.scored(false)
            );
        else if(second.getScore()==40&&first.getScore()<40) {
            first.lostGame();
            return inTennisPoints(
                    second.scored(false)
            );
        }else if(first.getScore()==40&&second.getScore()==40)
            return inTennisPoints(
                    second.scored(true)
            );
        else if(second.getScore()==40&&first.getScore()==41){
            first.lostAdv();
            return inTennisPoints(
                    second.getScore()
            );
        }else{
            first.lostGame();
            return inTennisPoints(
                    second.scored(true)
            );
        }
    }
    public int whoServes(){
        return ((first.getGameScore() + second.getGameScore())%2)+1;
    }
    private String inTennisPoints(int points){
        if (points<=40)
            return String.valueOf(points);
        else if (points==41)
            return "Ad";
        else
            return "Er";
    }

}
