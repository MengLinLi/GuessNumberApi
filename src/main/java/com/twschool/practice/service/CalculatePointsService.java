package com.twschool.practice.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatePointsService {
    private static int continueWinCount = 0;
    private static int points = 0;

    public int addPoint() {
        points = points + 3;
        if (continueWinCount % 3 == 0){
            points = points + 2;
        }
        if (continueWinCount % 5 == 0){
            points = points + 3;
        }
        return points;
    }

    public int subPoint() {
        points = points - 3;
        return points;
    }

    public void isContinueWin(String result){
        if (result.equals("4A0B")){
            continueWinCount ++;
        }else {
            continueWinCount = 0;
        }
    }

}
