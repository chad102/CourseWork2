package net.power.controllers;

import net.power.services.JavaQuestionService;
import net.power.Question;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;
    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")                  /// см. задание “/exam/java/add?question=QuestionText&answer=QuestionAnswer”  ???
    public String addQuestion(@RequestParam("questionText") String questionText, @RequestParam("questionAnswer") String questionAnswer) {
            return javaQuestionService.add(questionText, questionAnswer) + "Вопрос добавлен в список";
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestBody Question question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping(path = "/remove")               /// см. задание“/exam/java/remove?question=QuestionText&answer=QuestionAnswer” ???
    public String removeQuestion(@RequestParam("questionText") String questionText, @RequestParam("questionAnswer") String questionAnswer) {
        return javaQuestionService.remove(questionText, questionAnswer) + "Вопрос удален из списка";
    }
    @GetMapping(path = "/find")
    public Question findQuestion(@RequestParam("questionText") String questionText) {
        return javaQuestionService.findQuestion(questionText);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return javaQuestionService.getAllQuestions();
    }

}
