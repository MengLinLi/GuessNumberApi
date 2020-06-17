package com.twschool.practice.domain;

public class User {
    private int UserId;
    private int playTimes;
    private int totalPoints;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(int playTimes) {
        this.playTimes = playTimes;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public User(int userId, int playTimes, int totalPoints) {
        UserId = userId;
        this.playTimes = playTimes;
        this.totalPoints = totalPoints;
    }

    public User() {
    }
}
