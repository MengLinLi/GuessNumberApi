package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;

import java.util.Arrays;
import java.util.List;

public class GameService {

    private GuessNumberGame guessNumberGame;

    public GameService(GuessNumberGame guessNumberGame){
        this.guessNumberGame = guessNumberGame;
    }

    public String guess(String userAnswerString){
        List<String> userAnswer = Arrays.asList(userAnswerString.split(" "));
        return guessNumberGame.guess(userAnswer);
    }
}
