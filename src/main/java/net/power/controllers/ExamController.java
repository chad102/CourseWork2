package net.power.controllers;

import net.power.BadRequestException;
import net.power.services.ExaminerServiceImpl;
import net.power.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerServiceImpl = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    public List<String> getQuestions(@PathVariable("amount") int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }

}
