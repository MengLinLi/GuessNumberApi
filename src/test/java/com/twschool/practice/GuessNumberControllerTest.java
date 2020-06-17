package com.twschool.practice;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GuessNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_guess_result() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/game")
                .contentType(MediaType.APPLICATION_JSON)
                .param("guess", "1 2 3 4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));
    }

    @SpringBootTest
    @RunWith(SpringRunner.class)
    @AutoConfigureMockMvc
    public static class GameServiceTest {
        @Test
        public void should_return(){
            String userAnswerString = "7 2 3 4";
            Answer answer = new Answer(Arrays.asList("1","2","3","4"));
            RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
            Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(answer);
            GameService gameService = new GameService(new GuessNumberGame(randomAnswerGenerator));
            String result = gameService.guess(userAnswerString);
            assertEquals("3A0B",result);
        }
    }
}
