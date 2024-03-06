package net.power.services;

import net.power.Question;
import net.power.QuestionNotFoundException;
import net.power.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> allQuestions = new ArrayList<>();

    @Override
    public Question add(String questionText, String questionAnswer) {
        Question question1 = new Question(questionText, questionAnswer);
        allQuestions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question2) {
        allQuestions.add(question2);
        return question2;
    }

    @Override
    public Question remove(String questionText, String questionAnswer) {
        Question question3 = new Question(questionText, questionAnswer);
        if (allQuestions.contains(question3)) {
            allQuestions.remove(question3);
            return question3;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    public Question remove(Question question) {
        if (allQuestions.contains(question)) {
            allQuestions.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException();
        }
    }
@Override
    public String getRandomQuestion() {
        Random r = new Random();
        int randomIndexOfQuestionList = r.nextInt(allQuestions.size()) ; // 5
        return allQuestions.get(randomIndexOfQuestionList).getQuestion();
    }
@Override
    public List<Question> getAllQuestions() {
        return allQuestions;
    }

    public Question findQuestion(String questionText) {
        return allQuestions.stream().
                filter(e -> e.getQuestion().equals(questionText)).findAny().orElseThrow(QuestionNotFoundException::new);
        }
}

