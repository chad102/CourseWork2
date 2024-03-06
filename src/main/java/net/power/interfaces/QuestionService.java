package net.power.interfaces;

import net.power.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    Question add(String questionText, String questionAnswer);
    Question add(Question question);
    Question remove(String questionText, String questionAnswer);
    String getRandomQuestion();
    List<Question> getAllQuestions();
}
