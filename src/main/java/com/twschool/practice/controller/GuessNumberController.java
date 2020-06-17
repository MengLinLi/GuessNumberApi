package com.twschool.practice.controller;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("")
public class GuessNumberController {


    @GetMapping("/game")
    public Map<String,String> game(@RequestParam String guess){
        Map<String,String> map = new HashMap<String, String>();
        map.put("input", guess);
        map.put("result", "4A0B");
        return map;
    }

    @GetMapping("/oneguess")
    public int oneguess(@RequestParam String guess){
        int points = 0;
        List<String> userAnswerNumber = Arrays.asList(guess.split(" "));
        RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        guessNumberGame.guess(userAnswerNumber);
        if (guessNumberGame.getStatus().equals(GameStatus.SUCCEED)){
            points = points + 3;
        }else if (guessNumberGame.getLeftTryTimes() == 0 && guessNumberGame.getStatus().equals(GameStatus.FAILED)){
            points = points - 3;
        }else {
            points = points;
        }
        return points;
    }

    //@GetMapping("/onegame")
    //public int onegame(@RequestParam User user,
    //                   @RequestParam String guess){
    //    int points = 0;
    //    RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
    //    GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
    //    for (int i=0; i<guessNumberGame.getMAX_TRY_TIMES();i++){
    //        guessNumberGame.guess(userAnswerNumber);
    //        if (guessNumberGame.getStatus().equals(GameStatus.SUCCEED)){
    //            points = points + 3;
    //        }else if (guessNumberGame.getLeftTryTimes() == 0 && guessNumberGame.getStatus().equals(GameStatus.FAILED)){
    //            points = points - 3;
    //        }else {
    //            points = points;
    //        }
    //    }
    //    return points;
    //
    //}

    @GetMapping("/oneGuessByOneUser")
    public int oneGuessByOneUser(@RequestParam User user, @RequestParam String guess){
        user.setTotalPoints(0);
        List<String> userAnswerNumber = Arrays.asList(guess.split(" "));
        RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();
        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        guessNumberGame.guess(userAnswerNumber);
        if (guessNumberGame.getStatus().equals(GameStatus.SUCCEED)){
            user.setTotalPoints(user.getTotalPoints()+3);
        }else if (guessNumberGame.getStatus().equals(GameStatus.FAILED)){
            user.setTotalPoints(user.getTotalPoints()-3);
        }
        return user.getTotalPoints();
    }




}
