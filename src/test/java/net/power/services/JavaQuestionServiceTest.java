package net.power.services;

import net.power.Question;
import org.assertj.core.api.Assert;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    @BeforeEach


    @Test
    void add() {
        Question expected = new Question("questionText", "questionAnswer");
        JavaQuestionService actual = new JavaQuestionService();
        assertEquals(expected, actual.add("questionText", "questionAnswer"));
    }

    @Test
    void testAdd() {
        Question expected = new Question("questionText", "questionAnswer");
        JavaQuestionService actual = new JavaQuestionService();
        Question question = new Question("questionText", "questionAnswer");
        assertEquals(expected, actual.add(question));
    }

    @Test
    void remove() {
        Question expected = new Question("questionText", "answerText");

        JavaQuestionService actual = new JavaQuestionService();
        actual.add(new Question("questionText","answerText"));

        assertEquals(expected, actual.remove("questionText","answerText"));
    }

    @Test
    void testRemove() {
        Question expected = new Question("questionText", "questionAnswer");
        JavaQuestionService actual = new JavaQuestionService();
        Question question = new Question("questionText", "questionAnswer");
        actual.add(question);

        assertEquals(expected, actual.remove(question));
    }

    @Test
    @DisplayName("Проверка на исключение")
    void testRemoveQuestionNotFoundException() {
        JavaQuestionService actual = new JavaQuestionService();
        Assertions.assertThrows(RuntimeException.class, () -> actual.remove("q1", "a2"));
    }

    @Test
    void getRandomQuestion() {
        String expected = "q1";
        JavaQuestionService actual = new JavaQuestionService();
        actual.add(new Question("q1","a1"));
        assertEquals(expected, actual.getRandomQuestion());
    }

    @Test
    void getAllQuestions() {
        List<Question> expectedList = new ArrayList<>();
        expectedList.add(new Question("q1", "a1"));
        expectedList.add(new Question("q2", "a2"));
        expectedList.add(new Question("q3", "a3"));
        expectedList.add(new Question("q4", "a4"));

        JavaQuestionService actualList = new JavaQuestionService();
        actualList.add(new Question("q1", "a1"));
        actualList.add(new Question("q2", "a2"));
        actualList.add(new Question("q3", "a3"));
        actualList.add(new Question("q4", "a4"));

        assertEquals(expectedList,actualList.getAllQuestions());
    }

    @Test
    void findQuestion() {
        Question expected = new Question("questionText", "questionAnswer");
        JavaQuestionService actual = new JavaQuestionService();
        actual.add("questionText", "questionAnswer");
        assertEquals(expected, actual.findQuestion("questionText"));
    }

    @Test
    @DisplayName("Проверка исключения")
    void findQuestionException() {
        JavaQuestionService actual = new JavaQuestionService();
        Assertions.assertThrows(RuntimeException.class, () -> actual.findQuestion("q1"));
    }
}