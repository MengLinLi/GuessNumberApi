package com.twschool.practice.service;

public class CalculatePointsService {
    private int continueWinCount = 0;
    private int points = 0;

    public void addPoint() {
        points = points + 3;
        if (continueWinCount % 3 == 0){
            points = points + 2;
        }
        if (continueWinCount % 5 == 0){
            points = points + 3;
        }
    }

    public void subPoint() {
        points = points - 3;
    }

    public void isContinueWin(String result){
        if (result.equals("4A0B")){
            continueWinCount ++;
        }
    }

}
