package net.power.services;

import net.power.BadRequestException;
import net.power.Question;
import net.power.interfaces.ExaminerService;
import net.power.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<String> getQuestions(int amount) {
        Set<String> randomQuestions = new HashSet<>();

        if (amount > questionService.getAllQuestions().size()) {
            throw new BadRequestException();
        }

        while (randomQuestions.size() < amount) {
                randomQuestions.add(questionService.getRandomQuestion());
        }

        return new ArrayList<>(randomQuestions);
    }
}
