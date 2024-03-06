package net.power.services;

import net.power.BadRequestException;
import net.power.Question;
import net.power.interfaces.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    @DisplayName("Если amount больше чем вопросов в хранилище")
    void getQuestions() {
        List<Question> testList = new ArrayList<>();
        when(questionService.getAllQuestions()).thenReturn(testList);
        Assertions.assertThrows(BadRequestException.class, ()-> out.getQuestions(1));
    }

    @Test
    @DisplayName("Если всё ОК")
    void getQuestions2() {
        Question question1 = new Question("1+1=", "2");
        Question question2 = new Question("1+2=", "3");
        Question question3 = new Question("1+3=", "4");
        Question question4 = new Question("1+4=", "5");
        Question question5 = new Question("1+5=", "6");
        Question question6 = new Question("1+6=", "7");
        List<Question> testList = List.of(question1,question2,question3,question4,question5,question6);
        when(questionService.getAllQuestions()).thenReturn(testList);
        when(questionService.getRandomQuestion()).thenReturn(question1.getQuestion(), question2.getQuestion(),
                question3.getQuestion(),question4.getQuestion(), question5.getQuestion(), question6.getQuestion());

        List<String> actual = out.getQuestions(4);
        assertEquals(4, actual.size());
    }
}